package menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;

/*
 * Interfaccia che definisce l'operazione
 * per creare i pulsanti
 */
public interface InterfacciaPulsanti {
    void pulsante(JFrame frame, JPanel jPanel, String nomePulsante, List<String> l);
}
