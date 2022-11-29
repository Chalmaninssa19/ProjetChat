import java.io.*;
import java.net.*;
import java.lang.*;
public class Serveur{
    private static ServerSocket server;
    private static int port = 6666;

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        server = new ServerSocket(port);
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
    }
}