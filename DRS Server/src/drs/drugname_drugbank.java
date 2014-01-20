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

public class drugname_drugbank {
    
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
            Logger.getLogger(drugname_drugbank.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public String namefromid(String drugid)
    {
        String drugname = null;
       
       // System.out.println("drugid issssssss      " + drugid);
     
        String queryStri = "select * where {<"   + drugid + "> rdfs:label ?o}";
                
       try{    
           // RepositoryConnection con = rep.getConnection();
           //System.out.println(con.getRepository().getConnection());
            TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryStri);
      
            TupleQueryResult result = tupleQuery.evaluate();
      
            List<String> bindingNames = result.getBindingNames();
         
            try {
              
                while (result.hasNext()) {
                    
                    BindingSet bindingSet = result.next();
                    drugname = bindingSet.getValue(bindingNames.get(0)).toString();
                    
                //    System.out.println("            DRUGNAME FROM DRUGID                                  " + drugname);
                    
                 } 
       }
        finally {
           //  con.close();
       //  out.close();
        }
       }catch (OpenRDFException e) {
            System.out.println("Catch Error\n");
   
        }
       return drugname;
     }
    
}