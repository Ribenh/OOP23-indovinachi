import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import personaggi.Personaggio;
import personaggi.PersonaggiCreati;

public class PersonaggiCreatiTest {

    @Test
    public void testCreaPersonaggi_ListaNonVuota() {
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        assertNotNull(personaggi);
        assertFalse(personaggi.isEmpty());
    }

    @Test
    public void testCreaPersonaggi_CorrettezzaNumeroPersonaggi() {
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        assertEquals(24, personaggi.size());
    }

}