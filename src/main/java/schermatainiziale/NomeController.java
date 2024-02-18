package schermatainiziale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NomeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final JFrame frame;
    private final Map<String, Integer> nameScores;
    private static final String DATA_FILE = "src/main/java/schermatainiziale/name_scores.ser";
    
    /**
     * Costruttore della classe NomeController.
     */
    public NomeController(JFrame frame) {
        this.frame = frame;
        this.nameScores = loadNameScores();
    }

    /**
     * Aggiunge un nome alla mappa dei nomi e dei punteggi.
     */
    public void aggiungiNome() {
        String nome = JOptionPane.showInputDialog(frame, "Inserisci il tuo nome:");

        if (nome != null && !nome.trim().isEmpty()) {
            if (nameScores.containsKey(nome)) {

                int choice = JOptionPane.showConfirmDialog(frame,
                "Il nome e' gia' stato inserito. Vuoi aggiornare il tuo punteggio in classifica?",
                "Nome gia' presente",
                JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    setPunteggio(nome, 0);
                }
            } else {
                nameScores.put(nome, 0);
                saveNameScores();
            }
        }
    }

    /**
     * Imposta il punteggio per un nome nella mappa dei nomi e dei punteggi.
     */
    public void setPunteggio(String nome, int punteggio) {
        nameScores.put(nome, punteggio);
        saveNameScores();
    }

    /**
     * Restituisce la mappa dei nomi e dei punteggi.
     */
    public Map<String, Integer> getNameScores() {
        return nameScores;
    }

    /**
     * Salva la mappa dei nomi e dei punteggi su disco.
     */
    private void saveNameScores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(nameScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carica la mappa dei nomi e dei punteggi da disco.
     */
    @SuppressWarnings("unchecked")
    public Map<String, Integer> loadNameScores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (Map<String, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    /**
    * Rimuove un nome dalla mappa dei nomi e dei punteggi.
    */
    public void rimuoviNome(String nome) {
        if (nameScores.containsKey(nome)) {
            nameScores.remove(nome);
            saveNameScores();
        }
    }
}
