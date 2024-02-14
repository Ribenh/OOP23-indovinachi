package serchbar;

import personaggi.Personaggio;

import javax.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.awt.event.*;
import java.awt.*;

public class BarraRicercaGUI {

    JFrame frame = new JFrame("Tastiera - Indovina Chi?");
    JPanel panel = new JPanel();
    JButton b = new JButton("INVIO");
    JComboBox<String> combobox;

    private Personaggio personaggioDaIndovinare;
    private BarraRicerca barraRicerca = new BarraRicerca();

    public BarraRicercaGUI(String nomePersonaggio) {
        
        personaggioDaIndovinare = barraRicerca.trovaPersonaggio(nomePersonaggio);
        
        combobox = new JComboBox<>(new String []{"","Maschio", "Femmina", "Capelli Neri", 
        "Capelli Castani", "Capelli Bianchi", "Capelli Arancioni", "Capelli Verdi", "Capelli Marroni",
        "Capelli Lisci", "Capelli Mossi", "Capelli Ricci", "Capelli Corti", "Capelli Lunghi", "Occhi Marroni", 
        "Occhi Verdi", "Occhi Azzurri", "Pelato", "Barbuto", "Baffuto", "Ha Occhiali", "Ha Accessori"});
        AutoCompleteDecorator.decorate(combobox);

        final ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e){
                final String caratteristica = (String) combobox.getSelectedItem();
                switch(caratteristica){
                    case "Maschio":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.isUomo());
                    break;

                    case "Femmina":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.isUomo() == false);
                    break;

                    case "Capelli Neri":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreCapelli(personaggioDaIndovinare, "Neri"));
                    break;

                    case "Capelli Castani":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreCapelli(personaggioDaIndovinare, "Castani"));
                    break;

                    case "Capelli Bianchi":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreCapelli(personaggioDaIndovinare, "Bianchi"));
                    break;
                    
                    case "Capelli Arancioni":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreCapelli(personaggioDaIndovinare, "Arancioni"));
                    break;
                    
                    case "Capelli Verdi":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreCapelli(personaggioDaIndovinare, "Verdi"));
                    break;

                    case "Capelli Marroni":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreCapelli(personaggioDaIndovinare, "Marroni"));
                    break;

                    case "Capelli Lisci":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaTipoCapelli(personaggioDaIndovinare, "Lisci"));
                    break;

                    case "Capelli Mossi":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaTipoCapelli(personaggioDaIndovinare, "Mossi"));
                    break;

                    case "Capelli Ricci":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaTipoCapelli(personaggioDaIndovinare, "Ricci"));
                    break;

                    case "Capelli Lunghi":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaLunghezzaCapelli(personaggioDaIndovinare, "Lunghi"));
                    break;

                    case "Capelli Corti":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaLunghezzaCapelli(personaggioDaIndovinare, "Corti"));
                    break;

                    case "Occhi Marroni":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreOcchi(personaggioDaIndovinare, "Marroni"));
                    break;

                    case "Occhi Verdi":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreOcchi(personaggioDaIndovinare, "Verdi"));
                    break;

                    case "Occhi Azzurri":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreOcchi(personaggioDaIndovinare, "Azzurri"));
                    break;

                    case "Pelato":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.hasCapelli() == false);
                    break;

                    case "Barbuto":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.getBarba());
                    break;

                    case "Baffuto":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.hasBaffi());
                    break;

                    case "Ha Occhiali":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.hasOcchiali());
                    break;

                    case "Ha Accessori":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.hasAccessori());
                    break;

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
        panel.setLayout(new FlowLayout());
        frame.add(panel, BorderLayout.CENTER);
        panel.add(combobox);
        panel.add(b);
        
        frame.setVisible(true);
    }
}