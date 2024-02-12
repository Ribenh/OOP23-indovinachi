package menu;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.util.List;

/*
 * Interfaccia che definisce l'operazione
 * per creare i pulsanti
 */
public interface InterfacciaPulsanti {
    void pulsante(JFrame frame, JToolBar toolBar, String nomePulsante, List<String> l);
}
