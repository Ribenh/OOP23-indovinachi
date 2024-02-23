package tabellone;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import schermatafinale.VittoriaGUI;
import serchbar.BarraRicercaGUI;

/**
 * Classe che rappresenta l'interfaccia grafica del tabellone di gioco.
 */
public class TabelloneManualeGUI extends TabelloneGUI {

    private static final long serialVersionUID = -6218820467019983016L;

    private int tentativi; // Contatore dei tentativi

    public TabelloneManualeGUI(final int difficolta) {
        inizializzaTabelloneGUI(difficolta);; // Chiamata al costruttore della classe padre

        // Calcola MAX_TENTATIVI in base al livello di difficoltà
        final int maxTentativi = calcolaMaxTentativi(difficolta);
        // ActionListener per il pulsante "Fai una domanda"
        final JButton askQuestionButton = new JButton("Fai una domanda");
        askQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // Incrementa il contatore dei tentativi quando viene fatta una domanda
                tentativi++;
                // Verifica se il numero massimo di tentativi è stato superato
                if (tentativi >= maxTentativi) {
                    new VittoriaGUI(0); // Apre la SchermataFinale con indicazione di sconfitta
                    dispose(); // Chiude la finestra corrente
                } else {
                    new BarraRicercaGUI(personaggioDaIndovinare.getNome()); // Apre la barra di ricerca
                }
            }
        });
        getContentPane().add(askQuestionButton, BorderLayout.SOUTH);
        setVisible(true);
    }
}
