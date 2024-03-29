package edu.arizona.verbs.verb.bayes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import ros.pkg.verb_learning.srv.PerformVerb.Response;
import weka.estimators.NormalEstimator;

import cern.colt.Arrays;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import edu.arizona.verbs.mdp.StateConverter;
import edu.arizona.verbs.shared.Environment;
import edu.arizona.verbs.shared.OOMDPState;
import edu.arizona.verbs.shared.Relation;
import edu.arizona.verbs.shared.Remappable;
import edu.arizona.verbs.verb.Verb;

public class MaximumLikelihoodVerb implements Verb, Remappable<MaximumLikelihoodVerb> {
	private static Logger logger = Logger.getLogger(MaximumLikelihoodVerb.class);

	private class ReplanResult {
		public SimplePolicy path;
		public double likelihood;
		public long planningTime;
	}
	
	protected String lexicalForm_;
	protected ArrayList<String> arguments_;
//	protected NaiveBayesUpdateable classifier_ = null;
	
	// One estimator for each feature/relation
	protected HashMap<String, NormalEstimator> distributions = new HashMap<String, NormalEstimator>();
	
	
	public MaximumLikelihoodVerb(String lexicalForm, ArrayList<String> arguments) {
		lexicalForm_ = lexicalForm;
		arguments_ = arguments;
	}
	
//	// TODO: Would be easier to just return an empty dataset
//	private FastVector getFeatureVector(List<OOMDPState> trace) {
//		// We have two classes, positive and negative
//		FastVector classVal = new FastVector(2);
//		classVal.addElement("positive");
//		classVal.addElement("negative");
//		Attribute classAttribute = new Attribute("class", classVal);
//		
//		// Add an attribute for each relation
//		FastVector featureVector = new FastVector();
//		for (Relation rel : trace.get(0).getRelations()) { // Relations are already sorted
//			featureVector.addElement(new Attribute(rel.toString())); // Each relation becomes a numeric attribute
//		}
//		featureVector.addElement(classAttribute);
//		
//		return featureVector;
//	}
	
	private void initializeClassifier(List<OOMDPState> trace) {
		if (trace.isEmpty()) {
			throw new RuntimeException("Trace is empty.");
		}
		
		if (distributions.isEmpty()) {
			for (Relation rel : trace.get(0).getRelations()) { // Relations are already sorted
				System.out.println("THIS: " + rel);
				distributions.put(rel.toString(), new NormalEstimator(0.01)); // This should be enough
			}
		}
	}
	
	public void addInstance(List<OOMDPState> trace) {
		initializeClassifier(trace);
		
		List<Relation> relations = trace.get(0).getRelations();
		
		double[] avgs = new double[relations.size()];
		// Sum the total for each relation...
		for (OOMDPState state : trace) {
			for (int i = 0; i < avgs.length; i++) {
				Relation relation = state.getRelations().get(i);
				avgs[i] += (relation.getValue() ? 1.0 : 0.0);
			}
		}
		// ...compute the average for each relation
		for (int i = 0; i < avgs.length; i++) {
			avgs[i] = avgs[i] / trace.size();
			
			Relation rel = relations.get(i);
			distributions.get(rel.toString()).addValue(avgs[i], 1.0); // All instances have equal weight
		}
		
		for (String rel : distributions.keySet()) {
			System.out.println(rel + " => " + distributions.get(rel));
		}
	}
	
	@Override
	public void addPositiveInstance(List<OOMDPState> trace) {
		addInstance(trace);
	}

	@Override
	public void addNegativeInstance(List<OOMDPState> trace) {
//		addInstance(trace, false);
	}

	@Override
	public void addPositiveInstances(List<List<OOMDPState>> traces) {
		for (List<OOMDPState> trace : traces) {
			addPositiveInstance(trace);
		}
	}

	@Override
	public void addNegativeInstances(List<List<OOMDPState>> traces) {
//		for (List<OOMDPState> trace : traces) {
//			addNegativeInstance(trace);
//		}
	}

	@Override
	public void forgetInstances() {
		distributions.clear();
	}

