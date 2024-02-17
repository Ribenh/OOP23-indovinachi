package tabellone;

/**
 * Classe di test per l'interfaccia grafica del tabellone di gioco.
 */
<<<<<<< Updated upstream
public class TabelloneTest {
    /**
     * Metodo principale per avviare il programma di test.
     * @param args Argomenti passati da linea di comando (non utilizzati).
     * @throws java.io.IOException Eccezione generica di input/output.
     */
    public static void main(final String[] args) throws java.io.IOException {
        // Crea un'istanza di TabelloneGUI con un tabellone di dimensione passata
        new TabelloneGUI(1); 
=======
public final class TabelloneTest {
    /**
     * Metodo principale per avviare il programma di test.
     * @param args Argomenti passati da linea di comando (non utilizzati).
     */
    public static void main(final String[] args) {
        // Crea un'istanza di TabelloneGUI con un tabellone di dimensione passata
        new TabelloneGUI(2); 
    }

    /**
     * Costruttore privato per prevenire l'istanziazione esterna.
     */
    private TabelloneTest() {
        throw new AssertionError("Classe di utilità non deve essere istanziata");
>>>>>>> Stashed changes
    }
}
