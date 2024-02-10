package menu;

// Java Program to create a popup and display
// it on a parent frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class pop extends JFrame implements ActionListener {
    // popup
    Popup p;
 
    // constructor
    pop()
    {
        // create a frame
        JFrame f = new JFrame("pop");
 
        // create a label
        JLabel l = new JLabel("This is a popup");
 
        f.setSize(400, 400);
 
        PopupFactory pf = new PopupFactory();
 
        // create a panel
        JPanel p2 = new JPanel();
 
        // set Background of panel
        p2.setBackground(Color.red);
 
        p2.add(l);
 
        // create a popup
        p = pf.getPopup(f, p2, 180, 100);

        // create a panel
        JPanel p1 = new JPanel();
 
        // create a button
        JButton b = new JButton("click");

        int i = 0;

        while (Caratteristiche.MacroTratti.size() > i) {
            JButton c = new JButton(Caratteristiche.MacroTratti.get(i));
            p1.add(c);
            i++;
        }
 
        // add action listener
        b.addActionListener(this);
 

 
        p1.add(b);
        f.add(p1);
        f.setVisible(rootPaneCheckingEnabled);
    }
 
    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        p.show();
    }
    // main class
    public static void main(String args[])
    {
        new pop();
    }
}