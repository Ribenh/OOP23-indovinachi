package tabellone;

import java.util.List;
import java.util.Map;

import personaggi.Personaggio;

/**
 * Interfaccia che definisce le operazioni di un tabellone di gioco.
 */
public interface Tabellone {
    /**
     * Inizializza il tabellone con le dimensioni specificate.
     * @param sizeX La dimensione X del tabellone. 
     * @param sizeY La dimensione Y del tabellone.
     */
    void inizializzaTabellone(int sizeX, int sizeY);

    /**
     * Aggiorna lo stato del tabellone rimuovendo i personaggi specificati.
     * @param personaggiRimanenti La lista dei personaggi da rimuovere dal tabellone.
     */
    void aggiornaTabellone(List<String> personaggiRimanenti);

    /**
     * Restituisce lo stato attuale del tabellone.
     * @return La mappa che associa ogni posizione al personaggio corrispondente nel tabellone.
     */
    Map<Position, Personaggio> getTabellone();

    /**
     * Restituisce il personaggio da indovinare.
     * @return La stringa associata al personaggio da indovinare.
     */
    Personaggio getPersonaggioDaIndovinare();

    /**
     * Restituiace il personaggio in una determinata posizione.
     * @param pos La posizione del tabellone di cui ritornare il personagio.
     * @return Il personaggio associato a una determinata posizione del tabellone.
     */
    Personaggio get(Position pos);
}
