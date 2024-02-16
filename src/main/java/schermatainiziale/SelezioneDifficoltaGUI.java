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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Interfaccia grafica della selezione della difficoltà.
 */
public class SelezioneDifficoltaGUI extends JFrame{

    private static final int SCALEDWIDTH = -1;
    private static final int SCALEDHEIGHT = 800;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BUTTONWIDTH = 150;
    private static final int BUTTONHEIGHT = 50;
    private static final int FONTSIZE = 20;
    
    /**
     * Costruttore della classe SelezioneDifficoltaGUI che si aprirà dopo aver scelto la modalità.
     */
    public SelezioneDifficoltaGUI() {
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

        // pannello bottoni
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Seleziona la difficolta'");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Modifica del font del titolo
        Font titleFont = new Font("Arial", Font.BOLD, FONTSIZE);
        titleLabel.setFont(titleFont);

        buttonPanel.add(titleLabel, BorderLayout.NORTH);
        JPanel buttonsContainer = new JPanel();
        JButton facile = new JButton("Facile");
        JButton medio = new JButton("Media");
        JButton difficile = new JButton("Difficile");
        buttonsContainer.add(facile);
        buttonsContainer.add(medio);
        buttonsContainer.add(difficile);
        buttonPanel.add(buttonsContainer, BorderLayout.CENTER);

        // imposta le dimensioni prefissate per i pulsanti
        Dimension buttonSize = new Dimension(BUTTONWIDTH, BUTTONHEIGHT);
        facile.setPreferredSize(buttonSize);
        medio.setPreferredSize(buttonSize);
        difficile.setPreferredSize(buttonSize);

        // Aggiunta ascoltatori di azioni ai pulsanti
        facile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Codice per la modalità classica
                JOptionPane.showMessageDialog(SelezioneDifficoltaGUI.this, "Difficolta' facile selezionata");
            }
        });

        medio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Codice per la modalità manuale
                JOptionPane.showMessageDialog(SelezioneDifficoltaGUI.this, "Difficolta' media selezionata");
            }
        });

        difficile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Codice per la modalità manuale
                JOptionPane.showMessageDialog(SelezioneDifficoltaGUI.this, "Difficolta' difficile selezionata");
            }
        });

        // aggiunta pannello dei pulsanti in basso
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Aggiunta pannello alla finestra
        add(panel);
        setVisible(true);
    }
}
