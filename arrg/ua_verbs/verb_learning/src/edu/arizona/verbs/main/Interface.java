package edu.arizona.verbs.main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

import ros.NodeHandle;
import ros.Ros;
import ros.RosException;
import ros.ServiceServer;
import ros.ServiceServer.Callback;
import ros.pkg.oomdp_msgs.msg.MDPObjectState;
import ros.pkg.oomdp_msgs.srv.InitializeEnvironment;
import ros.pkg.oomdp_msgs.srv.PerformAction;
import ros.pkg.verb_learning.msg.VerbInstance;
import ros.pkg.verb_learning.srv.DefineSequentialVerb;
import ros.pkg.verb_learning.srv.DefineSequentialVerb.Response;
import ros.pkg.verb_learning.srv.ForgetVerb;
import ros.pkg.verb_learning.srv.LoadVerbs;
import ros.pkg.verb_learning.srv.PerformVerb;
import ros.pkg.verb_learning.srv.UpdateVerb;
import edu.arizona.verbs.environments.Simulators;
import edu.arizona.verbs.environments.ww2d.SimulatorFailureException;
import edu.arizona.verbs.mdp.StateConverter;
import edu.arizona.verbs.shared.Environment;
import edu.arizona.verbs.shared.OOMDPObjectState;
import edu.arizona.verbs.shared.OOMDPState;
import edu.arizona.verbs.verb.Verb;
import edu.arizona.verbs.verb.VerbBinding;
import edu.arizona.verbs.verb.Verbs;
import edu.arizona.verbs.verb.vfsm.FSMVerb;
import edu.arizona.verbs.verb.vfsm.SequentialVerb;

public class Interface {
	private static Logger logger = Logger.getLogger(Interface.class);

	// These are the verbs that we have learned!
	private static HashMap<String, Verb> verbs = new HashMap<String, Verb>();
	
	private static Environment currentEnvironment = null;
	public static Environment getCurrentEnvironment() { return currentEnvironment; }
	
	public static Verbs currentVerbType = Verbs.signature;
	
	// Maps: Binding -> Argument
	public static Map<String, String> extractReverseNameMap(VerbInstance vi) {
		if (vi.arguments.size() == vi.bindings.size()) {
			Map<String, String> nameMap = new HashMap<String, String>();
			for (int i = 0; i < vi.arguments.size(); i++) {
				nameMap.put(vi.bindings.get(i), vi.arguments.get(i));
			}
			return nameMap;
		} else {
			throw new RuntimeException("NAME MAP LENGTHS DO NOT MATCH IN VerbInstance");
		}
	}
	
