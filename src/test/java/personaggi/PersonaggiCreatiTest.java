package personaggi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * Classe di test per la classe PersonaggiCrati.
 */
public class PersonaggiCreatiTest {
    private static final int NUMERO_TOTALE_PERSONAGGI = 24;

    /**
     * Verifica che i personaggi vengano creati correttamente.
     */
    @Test
    public void testCreaPersonaggiListaNonVuota() {
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        assertNotNull(personaggi);
        assertFalse(personaggi.isEmpty());
    }

    /**
     * Verifica che il numero di personaggi creati sia corretto.
     */
    @Test
    public void testCreaPersonaggiCorrettezzaNumeroPersonaggi() {
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        assertEquals(NUMERO_TOTALE_PERSONAGGI, personaggi.size());
    }
}
