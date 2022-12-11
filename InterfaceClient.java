package window;

import javax.swing.*;
import java.awt.*;
import client.*;
import ecouteur.*;

public class InterfaceClient extends JFrame {

    BoiteDialogue contenu = new BoiteDialogue();
    Client client;

    public InterfaceClient( Client client) {
        this.client = client;

        this.add(contenu);
        this.contenu.getEnvoi().getButton().addMouseListener(new UseMouse(this, client));
        //this.setFocusable(true);
        this.setTitle("Chat client");
        this.setSize(400, 600);
        this.setBackground(Color.GREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

///Getters et setters
    public BoiteDialogue getContenu() { return this.contenu; }
    public Client getClient() { return this.client; }

}