	// Maps: Argument -> Binding
	public static LinkedHashMap<String, String> extractNameMap(VerbInstance vi) {
		if (vi.arguments.size() == vi.bindings.size()) {
			LinkedHashMap<String, String> nameMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < vi.arguments.size(); i++) {
				nameMap.put(vi.arguments.get(i), vi.bindings.get(i));
			}
			
			return nameMap;
		} else {
			throw new RuntimeException("NAME MAP LENGTHS DO NOT MATCH IN VerbInstance");
		}
	}
	
	// Service Handlers
	
	static ServiceServer.Callback<UpdateVerb.Request, UpdateVerb.Response> updateVerb = 
		new ServiceServer.Callback<UpdateVerb.Request, UpdateVerb.Response>() {
			@Override
			public UpdateVerb.Response call(UpdateVerb.Request request) {
				logger.debug("BEGIN update_verb callback...");
				logger.debug("Received a trace with " + request.trace.size() + " states for <" + request.verb + ">");

				// Get/make the verb
				String verbName = request.verb.verb;
				Verb verb = null;
				if (verbs.containsKey(verbName)) {
					verb = verbs.get(verbName); 
				} else {
					logger.info("VERB NOT FOUND: " + request.verb + ", creating it");
					verb = currentVerbType.create(verbName, request.verb.arguments);
					verbs.put(verbName, verb);
				}

				// Update it with the trace
				Map<String, String> nameMap = extractReverseNameMap(request.verb);
				// TODO: What about nameMap?
				List<OOMDPState> trace = StateConverter.msgArrayListToStates(request.trace);
				if (request.is_positive) {
					verb.addPositiveInstance(trace);
				} else {
					verb.addNegativeInstance(trace);
				}
				
				logger.debug("... END update_verb callback.");
				return new UpdateVerb.Response();
			}
		};
	
	static ServiceServer.Callback<ForgetVerb.Request, ForgetVerb.Response> forgetVerb =
		new ServiceServer.Callback<ForgetVerb.Request, ForgetVerb.Response>() {
			@Override
			public ForgetVerb.Response call(ForgetVerb.Request request) {
				System.out.println("Forgetting verb");
				
				String verbName = request.verb.verb;
				if (verbs.containsKey(verbName)) {
					Verb verb = verbs.get(request.verb.verb);
					verb.forgetInstances();
					
					System.out.println("Forgot verb");
				} 
				
				return new ForgetVerb.Response();
			}
		};
		
	static ServiceServer.Callback<ForgetVerb.Request, ForgetVerb.Response> deleteVerb =
		new ServiceServer.Callback<ForgetVerb.Request, ForgetVerb.Response>() {
			@Override
			public ForgetVerb.Response call(ForgetVerb.Request request) {
				String verbName = request.verb.verb;
				if (verbs.containsKey(verbName)) {
					verbs.remove(verbName);
				} 
				
				return new ForgetVerb.Response();
			}
		};
		
	// TODO: Restore load verbs	
	static ServiceServer.Callback<LoadVerbs.Request, LoadVerbs.Response> loadVerbs =
		new ServiceServer.Callback<LoadVerbs.Request, LoadVerbs.Response>() {
			@Override
			public LoadVerbs.Response call(LoadVerbs.Request request) {
				LoadVerbs.Response resp = new LoadVerbs.Response();
				
				logger.error("load_verbs service is current non-functional");
				
				return resp;
			}
		};
		
	static ServiceServer.Callback<PerformVerb.Request, PerformVerb.Response> performVerb = 
		new ServiceServer.Callback<PerformVerb.Request, PerformVerb.Response>() {
		@Override
		public PerformVerb.Response call(PerformVerb.Request request) {
			if (verbs.containsKey(request.verb.verb)) {
				Verb verb = verbs.get(request.verb.verb);
				
				if (verb.isReady()) {
					Map<String,String> argumentMap = extractNameMap(request.verb);
					
					try {
//						switch (currentVerbType) {
//						case FSM:
//							FSMVerb remapped = ((FSMVerb) verb).remap(argumentMap);
//							return remapped.perform(currentEnvironment, StateConverter.msgToState(request.start_state), request.execution_limit);
//						
//						case ML:
//							MaximumLikelihoodVerb remapped2 = ((MaximumLikelihoodVerb) verb).remap(argumentMap);
//							return remapped2.perform(currentEnvironment, StateConverter.msgToState(request.start_state), request.execution_limit);
//						
//						case IRL:
//							IRLVerb irl = (IRLVerb) verb;
//							return irl.perform(currentEnvironment, StateConverter.msgToState(request.start_state), request.execution_limit);
//							
//						default:
//							return new PerformVerb.Response();
//						}
					
						// TODO: Add argumentMap as a parameter, or add back re-mapping
						return verb.perform(currentEnvironment, StateConverter.msgToState(request.start_state), request.execution_limit);
						
					} catch (SimulatorFailureException sfe) {
						// For now, we just abandon ship
						// Later we will want to retry
						sfe.printStackTrace();
						return new PerformVerb.Response();
					}
					
				} else {
					return new PerformVerb.Response();
				}
			} else {
				System.err.println("Verb not found: " + request.verb.verb);
				return new PerformVerb.Response();
			}
		}
	};
		
	static ServiceServer.Callback<PerformAction.Request, PerformAction.Response> performAction = 
		new ServiceServer.Callback<PerformAction.Request, PerformAction.Response>() {
			@Override
			public PerformAction.Response call(PerformAction.Request request) {
				PerformAction.Response resp = new PerformAction.Response();
				
				OOMDPState performResult = currentEnvironment.performAction(request.action);
				resp.new_state = StateConverter.stateToMsg(performResult);
				
				return resp;
			}
		};
		
	static ServiceServer.Callback<InitializeEnvironment.Request, InitializeEnvironment.Response> initializeEnvironment = 
		new ServiceServer.Callback<InitializeEnvironment.Request, InitializeEnvironment.Response>() {
			@Override
			public InitializeEnvironment.Response call(InitializeEnvironment.Request request) {
				InitializeEnvironment.Response resp = new InitializeEnvironment.Response();
				
				Vector<OOMDPObjectState> states = new Vector<OOMDPObjectState>();
				for (MDPObjectState stateMsg : request.object_states) {
					states.add(StateConverter.msgToObjState(stateMsg));
				}				
				OOMDPState initializeResult = currentEnvironment.initializeEnvironment(states);
				resp.start_state = StateConverter.stateToMsg(initializeResult);
				return resp;
			}
		};
		
	// TODO: This doesn't seem to be working since the refactor, fix it
	static Callback<DefineSequentialVerb.Request, DefineSequentialVerb.Response> defineVerb =
		new Callback<DefineSequentialVerb.Request, DefineSequentialVerb.Response>() {
			@Override
			public Response call(DefineSequentialVerb.Request request) {
				Vector<VerbBinding> subverbs = new Vector<VerbBinding>();
				for (VerbInstance vi : request.subverbs) {
					VerbBinding vb = new VerbBinding();
					vb.verb = (FSMVerb) verbs.get(vi.verb);
					vb.binding = extractNameMap(vi); 
				
					subverbs.add(vb);
				}
				SequentialVerb verb = new SequentialVerb(request.verb, request.arguments, subverbs);
				verbs.put(request.verb, verb);
				
				return new Response();
			}
		};

	/**
	 * @param args
	 * @throws RosException
	 */
	public static void main(String[] args) throws RosException {
		if (args.length < 2) {
			System.out.println("Please choose an environment:");
			for (Simulators s : Simulators.values()) {
				System.out.println("\t" + s.toString());
			}
			System.out.println("and choose a verb type:");
			for (Verbs v : Verbs.values()) {
				System.out.println("\t" + v.toString());
			}
			
			System.exit(1);
		}
		
		final Ros ros = Ros.getInstance();
		ros.init("verb_learning");
		NodeHandle nh = ros.createNodeHandle();

		currentEnvironment = Simulators.valueOf(args[0]).create();		
		currentVerbType = Verbs.valueOf(args[1]);
		
		nh.advertiseService("verb_learning/load_verbs", new LoadVerbs(), loadVerbs);
		nh.advertiseService("verb_learning/forget_verb", new ForgetVerb(), forgetVerb);
		
		nh.advertiseService("verb_learning/update_verb", new UpdateVerb(), updateVerb);
		nh.advertiseService("verb_learning/define_verb", new DefineSequentialVerb(), defineVerb);
		
		nh.advertiseService("verb_learning/perform_verb", new PerformVerb(), performVerb);

		// These are for the teacher to use, since we will now be embedding some of the environments
		nh.advertiseService("verb_learning/initialize_environment", new InitializeEnvironment(), initializeEnvironment);
		nh.advertiseService("verb_learning/perform_action", new PerformAction(), performAction);
		
		logger.info("Initialization Complete, Services Advertised.");
		logger.info("Environment is " + currentEnvironment.getClass().getSimpleName() + ", Verb Type is " + currentVerbType);
		
		ros.spin();
	}
}
