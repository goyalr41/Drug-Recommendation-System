package drs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class server 
{
 
    private static Socket socket;
 
    public static void main(String[] args) 
    {
        try
        {
 
            int port = 19000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
 
            //Server is running always. This is done using this while(true) loop
            while(true) 
            {
                socket = serverSocket.accept();
               /* InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                System.out.println("Message received from client is "+number); */
                //Reading the message from the client
              //  socket = serverSocket.accept();
                ArrayList<String> input = new ArrayList<String>();
                
                List patientout = new ArrayList<String>();
                 //List doctorout_sem = new ArrayList<String>();
                 
                  List doctorout_mining = new ArrayList<String>();
            try {
                ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream()); //Error Line!
                
                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
               try {
                    Object object = objectInput.readObject();
                    input =  (ArrayList<String>) object;
                    System.out.println("input = " + input);
                    if(input.size() == 1){
                            patient_output pat = new patient_output();
                            patientout = pat.out(input);
                            objectOutput.writeObject(patientout);
                            pat.clear();
                    }else{
                        List<String> doctorout_sem = new ArrayList<String>();
                        List<String> small_sem = new ArrayList<String>();
                        List<String> l = new ArrayList<>();
                   
                        
                        try{
                            global_dec obg = new global_dec();
                            obg.clearfun();
                            split_lists sp = new split_lists();
                            sp.split(input);
                      //   l.add("LORAZEPAM (Tablet)");l.add("Flurazepam");
                      //  l.add("Tetracycline");
                     //   objectOutput.writeObject(l);
                             //doctorout_sem.clear();
                            doctorout_sem = global_dec.final_drugs;
                     //       System.out.println("fnal druuuuuuugs" + doctorout_sem);
                            small_sem.clear();
                            if(doctorout_sem.size() == 0){
                                List<String> exc = new ArrayList<String>();
                                exc.add("No Result Found");
                                objectOutput.writeObject(exc);
                            }else{
                                System.out.println("IN ELSE");
                                Iterator it = doctorout_sem.iterator();
                                int i = 0;
                                
                                while(it.hasNext() && i < 5){
                                    Object dr = it.next();
                                    String res = (String)dr;
                                    small_sem.add(res);
                                   // small_sem.add(doctorout_sem.get(i));
                                    i++;
                                }
                                System.out.println("fnal druuuuuuugs ========== " + small_sem);
                                objectOutput.writeObject(small_sem);
                            }
                            
                            objectOutput.flush();
                        }catch(Exception e){
                            List<String> exc = new ArrayList<String>();
                            exc.add("No Result Found");
                            objectOutput.writeObject(exc);
                            objectOutput.flush();
                        }
                        
                        try{
                            arff_filewrite ob = new arff_filewrite();
                        
                            ob.write(input);
                        
                            VisualizeJ48 v_ob = new VisualizeJ48();
                         
                            doctorout_mining = v_ob.mining_result(); 
                            if(doctorout_mining.size() == 0){
                                List<String> exc = new ArrayList<String>();
                                exc.add("No Result Found");
                                objectOutput.writeObject(exc);
                                
                            }else{
                                objectOutput.writeObject(doctorout_mining);
                            }
                            objectOutput.flush();
                        }catch(Exception e){
                            List<String> exc = new ArrayList<String>();
                            exc.add("No Result Found");
                            objectOutput.writeObject(exc);
                            objectOutput.flush();
                        }
                    } 
                        
                } catch (ClassNotFoundException e) {
                    System.out.println("The title list has not come from the server");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("The socket for reading the object has problem");
                e.printStackTrace();
            }
                
             
               // System.out.println("Message sent to the client is "+returnMessage);
                //bw.flush();
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        try 
                {
                    ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                    objectOutput.writeObject(global_dec.final_drugs);               
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }
    }
    
}

/*OutputStream os = socket.getOutputStream();
                            OutputStreamWriter  osw= new OutputStreamWriter(os);
                       
                            BufferedWriter bw = new BufferedWriter(osw); */
                        
                            /* serversend ss= new serversend();
                            ss.connectnow();*/
                            /*int i = 0;
                            Iterator it = doctorout_sem.iterator();
                            while(i<5) {
                                if(it.hasNext()){
                           
                                bw.write(it.next().toString());
                                }else {
                                    bw.write("");
                                }
                      
                                i++;
                            }*/