package form;

import java.awt.*;
import javax.swing.*;
import boite.*;

public class Formulaire extends JPanel {
    Champ [] champ;
    Valider valider;
    String [] label = { "Nom", "Adresse ip", "Port"};
    JPanel pan;
    JLabel title;

///Getters et setters
    public Champ [] getChamp() { return this.champ; }
    public Valider getValider() { return this.valider; }
    public String [] getLabel() { return this.label; }
    public JPanel getPan() { return this.pan; }
    public void setChamp( Champ [] champ) { this.champ = champ; }
    public void setValider( Valider valider) { this.valider = valider; }
    public void setLabel( String [] label) { this.label = label; }
    public void setPan( JPanel pan) { this.pan = pan; }

    public Formulaire() {
        try {
            listChamp();
            this.pan = new JPanel();
            this.valider = new Valider("Valider");
            title = new JLabel("CONNECTER VOUS A NOTRE CHAT");
            title.setFont(new Font("Arial", Font.PLAIN, 20));
            title.setBounds(20, 0, 400, 100);            
            pan.add(title);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public void listChamp() throws Exception {  ///Creer la liste des champs
        this.champ = new Champ[label.length];
        for ( int i = 0; i < champ.length; i++) {
            champ[i] = new Champ(label[i]);
        }
    }

    public JPanel creerForm() throws Exception {
        this.pan.setLayout(null);
        this.pan.setBounds(0, 0, 400, 600);
        int pos = 100;
        int posY = 0;
        int posX = 150;
        int c = 1;

        for ( int i = 0; i < champ.length; i++) {
            posY = c*pos;
            champ[i].setLab(new JLabel(champ[i].getLabel()));
            champ[i].getChamp().setBounds(posX, posY, 100, 50);
            champ[i].getLab().setBounds(50, posY, 100, 50);
            this.pan.add(champ[i].getChamp());
            this.pan.add(champ[i].getLab());
            c++;
        }
       
        this.valider.setBounds(posX, posY+100, 100, 50);
        this.pan.add(this.valider);

        return this.pan;
    }
}
