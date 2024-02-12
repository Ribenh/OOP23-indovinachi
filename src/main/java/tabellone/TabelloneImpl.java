package tabellone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

import personaggi.PersonaggiCreati;
import personaggi.Personaggio;

/**
 * Implementazione dell'interfaccia Tabellone che gestisce il tabellone di gioco.
 */
public class TabelloneImpl implements Tabellone {
    // Mappa che associa ogni posizione nel tabellone al personaggio corrispondente
    private final Map<Position, Personaggio> tabellone;
    private String personaggioDaIndovinare; 

    /**
     * Costruttore della classe TabelloneImpl.
     * @param size La dimensione del tabellone (numero di righe/colonne).
     */
     public TabelloneImpl(int sizeX, int sizeY) {
        this.tabellone = new HashMap<>();
        inizializzaTabellone(sizeX, sizeY);
    }

    /**
     * Inizializza il tabellone con le posizioni e i personaggi iniziali.
     * @param size La dimensione del tabellone (numero di righe/colonne).
     */
    public void inizializzaTabellone(int sizeX, int sizeY) {
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        Random random = new Random();
        personaggioDaIndovinare = personaggi.get(random.nextInt(personaggi.size())).getNome();

        int index = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Position position = new Position(i, j);
                tabellone.put(position, personaggi.get(index++));
                // Aggiornamento dell'indice solo se ci sono ancora personaggi nella lista
                if (index >= personaggi.size()) {
                    index = 0; // Ritorna al primo personaggio se si raggiunge la fine della lista
                }
            }
        }
    }

    /**
     * Aggiorna lo stato del tabellone rimuovendo i personaggi specificati.
     * @param personaggiRimanenti La lista dei personaggi da rimuovere dal tabellone.
     */
    @Override
    public void aggiornaTabellone(List<String> personaggiRimanenti) {
        // Crea una copia dell'entrySet per evitare ConcurrentModificationException
        Set<Entry<Position, Personaggio>> entrySetCopy = new HashSet<>(tabellone.entrySet());
    
        for (Entry<Position, Personaggio> entry : entrySetCopy) {
            if (personaggiRimanenti.contains(entry.getValue().getNome())) {
                // Rimuovi l'entry dalla mappa
                tabellone.remove(entry.getKey());
            }
        }
    }

    /**
     * Restituisce la mappa che rappresenta lo stato attuale del tabellone.
     * @return La mappa che associa ogni posizione al personaggio corrispondente.
     */
    @Override
    public Map<Position, Personaggio> getTabellone() {
        return tabellone;
    }

    @Override
    public String getPersonaggioDaIndovinare() {
        return personaggioDaIndovinare;
    }
}