	public double getLikelihood(List<OOMDPState> trace) {
		if (distributions.isEmpty() || trace.isEmpty()) {
			return Double.NEGATIVE_INFINITY;
			
		} else {
//			System.out.println("IN HERE");
			
			List<Relation> relations = trace.get(0).getRelations();
			
			double[] avgs = new double[relations.size()];
			// Sum the total for each relation...
			for (OOMDPState state : trace) {
				for (int i = 0; i < avgs.length; i++) {
					Relation relation = state.getRelations().get(i);
					avgs[i] += (relation.getValue() ? 1.0 : 0.0);
				}
			}
			// ...compute the average for each relation
			// Compute the probability under independence assumption
			double prob = 0.0; // 1.0;
			for (int i = 0; i < avgs.length; i++) {
				avgs[i] /= trace.size();
				Relation rel = relations.get(i);
				double proba = Math.max(0.001, distributions.get(rel.toString()).getProbability(avgs[i]));
				// Smoothing
				
//				System.out.println(proba);
				
				prob += Math.log(proba);
			}

//			System.out.println(Arrays.toString(avgs));
			
			return prob;
//			return logLikelihood;
		}
	}
	
	@Override
	public boolean isReady() {
		return !distributions.isEmpty();
	}

	@Override
	public Response perform(Environment environment, OOMDPState startState, int executionLimit) {
		Response response = new Response();
		
		OOMDPState start = startState;
		response.trace.add(StateConverter.stateToMsg(start));
		
		///////////////////////////////////////////////////////////////////
		// This part follows the (Kollar et al. 2010) paper

		int t = 4; // The depth to explore each replan step
		int k = 1; // The number of previous plans to consider in evaluating termination condition
		
		// For go tests, t = 4, k = 1
		// For deliver tests, t = 6, k = 1
		
		ArrayList<Double> likelihoods = new ArrayList<Double>(); // Stores the best likelihood at each depth
		boolean maxFound = false;
		
		SimplePolicy h = new SimplePolicy();
		h.setStartState(start);
		
		String action = "REPLAN";
		
		int numSteps = 0; 
		while (!maxFound && numSteps < executionLimit) { // the verb is not satisfied
			
			// If the old plan has finished or there is no plan, replan
			if (action.equals("REPLAN")) {
				logger.debug(">> REPLANNING!");
				
				ReplanResult result = oldReplan(environment, h, t);
				if (result == null) {
					break;
				}
				
				h = result.path;
				likelihoods.add(result.likelihood);
				response.planning_time += result.planningTime;
				
				h.print();
			}
			
			action = h.getActions().get(numSteps);
			
			// Check termination condition
			if (likelihoods.size() > k) {
				double end = likelihoods.get(likelihoods.size()-1);
				List<Double> lastK = likelihoods.subList(likelihoods.size()-k-1, likelihoods.size()-1);
				System.out.println("THIS: " + lastK);
				double min = Double.MAX_VALUE;
				for (double l : lastK) {
					min = Math.min(min, l);
				}
				System.out.println("END: " + end);
				System.out.println("MIN: " + min);
				if (end <= min) { // It seems that we get 1 a lot
					action = "TERMINATE";
					maxFound = true;
					break;
				}
			}

			// Perform the action
			if (!action.equals("REPLAN")) {
				OOMDPState nextState = environment.performAction(action);
				response.actions.add(action);
				response.trace.add(StateConverter.stateToMsg(nextState));
				numSteps++;
			}
		}
		
		response.actions.add("TERMINATE");
		
		response.execution_success = true;
		response.execution_length = numSteps;
		
		return response;
	}
	
	private ReplanResult replan(Environment environment, SimplePolicy h, int t) {
//		List<String> actions = Lists.newArrayList("person 0000", "person 1000", "person 0100", "person 0010", "person 0001");
		List<String> actions = environment.getActions();
		
		long startTime = System.currentTimeMillis();

		HashSet<List<String>> tested = Sets.newHashSet();
		HashSet<SimplePolicy> bestPolicies = new HashSet<SimplePolicy>();
		
		h.stripLast(); // Remove the "REPLAN"
//		h.getMdpStates();
//		OOMDPState lastState = h.getMdpStates().get(h.getMdpStates().size()- 1);
		
		double maxLikelihood = getLikelihood(h.getMdpStates());

		// Enumerate actions sequences
		List<List<String>> actionSequences = generateActionSequences(actions, t);
		for (List<String> sequence : actionSequences) {
			environment.reset();
			
			SimplePolicy sp = new SimplePolicy(h);
//			for (String action : sequence) {
			for (int i = 0; i < sequence.size(); i++) {
				String action = sequence.get(i);
				OOMDPState state = environment.simulateAction(action);
				sp.addActionState(action, state);
				
				if (!tested.contains(sequence.subList(0, i))) {
					// Check the likelihood of the sequence we've generated so far
					double likelihood = getLikelihood(sp.getMdpStates());
					if (likelihood > maxLikelihood) {	
						bestPolicies.clear();
						bestPolicies.add(sp);
						maxLikelihood = likelihood;
						
					} else if (likelihood == maxLikelihood) {
						bestPolicies.add(sp);
					}
					tested.add(sequence.subList(0, i));
				}
			}
		}
		
		
		logger.debug("TIED POLICIES: " + bestPolicies.size());
		
		if (bestPolicies.isEmpty()) {
			return null;
			
		} else {
//			System.out.println("\n\n\n\n\n");
//			for (SimplePolicy sp : bestPolicies) {
//				sp.replan();
//				sp.print();
//			}
//			System.out.println("\n\n\n\n\n");
	//		
			Random r = new Random();
			// Return a random element of the set
			SimplePolicy policy = bestPolicies.toArray(new SimplePolicy[0])[r.nextInt(bestPolicies.size())];
			// Add a "REPLAN" action to the end of the policy
			policy.replan();
	
			// DEBUG
//			policy.print();
			
			ReplanResult result = new ReplanResult();
			result.path = policy;
			result.likelihood = maxLikelihood;
			result.planningTime = System.currentTimeMillis() - startTime;
			return result;
		}
	}
	
