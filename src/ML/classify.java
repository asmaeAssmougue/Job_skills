package ML;
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
public class classify {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 
			DataSource source = new DataSource("data/training_data.arff");
			Instances data = source.getDataSet();
			System.out.println(data.numInstances() + " instances loaded.");
			// System.out.println(data.toString());

			// remove animal attribute
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
		    double[] vals = new double[data.numAttributes()];
		    
            
			vals[0] = 0.0;//jee 
			vals[1] = 0.0; //sap
			vals[2] = 0.0; //html5
			vals[3] = 0.0; //python
			vals[4] = 0.0; //css3
			vals[5] = 0.0; //javascript
			vals[6] = 0.0; //react
			vals[7] = 0.0; //jquery
			vals[8] = 1.0;//angular
			vals[9] = 0.0; //linux
			vals[10] = 0.0; //php
			vals[11] = 0.0; //html
			vals[12] = 0.0; //sql
			vals[13] = 0.0; //c++
			vals[14] = 0.0; //c#
			vals[15] = 0.0; //css
			vals[16]=0.0;//vue
			vals[17]=0.0;//docker
			vals[18]=0;//git
			vals[19]=0;//rest
			vals[20]=0;//boostrap
			vals[21]=1.0;//.net
			vals[22]=0;//js
			
			
			//type
			Instance myDomaine = new DenseInstance(1.0, vals);
			//Assosiate your instance with Instance object in this case dataRaw
			myDomaine.setDataset(data); 

			double label = tree.classifyInstance(myDomaine);
			System.out.println("domaine:  "+data.classAttribute().value((int) label));

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
			// Confusion matrix
			double[][] confusionMatrix = eval_roc.confusionMatrix();
			System.out.println(eval_roc.toMatrixString());

			/*
			 * Bonus: Plot ROC curve
			 */

			ThresholdCurve tc = new ThresholdCurve();
			int classIndex = 0;
			Instances result = tc.getCurve(eval_roc.predictions(), classIndex);
			// plot curve
			ThresholdVisualizePanel vmc = new ThresholdVisualizePanel();
			vmc.setROCString("(Area under ROC = " + tc.getROCArea(result) + ")");
			vmc.setName(result.relationName());
			PlotData2D tempd = new PlotData2D(result);
			tempd.setPlotName(result.relationName());
			tempd.addInstanceNumberAttribute();
			// specify which points are connected
			boolean[] cp = new boolean[result.numInstances()];
			for (int n = 1; n < cp.length; n++)
				cp[n] = true;
			tempd.setConnectPoints(cp);

			// add plot
			vmc.addPlot(tempd);
			// display curve
			JFrame frameRoc = new javax.swing.JFrame("ROC Curve");
			frameRoc.setSize(800, 500);
			frameRoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameRoc.getContentPane().add(vmc);
			frameRoc.setVisible(true);

	}

}
