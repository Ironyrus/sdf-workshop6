package vtp2022.day6.workshop;

import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.Random;

import javax.swing.plaf.metal.MetalIconFactory.TreeControlIcon;

public class Cookie {
    public Cookie() {

    }

    public String get_cookie() {
        //String filePath = "./src/main/java/vtp2022/day4/workshop/cookie_file.txt";
        String filePath = "./cookie_file.txt";
        String toClient = "";

        ArrayList<String> poems = new ArrayList<String>();
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) { //Checking if file exists. If it doesn't, create file.
            try {
                Path createdFilePath = Files.createFile(path);
                System.out.println("Created cookie_file.txt");
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else { //File exists. Accessing file.
            System.out.println("Accessing cookie_file.txt .....");
            try {
            File cookieFile = new File(filePath);
            FileReader frobj = new FileReader(cookieFile);
            BufferedReader brobj = new BufferedReader(frobj);
            String line;
            int count = 1;

            while ((line = brobj.readLine()) != null) {
                poems.add(line);
                System.out.println("Try " + count + ": " + line);
                count++;
            }
            Random random = new Random();
            System.out.println(count);
            toClient = poems.get(random.nextInt(count - 1));
            System.out.println(toClient);

            frobj.close();
            brobj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return toClient;
    }
}
