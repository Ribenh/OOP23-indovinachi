package tabellone;

import personaggi.Personaggio;
import schermatafinale.VittoriaGUI;
import menu.MenuPopup;
import menu.DomandaPulsante;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Classe che rappresenta l'interfaccia grafica del tabellone di gioco.
 */
public class TabelloneAutomaticoGUI extends TabelloneGUI {

    private static final long serialVersionUID = -6218820467019983016L;

    private int tentativi; // Contatore dei tentativi
    
    public TabelloneAutomaticoGUI(final int difficolta) {
        inizializzaTabelloneGUI(difficolta); // Inizializzazione del tabellone
        // Calcola il numero massimo di tentativi in base al livello di difficoltà
        final int maxTentativi = calcolaMaxTentativi(difficolta);
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
                    giraPersonaggi();
                }
            }
        });
        getContentPane().add(askQuestionButton, BorderLayout.SOUTH);
        setVisible(true);
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
        personaggioDaIndovinare.hasCaratteristica(personaggioDaIndovinare, caratteristicaScelta, dettaglioScelto);

        // Girare le caselle in base alla risposta del giocatore
        for (final Map.Entry<Position, JButton> entry : cells.entrySet()) {
            final Position posizione = entry.getKey();
            final Personaggio personaggio = getPersonaggioAtPosition(posizione);
            final JButton pulsante = entry.getValue();

            // Calcola se il personaggio ha la caratteristica
            final Boolean personaggioHaCaratteristica = 
            personaggio.hasCaratteristica(personaggio, caratteristicaScelta, dettaglioScelto);

            // Gira il personaggio che non ha la caratteristica se il personaggio da indovinare la ha
            // Gira il personaggio che ha la caratteristica se il personaggio da indovinare non la ha
            if (!personaggioHaCaratteristica && personaggioDaIndovinareHaCaratteristica
            || personaggioHaCaratteristica && !personaggioDaIndovinareHaCaratteristica) {
                pulsante.setEnabled(false);
            }
        }
    }
}
