package schermatafinale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che rappresenta l'interfaccia grafica della schermata finale.
 */
public class SchermataFinaleGUI {
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static final int BORDER = 5;

    /**
     * Costruttore della classe SchermataFinaleGUI.
     */
    public SchermataFinaleGUI() {
        final JFrame frame = new JFrame("Schermata Finale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel mainPanel = new JPanel(new BorderLayout());

        // pannello domande
        final JPanel domandePanel = new JPanel(new BorderLayout());
        domandePanel.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        final JLabel riepilogoLabel = new JLabel("Riepilogo Domande", SwingConstants.CENTER);
        domandePanel.add(riepilogoLabel, BorderLayout.NORTH);
        final JTextArea domandeTextArea = new JTextArea();

        // placeholder: le domande dovranno essere prese dal menù
        domandeTextArea.append("-ha i capelli castani?\n\n-ha gli occhi marroni?\n\n-e' un maschio?\n\n");

        domandeTextArea.setEditable(false);
        final JScrollPane domandeScrollPane = new JScrollPane(domandeTextArea);
        domandePanel.add(domandeScrollPane, BorderLayout.CENTER);

        // pannello classifica
        final JPanel classificaPanel = new JPanel(new BorderLayout());
        classificaPanel.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        final JLabel classificaLabel = new JLabel("Classifica", SwingConstants.CENTER);
        classificaPanel.add(classificaLabel, BorderLayout.NORTH);

        // crea la tabella con i nomi e i punteggi dei giocatori.
        // placeholder da cambiare (nella versione finale prende le domande ed il nome del giocatore dal menu)
        final String[] columnNames = {"Nome giocatore", "Punteggio"};
        final Object[][] data = {
            {"Giocatore 1", 10},
            {"Giocatore 2", 8},
            {"Giocatore 3", 6},
        };
        final JTable classificaTable = new JTable(data, columnNames);

        // ordina la tabella in base al punteggio
        classificaTable.setAutoCreateRowSorter(true);
        final JScrollPane classificaScrollpane = new JScrollPane(classificaTable);
        classificaPanel.add(classificaScrollpane, BorderLayout.CENTER);

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
                        System.exit(0);
                }
            }
        });

        frame.getContentPane().add(mainPanel);

        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
