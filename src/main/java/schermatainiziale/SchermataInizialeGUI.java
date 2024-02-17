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
import javax.swing.JPanel;

/**
 * Interfaccia grafica della schermata di selezione della modalita'.
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

    private int modeSelect = 0;
    private NomeController nomeController;

    /**
     * Costruttore della classe SchermataInizialeGUI.
     */
    public SchermataInizialeGUI() {
        super("Indovina Chi");

        // Impostazioni della finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        nomeController = new NomeController(this);

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

        // Pulsanti per selezionare la modalità di gioco
        final JPanel buttonPanel = new JPanel();
        final JButton classicMode = new JButton("Modalita' classica");
        final JButton manualMode = new JButton("Modalita' manuale");
        buttonPanel.add(classicMode);
        buttonPanel.add(manualMode);

        // Imposta le dimensioni prefissate per i pulsanti
        final Dimension buttonSize = new Dimension(BUTTONWIDTH, BUTTONHEIGHT);
        classicMode.setPreferredSize(buttonSize);
        manualMode.setPreferredSize(buttonSize);

        // Aggiunta ascoltatori di azioni ai pulsanti
        classicMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                nomeController.aggiungiNome();
                modeSelect = AUTOMATIC_MODE;
                dispose();
                new SelezioneDifficoltaGUI(modeSelect);
            }
        });

        manualMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                nomeController.aggiungiNome();
                modeSelect = MANUAL_MODE;
                dispose();
                new SelezioneDifficoltaGUI(modeSelect);
            }
        });

        // Aggiunta pannello dei pulsanti in basso
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Aggiunta pannello alla finestra
        add(panel);
        setVisible(true);
    }
}
