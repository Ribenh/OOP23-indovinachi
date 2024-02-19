package tabellone;

import personaggi.PersonaggiCreati;
import personaggi.Personaggio;
import schermatafinale.VittoriaGUI;
import menu.DomandaPulsante;
import menu.MenuPopup;

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
public class TabelloneAutomaticoGUI extends JFrame {

    private final Map<Position, JButton> cells = new HashMap<>();
    private Tabellone tabellone;
    private String personaggioDaIndovinare;
    private int tentativi=0;
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
    public TabelloneAutomaticoGUI(final int difficolta) {
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

            // Ottieni la caratteristica scelta nel menu pop-up
            String caratteristicaScelta = DomandaPulsante.getTipoCaratteristica();
            String dettaglioScelto = DomandaPulsante.getDettaglioCaratteristica();

            
            // Girare le caselle in base alla risposta del giocatore
            for (Map.Entry<Position, JButton> entry : cells.entrySet()) {
                Position posizione = entry.getKey();
                Personaggio personaggio = tabellone.getTabellone().get(posizione);
                JButton pulsante = entry.getValue();

            // Stampa dei valori di interesse
            System.out.println("Posizione: " + posizione);
            System.out.println("Nome personaggio: " + personaggio.getNome());
            System.out.println("Caratteristica scelta: " + caratteristicaScelta);
            System.out.println("Dettaglio scelto: " + dettaglioScelto);

                // Calcola se il personaggio ha la caratteristica
                //Boolean personaggioHaCaratteristica = personaggio.haCaratteristica(caratteristicaScelta, dettaglioScelto);
                //System.out.println("Il personaggio ha la caratteristica? " + personaggioHaCaratteristica);

                /*if (personaggioHaCaratteristica) {
                    // Se il personaggio ha la caratteristica e la risposta è "NO", gira la casella
                    if (dettaglioScelto.equals("NO")) {
                        pulsante.setEnabled(false);
                        System.out.println("Pulsante disabilitato perché il personaggio non ha la caratteristica.");
                    }
                    } else {
                    // Se il personaggio non ha la caratteristica e la risposta è "SI", gira la casella
                    if (dettaglioScelto.equals("SI")) {
                        pulsante.setEnabled(false);
                        System.out.println("Pulsante disabilitato perché il personaggio non ha la caratteristica.");
                    }
                }*/
                // Controlla se il personaggio ha la caratteristica e la risposta è "NO", o se non ha la caratteristica e la risposta è "SI"
                /*if ((personaggioHaCaratteristica && dettaglioScelto.equals("NO")) || (!personaggioHaCaratteristica && dettaglioScelto.equals("SI"))) {
                    pulsante.setEnabled(false);
                    System.out.println("Pulsante disabilitato perché il personaggio non ha la caratteristica.");
                }*/
            }

            //Controlla se il numero di domande massimo è stato superato
            if(tentativi >= 10) {
                new VittoriaGUI(0);
            }

            // Controlla se il personaggio cliccato corrisponde al personaggio da indovinare
            if (personaggioCliccato.getNome().equals(personaggioDaIndovinare)) {
                new VittoriaGUI(1); // Apre la SchermataFinale
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
                new MenuPopup(tentativi);
                tentativi++;
            }
        });
        mainPanel.add(askQuestionButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
