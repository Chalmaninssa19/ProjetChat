package boite;

import javax.swing.*;
import java.awt.*;

public class Envoyer extends JButton {
    JButton button;
    public Envoyer(String envoyer) {
        setBounds(10, 400, 100, 100);
        button = new JButton(envoyer);
        this.button.setBounds(330, 10, 100, 50);
    }

///Getter et setters
    public JButton getButton() { return this.button; }
    public void setButton( JButton button ) { this.button = button; }
}
