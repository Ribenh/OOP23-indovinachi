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
     * @param sizeX La larghezza del tabellone (numero di colonne).
     * @param sizeY L'altezza del tabellone (numero di righe).
     */
    void inizializzaTabellone(int sizeX, int sizeY);

    /**
     * Aggiorna lo stato del tabellone rimuovendo i personaggi specificati.
     * @param personaggiRimanenti La lista dei nomi dei personaggi da rimuovere dal tabellone.
     */
    void aggiornaTabellone(List<String> personaggiRimanenti);

    /**
     * Restituisce lo stato attuale del tabellone.
     * @return La mappa che associa ogni posizione al personaggio corrispondente nel tabellone.
     */
    Map<Position, Personaggio> getTabellone();

    /**
     * Restituisce il nome del personaggio da indovinare.
     * @return Il nome del personaggio da indovinare.
     */
    String getPersonaggioDaIndovinare();

    /**
     * Verifica se il personaggio cliccato corrisponde al personaggio da indovinare.
     * @param position La posizione del personaggio cliccato.
     * @return true se il personaggio cliccato è quello da indovinare, altrimenti false.
     */
    Boolean isPersonaggioCorretto(Position position);
}
