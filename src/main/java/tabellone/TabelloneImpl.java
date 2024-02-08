package tabellone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Implementazione dell'interfaccia Tabellone che gestisce il tabellone di gioco.
 */
public class TabelloneImpl implements Tabellone {
    // Mappa che associa ogni posizione nel tabellone al personaggio corrispondente
    private final Map<Position, String> tabellone;
    private String personaggioDaIndovinare; 

    /**
     * Costruttore della classe TabelloneImpl.
     * @param size La dimensione del tabellone (numero di righe/colonne).
     */
    public TabelloneImpl(int size) {
        this.tabellone = new HashMap<>();
        inizializzaTabellone(size);
    }

    /**
     * Inizializza il tabellone con le posizioni e i personaggi iniziali.
     * @param size La dimensione del tabellone (numero di righe/colonne).
     */
    @Override
    public void inizializzaTabellone(int size) {
        Random random = new Random();
        personaggioDaIndovinare = String.valueOf(random.nextInt(size) + 1);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Position position = new Position(i, j);
                // Calcola il numero del personaggio in base alla posizione nel tabellone
                tabellone.put(position, String.valueOf(i * size + j + 1));
            }
        }
    }

    /**
     * Aggiorna lo stato del tabellone rimuovendo i personaggi specificati.
     * @param personaggiRimanenti La lista dei personaggi da rimuovere dal tabellone.
     */
    @Override
    public void aggiornaTabellone(List<String> personaggiRimanenti) {
        for (Map.Entry<Position, String> entry : tabellone.entrySet()) {
            if (personaggiRimanenti.contains(entry.getValue())) {
                // Rimuove il personaggio impostando il valore a una stringa vuota
                entry.setValue("");
            }
        }
    }

    /**
     * Restituisce la mappa che rappresenta lo stato attuale del tabellone.
     * @return La mappa che associa ogni posizione al personaggio corrispondente.
     */
    @Override
    public Map<Position, String> getTabellone() {
        return tabellone;
    }

    @Override
    public String getPersonaggioDaIndovinare() {
        return personaggioDaIndovinare;
    }
}
