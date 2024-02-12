package menu;

import javax.swing.*;
import java.util.List;

/*
 * Interfaccia che definisce l'operazione
 * per creare i pulsanti
 */
public interface InterfacciaPulsanti {
    public void Pulsante(JFrame frame, JToolBar toolBar, String nomePulsante, List<String> L);
}
