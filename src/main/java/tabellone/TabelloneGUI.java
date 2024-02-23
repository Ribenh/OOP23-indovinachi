package tabellone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import personaggi.Personaggio;
import schermatafinale.VittoriaGUI;

public abstract class TabelloneGUI extends JFrame {

    protected static final long serialVersionUID = -6218820467019983016L;

    protected transient Map<Position, JButton> cells = new HashMap<>();
    protected transient Tabellone tabellone;
    protected transient Personaggio personaggioDaIndovinare;
    protected int tentativi; // Contatore dei tentativi

    protected static final int BUTTON_WIDTH = 160; // Larghezza del pulsante
    protected static final int BUTTON_HEIGHT = 130; // Altezza del pulsante
    protected static final int BUTTON_SIZE = 100; // Dimensione del pulsante

    // Definizione delle costanti per le dimensioni del tabellone
    protected static final int DIMENSIONE_FACILE = 3;
    protected static final int DIMENSIONE_INTERMEDIO = 4;
    protected static final int DIMENSIONE_DIFFICILE_X = 4;
    protected static final int DIMENSIONE_DIFFICILE_Y = 6;

    // Definizione delle costanti per il numero dei tentativi concessi
    private static final int MAX_TENTATIVI_FACILE = 8;
    private static final int MAX_TENTATIVI_INTERMEDIO = 10;
    private static final int MAX_TENTATIVI_DIFFICILE = 12;


    protected static int calcolaMaxTentativi(final int difficolta) {
        switch (difficolta) {
            case 1:
                return MAX_TENTATIVI_FACILE; // Livello facile
            case 2:
                return MAX_TENTATIVI_INTERMEDIO; // Livello intermedio
            case 3:
                return MAX_TENTATIVI_DIFFICILE; // Livello difficile
            default:
                return -1;
        }
    }

    protected void inizializzaTabelloneGUI(final int difficolta) {
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

        final JPanel mainPanel = new JPanel(new BorderLayout());
        initializeContentPane(mainPanel);

        final JPanel imagePanel = new JPanel(new GridLayout(sizeX, sizeY));
        final JScrollPane scrollPane = new JScrollPane(imagePanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Inizializzazione del tabellone con i personaggi iniziali
        tabellone.inizializzaTabellone(sizeX, sizeY);
        // Ottiene il personaggio da indovinare
        personaggioDaIndovinare = tabellone.getPersonaggioDaIndovinare();

        // ActionListener personalizzato per i pulsanti
        final ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JButton jb = (JButton) e.getSource();
                // Disabilita il pulsante cliccato
                jb.setEnabled(false);
                // Ottieni la posizione del pulsante cliccato
                Position pos = null;
                for (final Map.Entry<Position, JButton> entry : cells.entrySet()) {
                    if (entry.getValue() == jb) {
                        pos = entry.getKey();
                        break;
                    }
                }
                // Ottieni il personaggio corrispondente alla posizione
                final Personaggio personaggioCliccato = tabellone.getTabellone().get(pos);
                // Controlla se il personaggio cliccato corrisponde al personaggio da indovinare
                if (personaggioCliccato.getNome().equals(personaggioDaIndovinare.getNome())) {
                    new VittoriaGUI(1); // Apre la SchermataFinale
                    dispose(); // Chiude la finestra corrente
                }
            }
        };

        // Inizializzazione dei pulsanti e associazione dell'ActionListener
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                final Position pos = new Position(j, i);
                final Personaggio personaggio = getPersonaggioAtPosition(pos);
                final JButton jb = new JButton();
                // Ottieni l'immagine del personaggio
                final ImageIcon icon = personaggio.getImmagine();
                // Ridimensiona l'immagine per adattarla alla dimensione del pulsante
                final Image scaledImage = icon.getImage().getScaledInstance(BUTTON_SIZE, BUTTON_SIZE, Image.SCALE_SMOOTH);
                final ImageIcon scaledIcon = new ImageIcon(scaledImage);
                // Imposta l'immagine ridimensionata come icona del pulsante
                jb.setIcon(scaledIcon);
                cells.put(pos, jb);
                jb.addActionListener(al);
                imagePanel.add(jb);
            }
        }
    }

    // Metodo separato per inizializzare il content pane
    private void initializeContentPane(final JPanel mainPanel) {
        this.setContentPane(mainPanel);
    }

    /**
     * Restituisce il personaggio nella posizione specificata.
     * @param position La posizione del personaggio.
     * @return Il personaggio nella posizione specificata.
     */
    public Personaggio getPersonaggioAtPosition(final Position position) {
        return tabellone.get(position);
    }
}
