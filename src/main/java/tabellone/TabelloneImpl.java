package tabellone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Iterator;

import personaggi.PersonaggiCreati;
import personaggi.Personaggio;

/**
 * Implementazione dell'interfaccia Tabellone che gestisce il tabellone di gioco.
 */
public class TabelloneImpl implements Tabellone {
    // Mappa che associa ogni posizione nel tabellone al personaggio corrispondente
    private final transient Map<Position, Personaggio> tabellone; 
    private Personaggio personaggioDaIndovinare; 

    /**
     * Costruttore della classe TabelloneImpl.
     * @param sizeX La dimensione X del tabellone. 
     * @param sizeY La dimensione Y del tabellone.
     */
     public TabelloneImpl(final int sizeX, final int sizeY) {
        this.tabellone = new HashMap<>();
        inizializzaTabellone(sizeX, sizeY);
    }

    /**
     * Inizializza il tabellone con i personaggi creati e le rispettive posizioni.
     * @param sizeX La dimensione X del tabellone. 
     * @param sizeY La dimensione Y del tabellone.
     */
    @Override
    public final void inizializzaTabellone(final int sizeX, final int sizeY) {
        final List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        int index = 0;
        final Random random = new Random();

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                final Position position = new Position(i, j);
                final Personaggio personaggio = personaggi.get(index++);
                tabellone.put(position, personaggio);
                // Aggiornamento dell'indice solo se ci sono ancora personaggi nella lista
                if (index >= personaggi.size()) {
                    index = 0; // Ritorna al primo personaggio se si raggiunge la fine della lista
                }
            }
        }
        // Scegli casualmente il personaggio da indovinare tra quelli presenti sulla tabella
        final Position randomPosition = new ArrayList<>(tabellone.keySet()).get(random.nextInt(tabellone.size()));
        personaggioDaIndovinare = tabellone.get(randomPosition);
    }

    /**
     * Aggiorna lo stato del tabellone rimuovendo i personaggi specificati.
     * @param personaggiRimanenti La lista dei personaggi da rimuovere dal tabellone.
     */
    @Override
    public void aggiornaTabellone(final List<String> personaggiRimanenti) {
        final Iterator<Entry<Position, Personaggio>> iterator = tabellone.entrySet().iterator();
        while (iterator.hasNext()) {
            final Entry<Position, Personaggio> entry = iterator.next();
            if (personaggiRimanenti.contains(entry.getValue().getNome())) {
                iterator.remove(); 
            }
        }
    }

    /**
     * Restituisce una copia della mappa che rappresenta lo stato attuale del tabellone. 
     * @return Una copia della mappa che associa ogni posizione al personaggio corrispondente.
     */
    @Override
    public Map<Position, Personaggio> getTabellone() {
        return new HashMap<>(tabellone);
    }

    /**
     * Metodo per ottenere il nome del personaggio da indovinare.
     * @return Il nome del personaggio da indovinare.
     */
    @Override
    public Personaggio getPersonaggioDaIndovinare() {
        return personaggioDaIndovinare.creaCopia();
    }

    /**
     * Restituiace il personaggio in una determinata posizione.
     * @param position La posizione del tabellone di cui ritornare il personagio.
     * @return Il personaggio associato a una determinata posizione del tabellone.
     */
    @Override
    public Personaggio get(final Position position) {
        return tabellone.get(position);
    }
}
