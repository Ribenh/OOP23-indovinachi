package schermatainiziale;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * SchermataInizialeGUI rappresenta la finestra di avvio del gioco "Indovina Chi".
 * Questa classe gestisce la visualizzazione dell'immagine di benvenuto e la selezione
 * della modalità di gioco (classica o manuale).
 */
public class SchermataInizialeGUI extends JFrame {
    private static final long serialVersionUID = -6218820467019983015L;
    private static final int SCALEDWIDTH = -1;
    private static final int SCALEDHEIGHT = 800;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BUTTONWIDTH = 200;
    private static final int BUTTONHEIGHT = 50;
    private static final int AUTOMATIC_MODE = 1;
    private static final int MANUAL_MODE = 2;
    private static final String PLAYER_FILENAME = "src/main/java/schermatainiziale/giocatori.ser";

    private int modeSelect;

     // Utilizza la classe di utilità PersistentHashMap per salvare/scaricare lo stato della modalità
     private final transient PersistentHashMap<String, Integer> giocatori;

    /**
     * Costruttore della classe SchermataInizialeGUI.
     * Inizializza la finestra di avvio del gioco.
     */
    public SchermataInizialeGUI() {

        // CPD-OFF
        super("Indovina Chi");

        giocatori = new PersistentHashMap<>(PLAYER_FILENAME);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        final ImageIcon imageIcon = new ImageIcon("src/main/resources/immagini/IndovinaChi.png");
        final Image image = imageIcon.getImage();
        final Image newImage = image.getScaledInstance(SCALEDWIDTH, SCALEDHEIGHT, Image.SCALE_SMOOTH);
        final ImageIcon scaledImageIcon = new ImageIcon(newImage);

        final JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setIcon(scaledImageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        final JPanel buttonPanel = new JPanel();
        final JButton classicMode = new JButton("Modalita' classica");
        final JButton manualMode = new JButton("Modalita' manuale");
        buttonPanel.add(classicMode);
        buttonPanel.add(manualMode);
        final Dimension buttonSize = new Dimension(BUTTONWIDTH, BUTTONHEIGHT);
        classicMode.setPreferredSize(buttonSize);
        manualMode.setPreferredSize(buttonSize);

        classicMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String nomeGiocatore = JOptionPane.showInputDialog(null,
                "Inserisci il tuo nome:",
                "Inserisci nome",
                JOptionPane.QUESTION_MESSAGE);
                if (nomeGiocatore != null && !nomeGiocatore.isEmpty()) {
                    if (!giocatori.containsKey(nomeGiocatore)) {
                        giocatori.put(nomeGiocatore, 0);
                    } else {
                        final int choice = JOptionPane.showConfirmDialog(null,
                        "Il giocatore esiste gia'. Vuoi sovrascrivere il punteggio?",
                        "Sovrascrivi punteggio",
                        JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            giocatori.remove(nomeGiocatore);
                            giocatori.put(nomeGiocatore, 0);
                        } else {
                            new SchermataInizialeGUI();
                        }
                    }
                }
                modeSelect = AUTOMATIC_MODE;
                dispose();
                new SelezioneDifficoltaGUI(modeSelect);
            }
        });

        manualMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String nomeGiocatore = JOptionPane.showInputDialog(null,
                "Inserisci il tuo nome:",
                "Inserisci nome",
                JOptionPane.QUESTION_MESSAGE);
                if (nomeGiocatore != null && !nomeGiocatore.isEmpty()) {
                    if (!giocatori.containsKey(nomeGiocatore)) {
                        giocatori.put(nomeGiocatore, 0);
                    } else {
                        final int choice = JOptionPane.showConfirmDialog(null,
                        "Il giocatore esiste gia'. Vuoi sovrascrivere il punteggio?",
                        "Sovrascrivi punteggio",
                        JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            giocatori.put(nomeGiocatore, 0);
                        } else {
                            new SchermataInizialeGUI();
                        }
                    }
                }
                modeSelect = MANUAL_MODE;
                dispose();
                new SelezioneDifficoltaGUI(modeSelect);
            }
        });

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }

    /**
     * Metodo principale per avviare il gioco.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SchermataInizialeGUI();
    }
}
