package menu;

/**
 * Classe test per MunuPopup.
 */
public final class TestMenuPopUp {
    /**
     * Main del test.
     * @param args argomento
     * @throws IOException ignora errore I/O
     */
    public static void main(final String[] args) throws java.io.IOException {
        new MenuPopup(0);
    }
    private TestMenuPopUp() { 
        throw new UnsupportedOperationException("This is a test class and cannot be instantiated"); 
    }
}
