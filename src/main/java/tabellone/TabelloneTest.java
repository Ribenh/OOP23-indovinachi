package tabellone;

/**
 * Classe di test per l'interfaccia grafica del tabellone di gioco.
 */
public class TabelloneTest {
    /**
     * Metodo principale per avviare il programma di test.
     * @param args Argomenti passati da linea di comando (non utilizzati).
     * @throws java.io.IOException Eccezione generica di input/output.
     */
    public static void main(String[] args) throws java.io.IOException {
        // Crea un'istanza di TabelloneGUI con un tabellone di dimensione passata
        new TabelloneGUI(2); 
    }
}
