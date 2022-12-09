package server;

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class Serveur{
    private static ServerSocket server;
    int port;
    String message;

    public Serveur(  int port ) {
        try {
            this.port = port;
            connectoClient();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

///Getters et Setters
public int getPort() { return this.port; }
    public String getMessage() { return this.message; }
    public void setMessage( String message ) { this.message = message; }
    public void setPort ( int port ) { this.port = port; }
///Fonctions de la classe
    public ServerSocket getServer( int port ) throws Exception {
        ServerSocket server = new ServerSocket(port);
        return server;
    }

    public Socket acceptConnection( ServerSocket server) throws Exception  {  //Accepter la connexion d'un client
        Socket socket = server.accept();
        return socket;
    } 

    public ObjectInputStream getRequest( Socket socket ) throws Exception  {  //Avoir le socket 
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return ois;
    }

    public ObjectOutputStream sendResponse( Socket socket ) throws Exception  {   //Envoyer une repose 
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        return oos;
    }

    public void deconnectoClient(ObjectInputStream ois, ObjectOutputStream oos, Socket socket) throws Exception {
        ois.close();
        oos.close();
        socket.close();
    }

    public String scanner() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Message");
        String message = sc.nextLine();

        return message;
    }
    
    public void connectoClient() throws Exception {
        server = getServer(this.port);
        while(true) {
            System.out.println("Waiting for the client request");
            Socket socket = acceptConnection(server);
            ObjectInputStream ois = getRequest(socket);
            String message = (String) ois.readObject();
            System.out.println("Message :" + message);
            ObjectOutputStream oos = sendResponse(socket);
            String response = scanner();
            oos.writeObject("" + response);
            setMessage(message);

            deconnectoClient(ois, oos, socket);
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Maty ilay Socket serveur");
        server.close();
    }
    /*public void prepareServer() throws Exception  {
        server = new ServerSocket(this.port);
        while(true){
            System.out.println("Waiting for the client request");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message : "+message);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hi : "+message);

            ois.close();
            oos.close();
            socket.close();

            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Maty ilay Socket serveur");
        server.close();
    }*/
}