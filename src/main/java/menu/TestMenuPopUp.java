package menu;
/**
 * Classe test per MunuPopup.
 */
public final class TestMenuPopup {
    /**
     * Main del test.
     * @param args argomento
     * @throws IOException ignora errore I/O
     */
    public static void main(final String[] args) throws java.io.IOException {
        new MenuPopup(0);
    }
    private TestMenuPopup() { 
        throw new UnsupportedOperationException("This is a test class and cannot be instantiated"); 
    }
}
