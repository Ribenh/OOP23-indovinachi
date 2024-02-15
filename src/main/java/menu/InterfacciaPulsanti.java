package menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;

/**
 * Interfaccia per la creazione di pulsanti del menu pop up.
 */
public interface InterfacciaPulsanti {
    /**
     * Metodo per la crezione di pulsanti. 
     * prende in input i seguenti paramentri:
     * @param frame finestra che ospita il menu
     * @param jPanel pannello su cui inserirre i pulsanti
     * @param nomePulsante nome del pulsante
     * @param l lista di stringhe che contiene i nomi per il sottomenu pop up
     */
    void pulsante(JFrame frame, JPanel jPanel, String nomePulsante, List<String> l);
}
