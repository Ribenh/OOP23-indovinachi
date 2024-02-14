package menu;

import javax.swing.*;
import java.awt.*;


/*
 * Classe che rappresenta la GUI del menu di scelta
 * delle caratteristiche
 */

public class MenuPopup {

    /**
     * Metodo che crea il menu
     * a scelta multipla.
     */
    public MenuPopup() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*
                * Crea la finestra che ospiterà il menu
                */
                final JFrame frame = new JFrame();
                frame.setPreferredSize(new Dimension(650, 120));
                final JPanel panel = new JPanel();

                /*
                * Crea i pulsanti che comporranno
                * il menu popup
                */
                final Pulsanti p = new Pulsanti();
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

                panel.setLayout(new FlowLayout(FlowLayout.LEADING));
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
