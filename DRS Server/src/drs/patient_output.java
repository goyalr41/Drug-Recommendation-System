package drs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFParseException;

public class patient_output {
    Iterator iter;
    
        List result = new ArrayList<>();
        String drugdes = "";
        String foodint = "";
        String toxicity = "";
        String indication = "";
        String side_effects = "";
        String drugint = "";
        String pharma = "";
        List <String> sideeffects = new ArrayList<>();
        List <String> druginteracts = new ArrayList<>();
    List<String> out(List l) throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException
    {
        String drug = (String) l.get(0);
        System.out.println("drugname = " + drug);
        details_drug ob = new details_drug();
        ob.connect();
        
        ob.drug_descrption(drug);
        ob.food_interaction(drug);
        ob.indication(drug);
        ob.pharmacolgy(drug);
        ob.toxicity(drug);
        
        sideeffects = ob.side_effects(drug);
        druginteracts = ob.drug_interactions(drug);
        
        iter = global_druglists.drug_descp.iterator();
       if(iter.hasNext()){
       while (iter.hasNext()) {
                Object ele = iter.next();
                drugdes += (String)ele + "<br>";
       }
       }else{
           drugdes = "No information Available";
       }
       
       
       iter = global_druglists.drug_foodint.iterator();
       if(iter.hasNext()){
       while (iter.hasNext()) {
                Object ele = iter.next();
                foodint += (String)ele + "<br>";
       }
       }else{
           foodint = "No information Available";
       }
       
       iter = global_druglists.drug_ind.iterator();
       
       if(iter.hasNext()){
       while (iter.hasNext()) {
                Object ele = iter.next();
                indication += (String)ele + "<br>";
       }
       }else{
           indication = "No information Available";
       }
       
       if(iter.hasNext()){
       iter = global_druglists.drug_tox.iterator();
       
       while (iter.hasNext()) {
                Object ele = iter.next();
                toxicity += (String)ele + "<br>";
       }
       }else{
           toxicity = "No information Available";
       }
        
       iter = global_druglists.drug_pharma.iterator();
       
       if(iter.hasNext()){
       while (iter.hasNext()) {
                Object ele = iter.next();
                pharma += (String)ele + "<br>";
       }
       }else{
           pharma = "No information Available";
       }
       
       
       iter = sideeffects.iterator();
       int i = 0;
       
       if(iter.hasNext()){
           if(iter.next().toString() != "empty"){
                while(iter.hasNext() && i < 10){
                    Object ele = iter.next();
                    side_effects += (String)ele + "<br>";
                    i++;
                }
           }else{
               side_effects = "No information Available";
           }
       }else{
           side_effects = "No information Available";
       }
       
       i = 0;
       iter = druginteracts.iterator();
       if(iter.hasNext()){
           if(iter.next().toString() != "empty"){
                while(iter.hasNext() && i < 10){
                    Object ele = iter.next();
                    drugint += (String)ele + "<br>";
                    i++;
                }
           }else{
               drugint = "No information Available";
           }
       }else{
           drugint = "No information Available";
       }
       
       result.add(drugdes);result.add(foodint);result.add(toxicity);result.add(indication);
       result.add(side_effects);result.add(drugint);result.add(pharma);
       
       return result;
       
    }
     void clear()
     {
         global_druglists.drug_descp.clear();
         global_druglists.drug_foodint.clear();
         global_druglists.drug_ind.clear();
         global_druglists.drug_pharma.clear();
         global_druglists.drug_tox.clear();
         result.clear();sideeffects.clear();druginteracts.clear();
         drugdes = "";
         foodint = "";
         toxicity = "";
         indication = "";
         side_effects = "";
         drugint = "";
         pharma = "";
     }
}