	private List<List<String>> generateActionSequences(List<String> actions, int depth) {
		List<List<String>> result = Lists.newArrayList();
		
		if (depth == 0) {
			return result;
		}
		
		for (String action : actions) {
			List<List<String>> suffixes = generateActionSequences(actions, depth-1);
			
			if (suffixes.isEmpty()) {
				List<String> sequence = Lists.newArrayList(action);
				result.add(sequence);
			} else {
				for (List<String> rest : suffixes) {
					List<String> sequence = Lists.newArrayList(action);
					sequence.addAll(rest);
					result.add(sequence);
				}
			}
		}
		
		return result;
	}
	
	
	// This is the BFS up to depth T to find the max likelihood path given the history
	private ReplanResult oldReplan(Environment environment, SimplePolicy h, int t) {
//		List<String> actions = Lists.newArrayList("person 0000", "person 1000", "person 0100", "person 0010");
		List<String> actions = environment.getActions();

		long startTime = System.currentTimeMillis();
		
		HashSet<SimplePolicy> bestPolicies = new HashSet<SimplePolicy>();
		
		h.stripLast(); // Remove the "REPLAN"
		ArrayList<SimplePolicy> lastDepth = new ArrayList<SimplePolicy>();
		lastDepth.add(h);
		
		double maxLikelihood = Double.NEGATIVE_INFINITY;
		
		for (int j = 0; j < t; j++) { 
			
			ArrayList<SimplePolicy> currentDepth = new ArrayList<SimplePolicy>();
			
			for (SimplePolicy path : lastDepth) {
				
				for (String action : actions) {
					OOMDPState endState = path.getMdpStates().get(path.getMdpStates().size()- 1);
					OOMDPState nextState = environment.simulateAction(endState, action);
					
					SimplePolicy newPath = new SimplePolicy(path);
					newPath.addActionState(action, nextState);
					
					double likelihood = getLikelihood(newPath.getMdpStates());
					if (likelihood > maxLikelihood) {						
						if (!bestPolicies.isEmpty()) {
							System.out.println("A BEST: " + bestPolicies.iterator().next().getActions());
							System.out.println("THIS  : " + newPath.getActions());
							System.out.println("STATS : " + likelihood + " " + maxLikelihood);
						}
						
						bestPolicies.clear();
						bestPolicies.add(newPath);
						
						maxLikelihood = likelihood;
						
					} else if (likelihood == maxLikelihood) {
						bestPolicies.add(newPath);
					}
					
					currentDepth.add(newPath);
				}
			}
			
			logger.debug("END ITERATION");
			
			lastDepth = currentDepth;
		}
		
		logger.debug("TIED POLICIES: " + bestPolicies.size());
		
		Random r = new Random();
		SimplePolicy policy = bestPolicies.toArray(new SimplePolicy[0])[r.nextInt(bestPolicies.size())];
		
		policy.replan();
		
		ReplanResult result = new ReplanResult();
		result.path = policy;
		result.likelihood = maxLikelihood;
		result.planningTime = System.currentTimeMillis() - startTime;
		return result;
	}
//	
	@Override
	public String getLexicalForm() {
		return lexicalForm_;
	}

	@Override
	public String[] getArgumentArray() {
		return arguments_.toArray(new String[0]);
	}

	@Override
	public ArrayList<String> getArguments() {
		return arguments_;
	}

	@Override
	public String getIdentifierString() {
		return Joiner.on(",").join(Lists.asList(lexicalForm_, arguments_.toArray(new String[0])));
	}

	@Override
	public MaximumLikelihoodVerb remap(Map<String, String> nameMap) {
		return this; // TODO: How to remap here?
	}
	
}
