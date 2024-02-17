package tabellone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

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
     * @param sizeX La larghezza del tabellone (numero di colonne).
     * @param sizeY L'altezza del tabellone (numero di righe).
     */
     public TabelloneImpl(final int sizeX, final int sizeY) {
        this.tabellone = new HashMap<>();
        inizializzaTabellone(sizeX, sizeY);
    }

    /**
     * Inizializza il tabellone con le posizioni e i personaggi iniziali.
     * @param sizeX La larghezza del tabellone (numero di colonne).
     * @param sizeY L'altezza del tabellone (numero di righe).
     */
    public void inizializzaTabellone(final int sizeX, final int sizeY) {
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
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
        // Scegli casualmente il personaggio da indovinare tra quelli presenti sulla tabella
        Random random = new Random();
        Position randomPosition = new ArrayList<>(tabellone.keySet()).get(random.nextInt(tabellone.size()));
        personaggioDaIndovinare = tabellone.get(randomPosition).getNome();
    }

    /**
    * Aggiorna lo stato del tabellone rimuovendo i personaggi specificati.
    * @param personaggiRimanenti La lista dei nomi dei personaggi da rimuovere dal tabellone.
    */
    @Override
    public void aggiornaTabellone(final List<String> personaggiRimanenti) {
        // Creazione di una copia dell'entry set per evitare la modifica durante l'iterazione
        Set<Entry<Position, Personaggio>> entrySetCopy = new HashSet<>(tabellone.entrySet());
        // Iterazione sulla copia dell'entry set
        for (Entry<Position, Personaggio> entry : entrySetCopy) {
            if (personaggiRimanenti.contains(entry.getValue().getNome())) {
                // Rimuovi l'entry dalla mappa originale
                tabellone.remove(entry.getKey());
            }
        }
    }

    /**
    * Restituisce una vista non modificabile della mappa che rappresenta lo stato attuale del tabellone.
    * @return Una mappa non modificabile che associa ogni posizione al personaggio corrispondente nel tabellone.
    */
    @Override
    public Map<Position, Personaggio> getTabellone() {
        return Collections.unmodifiableMap(tabellone);
    }

    /**
     * Restituisce il nome del personaggio da indovinare.
     * @return Il nome del personaggio da indovinare.
     */
    @Override
    public String getPersonaggioDaIndovinare() {
        return personaggioDaIndovinare;
    }

    /**
     * Verifica se il personaggio cliccato corrisponde al personaggio da indovinare.
     * @param position La posizione del personaggio cliccato.
     * @return true se il personaggio cliccato è quello da indovinare, altrimenti false.
     */
    @Override
    public Boolean isPersonaggioCorretto(final Position position) {
        Personaggio personaggioCliccato = tabellone.get(position);
        return personaggioCliccato != null && personaggioCliccato.getNome().equals(personaggioDaIndovinare);
    }
}
