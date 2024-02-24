package tabellone;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import personaggi.Personaggio;
import schermatafinale.VittoriaGUI;
import menu.MenuPopup;
import menu.DomandaPulsante;

/**
 * Classe che rappresenta l'interfaccia grafica del tabellone di gioco automatico.
 */
public class TabelloneAutomaticoGUI extends TabelloneGUI {

    private static final long serialVersionUID = -6218820467019983016L;

    private int tentativi; // Contatore dei tentativi

    /**
     * Costruttore per la creazione di un'istanza di TabelloneAutomaticoGUI con una data difficoltà.
     * @param difficolta Il livello di difficoltà del gioco.
     */
    public TabelloneAutomaticoGUI(final int difficolta) {
        super(getDimensioneX(difficolta), getDimensioneY(difficolta)); // Chiamata al costruttore della superclasse TabelloneGUI
        inizializzaTabelloneGUI(difficolta); // Inizializzazione del tabellone
        // Calcola il numero massimo di tentativi in base al livello di difficoltà
        final int maxTentativi = calcolaMaxTentativi(difficolta);
        // Creazione del pannello contenitore per i pulsanti con layout GridLayout (1 riga, 2 colonne)
        final JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        // ActionListener per il pulsante "Fai una domanda"
        final JButton askQuestionButton = new JButton("Fai una domanda");
        askQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // Verifica se il numero massimo di tentativi è stato superato
                if (tentativi >= maxTentativi) {
                    new VittoriaGUI(0); // Apre la SchermataFinale con indicazione di sconfitta
                    dispose(); // Chiude la finestra corrente
                } else {
                    new MenuPopup(tentativi++); // Apre la barra di ricerca
                    askQuestionButton.setEnabled(false); // Disabilita il pulsante "Fai una domanda"
                }
            }
        });

        // ActionListener per il pulsante "Gira personaggi"
        final JButton rotateCharactersButton = new JButton("Gira personaggi");
        rotateCharactersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // Verifica se è stata fatta una domanda prima di abilitare il pulsante "Gira personaggi"
                giraPersonaggi();
                askQuestionButton.setEnabled(true); // Riattiva il pulsante "Fai una domanda"
            }
        });

        // Aggiungi i pulsanti al pannello contenitore
        buttonPanel.add(askQuestionButton); // Aggiungi il pulsante "Fai una domanda"
        buttonPanel.add(rotateCharactersButton); // Aggiungi il pulsante "Gira personaggi"

        add(buttonPanel, BorderLayout.SOUTH); // Aggiungi il pannello contenitore al content pane della finestra

        setVisible(true); // Rendi la finestra visibile dopo averla completamente inizializzata
    }

    /**
     * Metodo per disabilitare i pulsanti, "girando" i personaggi sulla base della risposta alla domanda del giocatore.
     * Ottiene la caratteristica scelta nel menu pop-up e verifica se i personaggi sul tabellone hanno tale caratteristica.
     */
    public void giraPersonaggi() {
        // Ottiene la caratteristica scelta nel menu pop-up
        final String caratteristicaScelta = DomandaPulsante.getTipoCaratteristica();
        final String dettaglioScelto = DomandaPulsante.getDettaglioCaratteristica();
        final Boolean personaggioDaIndovinareHaCaratteristica = 
        getPersonaggioDaIndovinare().hasCaratteristica(getPersonaggioDaIndovinare(), caratteristicaScelta, dettaglioScelto);

        // Girare le caselle in base alla risposta del giocatore
        for (final Map.Entry<Position, JButton> entry : getCells().entrySet()) {
            final Position posizione = entry.getKey();
            final Personaggio personaggio = getPersonaggioAtPosition(posizione);
            final JButton pulsante = entry.getValue();

            // Calcola se il personaggio ha la caratteristica
            final Boolean personaggioHaCaratteristica = 
            personaggio.hasCaratteristica(personaggio, caratteristicaScelta, dettaglioScelto);

            // Gira il personaggio che non ha la caratteristica se il personaggio da indovinare non ha la caratteristica
            if (!personaggioHaCaratteristica.equals(personaggioDaIndovinareHaCaratteristica)) {
                pulsante.setEnabled(false); // Disabilita il pulsante corrispondente
            }
        }
    }
}
