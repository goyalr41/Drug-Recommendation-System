package com.example.DRS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ClientDrugSearch
{

    private static Socket socket;
    static String host = "172.17.11.205";

    public void connectnow(List<String> sendlist)
    {
        try
        {
            //String host = "";
            int port = 19000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(host, port);

            //Send the message to the server
            /*OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
 
            String number = "2";
 
            String sendMessage = number + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage);
            * */
            //Get the return message from the server
            ArrayList<String> titleList = new ArrayList<String>();

            try {

                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(sendlist);

                ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
                Object object = objectInput.readObject();
                DrugInfo.drugresult = (ArrayList<String>) object;


            } catch (IOException e) {
                System.out.println("The socket for reading the object has problem");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}