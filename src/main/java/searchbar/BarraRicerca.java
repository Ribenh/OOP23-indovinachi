package searchbar;

import personaggi.PersonaggiCreati;
import personaggi.Personaggio;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * Classe che implementa InterfacciaBarraRicerca.
 */
public class BarraRicerca implements InterfacciaBarraRicerca {

    /**
     * Prende come parametro il nome del personaggio 
     * da indovinare è restituisce il suo tipo Personaggio.
     * @param nomePersonaggio Stringa che contiene il nome del personaggio
     * @return Ritorna un tipo Personaggio
     */
    @Override
    public Personaggio trovaPersonaggio(final String nomePersonaggio) {
        final List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        int i = 0;
        while (!personaggi.get(i).getNome().equals(nomePersonaggio) && i < personaggi.size()) {
            i++;
        }
        return personaggi.get(i);
    }

    /**
     * Fa apparire a schermo un messaggio con l'esito della ricerca.
     * @param f indica la finestra in cui inserire il messaggio
     * @param b booleano che indica l'esito positivo o negativo della ricerca
     */
    @Override
    public void messaggioRicerca(final JFrame f, final Boolean b) {
        if (b) {
            JOptionPane.showMessageDialog(f, "HAI INDOVINATO");
            f.dispose();
        } else {
            JOptionPane.showMessageDialog(f, "HAI SBAGLIATO");
            f.dispose();
        }
    }

    /**
     * Confronta il colore di capelli selezionato con quello del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica il colore di capelli selezionato
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    @Override
    public Boolean cercaColoreCapelli(final Personaggio p, final String caratteristica) {
        return p.getColoreCapelli().equals(caratteristica);
    }

    /**
     * Confronta il tipo di capelli selezionato con quello del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica il tipo di capelli selezionato
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    @Override
    public Boolean cercaTipoCapelli(final Personaggio p, final String caratteristica) {
        return p.getTipologiaCapelli().equals(caratteristica);
    }

    /**
     * Confronta la lunghezza di capelli selezionata con quella del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica la lunghezza di capelli selezionata
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    @Override
    public Boolean cercaLunghezzaCapelli(final Personaggio p, final String caratteristica) {
        return p.getLunghezzaCapelli().equals(caratteristica);
    }

    /**
     * Confronta il colore degli occhi selezionato con quello del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica il colore degli occhi selezionato
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    @Override
    public Boolean cercaColoreOcchi(final Personaggio p, final String caratteristica) {
        return p.getColoreOcchi().equals(caratteristica);
    }
}
