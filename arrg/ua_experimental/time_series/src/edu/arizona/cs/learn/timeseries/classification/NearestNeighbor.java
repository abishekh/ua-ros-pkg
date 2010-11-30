package edu.arizona.cs.learn.timeseries.classification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.apache.log4j.Logger;

import edu.arizona.cs.learn.algorithm.alignment.Params;
import edu.arizona.cs.learn.algorithm.alignment.SequenceAlignment;
import edu.arizona.cs.learn.algorithm.alignment.model.Distance;
import edu.arizona.cs.learn.algorithm.alignment.model.Instance;
import edu.arizona.cs.learn.timeseries.evaluation.BatchStatistics;
import edu.arizona.cs.learn.timeseries.model.Episode;
import edu.arizona.cs.learn.util.SequenceType;

public class NearestNeighbor extends Classifier {
	private static Logger logger = Logger.getLogger(NearestNeighbor.class);

	private int _k;
	private boolean _weighted;

	private List<Instance> _trainingData;

	public NearestNeighbor(SequenceType type, int k, boolean weighted) {
		super(type);

		this._k = k;
		this._weighted = weighted;

		logger.debug(this._k + "-NN");
	}

	public String getName() {
		return "knn";
	}

	public void addData(BatchStatistics fold) {
	}

	public String test(Instance instance) {
		Params params = new Params();
		params.setMin(0, 0);
		params.setBonus(1.0D, 1.0D);
		params.setPenalty(0.0D, 0.0D);
		params.normalize = Params.Normalize.regular;

		SummaryStatistics time = new SummaryStatistics();

		List<Distance> distanceList = new ArrayList<Distance>();
		for (Instance tmp : _trainingData) {
			params.seq1 = instance.sequence();
			params.seq2 = tmp.sequence();

			long start = System.currentTimeMillis();
			double distance = SequenceAlignment.distance(params);

			long end = System.currentTimeMillis();

			time.addValue(end - start);

			assert (distance <= 1.0D);

			distanceList.add(new Distance(tmp, distance));
		}

		Collections.sort(distanceList, new Comparator<Distance>() {
			public int compare(Distance o1, Distance o2) {
				return Double.compare(o1.d, o2.d);
			}
		});
		String maxClass = null;
		double max = 0.0D;

		Map<String,Double> map = new HashMap<String,Double>();
		for (int i = 0; (i < distanceList.size()) && (i < _k); i++) {
			Distance distance = (Distance) distanceList.get(i);
			String name = distance.instance.name();

			double inc = 1.0D;
			if (_weighted) 
				inc = 1.0D / distance.d;

			if (map.containsKey(name)) {
				map.put(name, map.get(name) + inc);
			} else { 
				map.put(name, inc);
			}

			if (map.get(name) > max) { 
				max = map.get(name);
				maxClass = name;
			}
		}

		return maxClass;
	}

	public void train(int x, List<Instance> training) {
		_trainingData = new ArrayList<Instance>(training);
	}

	public void train(List<Instance> training) {
		_trainingData = new ArrayList<Instance>(training);
	}
	
	public void trainEpisodes(int x, List<Episode> training, SequenceType type, boolean shuffle) { 
		trainEpisodes(training, type, shuffle);
	}
	
	public void trainEpisodes(List<Episode> training, SequenceType type, boolean shuffle) { 
		_trainingData = new ArrayList<Instance>();
		
		for (Episode e : training) { 
			Instance instance = e.toInstance(type);
			if (shuffle) 
				instance.shuffle();

			_trainingData.add(instance);
		}
	}
}