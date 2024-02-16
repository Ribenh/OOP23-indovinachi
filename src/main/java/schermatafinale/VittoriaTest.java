package schermatafinale;

/**
 * Classe per l'interfaccia grafica della schermata finale.
 */
public final class VittoriaTest {
    /**
     * Metodo per avviare la classe VittoriaGUI.
     * @param args
     */
    public static void main(final String[] args) {
        new VittoriaGUI();
    }

    /**
     * Costruttore privato per prevenire l'istanziazione esterna.
     */
    private VittoriaTest() {
        throw new AssertionError("Classe di utilità non deve essere istanziata");
    }
}
