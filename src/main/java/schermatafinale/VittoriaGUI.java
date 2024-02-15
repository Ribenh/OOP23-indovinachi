package schermatafinale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che rappresenta l'interfaccia grafica della schermata finale.
 */
public class VittoriaGUI extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int BORDER = 10;
    private static final int FONTSIZE = 24;

    /**
     * Costruttore della classe VittoriaGUI, genera una schermata finale che fa vedere se si ha vinto o perso la partita
     * e tre tasti:
     * 
     * - Gioca ancora fa iniziare una nuova partita
     * - Dettagli apre una schermata con classifica e statistiche
     * - Esci permette di chiudere il gioco.
     */
    public VittoriaGUI() {
        setTitle("Schermata Finale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Hai vinto!");
        
        /*
         * if (personaggioCliccato.getNome().equals(personaggioDaIndovinare)) {
            label = new JLabel("HAI VINTO!");
        } else {
            label = new JLabel("HAI PERSO!");
        }
         */
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, FONTSIZE));
        panel.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton btnGiocaAncora = new JButton("Gioca ancora");
        btnGiocaAncora.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        btnGiocaAncora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // Aggiungi qui il codice per la logica di "Gioca ancora"
            }
        });
        buttonPanel.add(btnGiocaAncora);

        JButton btnDettagli = new JButton("Dettagli");
        btnDettagli.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        btnDettagli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                new SchermataFinaleGUI();
            }
        });
        buttonPanel.add(btnDettagli);

        JButton btnEsci = new JButton("Esci");
        btnEsci.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        btnEsci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                    null, "Sei sicuro di voler uscire?",
                    "Conferma",
                    JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        buttonPanel.add(btnEsci);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
