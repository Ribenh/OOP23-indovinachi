package schermataFinale;

import java.awt.*;
import javax.swing.*;

public class schermataFinaleGUI {

    private JFrame frame;
    private JPanel domandePanel;
    private JPanel classificaPanel;
    private JTextArea domandeTextArea;
    private JTable classificaTable;
    private JScrollPane domandeScrollPane;
    private JScrollPane classificaScrollpane;
    
    public schermataFinaleGUI() {
        frame = new JFrame("Schermata Finale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // pannello domande
        domandePanel = new JPanel(new BorderLayout());
        domandePanel.add(new JLabel("Riepilogo Domande"), BorderLayout.NORTH);
        domandeTextArea = new JTextArea();

        // placeholder: le domande dovranno essere prese dal menù
        domandeTextArea.append("-ha i capelli castani?\n\n-ha gli occhi marroni?\n\n-e' un maschio?\n\n");
        
        domandeTextArea.setEditable(false);

        domandeScrollPane = new JScrollPane(domandeTextArea);
        domandePanel.add(domandeScrollPane, BorderLayout.CENTER);

        // pannello classifica
        classificaPanel = new JPanel(new BorderLayout());
        classificaPanel.add(new JLabel("Classifica"), BorderLayout.NORTH);

        // crea la tabella con i nomi e i punteggi dei giocatori.
        // placeholder da cambiare (nella versione finale prende le domande ed il nome del giocatore dal menu)
        String[] columnNames = {"Nome giocatore", "Punteggio"};
        Object[][] data = {
            {"Giocatore 1", 10},
            {"Giocatore 2", 8},
            {"Giocatore 3", 6},
        };
        classificaTable = new JTable(data, columnNames);

        // ordina la tabella in base al punteggio
        classificaTable.setAutoCreateRowSorter(true);
        
        classificaScrollpane = new JScrollPane(classificaTable);
        classificaPanel.add(classificaScrollpane, BorderLayout.CENTER);

        mainPanel.add(domandePanel, BorderLayout.CENTER);
        mainPanel.add(classificaPanel, BorderLayout.EAST);

        frame.getContentPane().add(mainPanel);

        frame.setSize(new Dimension(800, 400));
        frame.setResizable(false);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new schermataFinaleGUI();
    }
}
