package menu;

import java.util.List;
/**
 * Classe Util contenente Liste di stringhe costanti.
 */
public final class CaratteristicheUtil {
    /**
     *Crea e inizializza una Lista di Stringhe costante GENERE.
     */
    public static final List<String> GENERE = List.of("Maschio", "Femmina");
    /**
     *Crea e inizializza una Lista di Stringhe costante COLORECAPELLI.
     */
    public static final List<String> COLORECAPELLI = List.of("Neri", "Castani", "Bianchi", "Arancioni", "Verdi", "Marroni");
    /**
     *Crea e inizializza una Lista di Stringhe costante TIPICAPELLI.
     */
    public static final List<String> TIPICAPELLI = List.of("Lisci", "Mossi", "Ricci");
    /**
     *Crea e inizializza una Lista di Stringhe costante LUNGHEZZACAPELLI.
     */
    public static final List<String> LUNGHEZZACAPELLI = List.of("Corti", "Lunghi");
    /**
     *Crea e inizializza una Lista di Stringhe costante COLOREOCCHI.
     */
    public static final List<String> COLOREOCCHI = List.of("Marroni", "Verdi", "Azzurri");
    /**
     *Crea e inizializza una Lista di Stringhe costante YESORNO.
     */
    public static final List<String> YESORNO = List.of("SI", "NO");

    private CaratteristicheUtil() { 
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
