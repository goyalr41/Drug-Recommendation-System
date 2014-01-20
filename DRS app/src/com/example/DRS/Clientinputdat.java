package com.example.DRS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clientinputdat
{

    private static Socket socket;
    List<String> semanticresult = new ArrayList<String>();
    public String[]  connectnow()

    {
        String[] temp = null;
        try
        {
            String host = "localhost";
            int port = 18000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(ClientDrugSearch.host, port);

            //Send the message to the server
           /* OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String number = "2";

            String sendMessage = number + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage); */

            //Get the return message from the server
            //Result.semanticresult = new ArrayList<String>();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String h = br.readLine();
            System.out.println("Print ho rha h "+ h);
           temp = h.split("9889");
            int i = 0;
           // semanticresult = new ArrayList<String>();
            while( i < temp.length)  {


              System.out.println("Print ho rha h "+ temp[i]);
              //semanticresult.add(temp[i]);
              i++;

            }

            System.out.println( temp[2]);
           // Iterator it =   semanticresult.iterator();
           // System.out.println("Final List" + semanticresult);
            //while(it.hasNext()) {
            //    System.out.println("Ban rhi h ye to " + it.next().toString());
            //}


        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return temp;
    }
}