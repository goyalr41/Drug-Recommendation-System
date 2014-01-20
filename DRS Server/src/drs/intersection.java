package drs;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class intersection {
    List <String> finaldrug_all = new ArrayList<>();
   List <String> finaldrug_drugint = new ArrayList<>();
    public void allergy_intersection(List l)
    {
      
       Iterator it = l.iterator();
                
            for (Map.Entry<String, List<String>> entry : global_dec.map_allergyint.entrySet()) {
             //System.out.println("IN MAP ALLERGIES");
                String key = entry.getKey();
                List<String> temp1 = entry.getValue();
                
                List<String> temp = new ArrayList<String> (15);
                int allernum = temp1.size(); // gets the exact number of elements I want
                /*if (allernum > 10) {
                    
                    for (int i = 0; i < 10; i++) {
                         temp.add(temp1.get(i));
                    }
                }else{
                    temp = temp1;
                }*/
       
               
                int flag = 0;
                while (it.hasNext()) {
                    Object dr = it.next();
                    String prev_allergy = (String)dr;
       
                    boolean val = temp1.contains(prev_allergy);
                    if(val == true) {
                        flag = 1;
                    }
                }
                
                    if(flag == 0){
                        finaldrug_all.add(key);
                    }
            
         }
          System.out.println("final druglist aftr allergyintersectns=           "  + finaldrug_all);  
    
    
    }
    public void drug_intersection(List l)
    {
      
       Iterator it = l.iterator();
                
            for (Map.Entry<String, List<String>> entry : global_dec.map_drugint.entrySet()) {
             //System.out.println("IN MAP ALLERGIES");
                String key = entry.getKey();
                List<String> temp = entry.getValue();
                
                int flag = 0;
                
                while (it.hasNext()) {
                    Object dr = it.next();
                    String prev_drugs = (String)dr;
                       
                    boolean val = temp.contains(prev_drugs);
                    if(val == true){
                        flag = 1;
                    }
               
                  
            }
                  if(flag == 0){
                        finaldrug_drugint.add(key);
                    }
         }
          System.out.println("final list after druginteraction=           "  + finaldrug_drugint);  
    
    
    }
    public void final_drugs()
    {
        global_dec.final_drugs.clear();
        Iterator it = finaldrug_all.iterator();
       while (it.hasNext()) {
                Object dr = it.next();
                String drug = (String)dr;
                if(finaldrug_drugint.contains(drug)){
                    global_dec.final_drugs.add(drug);
                }
       }
    }
    public static void main(String args[])
    {
     //   List <String> prev_all = new ArrayList<>();
        
    }
}
