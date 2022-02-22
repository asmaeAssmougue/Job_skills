package ML;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import weka.gui.visualize.PlotData2D;
import weka.gui.visualize.ThresholdVisualizePanel;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;

public class ClassificationTask {

	public void classification(ArrayList lista) throws Exception {

		/*
		 * Load the data
		 */
		DataSource source = new DataSource("data/training_data.arff");
		Instances data = source.getDataSet();
		System.out.println(data.numInstances() + " instances loaded.");
		System.out.println(data.toString());

		
	    String[] opts = new String[] { "-R", "1" };
		Remove remove = new Remove();
		remove.setOptions(opts);
		remove.setInputFormat(data);
		data = Filter.useFilter(data, remove);

		/*
		 * Feature selection
		 */
		AttributeSelection attSelect = new AttributeSelection();
		InfoGainAttributeEval eval = new InfoGainAttributeEval();
		Ranker search = new Ranker();
		attSelect.setEvaluator(eval);
		attSelect.setSearch(search);
		attSelect.SelectAttributes(data);
		int[] indices = attSelect.selectedAttributes();
		System.out.println("Selected attributes: "+Utils.arrayToString(indices));

		/*
		 * Build a decision tree
		 */
	    String[] options = new String[1];
		options[0] = "-U";
		J48 tree = new J48();
		tree.setOptions(options);
		tree.buildClassifier(data);
		System.out.println(tree);

		/*
		 * Classify new instance.-->test
		 */
		
    	double[] vals = new double[data.numAttributes()];
    	//System.out.println(data);
    	for(int i=0;i<lista.size();i++) {
    		vals[i]=(double) lista.get(i);
    	}
    	
		Instance mydomaine = new DenseInstance(1.0, vals);
		//Assosiate your instance with Instance object in this case dataRaw
		mydomaine.setDataset(data); 

		double label = tree.classifyInstance(mydomaine);
		System.out.println(data.classAttribute().value((int) label));

		/*
		 * Visualize decision tree
		 */
		TreeVisualizer tv = new TreeVisualizer(null, tree.graph(),
				new PlaceNode2());
		JFrame frame = new javax.swing.JFrame("Tree Visualizer");
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tv);
		frame.setVisible(true);
		tv.fitToScreen();  

		/*
		 * Evaluation
		 */

		Classifier cl = new J48();
		Evaluation eval_roc = new Evaluation(data);
		eval_roc.crossValidateModel(cl, data, 10, new Random(1), new Object[] {});
		System.out.println(eval_roc.toSummaryString());
		//Confusion matrix
		double[][] confusionMatrix = eval_roc.confusionMatrix();
		System.out.println(eval_roc.toMatrixString());

	

	}
}
