package menu;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/*
 * Classe che implementa l'interfaccia
 * per la creazione dei pulsanti
 */

public class Pulsanti implements InterfacciaPulsanti{

    public void Pulsante(JFrame frame, JToolBar toolBar, String nomePulsante, List<String> L){
        int i;
        final JPopupMenu pm = new JPopupMenu();
        for(i = 0; i < L.size(); i++){
            pm.add(new JMenuItem(new AbstractAction(L.get(i)) {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Dettaglio Selezionato");
            }
            }));
        }
        
        final JButton b = new JButton(nomePulsante);
        b.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pm.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        toolBar.add(b);
    }
}
