package tabellone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe che rappresenta l'interfaccia grafica del tabellone di gioco.
 */
public class TabelloneGUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<Position, JButton> cells = new HashMap<>();
    private Tabellone tabellone;
    private final String personaggioDaIndovinare;

    /**
     * Costruttore della classe TabelloneGUI.
     * @param size La dimensione del tabellone (numero di righe/colonne).
     */
    public TabelloneGUI(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70 * size, 70 * size);
        // Creazione di un'istanza di TabelloneImpl
        this.tabellone = new TabelloneImpl(size); 

        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(panel);

        // Inizializzazione del tabellone con i personaggi iniziali
        tabellone.inizializzaTabellone(size);
        //Ottiene il personaggio da indovinare
        personaggioDaIndovinare = tabellone.getPersonaggioDaIndovinare();

        // ActionListener personalizzato per i pulsanti
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton) e.getSource();
                // Disabilita il pulsante cliccato
                jb.setEnabled(false); 

                // Ottieni la posizione del pulsante cliccato
                Position pos = null;
                for (Map.Entry<Position, JButton> entry : cells.entrySet()) {
                    if (entry.getValue() == jb) {
                        pos = entry.getKey();
                        break;
                    }
                }

                // Ottieni il personaggio corrispondente alla posizione
                String personaggioCliccato = tabellone.getTabellone().get(pos);

                // Controlla se il personaggio cliccato corrisponde al personaggio da indovinare
                if (personaggioCliccato.equals(personaggioDaIndovinare)) {
                    JOptionPane.showMessageDialog(TabelloneGUI.this, "Vittoria");
                    // Chiudi la finestra
                    dispose(); 
                }
            }
        };

        // Inizializzazione dei pulsanti e associazione dell'ActionListener
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Position pos = new Position(j, i);
                // Imposta il testo del pulsante al personaggio in quella posizione
                JButton jb = new JButton(tabellone.getTabellone().get(pos)); 
                cells.put(pos, jb);
                // Aggiunge l'ActionListener personalizzato
                jb.addActionListener(al); 
                panel.add(jb);
            }
        }

        this.setVisible(true);
    }
}