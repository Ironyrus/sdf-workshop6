//mvn compile exec:java -Dexec.mainClass="vtp2022.day4.workshop.Server"
//https://www.geeksforgeeks.org/java-net-serversocket-class-in-java/#:~:text=In%20java.rmi.Server%2C%20ServerSocket%20class%20is%20used%20to%20create,so%20as%20to%3A%20return%20an%20unbound%20server%20socket.
//Run this class first in one cmd terminal. Then open another terminal (with this one still running) and run Client.java.

package vtp2022.day6.workshop;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;
import java.net.*;

/**
 * This is the Server file.
 *
 */
public class Server 
{
    public static int port = 3333;
    public static String toClient = "";
    public static void main( String[] args ) {   
        String toClient = "";
        String msg = "";
        int cycle = 0;

        //testing (MUST USE WITH COOKIECLIENTHANDLER AND NETWORKIO THEN CAN WORK)
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try {
            ServerSocket server = new ServerSocket(port);
            while(true){
                Socket soc = server.accept();
                CookieClientHandler thr = new CookieClientHandler(soc, "./cookie_file.txt");
                threadPool.submit(thr);
                System.out.println("Submitted to threadPool...");
                System.out.println("Cycle: " + cycle++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //end test

}
}