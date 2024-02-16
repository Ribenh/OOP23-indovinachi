package schermatainiziale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Interfaccia grafica della schermata di selezione della modalità.
 */
public class SchermataInizialeGUI extends JFrame {

    private static final int SCALEDWIDTH = -1;
    private static final int SCALEDHEIGHT = 800;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BUTTONWIDTH = 200;
    private static final int BUTTONHEIGHT = 50;

    /**
     * Costruttore della classe SchermataInizialeGUI.
     */
    public SchermataInizialeGUI() {
        super("Indovina Chi");

        // Impostazioni della finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        // Pannello principale
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Carica l'immagine e la ridimensiona
        ImageIcon imageIcon = new ImageIcon("src/main/java/schermatainiziale/IndovinaChi.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(SCALEDWIDTH, SCALEDHEIGHT, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setIcon(scaledImageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Pulsanti per selezionare la modalità di gioco
        JPanel buttonPanel = new JPanel();
        JButton classicMode = new JButton("Modalita' classica");
        JButton manualMode = new JButton("Modalita' manuale");
        buttonPanel.add(classicMode);
        buttonPanel.add(manualMode);

        // Imposta le dimensioni prefissate per i pulsanti
        Dimension buttonSize = new Dimension(BUTTONWIDTH, BUTTONHEIGHT);
        classicMode.setPreferredSize(buttonSize);
        manualMode.setPreferredSize(buttonSize);

        // Aggiunta ascoltatori di azioni ai pulsanti
        classicMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Codice per la modalità classica
                dispose();
                new SelezioneDifficoltaGUI();
            }
        });

        manualMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Codice per la modalità manuale
                dispose();
                new SelezioneDifficoltaGUI();
            }
        });

        // Aggiunta pannello dei pulsanti in basso
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Aggiunta pannello alla finestra
        add(panel);
        setVisible(true);
    }
}
