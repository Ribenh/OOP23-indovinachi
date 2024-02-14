/*
 * Implementazione di
 * InterfacciaPulsanti
 */
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

public final class Pulsanti implements InterfacciaPulsanti {
    @Override
    public void pulsante(final JFrame frame, final JPanel panel, final String nomePulsante, final List<String> l) {
        final JButton b = new JButton(nomePulsante);
        int i;

        final JPopupMenu pm = new JPopupMenu();
        for (i = 0; i < l.size(); i++) {
            final String dettaglioPulsante = l.get(i);
            pm.add(new JMenuItem(new AbstractAction(dettaglioPulsante) {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    final DomandaPulsante d = new DomandaPulsante();
                    JOptionPane.showMessageDialog(frame, d.creaDomanda(nomePulsante, dettaglioPulsante));
                }
            }));
        }
        
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                pm.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        panel.add(b);
    }
}
