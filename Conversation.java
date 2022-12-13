package server;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Conversation extends Thread {
    Socket socketClient;
    int numero;
    ArrayList<Socket> clientConnectes = new ArrayList<>();

    public Conversation ( Socket socketClient, int numero, ArrayList<Socket> clientConnectes) {
        super();
        this.socketClient = socketClient;
        this.numero = numero;
        this.clientConnectes = clientConnectes;
    }

    @Override
    public void run() {
        try {
            InputStream is = socketClient.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader in = new BufferedReader(isr);
            System.out.println("Wait for a client");
            
            System.out.println(" Client numero " + numero + " connecte au serveur");
            OutputStream op = socketClient.getOutputStream();
            PrintWriter pw = new PrintWriter(op, true);
            String ip = socketClient.getRemoteSocketAddress().toString();
            pw.println("Bienvenue vous etes le client numero " + numero);

            while(true) {   //Repondre et recevoir tant que le client est connecte
                String req;
                while ((req=in.readLine()) != null) {
                    System.out.println(ip + " a envoye " + req);
                    broadCast(req, numero);
                }
                closeConversation(socketClient, in, pw);
            }
        } catch ( Exception e) {
            deconnect();
        }
    }

    public void closeConversation( Socket socketClient, BufferedReader in, PrintWriter pw) {
        try {
            if ( socketClient != null) {
                socketClient.close();
            }
            if ( in != null ) {
                in.close();
            }
            if ( pw != null ) {
                pw.close();
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
    } 

    public void deconnect() {
        try {
            clientConnectes.remove(this);
            System.out.println(" Client number " + numero + " has deconnected");
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public void broadCast(String message, int num) {
        try {
            for ( Socket clientConnecte : clientConnectes ) {
                if ( socketClient !=clientConnecte ) {
                    PrintWriter pw = new PrintWriter(clientConnecte.getOutputStream(), true);
                    pw.println("Client " + num + " : " + message);
                }
            }            
        }   catch( Exception e) {
            e.printStackTrace();
        }
    }

}