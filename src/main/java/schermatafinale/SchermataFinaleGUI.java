package schermatafinale;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.Box;
import schermatainiziale.PersistentHashMap;
import schermatainiziale.SchermataInizialeGUI;
import searchbar.ListaDomande;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Classe GUI per visualizzare la schermata finale con un riepilogo delle domande e della classifica.
 * Consente agli utenti di giocare nuovamente o di uscire dall'applicazione.
 */
public class SchermataFinaleGUI {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static final int BORDER = 5;
    private static final String FILENAME = "src/main/java/schermatainiziale/giocatori.ser";

    private final transient PersistentHashMap<String, Integer> giocatori = new PersistentHashMap<>(FILENAME);

    /**
     * Costruttore per inizializzare la schermata finale.
     * @param domande La lista delle domande da visualizzare.
     */
    public SchermataFinaleGUI(final List<String> domande) {

        // Carica i punteggi dei nomi
        giocatori.loadHashMap();
        giocatori.setScoreForLastEntry(domande.size());

        final JFrame frame = new JFrame("Schermata Finale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel mainPanel = new JPanel(new BorderLayout());

        // pannello domande
        final JPanel domandePanel = new JPanel(new BorderLayout());
        domandePanel.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        final JLabel riepilogoLabel = new JLabel("Riepilogo Domande", SwingConstants.CENTER);
        domandePanel.add(riepilogoLabel, BorderLayout.NORTH);
        final JTextArea domandeTextArea = new JTextArea();

        // Inserimento delle domande nella TextArea
        for (final String domanda : domande) {
            domandeTextArea.append(domanda + "\n\n");
        }
        domandeTextArea.setEditable(false);
        final JScrollPane domandeScrollPane = new JScrollPane(domandeTextArea);
        domandePanel.add(domandeScrollPane, BorderLayout.CENTER);

        // pannello classifica
        final JPanel classificaPanel = new JPanel(new BorderLayout());
        classificaPanel.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        final JLabel classificaLabel = new JLabel("Classifica", SwingConstants.CENTER);
        classificaPanel.add(classificaLabel, BorderLayout.NORTH);

         // Filtra e ordina i giocatori per punteggio crescente
        final List<Map.Entry<String, Integer>> filteredAndSortedPlayers = new ArrayList<>();
        for (final Map.Entry<String, Integer> entry : giocatori.entrySet()) {
            if (entry.getValue() != 0) {
                filteredAndSortedPlayers.add(entry);
            }
        }
        filteredAndSortedPlayers.sort(Comparator.comparingInt(Map.Entry::getValue));

        // Creazione dei dati per la JTable
        Object[][] data = new Object[filteredAndSortedPlayers.size()][2];
        for (int i = 0; i < filteredAndSortedPlayers.size(); i++) {
            final Map.Entry<String, Integer> entry = filteredAndSortedPlayers.get(i);
            data[i][0] = entry.getKey(); // Giocatore
            data[i][1] = entry.getValue(); // Numero domande
        }

        // Nomi delle colonne
        final String[] columnNames = {"Giocatore", "Numero domande"};

        // Creazione della JTable con i dati e i nomi delle colonne
        final JTable classificaTable = new JTable(data, columnNames);
        final JScrollPane classificaScrollPane = new JScrollPane(classificaTable);
        classificaPanel.add(classificaScrollPane, BorderLayout.CENTER);

        // creazione pulsanti
        final JButton giocaAncora = new JButton("Gioca ancora");
        final JButton esci = new JButton("Esci");

        // Aggiunta dei pulsanti al pannello dei pulsanti con un BoxLayout
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(giocaAncora);
        buttonPanel.add(Box.createHorizontalGlue()); // Spazio flessibile tra i pulsanti
        buttonPanel.add(esci);

        // Aggiunta dei bordi ai pannelli principali
        mainPanel.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));

        // Aggiunta dei componenti al pannello principale
        mainPanel.add(domandePanel, BorderLayout.CENTER);
        mainPanel.add(classificaPanel, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Aggiunta dell'ActionListener per il pulsante "Esci"
        esci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Sei sicuro di voler chiudere l'applicazione?",
                        "Conferma chiusura",
                        JOptionPane.YES_NO_OPTION);
                 if (result == JOptionPane.YES_OPTION) {
                     // Pulisci la TextArea prima di chiudere l'applicazione
                     domandeTextArea.setText("");
                     frame.dispose();
                 }
             }
         });

        // Aggiunta dell'ActionListener per il pulsante "Gioca ancora"
        giocaAncora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                ListaDomande.clearListaDomande();
                frame.dispose();
                new SchermataInizialeGUI();
            }
        });

        frame.getContentPane().add(mainPanel);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
