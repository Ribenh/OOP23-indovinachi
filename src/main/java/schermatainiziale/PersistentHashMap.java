package schermatainiziale;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 * PersistentHashMap è una mappa chiave-valore che supporta la persistenza su disco.
 * 
 * @param <K> Il tipo delle chiavi, deve essere Serializable.
 * @param <V> Il tipo dei valori, deve essere Serializable.
 */
public class PersistentHashMap<K extends Serializable, V extends Serializable> {
    private static final Logger LOGGER = Logger.getLogger(PersistentHashMap.class.getName());
    private final Map<K, V> hashMap;
    private final String filename;
    /**
     * Costruttore che inizializza la mappa caricandola dal file specificato.
     * 
     * @param filename Il percorso del file su cui persistere la mappa.
     */
    public PersistentHashMap(final String filename) {
         this.filename = filename;
         this.hashMap = loadHashMap();
     }

     /**
      * Carica la mappa da un file sul disco.
      * <p>
     * Se il file specificato esiste e contiene una mappa serializzata, restituisce la mappa.
     * Se il file non esiste o contiene un tipo di oggetto diverso da una mappa, restituisce una nuova LinkedHashMap.
      * </p>
      * 
      * @return La mappa caricata dal file, o una nuova LinkedHashMap se il file non esiste o non può essere letto correttamente.
      *
      */
     @SuppressWarnings("unchecked")
     public final Map<K, V> loadHashMap() {
         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
             final Object obj = ois.readObject();
            if (obj instanceof Map) {
                return (Map<K, V>) obj;
            } else {
                // Se il file contiene un tipo diverso, restituisce una nuova LinkedHashMap
                return new LinkedHashMap<>();
            }
        } catch (FileNotFoundException e) {
            // Se il file non esiste, restituisce una nuova LinkedHashMap
            return new LinkedHashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Si è verificato un errore durante il caricamento della HashMap.", e);
            return new LinkedHashMap<>();
        }
    }
    /**
     * Aggiunge una coppia chiave-valore alla mappa e salva la mappa su disco.
     * <p>
     * Se si desidera estendere questa classe e sovrascrivere questo metodo, assicurarsi
     * di chiamare il metodo saveHashMap() alla fine della propria implementazione per garantire
     * che le modifiche vengano salvate su disco correttamente.
     * </p>
     * 
     * @param key La chiave da aggiungere alla mappa.
     * @param value Il valore associato alla chiave.
     */
    public void put(final K key, final V value) {
        hashMap.put(key, value);
        saveHashMap();
    }
    /**
     * Restituisce il valore associato alla chiave specificata nella mappa.
     * 
     * @param key La chiave di cui ottenere il valore associato.
     * @return Il valore associato alla chiave specificata, o null se la chiave non è presente nella mappa.
     */
    public V get(final K key) {
        return hashMap.get(key);
    }
    /**
     * Rimuove la coppia chiave-valore associata alla chiave specificata dalla mappa e salva la mappa su disco.
     * <p>
     * Se si desidera estendere questa classe e sovrascrivere questo metodo, assicurarsi
     * di chiamare il metodo saveHashMap() alla fine della propria implementazione per garantire
     * che le modifiche vengano salvate su disco correttamente.
     * </p>
     * 
     * @param key La chiave da rimuovere dalla mappa.
     */
    public void remove(final K key) {
        hashMap.remove(key);
        saveHashMap();
    }
    /**
     * Salva la mappa su disco.
     */
    public void saveHashMap() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(hashMap);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Si è verificato un errore durante il salvataggio della HashMap.", e);
        }
    }
    /**
     * Cancella tutti gli elementi della mappa e salva la mappa su disco.
     */
    public void clear() {
        hashMap.clear();
        saveHashMap();
    }
    /**
     * Restituisce il numero di coppie chiave-valore presenti nella mappa.
     * 
     * @return Il numero di coppie chiave-valore presenti nella mappa.
     */
    public int size() {
        return hashMap.size();
    }
    /**
     * Verifica se la mappa è vuota.
     * 
     * @return true se la mappa è vuota, altrimenti false.
     */
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }
    /**
     * Verifica se la mappa contiene la chiave specificata.
     * 
     * @param key La chiave da cercare nella mappa.
     * @return true se la mappa contiene la chiave specificata, altrimenti false.
     */
    public boolean containsKey(final K key) {
        return hashMap.containsKey(key);
    }
    /**
     * Restituisce l'ultima coppia chiave-valore inserita nella mappa.
     * 
     * @return L'ultima coppia chiave-valore inserita nella mappa, o null se la mappa è vuota.
     */
    public Entry<K, V> getLastEntry() {
        if (hashMap.isEmpty()) {
            return null;
        }
        Entry<K, V> lastEntry = null;
        for (final Entry<K, V> entry : hashMap.entrySet()) {
            lastEntry = entry;
        }
        return lastEntry;
    }
    /**
     * Imposta il valore per l'ultima chiave inserita nella mappa e salva la mappa su disco.
     * 
     * @param score Il valore da impostare per l'ultima chiave inserita nella mappa.
     */
    public void setScoreForLastEntry(final V score) {
        final Entry<K, V> lastEntry = getLastEntry();
        if (lastEntry != null) {
            lastEntry.setValue(score);
            saveHashMap();
        }
    }
    /**
     * Restituisce un array contenente tutte le coppie chiave-valore della mappa.
     * 
     * @return Un array contenente tutte le coppie chiave-valore della mappa.
     */
    public Entry<K, V>[] entrySet() {
        @SuppressWarnings("unchecked")
        final Entry<K, V>[] entries = new Entry[hashMap.size()];
        int i = 0;
        for (final Entry<K, V> entry : hashMap.entrySet()) {
            entries[i++] = entry;
        }
        return entries;
    }
}
