import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class Client{
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for(int i=0; i<5;i++){
            socket = new Socket("localhost", 6666);
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
    }
}