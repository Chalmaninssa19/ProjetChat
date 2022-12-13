package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.math.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ServerChat extends Thread {
    int nbClient;
    ArrayList<Socket> clientConnectes = new ArrayList<>();
    ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            //Une connection pour chaque client qui veut se connecter et gerer une conversation avec chaque client connecte
            serverSocket = new ServerSocket(1234); //Demarre un 
            while ( true ) {
                Socket socketClient = serverSocket.accept();    //Accepter la connection d'un client a tout moment
                nbClient++;
                clientConnectes.add(socketClient);
                Conversation conversation = new Conversation( socketClient, nbClient, clientConnectes);   //Generer un nouveau thread pour la conversation
                conversation.start();
            }
        }   catch(Exception e) {
            closeServer();
        }
    }

    public void closeServer() {
        try {
            if(serverSocket != null) {
                serverSocket.close();
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static void main( String [] args) {
        new ServerChat().start();
    }
}