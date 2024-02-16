package schermatainiziale;

/**
 * Classe di test per l'interfaccia grafica della schermata iniziale.
 */
public final class SchermataInizialeTest {

    /**
     * Metodo principale per avviare l'interfaccia della schermata iniziale.
     * @param args
     */
    public static void main(final String[] args) {
        new SchermataInizialeGUI();
    }

    /**
     * Costruttore privato per prevenire l'istanziazione esterna.
     */
    private SchermataInizialeTest() {
        throw new AssertionError("Classe di utilità non deve essere istanziata");
    }
}
