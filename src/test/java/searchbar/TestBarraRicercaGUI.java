package searchbar;

/**
 * Classe test per BarraRicercaGUI.
 */
public final class TestBarraRicercaGUI {
    /**
     * Main del test.
     * @param args argomento
     * @throws IOException ignora errore I/O
     */
    public static void main(final String[] args) throws java.io.IOException {
        new BarraRicercaGUI("Natalie");
    }

    private TestBarraRicercaGUI() { 
        throw new UnsupportedOperationException("This is a test class and cannot be instantiated"); 
    }
}
