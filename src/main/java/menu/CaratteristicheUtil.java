/*
* Creazione di Liste costanti
* che elenca le caratteristiche
*/
package menu;

/*
* importa java.util.list
*/
import java.util.List;


public abstract class CaratteristicheUtil {
    
    public static final List<String> GENERE = List.of("Maschio", "Femmina");
    public static final List<String> COLORECAPELLI = List.of("Neri", "Castani", "Bianchi", "Arancioni", "Verdi", "Marroni");
    public static final List<String> TIPICAPELLI = List.of("Lisci", "Mossi", "Ricci");
    public static final List<String> LUNGHEZZACAPELLI = List.of("Corti", "Lunghi");
    public static final List<String> COLOREOCCHI = List.of("Marroni", "Verdi", "Azzurri");
    public static final List<String> YESORNO = List.of("SI", "NO");

}