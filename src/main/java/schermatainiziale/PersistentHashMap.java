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

public class PersistentHashMap<K extends Serializable, V extends Serializable> {
    private final Map<K, V> hashMap;
    private final String filename;

    public PersistentHashMap(final String filename) {
        this.filename = filename;
        this.hashMap = loadHashMap();
    }

    @SuppressWarnings("unchecked")
    public final Map<K, V> loadHashMap() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            final Object obj = ois.readObject();
            if (obj instanceof Map) {
                return (Map<K, V>) obj;
            } else {
                // If the file contains a different type, return a new LinkedHashMap
                return new LinkedHashMap<>();
            }
        } catch (FileNotFoundException e) {
            // If the file doesn't exist, return a new LinkedHashMap
            return new LinkedHashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new LinkedHashMap<>();
        }
    }

    public void put(final K key, final V value) {
        hashMap.put(key, value);
        saveHashMap();
    }

    public V get(final K key) {
        return hashMap.get(key);
    }

    public void remove(final K key) {
        hashMap.remove(key);
        saveHashMap();
    }

    public void saveHashMap() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        hashMap.clear();
        saveHashMap();
    }

    public int size() {
        return hashMap.size();
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public boolean containsKey(final K key) {
        return hashMap.containsKey(key);
    }

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

    public void setScoreForLastEntry(final V score) {
        final Entry<K, V> lastEntry = getLastEntry();
        if (lastEntry != null) {
            lastEntry.setValue(score);
            saveHashMap();
        }
    }

    public Entry<K, V>[] entrySet() {
        @SuppressWarnings("unchecked")
        Entry<K, V>[] entries = new Entry[hashMap.size()];
        int i = 0;
        for (Entry<K, V> entry : hashMap.entrySet()) {
            entries[i++] = entry;
        }
        return entries;
    }
}
