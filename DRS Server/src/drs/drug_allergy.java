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
import java.util.*;

public class drug_allergy {
    public Set s1 = new HashSet();
    public String sesameServerURL;
    public String repositoryID;
    public Repository rep;
    //public Iterator entries = m1.entrySet().iterator();
    public RepositoryConnection con;
    
    public void connection()
    {
        try {
            sesameServerURL = "http://localhost:8080/openrdf-sesame";
            repositoryID = "1";
            rep = new HTTPRepository(sesameServerURL, repositoryID);
            rep.initialize();
            con = rep.getConnection();
        } catch (RepositoryException ex) {
            Logger.getLogger(drug_allergy.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public List<String> allergyinteract(String drugcast)
    {
        //Iterator iter = s1.iterator();
          //  while (iter.hasNext()) {
            //    Object dr = iter.next();
             List<String> l= new ArrayList<>();
                //'Peginterferon alfa-2a'
             //String drugcast = (String)dr;
    
        String queryStri = "PREFIX drugbank:<http://www4.wiwiss.fu-berlin.de/drugbank/resource/sider/>" + 
                            "select DISTINCT ?allergyname where {<" + 
                                 drugcast + "> <http://www4.wiwiss.fu-berlin.de/sider/resource/sider/sideEffect> ?o." +
                                " ?o <http://www4.wiwiss.fu-berlin.de/sider/resource/sider/sideEffectName> ?allergyname" +
                                
                            "}";
           
    
       try{    
           // RepositoryConnection con = rep.getConnection();
           //System.out.println(con.getRepository().getConnection());
            TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryStri);
      
            TupleQueryResult result = tupleQuery.evaluate();
      
            List<String> bindingNames = result.getBindingNames();
          
            try {
               
                while (result.hasNext()) {
                    
                    BindingSet bindingSet = result.next();
                    String drug_int = bindingSet.getValue(bindingNames.get(0)).toString();
                    
                    l.add(drug_int);
                } 
       }
        finally {
           //  con.close();
       //  out.close();
        }
       }catch (OpenRDFException e) {
            System.out.println("Catch Error\n");
   
        }
       
       return l; 
   
     }
    
  
}