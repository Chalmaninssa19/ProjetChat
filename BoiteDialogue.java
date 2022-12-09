package window;

import javax.swing.*;
import java.awt.*;
import boite.*;

public class BoiteDialogue extends JPanel {
    Champ champ;
    Envoyer envoi;
    public BoiteDialogue() {
        champ = new Champ("Message");
        envoi = new Envoyer("Envoyer");
        this.add(champ.getChamp());
        this.add(champ.getLab());
        this.add(envoi.getButton());
        this.setBounds(0, 0, 600, 600);
        this.setLayout(null);
        this.setBackground(Color.GREEN);
    }

///Getters et setters
    public Champ getChamp() { return this.champ; }
    public Envoyer getEnvoi() { return this.envoi; }
    public void setChamp( Champ champ ) { this.champ = champ; }
    public void setEnvoi( Envoyer envoi ) { this.envoi = envoi; }
}