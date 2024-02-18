package schermatafinale;

import java.io.*;
import java.util.*;

public class NomeScoresUtility {

    private static final String FILE_PATH = "src/main/java/schermatainiziale/name_scores.ser";

    /**
     * Carica i punteggi dei nomi dal file .ser.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Integer> loadNameScores() {
        Map<String, Integer> nameScores = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            nameScores = (HashMap<String, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nameScores;
    }

    /**
     * Salva i punteggi dei nomi nel file .ser.
     */
    public static void saveNameScores(Map<String, Integer> nameScores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(nameScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rimuove l'ultimo nome aggiunto dalla mappa dei punteggi dei nomi.
     */
    public static void removeLastName(Map<String, Integer> nameScores) {
        if (!nameScores.isEmpty()) {
            String lastAddedName = null;
            for (String name : nameScores.keySet()) {
                lastAddedName = name;
            }
            if (lastAddedName != null) {
                nameScores.remove(lastAddedName);
            }
        }
    }
}
