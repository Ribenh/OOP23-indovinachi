package schermatafinale;

import serchbar.ListaDomande;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.FlowLayout;

import schermatainiziale.SchermataInizialeGUI;

public class VittoriaGUI extends JFrame {

    private static final long serialVersionUID = -6218820467019983016L;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int BORDER = 10;
    private static final int FONTSIZE = 24; 
    private static final int VITTORIA = 1;
    private static final int SCONFITTA = 2;
    
    List<String> domande = ListaDomande.getDomande();

    public VittoriaGUI(int stato) {

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
            // Rimuove l'ultimo nome aggiunto
            
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
