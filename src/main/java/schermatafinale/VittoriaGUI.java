package schermatafinale;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import schermatainiziale.PersistentHashMap;
import schermatainiziale.SchermataInizialeGUI;
import serchbar.ListaDomande;

/**
 * Classe che rappresenta la finestra di vittoria o sconfitta dell'utente.
 */
public class VittoriaGUI extends JFrame {
    private static final long serialVersionUID = -6218820467019983016L;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int BORDER = 10;
    private static final int FONTSIZE = 24;
    private static final int VITTORIA = 1;
    private static final int SCONFITTA = 2;
    private static final String FILENAME = "src/main/java/schermatainiziale/giocatori.ser";

    private final List<String> domande = ListaDomande.getDomande();
    private final transient PersistentHashMap<String, Integer> giocatori = new PersistentHashMap<>(FILENAME);

     /**
      * Costruttore per inizializzare la finestra di vittoria o sconfitta.
     * @param stato Lo stato della partita (1 per vittoria, 2 per sconfitta).
     */
    public VittoriaGUI(final int stato) {

        // Carica i punteggi dei nomi
        giocatori.loadHashMap();

        setTitle("Schermata Finale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JLabel label = new JLabel();

        if (stato == VITTORIA) {
            label.setText("Hai Vinto!");
        } else if (stato == SCONFITTA) {
            label.setText("Hai Perso!");
            giocatori.remove(giocatori.getLastEntry().getKey());
        }

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, FONTSIZE));
        panel.add(label, BorderLayout.CENTER);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        final JButton btnGiocaAncora = new JButton("Gioca ancora");
        btnGiocaAncora.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        btnGiocaAncora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                new SchermataInizialeGUI();
            }
        });

        buttonPanel.add(btnGiocaAncora);
        final JButton btnDettagli = new JButton("Dettagli");
        btnDettagli.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        btnDettagli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                new SchermataFinaleGUI(domande);
            }
        });
        buttonPanel.add(btnDettagli);
        final JButton btnEsci = new JButton("Esci");
        btnEsci.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        btnEsci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int choice = JOptionPane.showConfirmDialog(
                    null, "Sei sicuro di voler uscire?",
                    "Conferma",
                     JOptionPane.YES_NO_OPTION);

                 if (choice == JOptionPane.YES_OPTION) {
                     dispose();
                }
            }
        });

        buttonPanel.add(btnEsci);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }
}
