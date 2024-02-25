import static org.junit.jupiter.api.Assertions.*;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import personaggi.Personaggio;
import personaggi.PersonaggioImpl;

import javax.swing.ImageIcon;

public class PersonaggioImplTest {

    private Personaggio personaggio;

    final ImageIcon basilIcon = new ImageIcon("immagini/basil.jpg");
    final ImageIcon melvinIcon = new ImageIcon("immagini/melvin.jpg");

    /**
     * Crea un nuovo personaggio di esempio per ogni test.
     */
    @BeforeEach
    public void setUp() {
        personaggio = new PersonaggioImpl("Mario", basilIcon, true, "Nero", "Lisci", "Corti", "Marroni", false,
                false, false, true, true);
    }

    /**
     * Verifica che il nome del personaggio sia correttamente impostato e
     * recuperato.
     */
    @Test
    public void testGetSetNome() {
        assertEquals("Mario", personaggio.getNome());
    }

    /**
     * Verifica che l'immagine del personaggio sia correttamente impostata e
     * recuperata.
     */
    @Test
    public void testGetSetImmagine() {
        // Ottieni l'immagine originale dal ImageIcon
        Image immagineOriginale = basilIcon.getImage();

        // Ottieni l'immagine dal personaggio
        Image immagineRitornata = personaggio.getImmagine().getImage();

        // Confronta le dimensioni delle immagini
        assertEquals(immagineOriginale.getWidth(null), immagineRitornata.getWidth(null));
        assertEquals(immagineOriginale.getHeight(null), immagineRitornata.getHeight(null));

        // Confronta il contenuto delle immagini pixel per pixel
        BufferedImage bufferedImageOriginale = toBufferedImage(immagineOriginale);
        BufferedImage bufferedImageRitornata = toBufferedImage(immagineRitornata);

        for (int x = 0; x < bufferedImageOriginale.getWidth(); x++) {
            for (int y = 0; y < bufferedImageOriginale.getHeight(); y++) {
                assertEquals(bufferedImageOriginale.getRGB(x, y), bufferedImageRitornata.getRGB(x, y));
            }
        }
    }

    // Metodo di utilità per convertire un'immagine in BufferedImage
    private BufferedImage toBufferedImage(Image image) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
        return bufferedImage;
    }

    /**
     * Verifica che il flag per la presenza dei capelli sia correttamente impostato
     * e recuperato.
     */
    @Test
    public void testHasSetCapelli() {
        assertTrue(personaggio.hasCapelli());
        personaggio.setHasCapelli(false);
        assertFalse(personaggio.hasCapelli());
    }

    /**
     * Verifica che il colore dei capelli del personaggio sia correttamente
     * impostato e recuperato.
     */
    @Test
    public void testGetSetColoreCapelli() {
        assertEquals("Nero", personaggio.getColoreCapelli());
        personaggio.setColoreCapelli("Biondo");
        assertEquals("Biondo", personaggio.getColoreCapelli());
    }

    /**
     * Verifica che la tipologia dei capelli del personaggio sia correttamente
     * impostata e recuperata.
     */
    @Test
    public void testGetSetTipologiaCapelli() {
        assertEquals("Lisci", personaggio.getTipologiaCapelli());
        personaggio.setTipologiaCapelli("Ricci");
        assertEquals("Ricci", personaggio.getTipologiaCapelli());
    }

    /**
     * Verifica che la lunghezza dei capelli del personaggio sia correttamente
     * impostata e recuperata.
     */
    @Test
    public void testGetSetLunghezzaCapelli() {
        assertEquals("Corti", personaggio.getLunghezzaCapelli());
        personaggio.setLunghezzaCapelli("Lunghi");
        assertEquals("Lunghi", personaggio.getLunghezzaCapelli());
    }

    /**
     * Verifica che il colore degli occhi del personaggio sia correttamente
     * impostato e recuperato.
     */
    @Test
    public void testGetSetColoreOcchi() {
        assertEquals("Marroni", personaggio.getColoreOcchi());
        personaggio.setColoreOcchi("Verdi");
        assertEquals("Verdi", personaggio.getColoreOcchi());
    }

    /**
     * Verifica che il flag per la presenza della barba sia correttamente impostato
     * e recuperato.
     */
    @Test
    public void testHasSetBarba() {
        assertFalse(personaggio.hasBarba());
        personaggio.setBarba(true);
        assertTrue(personaggio.hasBarba());
    }

    /**
     * Verifica che il flag per la presenza degli occhiali sia correttamente
     * impostato e recuperato.
     */
    @Test
    public void testHasSetOcchiali() {
        assertFalse(personaggio.hasOcchiali());
        personaggio.setOcchiali(true);
        assertTrue(personaggio.hasOcchiali());
    }

    /**
     * Verifica che il flag per la presenza di accessori sia correttamente impostato
     * e recuperato.
     * 
     */
    @Test
    public void testHasSetAccessori() {
        assertFalse(personaggio.hasAccessori());
        personaggio.setAccessori(true);
        assertTrue(personaggio.hasAccessori());
    }

    /**
     * Verifica che il flag per la presenza degi baffi sia correttamente impostato e
     * recuperato.
     */
    @Test
    public void testHasSetBaffi() {
        assertTrue(personaggio.hasBaffi());
        personaggio.setBaffi(false);
        assertFalse(personaggio.hasBaffi());
    }

    /**
     * Verifica che il flag per il genere del personaggio sia correttamente
     * impostato e recuperato.
     */
    @Test
    public void testIsSetUomo() {
        assertEquals(true, personaggio.isUomo());
        personaggio.setUomo(false);
        assertEquals(false, personaggio.isUomo());
        personaggio.setUomo(true);
        assertEquals(true, personaggio.isUomo());
    }

    /**
     * Verifica che il personaggio abbia la caratteristica specificata (ad esempio,
     * "Maschio" per il genere maschile.)
     */
    @Test
    public void testHasCaratteristicaPresente() {
        assertTrue(personaggio.hasCaratteristica(personaggio, "GENERE", "Maschio"));
    }

    /**
     * Verifica che il personaggio non abbia la caratteristica specificata (ad
     * esempio, "Femmina" per il genere maschile).
     */
    @Test
    public void testHasCaratteristicaAssente() {
        assertFalse(personaggio.hasCaratteristica(personaggio, "GENERE", "Femmina"));
    }
}