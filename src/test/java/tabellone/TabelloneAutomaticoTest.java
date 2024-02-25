package tabellone;

/**
 * Classe di test per l'interfaccia grafica del tabellone di gioco.
 */
public final class TabelloneAutomaticoTest {
    /**
     * Metodo principale per avviare il programma di test.
     * @param args Argomenti passati da linea di comando (non utilizzati).
     */
    public static void main(final String[] args) {
        // Crea un'istanza di TabelloneGUI con un tabellone di dimensione passata
        new TabelloneAutomaticoGUI(3); 
    }

    /**
     * Costruttore privato per prevenire l'istanziazione esterna.
     */
    private TabelloneAutomaticoTest() {
        throw new AssertionError("Classe di utilità non deve essere istanziata");
    }
}
