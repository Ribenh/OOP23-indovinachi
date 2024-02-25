package personaggi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.util.Collections;



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
        final ImageIcon basilIcon = new ImageIcon("src/main/resources/immagini/basil.jpg");
        final ImageIcon melvinIcon = new ImageIcon("src/main/resources/immagini/melvin.jpg");
        final ImageIcon hannahIcon = new ImageIcon("src/main/resources/immagini/hannah.jpg");
        final ImageIcon simoneIcon = new ImageIcon("src/main/resources/immagini/simone.jpg");
        final ImageIcon ianIcon = new ImageIcon("src/main/resources/immagini/ian.jpg");
        final ImageIcon islaIcon = new ImageIcon("src/main/resources/immagini/isla.jpg");
        final ImageIcon rupertIcon = new ImageIcon("src/main/resources/immagini/rupert.jpg");
        final ImageIcon maggieIcon = new ImageIcon("src/main/resources/immagini/maggie.jpg");
        final ImageIcon susanIcon = new ImageIcon("src/main/resources/immagini/susan.jpg");
        final ImageIcon natalieIcon = new ImageIcon("src/main/resources/immagini/natalie.jpg");
        final ImageIcon kimIcon = new ImageIcon("src/main/resources/immagini/kim.jpg");
        final ImageIcon stephenIcon = new ImageIcon("src/main/resources/immagini/stephen.jpg");
        final ImageIcon joshuaIcon = new ImageIcon("src/main/resources/immagini/joshua.jpg");
        final ImageIcon xiaoMeiIcon = new ImageIcon("src/main/resources/immagini/xiao mei.jpg");
        final ImageIcon jenniferIcon = new ImageIcon("src/main/resources/immagini/jennifer.jpg");
        final ImageIcon brianIcon = new ImageIcon("src/main/resources/immagini/brian.jpg");
        final ImageIcon garyIcon = new ImageIcon("src/main/resources/immagini/gary.jpg");
        final ImageIcon martineIcon = new ImageIcon("src/main/resources/immagini/martine.jpg");
        final ImageIcon billIcon = new ImageIcon("src/main/resources/immagini/bill.jpg");
        final ImageIcon royIcon = new ImageIcon("src/main/resources/immagini/roy.jpg");
        final ImageIcon ednaIcon = new ImageIcon("src/main/resources/immagini/edna.jpg");
        final ImageIcon moIcon = new ImageIcon("src/main/resources/immagini/mo.jpg");
        final ImageIcon kellyIcon = new ImageIcon("src/main/resources/immagini/kelly.jpg");
        final ImageIcon peteIcon = new ImageIcon("src/main/resources/immagini/pete.jpg");

        // Creazione dei personaggi
        PERSONAGGI.add(new PersonaggioImpl("Basil", basilIcon, true, "Neri", LISCI, CORTI, MARRONI, false, 
        false, false, true, true));
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
        // Mescola la lista in modo casuale
        Collections.shuffle(personaggiRandom);
        return personaggiRandom;
    }

    /**
     * Costruttore privato per prevenire l'istanziazione esterna.
     */
    private PersonaggiCreati() {
        throw new AssertionError("Classe di utilità non deve essere istanziata");
    }
}
