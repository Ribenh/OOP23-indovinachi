package tabellone;

import java.util.List;
import java.util.Map;

/**
 * Interfaccia che definisce le operazioni di un tabellone di gioco.
 */
public interface Tabellone {
    
    /**
     * Inizializza il tabellone con le dimensioni specificate.
     * @param size La dimensione del tabellone (numero di righe/colonne).
     */
    void inizializzaTabellone(int size);
    
    /**
     * Aggiorna lo stato del tabellone rimuovendo i personaggi specificati.
     * @param personaggiRimanenti La lista dei personaggi da rimuovere dal tabellone.
     */
    void aggiornaTabellone(List<String> personaggiRimanenti);
    
    /**
     * Restituisce lo stato attuale del tabellone.
     * @return La mappa che associa ogni posizione al personaggio corrispondente nel tabellone.
     */
    Map<Position, String> getTabellone();

    /**
     * Restituisce il personaggio da indovinare.
     * @return La stringa associata al personaggio da indovinare.
     */
    String getPersonaggioDaIndovinare();
}