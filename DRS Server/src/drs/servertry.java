package drs;

  import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
 
public class servertry 
{
 
    private static Socket socket;
 
    public void connectnow() throws IOException 
    {
        try
        {
 
            int port = 18000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
 
            //Server is running always. This is done using this while(true) loop
           // while(true) 
           // {
                //Reading the message from the client
                socket = serverSocket.accept();
               /* InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                System.out.println("Message received from client is "+number);
 */
                //Multiplying the number by 2 and forming the return message
              /*  String returnMessage;
                try
                {
                    int numberInIntFormat = Integer.parseInt(number);
                    int returnValue = numberInIntFormat*2;
                    returnMessage = String.valueOf(returnValue) + "\n";
                }
                catch(NumberFormatException e)
                {
                    //Input was not a number. Sending proper message back to client.
                    returnMessage = "Please send a proper number\n";
                }
 */
                 OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                
                int i = 0;
                       Iterator it = global_dec.final_drugs.iterator();
                        //while(i<5) {
                       String o = null ;
                            while(it.hasNext() && i < 5){
                           i++;
                            o = o +  it.next().toString() + "*";
                           
                           System.out.println("val  " + o);
                           
                             //bw.write("*");
                             //bw.flush();
                            }
                              bw.write(o);
                              bw.flush();
                           /* while(i < 5){
                                i++;
                                bw.write("");
                                bw.flush();
                            }*/
                       //objectOutput.writeObject(doctorout_sem);
                        //i++;
                        
                        //}
                      //  objectOutput.writeObject(doctorout_mining);
                    
                
                
                //Sending the response back to the client.
               
                //bw.write(returnMessage);
                //System.out.println("Message sent to the client is "+returnMessage);
                //bw.flush();
            
        }
        catch (Exception e) 
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