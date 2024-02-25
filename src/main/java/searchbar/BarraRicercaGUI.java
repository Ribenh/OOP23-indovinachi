package searchbar;
import personaggi.Personaggio;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
/**
 * Classe che rappresenta l'interfaccia grafica della barra di ricerca.
 */
public class BarraRicercaGUI {
    private static final int LARGHEZZA_FRAME = 400;
    private static final int ALTEZZA_FRAME = 200;
    private final JFrame frame = new JFrame("Tastiera - Indovina Chi?");
    private final JPanel panel = new JPanel();
    private final JButton b = new JButton("INVIO");
    private final JComboBox<String> combobox;
    private final Personaggio personaggioDaIndovinare;
    private final BarraRicerca barraRicerca = new BarraRicerca();
    /**
     * Prende in input il nome del personaggio da indovinare e crea una barra di ricerca.
     * @param nomePersonaggio nome del personaggio da indovinare
     */
    public BarraRicercaGUI(final String nomePersonaggio) {
        personaggioDaIndovinare = barraRicerca.trovaPersonaggio(nomePersonaggio);
        combobox = new JComboBox<>(new String []{"", "Maschio", "Femmina", "Capelli Neri", 
        "Capelli Castani", "Capelli Bianchi", "Capelli Arancioni", "Capelli Biondi", "Capelli Lisci", 
        "Capelli Mossi", "Capelli Ricci", "Capelli Corti", "Capelli Lunghi", "Occhi Marroni", 
        "Occhi Verdi", "Occhi Azzurri", "Pelato", "Barbuto", "Baffuto", "Ha Occhiali", "Ha Accessori"});
        AutoCompleteDecorator.decorate(combobox);
        final ActionListener al = new ActionListener() {
             @Override
             public void actionPerformed(final ActionEvent e) {
                 final String caratteristica = (String) combobox.getSelectedItem();
                 ListaDomande.addDomandA(caratteristica);
                 switch (caratteristica) {
                     case "Maschio":
                     barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.isUomo());
                    break;
                    case "Femmina":
                    barraRicerca.messaggioRicerca(frame, !personaggioDaIndovinare.isUomo());
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
                    case "Capelli Biondi":
                    barraRicerca.messaggioRicerca(frame, barraRicerca.cercaColoreCapelli(personaggioDaIndovinare, "Biondi"));
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
                    barraRicerca.messaggioRicerca(frame, !personaggioDaIndovinare.hasCapelli());
                    break;
                    case "Barbuto":
                    barraRicerca.messaggioRicerca(frame, personaggioDaIndovinare.hasBarba());
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
                     ListaDomande.removeDomandA(caratteristica);
                     JOptionPane.showMessageDialog(frame, "Input non valido\nRIPROVARE");
                     break;
                 }
            }
        };
        b.addActionListener(al);
        frame.setSize(LARGHEZZA_FRAME, ALTEZZA_FRAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());
        frame.add(panel, BorderLayout.CENTER);
        panel.add(combobox);
        panel.add(b);
        frame.setVisible(true);
    }
}
