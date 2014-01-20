

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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

public class drug_interaction {
    public Map m1 = new HashMap();
    public String sesameServerURL;
    public String repositoryID;
    public Repository rep;
    public Iterator entries = m1.entrySet().iterator();
    
    public void connection()
    {
        try {
            sesameServerURL = "http://localhost:8080/openrdf-sesame";
            repositoryID = "1";
            rep = new HTTPRepository(sesameServerURL, repositoryID);
            rep.initialize();
        } catch (RepositoryException ex) {
            Logger.getLogger(drug_interaction.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public void fun(String drug)
    {
        String queryStri = "select ?side where {?s <http://www4.wiwiss.fu-berlin.de/sider/resource/sider/drugName> '"+ drug +"'." +
        "?s <http://www4.wiwiss.fu-berlin.de/sider/resource/sider/sideEffect> ?side}";
    
    
       try{    
            RepositoryConnection con = rep.getConnection();
            System.out.println(con.getRepository().getConnection());
            TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryStri);
      
            TupleQueryResult result = tupleQuery.evaluate();
      
            List<String> bindingNames = result.getBindingNames();
         
            try {
                while (result.hasNext()) {
            
                    BindingSet bindingSet = result.next();
                    Value side = bindingSet.getValue(bindingNames.get(0));
                    System.out.println("sider = " + side);
                    if(!m1.containsKey(side)){
                        m1.put(side.toString(),1);
                    }else{
                        int val = (int) m1.get(side);
                        val++;
                        m1.put(side.toString(),val);
                    }
                        //    System.out.println("\nfirst"+"\n"+firstValue1);
                } 
       }
        finally {
           //  con.close();
       //  out.close();
        }
       }catch (OpenRDFException e) {
            System.out.println("He\n");
   
        }
    //System.out.print("\n" + m1);
    }
    public void filter()
    {
        while(entries.hasNext()){
            Map.Entry entry = (Map.Entry)entries.next();
            Integer value = (Integer)entry.getValue();
            if(value > 1){
                System.out.println("wtf");
                String key = (String)entry.getKey();
                m1.remove(key);
            }
        }
    }
    public static void main(String str[]) throws RepositoryException, IOException, RDFParseException 
    {
        int flag=0;
        drug_interaction drug = new drug_interaction();
        drug.connection();
        drug.fun("Ritalin");
        drug.fun("retinol");
        drug.fun("BRETYLIUM TOSYLATE");
        drug.filter();
        
    }
}