package drs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openrdf.OpenRDFException;
import org.openrdf.model.Value;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.rio.RDFParseException;



public class universal_drugfordisease {
    public Set s1 = new HashSet();  //stores drug_names
    public Set s2 = new HashSet();  //stores drug_ids
    public String sesameServerURL;
    public String repositoryID;
    public Repository rep;
    //public global_dec gl = new global_dec();
    //public Iterator entries = m1.entrySet().iterator();
    public RepositoryConnection con;
    //private Object g1;
    public void connection()
    {
        try {
            sesameServerURL = "http://localhost:8080/openrdf-sesame";
            
            repositoryID = "2";
            rep = new HTTPRepository(sesameServerURL, repositoryID);
            rep.initialize();
            con = rep.getConnection();
        } catch (RepositoryException ex) {
            Logger.getLogger(universal_drugfordisease.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

  public void universalset(String disease)
  {
        String dname1 = null;
        System.out.println("dissss "+ disease);
       
        
        String queryStri = "PREFIX diseasome: <http://www4.wiwiss.fu-berlin.de/diseasome/resource/diseasome/> "+
    "select ?drugid { "+
    "?s rdfs:label ?diseasename . filter regex(?diseasename,'"+disease+"', 'i')  ."+
    "?s diseasome:possibleDrug ?drugid ."+
    "}";
    
    
       try{    
            TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryStri);
      
            TupleQueryResult result = tupleQuery.evaluate();
            
            List<String> bindingNames = new ArrayList<String>();
                    
            try{
                 bindingNames = result.getBindingNames();
            }catch(Exception e){
                
            }
            
            try {
              
             
                while (result.hasNext()) {
                    
                    BindingSet bindingSet = result.next();
                    
                    Value firstValue1 = bindingSet.getValue(bindingNames.get(0));
                if(firstValue1 != null){
                    String drug_int = firstValue1.toString();
                    System.out.println("Drug ID" + drug_int);
                    s2.add(drug_int);
                    if(drug_int.contains("drugbank")){
                        drugname_drugbank drugid = new drugname_drugbank();
                    //con.close();
                        drugid.connection();
                        dname1  = drugid.namefromid(drug_int);
                        //System.out.println("Drug ID" + drug_int);
                         if(dname1.contains("\"")) {
                                                dname1 = dname1.substring(1,dname1.length()-1);
                                                System.out.println(dname1);
                                            }
                        s1.add(dname1);
                    }else if(drug_int.contains("dailymed")){
                        drugname_dailymed drugid = new drugname_dailymed();
                         
                       
                    //con.close();
                        drugid.connection();
                        dname1  = drugid.namefromid(drug_int);                      
                        if(dname1.contains("\"")) {
                                                dname1 = dname1.substring(1,dname1.length()-1);
                                                System.out.println(dname1);
                                            }
                        //System.out.println("Drug ID" + drug_int);
                        s1.add(dname1);
                    
                   }
                    String d2 = dname1;
                   global_dec.map_drugid_name.put(drug_int, d2); 
                   global_dec.map_name_drugid.put(d2, drug_int);
                        //    System.out.println("\nfirst"+"\n"+firstValue1);
                } 
               }
       }
        finally {
           //  con.close();
       //  out.close();
        }
       }catch (OpenRDFException e) {
            System.out.println("Catch Error\n");
   
        }
       System.out.println("List of drugs after diseasome     " + s1);
       
       drug_int dr = new drug_int();
       dr.connection();
       dr.interact(s1);
       
       sameas_sider_drug ssd = new sameas_sider_drug();
       ssd.connection();
       //Set allergyid = new HashSet();
       Iterator iter = s2.iterator();
       drug_allergy dr1 = new drug_allergy();
       dr1.connection();
            while (iter.hasNext()) {
                Object ele = iter.next();
                String siderid = ssd.sameasfromid((String)ele);
               // allergyid.add(siderid);
                Object val = global_dec.map_drugid_name.get((String)ele);
                System.out.print("allergies of " + (String)val  + "                        " +siderid);     
                 
                 if(siderid !=null &&  !siderid.isEmpty()) {
                    List<String> allergylist = dr1.allergyinteract(siderid);
                 //Object val = global_dec.map_drugid_name.get((String)ele);
                 System.out.print("allergielist =                        " + allergylist); 
                 global_dec.map_allergyint.put((String)val, allergylist);
                 
                } else {
                     List<String> allergylist = new ArrayList<>();
                     allergylist.add("empty");
                      global_dec.map_allergyint.put((String)val, allergylist);
                 }
            }
           // global_dec g = new global_dec();
            //    g.displaymap1();
      
     
    
    }
    
    public static void main(String str[]) throws RepositoryException, IOException, RDFParseException 
    {
        //int flag=0;
       universal_drugfordisease uni_drug = new   universal_drugfordisease();
       uni_drug.connection();
        //String s = "17,20-lyase deficiency";
       uni_drug.universalset("17,20-lyase deficiency");
        
      
 
  
        global_dec.final_drugs.clear();
        global_dec.map_allergyint.clear();
        global_dec.map_drugid_name.clear();
        global_dec.map_drugint.clear();
        
        
        global_dec g = new global_dec();
        g.displaymap();
        g.displaymap1();
        g.displaymap2(); 
       intersection ob = new intersection();
       
    }
}