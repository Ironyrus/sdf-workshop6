package vtp2022.day6.workshop;

import java.net.Socket;

public class CookieClientHandler implements Runnable {

    private Socket soc;
    private String cookie;

    public CookieClientHandler(Socket s, String cookieFile) {
        this.soc = s;
        this.cookie = cookieFile;
    }

    @Override
    public void run() {
        System.out.println("Starting a client thread");
        try {
            NetworkIO netIO = new NetworkIO(soc);
            String req = "";
            while(!req.equals("exit")){
                Cookie cookie = new Cookie();

                req = netIO.read();
                System.out.println("[client] " + req);
                if(req.trim().equals("exit")){
                    break;
                } else if (req.trim().equals("get cookie"))
                {
                    netIO.write(cookie.get_cookie());
                    //System.out.println(file -> this.cookieFile);
                } else {
                    netIO.write("USAGE: exit/get cookie");
                }

            }
            netIO.close();
            soc.close();
            System.out.println("Exiting the thread!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}