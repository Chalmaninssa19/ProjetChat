package boite;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class Champ extends JComponent {
    JComponent champ;
    JLabel lab;
    String label;
    boolean visible = true;
    //String valueDefault = "-";
    public Champ(){}
    public Champ(String label) 
    {
        setBounds(10, 10, 200, 200);
        setBackground(Color.RED);
        setLayout(null);

        champ = new JTextField();
        champ.setBounds(10, 10, 300, 100);
        lab = new JLabel(label);
        lab.setBounds(100, 100, 300, 300);
        setLabel(label);
    }

    // Les getters et les setters
    public JComponent getChamp() { return this.champ; }
    public JLabel getLab() { return this.lab; }
    public String getLabel() { return this.label; }
    public boolean getVisible() { return this.visible; }
    //public String getValueDefault() { return this.valueDefault; }

    public void setChamp(JComponent jc) { this.champ = jc; }
    public void setLab(JLabel lab) { this.lab = lab; }
    public void setLabel(String text) {
        this.label = text;
    }
    public void setVisible( boolean v) { this.visible = v; }
    /*public void setValueDefault(String vd) {
        this.valueDefault = vd;
        ((JTextField)this.champ).setText(this.valueDefault);
    }*/
}