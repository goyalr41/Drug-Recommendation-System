package drs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class appendedfile {
    
   void append(List input) throws IOException{
            /*File file =new File("D:\\test1.arff");
 
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
 
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter out = new BufferedWriter(fileWritter);
    	       // bufferWritter.write("l");
    	       // bufferWritter.close();
 
	        System.out.println("Done");
                out.append("hii");
                Iterator it = input.iterator();
        
        
        while( it.hasNext()){
           // System.out.println("hii");
            Object ele = it.next();
          String ss = ele.toString();
          out.append(ss);out.append(",");
          
        }
        out.append("?");
        out.close(); */
       String path = "D:\\test1.arff";       
      
        //creating file object from given path
        File file = new File(path);
      
        //FileWriter second argument is for append if its true than FileWritter will
        //write bytes at the end of File (append) rather than beginning of file
        FileWriter fileWriter = new FileWriter(file,true);
      
        //Use BufferedWriter instead of FileWriter for better performance
        BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);
       // fileWriter.append("This text should be appended in File form Java Program");
        
        Iterator it = input.iterator();
        
        
        while( it.hasNext()){
           // System.out.println("hii");
            Object ele = it.next();
          String ss = ele.toString();
          fileWriter.append(ss);fileWriter.append(",");
          
        }
        fileWriter.append("?");
      
        //Don't forget to close Streams or Reader to free FileDescriptor associated with it
        bufferFileWriter.close();


    }
   public static void main(String[] args) throws IOException
   {
       appendedfile ob = new appendedfile();
        List in = new ArrayList<String>();
        in.add("FEMALE");
        in.add("12");
        in.add("YES");
        in.add("YES");
        in.add("37");
        in.add("16");
        in.add("?");
        in.add("drug_dependence");
        in.add("?");
        in.add("Propericiazine");
        in.add("Protoporphyria_erythropoietic");
        in.add("Leukemia_Philadelphia_chromosome_positive_resistant_to_imatinib");
        //in.add("")
        ob.append(in);
   }
}
