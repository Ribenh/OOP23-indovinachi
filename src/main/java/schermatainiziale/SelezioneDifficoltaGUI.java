package schermatainiziale;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tabellone.TabelloneGUI;

/**
 * Interfaccia grafica della selezione della difficoltà.
 */
public class SelezioneDifficoltaGUI extends JFrame {

    private static final int SCALEDWIDTH = -1;
    private static final int SCALEDHEIGHT = 800;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BUTTONWIDTH = 150;
    private static final int BUTTONHEIGHT = 50;
    private static final int FONTSIZE = 20;
    private static final int DIMENSIONE_FACILE = 1;
    private static final int DIMENSIONE_MEDIA = 2;
    private static final int DIMENSIONE_DIFFICILE = 3;
    private static final int AUTOMATIC_MODE = 1;
    private static final int MANUAL_MODE = 2;

    /**
     * Costruttore della classe SelezioneDifficoltaGUI che si aprirà dopo aver scelto la modalità.
     */
    public SelezioneDifficoltaGUI(int modeSelect) {
        super("Indovina Chi");

        // Impostazioni della finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        // Pannello principale
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

         // Carica l'immagine e la ridimensiona
        final ImageIcon imageIcon = new ImageIcon("src/main/java/schermatainiziale/IndovinaChi.png");
        final Image image = imageIcon.getImage();
        final Image newImage = image.getScaledInstance(SCALEDWIDTH, SCALEDHEIGHT, Image.SCALE_SMOOTH);
        final ImageIcon scaledImageIcon = new ImageIcon(newImage);
        final JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setIcon(scaledImageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        // pannello bottoni
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        final JLabel titleLabel = new JLabel("Seleziona la difficolta'");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Modifica del font del titolo
        final Font titleFont = new Font("Arial", Font.BOLD, FONTSIZE);
        titleLabel.setFont(titleFont);

        buttonPanel.add(titleLabel, BorderLayout.NORTH);
        final JPanel buttonsContainer = new JPanel();
        final JButton facile = new JButton("Facile");
        final JButton medio = new JButton("Media");
        final JButton difficile = new JButton("Difficile");
        buttonsContainer.add(facile);
        buttonsContainer.add(medio);
        buttonsContainer.add(difficile);
        buttonPanel.add(buttonsContainer, BorderLayout.CENTER);

        // imposta le dimensioni prefissate per i pulsanti
        final Dimension buttonSize = new Dimension(BUTTONWIDTH, BUTTONHEIGHT);
        facile.setPreferredSize(buttonSize);
        medio.setPreferredSize(buttonSize);
        difficile.setPreferredSize(buttonSize);

        // Aggiunta ascoltatori di azioni ai pulsanti
        facile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                if (modeSelect == AUTOMATIC_MODE) {
                    new TabelloneAutomaticoGUI(DIMENSIONE_FACILE);
                } else if (modeSelect == MANUAL_MODE) {
                    new TabelloneManualeGUI(DIMENSIONE_FACILE);
                }
            }
        });

        medio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                if (modeSelect == AUTOMATIC_MODE) {
                    new TabelloneAutomaticoGUI(DIMENSIONE_MEDIA);
                } else if (modeSelect == MANUAL_MODE) {
                    new TabelloneManualeGUI(DIMENSIONE_MEDIA);
                }
            }
        });

        difficile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                if (modeSelect == AUTOMATIC_MODE) {
                    new TabelloneAutomaticoGUI(DIMENSIONE_DIFFICILE);
                } else if (modeSelect == MANUAL_MODE) {
                    new TabelloneManualeGUI(DIMENSIONE_DIFFICILE);
                }
            }
        });

        // aggiunta pannello dei pulsanti in basso
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Aggiunta pannello alla finestra
        add(panel);
        setVisible(true);
    }
}
