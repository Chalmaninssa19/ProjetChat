package display;

import window.*;
import server.*;
import client.*;

public class Main {
    public static void main( String [] args) throws Exception {
        String host = "localhost";
        int port = 8888;
        Serveur server = new Serveur(port);
        Client client = new Client( host, port);
        Interface inter = new Interface( client);
        //Interface inter1 = new Interface( server);
    }
}