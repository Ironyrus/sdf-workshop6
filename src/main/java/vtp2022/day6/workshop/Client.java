package vtp2022.day6.workshop;

import java.net.ServerSocket;
import java.io.*;
import java.net.*;

//This is the Client file.
// mvn compile exec:java -Dexec.mainClass="vtp2022.day4.workshop.Client"

public class Client {
    

    public static void main(String args[]) {
        System.out.println("Port: " + Server.port);
        try {
            Socket soc = new Socket("localhost", Server.port);
            DataOutputStream d = new DataOutputStream(soc.getOutputStream());
            Console cons = System.console();
            String str = ""; 
            DataInputStream dis = null;
            while(!str.equals("close")) {
                System.out.println("\nUSAGE: get cookie/close");
                str = cons.readLine();
                d.writeUTF(str);
                d.flush();
    
                //other way (First was Client send to Server, now Server back to Client.)
                dis = new DataInputStream(soc.getInputStream());
                String msg = (String)dis.readUTF();
                System.out.println(msg);    
            }
            dis.close();
            d.close();
            soc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Client: Working.");
        
    }
}
