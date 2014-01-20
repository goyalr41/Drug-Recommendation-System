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

public class drugcategory {
    
    public String sesameServerURL;
    public String repositoryID;
    public Repository rep;
    
    public RepositoryConnection con;
    public void connection()
    {
        try {
            sesameServerURL = "http://localhost:8080/openrdf-sesame";
            repositoryID = "3";
            rep = new HTTPRepository(sesameServerURL, repositoryID);
            rep.initialize();
            con = rep.getConnection();
        } catch (RepositoryException ex) {
            Logger.getLogger(drugcategory.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public List<List<String>> drugcategory(List<String> drugname)
    {
        Iterator iter = drugname.iterator();
            int cnt = 0;
        while(iter.hasNext()){
       
        String drugcate = null;
        String drugid = global_dec.map_name_drugid.get(iter.next());
       // System.out.println("drugid issssssss      " + drugid);
     
        String queryStri = "select * where {<"   + drugid + "> <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/drugCategory> ?o}";
                
       try{    
           // RepositoryConnection con = rep.getConnection();
           //System.out.println(con.getRepository().getConnection());
            TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryStri);
      
            TupleQueryResult result = tupleQuery.evaluate();
      
            List<String> bindingNames = result.getBindingNames();
      
            try {
                int gh = 0;
                while (result.hasNext()) {
                    gh++;
                    BindingSet bindingSet = result.next();
                    drugcate = bindingSet.getValue(bindingNames.get(0)).toString();
                    if(global_dec.map_categorydrug.containsKey((String)drugcate)) {
                      List<String> temp =  global_dec.map_categorydrug.get((String)drugcate);
                       drugname_drugbank getdrugid = new drugname_drugbank();
                    //con.close();
                        getdrugid.connection();
                        String dname  = getdrugid.namefromid(drugid);
                     temp.add(dname);
                    
                     global_dec.map_categorydrug.put((String)drugcate,temp);
                    }else {
                        List<String> temp = new ArrayList<>();
                           drugname_drugbank getdrugid = new drugname_drugbank();
                    //con.close();
                        getdrugid.connection();
                        String dname  = getdrugid.namefromid(drugid);
                     temp.add(dname);
                        global_dec.map_categorydrug.put((String)drugcate,temp);
                    }
                  
                //    System.out.println("            DRUGNAME FROM DRUGID                                  " + drugname);
                    
                 } 
                if(gh == 0){
                     List<String> temp = new ArrayList<>();
                           drugname_drugbank getdrugid = new drugname_drugbank();
                    //con.close();
                        getdrugid.connection();
                        String dname  = getdrugid.namefromid(drugid);
                     temp.add(dname);
                     String j = (cnt++) + "";
                        global_dec.map_categorydrug.put((String)j,temp);
                }
       }
        finally {
           //  con.close();
       //  out.close();
        }
       }catch (OpenRDFException e) {
            System.out.println("Catch Error\n");
   
        }
        }
          return makelislist();
     }
    
    public List<List<String>> makelislist(){
            List<List<String>> lst = new ArrayList<List<String>>() ;
            for (Map.Entry<String, List<String>> entry : global_dec.map_allergyint.entrySet()) {
             //System.out.println("IN MAP ALLERGIES");
                String key = entry.getKey();
                List<String> temp1 = entry.getValue();
                lst.add(temp1);
            }   
            TupleofDrugs tod = new TupleofDrugs();
            return tod.tuple(lst);
    }
}