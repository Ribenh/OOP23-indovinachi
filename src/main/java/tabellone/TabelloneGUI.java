package tabellone;

import personaggi.PersonaggiCreati;
import personaggi.Personaggio;
import schermatafinale.VittoriaGUI;
import serchbar.BarraRicercaGUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe che rappresenta l'interfaccia grafica del tabellone di gioco.
 */
public class TabelloneGUI extends JFrame {

    private final Map<Position, JButton> cells = new HashMap<>();
    private Tabellone tabellone;
    private String personaggioDaIndovinare;

    private static final int BUTTON_WIDTH = 160; // Larghezza del pulsante
    private static final int BUTTON_HEIGHT = 130; // Altezza del pulsante
    private static final int BUTTON_SIZE = 100; // Dimensione del pulsante
    // Definizione delle costanti per le dimensioni del tabellone
    private static final int DIMENSIONE_FACILE = 3;
    private static final int DIMENSIONE_INTERMEDIO = 4;
    private static final int DIMENSIONE_DIFFICILE_X = 4;
    private static final int DIMENSIONE_DIFFICILE_Y = 6;

    /**
     * Costruttore della classe TabelloneGUI.
     * @param difficolta La difficoltà del gioco, rappresentata da un valore intero.
     *                   - 1 per il livello facile, con una dimensione di tabellone 3x3.
     *                   - 2 per il livello intermedio, con una dimensione di tabellone 4x4.
     *                   - 3 per il livello difficile, con una dimensione di tabellone 6x4.
     */
    public TabelloneGUI(final int difficolta) {
        int sizeX = 0;
        int sizeY = 0;
        switch (difficolta) {
            case 1:
                sizeX = DIMENSIONE_FACILE; // Larghezza del tabellone per il livello facile
                sizeY = DIMENSIONE_FACILE; // Altezza del tabellone per il livello facile
                break;
            case 2:
                sizeX = DIMENSIONE_INTERMEDIO; // Larghezza del tabellone per il livello intermedio
                sizeY = DIMENSIONE_INTERMEDIO; // Altezza del tabellone per il livello intermedio
                break;
            case 3:
                sizeX = DIMENSIONE_DIFFICILE_X; // Larghezza del tabellone per il livello difficile
                sizeY = DIMENSIONE_DIFFICILE_Y; // Altezza del tabellone per il livello difficile
                break;
            default:
                // Mostra un messaggio di errore se la difficoltà non è valida
                JOptionPane.showMessageDialog(this, "Livello di difficoltà non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
        }

        // Impostazioni della finestra
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(BUTTON_WIDTH * sizeX, BUTTON_HEIGHT * sizeY);

        // Creazione del tabellone e del pannello
        this.tabellone = new TabelloneImpl(sizeX, sizeY);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.getContentPane().add(mainPanel);

        JPanel imagePanel = new JPanel(new GridLayout(sizeX, sizeY));
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Inizializzazione del tabellone con i personaggi iniziali
        tabellone.inizializzaTabellone(sizeX, sizeY);
        // Ottiene il personaggio da indovinare
        personaggioDaIndovinare = tabellone.getPersonaggioDaIndovinare();

        // ActionListener personalizzato per i pulsanti
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
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
                Personaggio personaggioCliccato = tabellone.getTabellone().get(pos);

                // Controlla se il personaggio cliccato corrisponde al personaggio da indovinare
                if (personaggioCliccato.getNome().equals(personaggioDaIndovinare)) {
                    new VittoriaGUI(); // Apre la SchermataFinale
                    dispose(); // Chiude la finestra corrente
                }
            }
        };

        // Inizializzazione dei pulsanti e associazione dell'ActionListener
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        int index = 0;

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Position pos = new Position(j, i);
                Personaggio personaggio = personaggi.get(index++);
                JButton jb = new JButton();

                // Ottieni l'immagine del personaggio
                ImageIcon icon = personaggio.getImmagine();
                // Ridimensiona l'immagine per adattarla alla dimensione del pulsante
                Image scaledImage = icon.getImage().getScaledInstance(BUTTON_SIZE, BUTTON_SIZE, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                // Imposta l'immagine ridimensionata come icona del pulsante
                jb.setIcon(scaledIcon);

                cells.put(pos, jb);
                jb.addActionListener(al);
                imagePanel.add(jb);
            }
        }
        // Pulsante "Fai una domanda"
        JButton askQuestionButton = new JButton("Fai una domanda");
        askQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BarraRicercaGUI(personaggioDaIndovinare);
            }
        });
        mainPanel.add(askQuestionButton, BorderLayout.SOUTH);
        setVisible(true);
    }
}
