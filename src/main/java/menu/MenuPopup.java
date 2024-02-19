package menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * Classe che rappresenta il menu pop-up.
 */
public class MenuPopup {
    private static final int RIGHE_GRID = 5;
    private static final int COLONNE_GRID = 2;
    private static final int LARGHEZZA_FRAME = 500;
    private static final int ALTEZZA_FRAME = 500;
    private final JFrame frame = new JFrame("Menu Scelta - Indovina Chi?");
    private final JPanel panel = new JPanel();
    private final Pulsanti p = new Pulsanti();

    /**
     * Costruttore della classe MenuPopup.
     * @param tentativi il numero di tentativi effettuati
     *                  se è 0 viene proiettato un messaggio
     *                  introduttivo
     */
    public MenuPopup(final int tentativi) {
        /*
        * Crea i pulsanti che comporranno
        * il menu popup
        */
        p.pulsante(frame, panel, "GENERE", CaratteristicheUtil.GENERE);
        p.pulsante(frame, panel, "HA I CAPELLI?", CaratteristicheUtil.YESORNO);
        p.pulsante(frame, panel, "COLORE CAPELLI", CaratteristicheUtil.COLORECAPELLI);
        p.pulsante(frame, panel, "TIPO DI CAPELLI", CaratteristicheUtil.TIPICAPELLI);
        p.pulsante(frame, panel, "LUNGHEZZA CAPELLI", CaratteristicheUtil.LUNGHEZZACAPELLI);
        p.pulsante(frame, panel, "COLORE OCCHI", CaratteristicheUtil.COLOREOCCHI);
        p.pulsante(frame, panel, "HA LA BARBA?", CaratteristicheUtil.YESORNO);
        p.pulsante(frame, panel, "HA I BAFFI?", CaratteristicheUtil.YESORNO);
        p.pulsante(frame, panel, "HA ACCESSORI?", CaratteristicheUtil.YESORNO);
        p.pulsante(frame, panel, "HA OCCHIALI?", CaratteristicheUtil.YESORNO);

        panel.setLayout(new GridLayout(RIGHE_GRID, COLONNE_GRID));
        frame.setPreferredSize(new Dimension(LARGHEZZA_FRAME, ALTEZZA_FRAME));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        if (tentativi == 0) {
            JOptionPane.showMessageDialog(frame, "Benvenuto Giocatore\nseleziona la prima caratteristica per iniziare");
        }
    }
}
