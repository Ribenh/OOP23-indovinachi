package tabellone;

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
import java.util.Map;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Classe che rappresenta l'interfaccia grafica del tabellone di gioco.
 */
public class TabelloneManualeGUI extends JFrame {

    private transient Map<Position, JButton> cells = new HashMap<>();
    private transient Tabellone tabellone;
    private String personaggioDaIndovinare;
    private int tentativi = 0; // Contatore dei tentativi

    private static final long serialVersionUID = 1L; // Aggiungi un numero di versione per la serializzazione

    private static final int BUTTON_WIDTH = 160; // Larghezza del pulsante
    private static final int BUTTON_HEIGHT = 130; // Altezza del pulsante
    private static final int BUTTON_SIZE = 100; // Dimensione del pulsante

    // Definizione delle costanti per le dimensioni del tabellone
    private static final int DIMENSIONE_FACILE = 3;
    private static final int DIMENSIONE_INTERMEDIO = 4;
    private static final int DIMENSIONE_DIFFICILE_X = 4;
    private static final int DIMENSIONE_DIFFICILE_Y = 6;

    // Definizione delle costanti per il numero dei tentativi concessi
    private static final int MAX_TENTATIVI_FACILE = 8;
    private static final int MAX_TENTATIVI_INTERMEDIO = 10;
    private static final int MAX_TENTATIVI_DIFFICILE = 12;

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        cells = new HashMap<>(); // Inizializza il campo cells dopo la deserializzazione
    }

    /**
     * Calcola il numero massimo di tentativi consentiti in base al livello di difficoltà.
     * @param difficolta Il livello di difficoltà del gioco. 
     * - 1 per il livello facile. 
     * - 2 per il livello intermedio. 
     * - 3 per il livello difficile.
     * @return Il numero massimo di tentativi consentiti. 
     * Se la difficoltà non è valida, viene stampato un messaggio di errore e viene restituito -1.
     */
    private static int calcolaMaxTentativi(final int difficolta) {
        switch (difficolta) {
            case 1:
                return MAX_TENTATIVI_FACILE; // Livello facile
            case 2:
                return MAX_TENTATIVI_INTERMEDIO; // Livello intermedio
            case 3:
                return MAX_TENTATIVI_DIFFICILE; // Livello difficile
            default:
                System.err.println("Difficoltà non valida: " + difficolta);
                return -1;
        }
    }

    /**
     * Costruttore della classe TabelloneGUI.
     *
     * @param difficolta La difficoltà del gioco, rappresentata da un valore intero. 
     * - 1 per il livello facile, con una dimensione di tabellone 3x3. 
     * - 2 per il livello intermedio, con una dimensione di tabellone 4x4. 
     * - 3 per il livello difficile, con una dimensione di tabellone 6x4.
     */
    public TabelloneManualeGUI(final int difficolta) {
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
        setLocationRelativeTo(null);

        // Creazione del tabellone e del pannello
        this.tabellone = new TabelloneImpl(sizeX, sizeY);

        JPanel mainPanel = new JPanel(new BorderLayout());
        initializeContentPane(mainPanel);

        JPanel imagePanel = new JPanel(new GridLayout(sizeX, sizeY));
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Inizializzazione del tabellone con i personaggi iniziali
        tabellone.inizializzaTabellone(sizeX, sizeY);
        // Ottiene il personaggio da indovinare
        personaggioDaIndovinare = tabellone.getPersonaggioDaIndovinare();
        System.out.println(personaggioDaIndovinare);

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
                    new VittoriaGUI(1); // Apre la SchermataFinale
                    dispose(); // Chiude la finestra corrente
                }
            }
        };

        // Inizializzazione dei pulsanti e associazione dell'ActionListener
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Position pos = new Position(j, i);
                Personaggio personaggio = tabellone.getPersonaggioAtPosition(pos);
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

        // Calcola MAX_TENTATIVI in base al livello di difficoltà
        int maxTentativi = calcolaMaxTentativi(difficolta);
        // ActionListener per il pulsante "Fai una domanda"
        JButton askQuestionButton = new JButton("Fai una domanda");
        askQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // Incrementa il contatore dei tentativi quando viene fatta una domanda
                tentativi++;
                // Verifica se il numero massimo di tentativi è stato superato
                if (tentativi >= maxTentativi) {
                    new VittoriaGUI(0); // Apre la SchermataFinale con indicazione di sconfitta
                    dispose(); // Chiude la finestra corrente
                } else {
                    new BarraRicercaGUI(personaggioDaIndovinare); // Apre la barra di ricerca
                }
            }
        });
        mainPanel.add(askQuestionButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    // Metodo separato per inizializzare il content pane
    private void initializeContentPane(final JPanel mainPanel) {
        this.setContentPane(mainPanel);
    }
}
