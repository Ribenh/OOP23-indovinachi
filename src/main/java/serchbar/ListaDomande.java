package serchbar;

import java.util.ArrayList;
import java.util.List;
/**
 * Definisce la classe ListaDomande.
 */
public final class ListaDomande {
    private static List<String> domande = new ArrayList<>();

    /**
     * Aggiunge una domanda alla lista di stringhe.
     * @param s domsnda
     */
    public static void addDomandA(final String s) {
        domande.add(s);
    }

    /**
     * Crea una copia immutabile della lista delle
     * domande e la restituisce.
     * @return Lista di domande
     */
    public static List<String> getDomande() {
        return List.copyOf(domande);
    }

    private ListaDomande() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
