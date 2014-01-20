package drs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openrdf.OpenRDFException;
import org.openrdf.model.Value;
import org.openrdf.query.BindingSet;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.rio.RDFParseException;

public class details_drug {
    public RepositoryConnection con;
    
    void connect() throws RepositoryException, IOException, RDFParseException 
    {
        
        String sesameServerURL = "http://localhost:8080/openrdf-sesame";
        String repositoryID = "3";
        Repository rep = new HTTPRepository(sesameServerURL, repositoryID);
        rep.initialize(); 
   
         con = rep.getConnection();
    }
    void drug_descrption(String drug) throws RepositoryException, MalformedQueryException, QueryEvaluationException
    {
        String queryString =   "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>" +
                "SELECT ?drugDesc " +
                " WHERE {?drug rdfs:label ?drugname . filter regex(?drugname, '"+ drug +"', 'i')  ." +
                "OPTIONAL { ?drug drugbank:description ?drugDesc .}" +
                "}";
           
        TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        TupleQueryResult result = tupleQuery.evaluate();
      
         List<String> bindingNames = result.getBindingNames();
         
        
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();
                Value firstValue1 = bindingSet.getValue(bindingNames.get(0));
                if(firstValue1 != null){
                String ans = firstValue1.toString();
                global_druglists.drug_descp.add(ans);
                }
            }
    }
    void food_interaction(String drug) throws RepositoryException, MalformedQueryException, QueryEvaluationException
    {
        String queryString =   "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>" +
                "SELECT ?foodint" +
                " WHERE {?drug rdfs:label ?drugname . filter regex(?drugname, '"+drug+"', 'i')  ." +
                "OPTIONAL {?drug drugbank:foodInteraction ?foodint .}" +
                "}";
           
        TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        TupleQueryResult result = tupleQuery.evaluate();
      
         List<String> bindingNames = result.getBindingNames();
         
       // System.out.println("Size in foodintlist = " + result.size());
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();
                Value firstValue1 = bindingSet.getValue(bindingNames.get(0));
               if(firstValue1 != null){
                
                //System.out.println("string = " + firstValue1.toString());
                    String ans = firstValue1.toString();
                    System.out.println("string = " + ans);
                    global_druglists.drug_foodint.add(ans);
               }
            }
    }
    void indication(String drug) throws RepositoryException, MalformedQueryException, QueryEvaluationException
    {
        String queryString =   "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>" +
                "SELECT ?indication" +
                " WHERE {?drug rdfs:label ?drugname . filter regex(?drugname, '"+drug+"', 'i')  ." +
                "OPTIONAL { ?drug drugbank:indication ?indication.}" +
                "}";
           
        TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        TupleQueryResult result = tupleQuery.evaluate();
      
         List<String> bindingNames = result.getBindingNames();
         
        
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();
                Value firstValue1 = bindingSet.getValue(bindingNames.get(0));
                if(firstValue1 != null){
                String ans = firstValue1.toString();
                global_druglists.drug_ind.add(ans);
                }
            }
    }
    void toxicity(String drug) throws RepositoryException, MalformedQueryException, QueryEvaluationException
    {
        String queryString =   "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>" +
                "SELECT ?od " +
                " WHERE {?drug rdfs:label ?drugname . filter regex(?drugname, '"+drug+"', 'i')  ." +
                "OPTIONAL { ?drug drugbank:toxicity ?od.}" +
                "}";
           
        TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        TupleQueryResult result = tupleQuery.evaluate();
      
         List<String> bindingNames = result.getBindingNames();
         
        
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();
                Value firstValue1 = bindingSet.getValue(bindingNames.get(0));
                if(firstValue1 != null){
                String ans = firstValue1.toString();
                global_druglists.drug_tox.add(ans);
                }
            }
    }
    void pharmacolgy(String drug) throws RepositoryException, MalformedQueryException, QueryEvaluationException
    {
        String queryString =   "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>" +
                "SELECT ?pharma " +
                " WHERE {?drug rdfs:label ?drugname . filter regex(?drugname, '"+drug+"', 'i')  ." +
                "OPTIONAL { ?drug drugbank:pharmacology ?pharma.}" +
                "}";
           
        TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        TupleQueryResult result = tupleQuery.evaluate();
      
         List<String> bindingNames = result.getBindingNames();
         
        
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();
                Value firstValue1 = bindingSet.getValue(bindingNames.get(0));
                if(firstValue1 != null){
                String ans = firstValue1.toString();
                global_druglists.drug_pharma.add(ans);
                }
            }
    }
    
    List <String> side_effects(String drug) throws RepositoryException, MalformedQueryException, QueryEvaluationException
    {
        String queryString =   "PREFIX drugbank: <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/>" +
                "SELECT ?drugid " +
                " WHERE {?drugid rdfs:label ?drugname . filter regex(?drugname, '"+drug+"', 'i')  ." +
                "}";
        TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
        TupleQueryResult result = tupleQuery.evaluate();
      
         List<String> bindingNames = result.getBindingNames();
         String ans = null;
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();
                Value firstValue1 = bindingSet.getValue(bindingNames.get(0));
                 ans = firstValue1.toString();
                // System.out.println("drugid = " + ans);
            }
            
        List<String> allergylist = new ArrayList<>();
        sameas_sider_drug ssd = new sameas_sider_drug();
       ssd.connection();
       String siderid = ssd.sameasfromid(ans);
       
      // System.out.println("siderid = " + siderid);
       drug_allergy dr1 = new drug_allergy();
       
        if(siderid !=null &&  !siderid.isEmpty()) {
            dr1.connection();        
            allergylist = dr1.allergyinteract(siderid);
                 //Object val = global_dec.map_drugid_name.get((String)ele);
        //         System.out.print("allergielist =                        " + allergylist); 
                 
                 
         } else {
                     allergylist = new ArrayList<>();
                     allergylist.add("empty");
           }
        return allergylist;
       
    }
    
    List <String> drug_interactions(String drug) throws RepositoryException, MalformedQueryException, QueryEvaluationException
    {
        drug_int dr = new drug_int();
        dr.connection();
        
        Set s1 = new HashSet(); 
        s1.add(drug);
        List<String> l = new ArrayList<>();
        
        dr.interact(s1);
        for (Map.Entry<String, List<String>> entry : global_dec.map_drugint.entrySet()) {
              String key = entry.getKey();
               l= entry.getValue();
              
         }
        
        return l;
       
    }
  /*  public static void main(String[] args) throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException
    {
        details_drug ob = new details_drug();
        ob.connect();
        
        ob.drug_descrption("aspirin");
        ob.food_interaction("aspirin");
        ob.indication("aspirin");
        ob.pharmacolgy("aspirin");
        ob.toxicity("aspirin");
        List <String> l1 = ob.side_effects("Clomifene");
        List <String> l2 = ob.drug_interactions("Peginterferon alfa-2a");
       // System.out.print("druglist =                        " + l2); 
        //System.out.print("allergielistsize =                        " + l.size()); 
        //System.out.print("allergielist =                        " + l); 
        /*System.out.println("drugdesc" + global_druglists.drug_descp);
        System.out.println("foodint" + global_druglists.drug_foodint);
        System.out.println("indi" + global_druglists.drug_ind);
        System.out.println("toxicity" + global_druglists.drug_tox);
        System.out.println("pharma" + global_druglists.drug_pharma); 
        
    }*/
}
  
            
                    
        
            