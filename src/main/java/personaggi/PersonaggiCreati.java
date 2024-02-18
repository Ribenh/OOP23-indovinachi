package personaggi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.util.Collections;

<<<<<<< HEAD
public class PersonaggiCreati {
    // Lista dei personaggi disponibili
    private static final List<Personaggio> personaggi = new ArrayList<>();

    static {
        // Salvataggio immagini
        ImageIcon basilIcon = new ImageIcon("immagini/basil.jpg");
        ImageIcon melvinIcon = new ImageIcon("immagini/melvin.jpg");
        ImageIcon hannahIcon = new ImageIcon("immagini/hannah.jpg");
        ImageIcon simoneIcon = new ImageIcon("immagini/simone.jpg");
        ImageIcon ianIcon = new ImageIcon("immagini/ian.jpg");
        ImageIcon islaIcon = new ImageIcon("immagini/isla.jpg");
        ImageIcon rupertIcon = new ImageIcon("immagini/rupert.jpg");
        ImageIcon maggieIcon = new ImageIcon("immagini/maggie.jpg");
        ImageIcon susanIcon = new ImageIcon("immagini/susan.jpg");
        ImageIcon natalieIcon = new ImageIcon("immagini/natalie.jpg");
        ImageIcon kimIcon = new ImageIcon("immagini/kim.jpg");
        ImageIcon stephenIcon = new ImageIcon("immagini/stephen.jpg");
        ImageIcon joshuaIcon = new ImageIcon("immagini/joshua.jpg");
        ImageIcon xiaoMeiIcon = new ImageIcon("immagini/xiao mei.jpg");
        ImageIcon jenniferIcon = new ImageIcon("immagini/jennifer.jpg");
        ImageIcon brianIcon = new ImageIcon("immagini/brian.jpg");
        ImageIcon garyIcon = new ImageIcon("immagini/gary.jpg");
        ImageIcon martineIcon = new ImageIcon("immagini/martine.jpg");
        ImageIcon billIcon = new ImageIcon("immagini/bill.jpg");
        ImageIcon royIcon = new ImageIcon("immagini/roy.jpg");
        ImageIcon ednaIcon = new ImageIcon("immagini/edna.jpg");
        ImageIcon moIcon = new ImageIcon("immagini/mo.jpg");
        ImageIcon kellyIcon = new ImageIcon("immagini/kelly.jpg");
        ImageIcon peteIcon = new ImageIcon("immagini/pete.jpg");
        
        // Creazione dei personaggi
        personaggi.add(new PersonaggioImpl("Basil", basilIcon, true, "Neri", "Lisci", "Corti", "Marroni", false, false, false, true, null));
        personaggi.add(new PersonaggioImpl("Melvin", melvinIcon, true, "Castani", "Lisci", "Corti", "Marroni", false, true, false, false, true));
        personaggi.add(new PersonaggioImpl("Hannah", hannahIcon, true, "Castani", "Lisci", "Lunghi", "Marroni", false, false, true, false, false));
        personaggi.add(new PersonaggioImpl("Simone", simoneIcon, true, "Castani", "Lisci", "Lunghi", "Verdi", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Ian", ianIcon, true, "Bianchi", "Lisci", "Corti", "Marroni", false, true, false, true, true));
        personaggi.add(new PersonaggioImpl("Isla", islaIcon, true, "Arancioni", "Lisci", "Lunghi", "Verdi", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Rupert", rupertIcon, false, "Verdi", false, true, false, true, true));
        personaggi.add(new PersonaggioImpl("Maggie", maggieIcon, true, "Castani", "Mossi", "Lunghi", "Marroni", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Susan", susanIcon, true, "Castani", "Ricci", "Lunghi", "Marroni", false, false, true, false, false));
        personaggi.add(new PersonaggioImpl("Kim", kimIcon, true, "Castani", "Lisci", "Lunghi", "Marroni", false, true, false, false, false));
        personaggi.add(new PersonaggioImpl("Stephen", stephenIcon, true, "Neri", "Lisci", "Corti", "Marroni", false, false, false, false, true));
        personaggi.add(new PersonaggioImpl("Joshua", joshuaIcon, true, "Castani", "Lisci", "Corti", "Marroni", false, false, false, false, true));
        personaggi.add(new PersonaggioImpl("Natalie", natalieIcon, true, "Biondi", "Lisci", "Lunghi", "Verdi", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Xiao Mei", xiaoMeiIcon, true, "Neri", "Lisci", "Lunghi", "Marroni", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Jennifer", jenniferIcon, true, "Arancioni", "Lisci", "Lunghi", "Marroni", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Brian", brianIcon, true, "Castani", "Lisci", "Corti", "Verdi", true, true, false, true, true));
        personaggi.add(new PersonaggioImpl("Gary", garyIcon, true, "Castani", "Lisci", "Corti", "Verdi", false, false, false, false, true));
        personaggi.add(new PersonaggioImpl("Martine", martineIcon, true, "Castani", "Lisci", "Lunghi", "Marroni", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Bill", billIcon, true, "Castani", "Lisci", "Corti", "Marroni", true, false, false, true, true));
        personaggi.add(new PersonaggioImpl("Roy", royIcon, true, "Castani", "Lisci", "Corti", "Marroni", false, true, false, false, true));
        personaggi.add(new PersonaggioImpl("Edna", ednaIcon, true, "Bianchi", "Lisci", "Lunghi", "Azzurri", false, true, false, false, false));
        personaggi.add(new PersonaggioImpl("Mo", moIcon, false, "Marroni", true, false, true, true, true));
        personaggi.add(new PersonaggioImpl("Kelly", kellyIcon, true, "Biondi", "Lisci", "Lunghi", "Verdi", false, false, false, false, false));
        personaggi.add(new PersonaggioImpl("Pete", peteIcon, true, "Marroni", "Ricci", "Corti", "Marroni", true, false, false, true, true));
    }

    public static List<Personaggio> creaPersonaggi() {
        // Copia la lista dei personaggi disponibili
        List<Personaggio> personaggiRandom = new ArrayList<>(personaggi);
=======


/**
 * Classe che gestisce la creazione dei personaggi disponibili nel gioco.
 */
public final class PersonaggiCreati {
    // Lista dei personaggi disponibili
    private static final List<Personaggio> PERSONAGGI = new ArrayList<>();
    private static final String CORTI = "Corti";
    private static final String LISCI = "Lisci";
    private static final String MARRONI = "Marroni";
    private static final String CASTANI = "Castani";
    private static final String LUNGHI = "Lunghi";
    private static final String VERDI = "Verdi";
    static {
        // Salvataggio immagini
        final ImageIcon basilIcon = new ImageIcon("immagini/basil.jpg");
        final ImageIcon melvinIcon = new ImageIcon("immagini/melvin.jpg");
        final ImageIcon hannahIcon = new ImageIcon("immagini/hannah.jpg");
        final ImageIcon simoneIcon = new ImageIcon("immagini/simone.jpg");
        final ImageIcon ianIcon = new ImageIcon("immagini/ian.jpg");
        final ImageIcon islaIcon = new ImageIcon("immagini/isla.jpg");
        final ImageIcon rupertIcon = new ImageIcon("immagini/rupert.jpg");
        final ImageIcon maggieIcon = new ImageIcon("immagini/maggie.jpg");
        final ImageIcon susanIcon = new ImageIcon("immagini/susan.jpg");
        final ImageIcon natalieIcon = new ImageIcon("immagini/natalie.jpg");
        final ImageIcon kimIcon = new ImageIcon("immagini/kim.jpg");
        final ImageIcon stephenIcon = new ImageIcon("immagini/stephen.jpg");
        final ImageIcon joshuaIcon = new ImageIcon("immagini/joshua.jpg");
        final ImageIcon xiaoMeiIcon = new ImageIcon("immagini/xiao mei.jpg");
        final ImageIcon jenniferIcon = new ImageIcon("immagini/jennifer.jpg");
        final ImageIcon brianIcon = new ImageIcon("immagini/brian.jpg");
        final ImageIcon garyIcon = new ImageIcon("immagini/gary.jpg");
        final ImageIcon martineIcon = new ImageIcon("immagini/martine.jpg");
        final ImageIcon billIcon = new ImageIcon("immagini/bill.jpg");
        final ImageIcon royIcon = new ImageIcon("immagini/roy.jpg");
        final ImageIcon ednaIcon = new ImageIcon("immagini/edna.jpg");
        final ImageIcon moIcon = new ImageIcon("immagini/mo.jpg");
        final ImageIcon kellyIcon = new ImageIcon("immagini/kelly.jpg");
        final ImageIcon peteIcon = new ImageIcon("immagini/pete.jpg");

        // Creazione dei personaggi
        PERSONAGGI.add(new PersonaggioImpl("Basil", basilIcon, true, "Neri", LISCI, CORTI, MARRONI, false, 
        false, false, true, null));
        PERSONAGGI.add(new PersonaggioImpl("Melvin", melvinIcon, true, CASTANI, LISCI, CORTI, MARRONI, false, 
        true, false, false, true));
        PERSONAGGI.add(new PersonaggioImpl("Hannah", hannahIcon, true, CASTANI, LISCI, LUNGHI, MARRONI, false, 
        false, true, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Simone", simoneIcon, true, CASTANI, LISCI, LUNGHI, VERDI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Ian", ianIcon, true, "Bianchi", LISCI, CORTI, MARRONI, false, 
        true, false, true, true));
        PERSONAGGI.add(new PersonaggioImpl("Isla", islaIcon, true, "Arancioni", LISCI, LUNGHI, VERDI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Rupert", rupertIcon, false, VERDI, false, true, false, true, true));
        PERSONAGGI.add(new PersonaggioImpl("Maggie", maggieIcon, true, CASTANI, "Mossi", LUNGHI, MARRONI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Susan", susanIcon, true, CASTANI, "Ricci", LUNGHI, MARRONI, false, 
        false, true, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Kim", kimIcon, true, CASTANI, LISCI, LUNGHI, MARRONI, false, 
        true, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Stephen", stephenIcon, true, "Neri", LISCI, CORTI, MARRONI, false, 
        false, false, false, true));
        PERSONAGGI.add(new PersonaggioImpl("Joshua", joshuaIcon, true, CASTANI, LISCI, CORTI, MARRONI, false, 
        false, false, false, true));
        PERSONAGGI.add(new PersonaggioImpl("Natalie", natalieIcon, true, "Biondi", LISCI, LUNGHI, VERDI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Xiao Mei", xiaoMeiIcon, true, "Neri", LISCI, LUNGHI, MARRONI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Jennifer", jenniferIcon, true, "Arancioni", LISCI, LUNGHI, MARRONI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Brian", brianIcon, true, CASTANI, LISCI, CORTI, VERDI, true, 
        true, false, true, true));
        PERSONAGGI.add(new PersonaggioImpl("Gary", garyIcon, true, CASTANI, LISCI, CORTI, VERDI, false, 
        false, false, false, true));
        PERSONAGGI.add(new PersonaggioImpl("Martine", martineIcon, true, CASTANI, LISCI, LUNGHI, MARRONI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Bill", billIcon, true, CASTANI, LISCI, CORTI, MARRONI, true, 
        false, false, true, true));
        PERSONAGGI.add(new PersonaggioImpl("Roy", royIcon, true, CASTANI, LISCI, CORTI, MARRONI, false, 
        true, false, false, true));
        PERSONAGGI.add(new PersonaggioImpl("Edna", ednaIcon, true, "Bianchi", LISCI, LUNGHI, "Azzurri", false, 
        true, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Mo", moIcon, false, CASTANI, true, false, true, true, true));
        PERSONAGGI.add(new PersonaggioImpl("Kelly", kellyIcon, true, "Biondi", LISCI, LUNGHI, VERDI, false, 
        false, false, false, false));
        PERSONAGGI.add(new PersonaggioImpl("Pete", peteIcon, true, CASTANI, "Ricci", CORTI, MARRONI, true, 
        false, false, true, true));
    }

    /**
     * Restituisce una lista di personaggi creata mescolando casualmente i personaggi disponibili.
     * @return Una lista di personaggi.
     */
    public static List<Personaggio> creaPersonaggi() {
        // Copia la lista dei personaggi disponibili
        final List<Personaggio> personaggiRandom = new ArrayList<>(PERSONAGGI);
>>>>>>> personaggi
        // Mescola la lista in modo casuale
        Collections.shuffle(personaggiRandom);
        return personaggiRandom;
    }
<<<<<<< HEAD
=======

    /**
     * Costruttore privato per prevenire l'istanziazione esterna.
     */
    private PersonaggiCreati() {
        throw new AssertionError("Classe di utilità non deve essere istanziata");
    }
>>>>>>> personaggi
}
