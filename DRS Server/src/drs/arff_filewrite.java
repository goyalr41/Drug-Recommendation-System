package drs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arff_filewrite {
    
    void write(List input) throws FileNotFoundException, IOException
    {
        File file = new File("D:\\test1.arff");
        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);   

        
        File inp_file = new File("D:\\test.arff");
        BufferedReader br = new BufferedReader(new FileReader(inp_file));
        String line;
        
        String x;
        Iterator it = input.iterator();
        
        while ((line = br.readLine()) != null) {
            out.write(line);
            out.write("\n");
        }
        //int i = input.size()-;
        //int j = 0;
        
        
        while( it.hasNext()){
            String fin = ""; 
            Object ele = it.next();
            String ss = ele.toString();
            for(int i = 0; i < ss.length(); i++){
                if(ss.charAt(i) == 32){
                    fin += "_";
                }else{
                      fin += ss.charAt(i);
                }
            }
         // System.out.println("sss == " +fin);
          out.write(fin);out.write(",");
            
        }
        out.write("?");
        out.close();
    }
   /* public static void main(String[] args) throws FileNotFoundException, IOException
    {
        arff_filewrite ob = new arff_filewrite();
        List in = new ArrayList<String>();
        in.add("FEMALE");
        in.add("12");
        in.add("YES");
        in.add("YES");
        in.add("37");
        //in.add("16");
        in.add("?");
        in.add("drug_dependence");
        in.add("?");
        in.add("Propericiazine");
        in.add("Protoporphyria_erythropoietic");
       in.add("Leukemia_Philadelphia_chromosome_positive_resistant_to_imatinib");
        //in.add("")
        ob.write(in);
    }*/
}
    

