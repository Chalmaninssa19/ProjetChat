package window;

import javax.swing.*;
import java.awt.*;
import client.*;
import server.*;
import ecouteur.*;

public class Interface extends JFrame {

    BoiteDialogue contenu = new BoiteDialogue();
    Client client;
    Serveur server;
    public Interface( Client client) {
        this.client = client;

        this.add(contenu);
        this.contenu.getEnvoi().getButton().addMouseListener(new UseMouse(this, client));
        //this.setFocusable(true);
        this.setTitle("Chat client");
        this.setSize(600, 600);
        this.setBackground(Color.GREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public Interface( Serveur server ) {
        this.server = server;

        this.add(contenu);
        this.contenu.getEnvoi().getButton().addMouseListener(new UseMouse(this, server));
        //this.setFocusable(true);
        this.setTitle("Chat serveur");
        this.setSize(600, 600);
        this.setBackground(Color.GREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
///Getters et setters
    public BoiteDialogue getContenu() { return this.contenu; }
    public Client getClient() { return this.client; }
    public Serveur getServer() { return this.server; }

}