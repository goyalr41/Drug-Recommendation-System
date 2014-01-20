package com.example.DRS;

import android.widget.Toast;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientSemQuery
{

    private static Socket socket;
    private String[] List2;


    public String[] connectnow(List<String> sendlit)
    {
        try
        {
            String host = "";
            int port = 19000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(ClientDrugSearch.host, port);

            /*//Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
 
            String number = "2";
 
            String sendMessage = number + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage);   */

            //Get the return message from the server
            List<String> mylist = new ArrayList<String>();
            mylist.add("Raman");
            mylist.add("Shyam");
            mylist.add("ghhh");
            mylist.add("totp");

            try {

                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(sendlit);

               /* ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
                Object object = objectInput.readObject();
                object = objectInput.readObject();
                Result.semanticresult = (ArrayList<String>) object; */
                Clientinputdat cid = new Clientinputdat();
                List2 =  cid.connectnow();





                //Result.semanticresult = mylist;

                //object = objectInput.readObject();
                //miningresult = (ArrayList<String>) object;

            } catch (IOException e) {
                System.out.println("The socket for reading the object has problem");
                e.printStackTrace();
            } catch (/*ClassNotFoundException*/ Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            //Result.semanticresult = mylist;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }       */
      return List2;
    }



}