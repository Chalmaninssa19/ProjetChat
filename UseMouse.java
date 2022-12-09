package ecouteur;

import java.awt.event.*;
import client.*;
import javax.swing.*;
import window.*;
import server.*;

public class UseMouse implements MouseListener
{
    Interface fen;
    Serveur server;
    Client client;

    public UseMouse( Interface fen, Client client) {
        this.fen = fen;
        this.client = client;
    }

    public UseMouse( Interface fen, Serveur server ) {
        this.fen = fen;
        this.server = server;
    }
    public void mouseClicked( MouseEvent e ) {  //Ce qui se passe lorsqu'on clique sur la souris
        if ( e.getSource() == fen.getContenu().getEnvoi().getButton()) {
            try {
                String message = ((JTextField)fen.getContenu().getChamp().getChamp()).getText();
                String response = ((JTextField)fen.getContenu().getChamp().getChamp()).getText();
                //server.connectoClient(response);
                client.waitConnection(message);
                ((JLabel)fen.getContenu().getChamp().getLab()).setText(client.getResponse());
                ((JLabel)fen.getContenu().getChamp().getLab()).setText(server.getMessage());

            } catch ( Exception ex) {
                System.out.println(ex);
            }
        }
    }
    public void mousePressed(MouseEvent e)
    {}
    public void mouseReleased(MouseEvent e)
    {}
    public void mouseEntered(MouseEvent e)
    {}
    public void mouseExited(MouseEvent e)
    {}
}