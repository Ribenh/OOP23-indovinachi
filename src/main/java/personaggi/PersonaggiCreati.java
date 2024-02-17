package personaggi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.util.Collections;

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
        // Mescola la lista in modo casuale
        Collections.shuffle(personaggiRandom);
        return personaggiRandom;
    }
}
