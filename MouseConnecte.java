package ecouteur;

import java.awt.event.*;
import javax.swing.*;
import window.*;
import client.*;

public class MouseConnecte implements MouseListener
{
    Connecter fen;
    Client client = new Client();

    public MouseConnecte( Connecter fen) {
        this.fen = fen;
    }

    public void mouseClicked( MouseEvent e ) {  //Ce qui se passe lorsqu'on clique sur la souris
        try {
            String nom = ((JTextField)fen.getForm().getChamp()[0].getChamp()).getText();
            String adresse = ((JTextField)fen.getForm().getChamp()[1].getChamp()).getText();
            String port = ((JTextField)fen.getForm().getChamp()[2].getChamp()).getText();
            client.creerClient(adresse, nom, Integer.parseInt(port));
        } catch ( Exception ex) {
            ex.printStackTrace();
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