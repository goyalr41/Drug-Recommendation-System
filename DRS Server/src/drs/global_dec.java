package drs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.io.*;

/**
 *
 * @author Sid
 */
public class global_dec {
    public static  Map<String, List<String> > map_drugint = new HashMap<>();
    
     public static  Map<String, List<String> > map_allergyint = new HashMap<>();
     public static  Map<String, List<String> > map_categorydrug = new HashMap<>();
       public static  Map<String,String> map_drugid_name = new HashMap<>();
       public static  Map<String,String> map_name_drugid = new HashMap<>();
       public static List <String> final_drugs = new ArrayList<>();
       
       void clearfun()
       {
           map_drugint.clear();
           map_allergyint.clear();
           map_categorydrug.clear();
           map_drugid_name.clear();
           map_name_drugid.clear();
         //  final_drugs.clear();
       }
        
    void displaymap()
    {     
        
         //for (List<String> l : map_drugint.values()) {
         //    System.out.println(l.size() + ": " + l);
        // }
         
         for (Map.Entry<String, List<String>> entry : map_drugint.entrySet()) {
              String key = entry.getKey();
              List<String> l= entry.getValue();
              System.out.println("drugint = " + key + "sizelist = " + l.size() + ": interacting_drugs = " + l);
         }
         
         
         
    }
    void displaymap1()
    {     
        
        // for (List<String> l : map_allergyint.values()) {
        //     System.out.println(l.size() + ": " + l);
        // }
         
         for (Map.Entry<String, List<String>> entry : map_allergyint.entrySet()) {
             //System.out.println("IN MAP ALLERGIES");
              String key = entry.getKey();
              List<String> l= entry.getValue();
             if (!l.isEmpty()) {
              System.out.println("drug = " + key + " sizelist = " + l.size() + " : allergies  = " + l);
         } else System.out.println("drug = " + key + " :no allergies  = " ); 
             
         
         }  
         
    }
    void displaymap2()
    {     
        
        // for (List<String> l : map_allergyint.values()) {
        //     System.out.println(l.size() + ": " + l);
        // }
         
         for (Map.Entry<String, String> entry : map_drugid_name.entrySet()) {
              String key = entry.getKey();
             String l= entry.getValue();
              System.out.println("drug = " + key + "sizelist = " + ": " + l);
         }
         
         
         
    }
    /*void displayfile()
    {     
        
         for (List<String> l : map_drugint.values()) {
             System.out.println(l.size() + ": " + l);
         }
         
         for (Map.Entry<String, List<String>> entry : map_drugint.entrySet()) {
              String key = entry.getKey();
              List<String> l= entry.getValue();
              File file = new File("C:\\Users\\Sid\\Documents\\NetBeansProjects\\project\\src\\output.txt");
              FileWriter fstream = new FileWriter(file);
              BufferedWriter out = new BufferedWriter(fstream);  
              //System.out.println("drug = " + key + "sizelist = " + l.size() + ": " + l);
         }
         
         
         
    }*/
    
    

}
