package drs;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import weka.core.Instances;
 import weka.classifiers.Evaluation;
 import weka.classifiers.trees.J48;

import javax.swing.JFrame;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

/**
 * Displays a trained J48 as tree.
 * Expects an ARFF filename as first argument.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class VisualizeJ48 {
    
  List<String> mining_result() throws Exception {
    // train classifier
    J48 cls = new J48();
    File file = new File("D:\\train_test.arff");
    Instances train_data = new Instances(new BufferedReader(new FileReader(file)));
     
    
    /*train_data.setClassIndex(train_data.numAttributes() - 1);
    cls.buildClassifier(train_data);
    */
    File file1 = new File("D:\\test1.arff");
    Instances test_data = new Instances(new BufferedReader(new FileReader(file1)));
    
    train_data.setClassIndex(train_data.numAttributes() - 1);
    cls.buildClassifier(train_data);
       test_data.setClassIndex(test_data.numAttributes() - 1);
    
    Evaluation eval = new Evaluation(train_data);
    eval.evaluateModel(cls, test_data );
    System.out.println(eval.toSummaryString("\nResults\n======\n", false));
    
  String x;
  String[] value = null;
     for (int i = 0; i < test_data.numInstances(); i++) {
            double pred = cls.classifyInstance(test_data.instance(i));
            System.out.print("given value: "
                    + test_data.classAttribute().value(
                            (int) test_data.instance(i).classValue()));
            System.out.println(". predicted value: "
                    + test_data.classAttribute().value((int) pred));
            
            x = test_data.classAttribute().value((int) pred);
            value = x.split("_");
     }
    int len = value.length;
    //int flag = 1;
    List drug_name = new ArrayList<String>();
    String y = "";
    for (int i = 0; i < len; i++) {
        System.out.println("val is "+ value[i] );
        if (value[i].length() <= 3) {
             y =y +   value[i] + value[i+ 1];
             i++;
             drug_name.add(y);
             //flag = 0;
        } else {
            drug_name.add(value[i]);
        }
    }
    System.out.println("list is "+ drug_name); 
    
    //writetrain()
    return drug_name;
/*ArffSaver saver = new ArffSaver();
 saver.setInstances(test_data);
 saver.setFile(new File("E:\\wekaoutput1.arff"));
 //saver.setDestination(new File("E:\\wekaoutput.arff"));   // **not** necessary in 3.5.4 and later
 saver.writeBatch();
  
  */          
   
             
             
             // display classifier
 /* final javax.swing.JFrame jf = 
      new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
    jf.setSize(1000, 1000);
    jf.getContentPane().setLayout(new BorderLayout());
    TreeVisualizer tv = new TreeVisualizer(null,
        cls.graph(),
        new PlaceNode2());
    jf.getContentPane().add(tv, BorderLayout.CENTER);
    jf.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent e) {
        jf.dispose();
      }
    });
 
    jf.setVisible(true);
    tv.fitToScreen();
  */
  }
}

