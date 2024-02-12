package menu;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;


/*
 * Classe che rappresenta la GUI del menu di scelta
 * delle caratteristiche
 */

public class MenuPopup {

    public void menu() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*
                * Crea la finestra che ospiterà il menu
                */
                final JFrame frame = new JFrame();
                frame.setPreferredSize(new Dimension(1000, 500));
                final JToolBar toolBar = new JToolBar();
        

                /*
                * Crea i pulsanti che comporranno
                * il menu popup
                */
        
                final Pulsanti p = new Pulsanti();
                p.pulsante(frame, toolBar, "GENERE", CaratteristicheUtil.GENERE);
                p.pulsante(frame, toolBar, "HA I CAPELLI?", CaratteristicheUtil.YESORNO);
                p.pulsante(frame, toolBar, "COLORE CAPELLI", CaratteristicheUtil.COLORECAPELLI);
                p.pulsante(frame, toolBar, "TIPO DI CAPELLI", CaratteristicheUtil.TIPICAPELLI);
                p.pulsante(frame, toolBar, "LUNGHEZZA CAPELLI", CaratteristicheUtil.LUNGHEZZACAPELLI);
                p.pulsante(frame, toolBar, "COLORE OCCHI", CaratteristicheUtil.COLOREOCCHI);
                p.pulsante(frame, toolBar, "HA LA BARBA?", CaratteristicheUtil.YESORNO);
                p.pulsante(frame, toolBar, "HA I BAFFI?", CaratteristicheUtil.YESORNO);
                p.pulsante(frame, toolBar, "HA ACCESSORI?", CaratteristicheUtil.YESORNO);
                p.pulsante(frame, toolBar, "HA OCCHIALI?", CaratteristicheUtil.YESORNO);
                
                

                frame.getContentPane().add(toolBar, BorderLayout.NORTH);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    

    }
}