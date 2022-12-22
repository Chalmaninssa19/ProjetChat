package window;

import javax.swing.*;
import java.awt.*;
import form.Formulaire;
import ecouteur.*;

public class Connecter extends JFrame {
    Formulaire form = new Formulaire();
    public Formulaire getForm() { return this.form; }
    public Connecter () {
        try {
            this.add(form.creerForm());
            form.getValider().addMouseListener(new MouseConnecte(this));
            this.setTitle("Formulaire");
            this.setSize(400, 600);
            this.setBackground(Color.GREEN);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args ) throws Exception {
        new Connecter();
    }
}