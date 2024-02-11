package menu;

import javax.swing.*;
import java.awt.*;


/*
 * Classe che rappresenta la GUI del menu di scelta
 * delle caratteristiche
 */

public class menuPopup {

    public static void main(String[] args) {

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
        
        Pulsanti p = new Pulsanti();
        p.Pulsante(frame, toolBar, "GENERE", caratteristiche.Genere);
        p.Pulsante(frame, toolBar, "HA I CAPELLI?", caratteristiche.yesORno);
        p.Pulsante(frame, toolBar, "COLORE CAPELLI", caratteristiche.coloreCapelli);
        p.Pulsante(frame, toolBar, "TIPO DI CAPELLI", caratteristiche.tipiCapelli);
        p.Pulsante(frame, toolBar, "LUNGHEZZA CAPELLI", caratteristiche.lunghezzaCapelli);
        p.Pulsante(frame, toolBar, "COLORE OCCHI", caratteristiche.coloreOcchi);
        p.Pulsante(frame, toolBar, "HA LA BARBA?", caratteristiche.yesORno);
        p.Pulsante(frame, toolBar, "HA I BAFFI?", caratteristiche.yesORno);
        p.Pulsante(frame, toolBar, "HA ACCESSORI?", caratteristiche.yesORno);
        p.Pulsante(frame, toolBar, "HA OCCHIALI?", caratteristiche.yesORno);
        
        

        frame.getContentPane().add(toolBar, BorderLayout.NORTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}