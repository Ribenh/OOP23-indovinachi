package serchBar;

import javax.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.awt.event.*;
import java.awt.*;
public class Demo {

    JFrame frame = new JFrame("Tastiera - Indovina Chi?");
    JPanel north = new JPanel();
    JPanel south = new JPanel();
    JButton b = new JButton("INVIO");
    AutoCompleteDecorator decorator;
    JComboBox<String> combobox;
    

    public Demo() {
        combobox = new JComboBox<>(new String []{"","Maschio", "Femmina", "Capelli Neri", 
        "Capelli Castani", "Capelli Bianchi", "Capelli Arancioni", "Capelli Verdi", "Capelli Marroni",
        "Capelli Lisci", "Capelli Mossi", "Capelli Ricci", "Capelli Corti", "Capelli Lunghi", "Occhi Marroni", 
        "Occhi Verdi", "Occhi Azzurri", "Pelato", "Barbuto", "Baffuto", "Ha Occhiali", "Ha Accessori"});
        AutoCompleteDecorator.decorate(combobox);

        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String s = (String) combobox.getSelectedItem();
                switch(s){
                    case "Maschio":

                    default:
                    JOptionPane.showMessageDialog(frame, "Input non valido\nRIPROVARE");
                    break;
                }
            }
        };

        b.addActionListener(al);

        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        north.setLayout(new FlowLayout());
        south.setLayout(new FlowLayout());
        frame.add(north, BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);
        north.add(combobox);
        north.add(b);
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo();
    }
}