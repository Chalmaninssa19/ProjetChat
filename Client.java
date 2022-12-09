package client;

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class Client{
    String ip;
    int port;
    String response;

///Getters et setters
    public String getIp() { return this.ip; }
    public int getPort() { return this.port; }
    public String getResponse() { return this.response; }
    public void setIp( String ip ) { this.ip = ip; }
    public void setPort( int port ) { this.port = port; }
    public void setResponse(String response) { this.response = response; }

///Constructor
    public Client ( String host, int port) throws Exception {
        try {
            this.ip = host;
            this.port = port;
            //connectoServer();
        }catch ( Exception e) {
            System.out.println(e);
        }
    }

///Fonction de la classe
    public InetAddress getHost() throws Exception { //Avoir les hosts disponible
        return InetAddress.getLocalHost();
    }

    public Socket getSocket( String localhost, int port) throws Exception {  //Avoir le socket par le port
        Socket socket = new Socket(localhost, port);
        return socket;
    }

    public ObjectOutputStream getOutStream( Socket socket) throws Exception {   //Avoir un flux de sortie 
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        return oos;
    }

    public ObjectInputStream getInStream( Socket socket ) throws Exception {  //Avoir les flux se sortie
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return ois;
    }
    
    public void deconnectoServer( ObjectInputStream ois, ObjectOutputStream oos ) throws Exception {
        ois.close();
        oos.close();
    }

    public String scanner() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Message");
        String message = sc.nextLine();

        return message;
    }
    public void waitConnection( String message) throws Exception {
        //InetAddress host = getHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for ( int i = 0; i < 1; i++) {
            socket = getSocket(this.ip, this.port);
            //System.out.println(" Le socket -> " + socket);
            oos = getOutStream(socket);
            System.out.println("Envoyer une requete au serveur");
                //String message = scanner();
                if(i==4)oos.writeObject("exit");
                else oos.writeObject(""+message);
                ois = getInStream(socket);
                String reponse = (String)ois.readObject();
                this.response = reponse;
                System.out.println("Reponse: " + reponse);
                deconnectoServer( ois, oos);
                Thread.sleep(100);
        }
    }
    /*public void connectoServer() throws Exception {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for(int i=0; i<5;i++){
            socket = new Socket( this.ip, this.port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
                Scanner sc = new Scanner(System.in);
                System.out.print("Message: ");
                String message = sc.nextLine();
                if(i==4)oos.writeObject("exit");
                else oos.writeObject(""+message);
                ois = new ObjectInputStream(socket.getInputStream());
                //String message = (String) ois.readObject(); 
                System.out.println("Message: " + message);
                ois.close();
                oos.close();
                Thread.sleep(100);
        }
    }*/
}