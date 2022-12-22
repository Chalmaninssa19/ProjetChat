package boite;

import javax.swing.*;
import java.awt.*;

public class Valider extends JButton {
    JButton button;
    public Valider(String envoyer) {
        setBounds(10, 100, 100, 100);
        setText(envoyer);
        button = new JButton(envoyer);
        //this.button.setBounds(310, 500, 70, 50);
    }

///Getter et setters
    public JButton getButton() { return this.button; }
    public void setButton( JButton button ) { this.button = button; }
}
