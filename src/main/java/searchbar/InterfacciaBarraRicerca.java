package searchbar;

import personaggi.Personaggio;

import javax.swing.JFrame;
/**
 * Interfaccia che definisce le operazioni della BarraRicerca.
 */
public interface InterfacciaBarraRicerca {
    /**
     * Definisce il metodo trovaPersonaggio che prende come parametro il
     * nome del personaggio da indovinare è restituisce il suo tipo Personaggio.
     * @param nomePersonaggio Stringa che contiene il nome del personaggio
     * @return Ritorna un tipo Personaggio
     */
    Personaggio trovaPersonaggio(String nomePersonaggio);

    /**
     * Definisce il metodo cercaColoreCapelli che confronta il colore di 
     * capelli selezionato con quello del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica il colore di capelli selezionato
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    Boolean cercaColoreCapelli(Personaggio p, String caratteristica);

    /**
     * Definisce il metodo cercaTipoCapelli che confronta il tipo di 
     * capelli selezionato con quello del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica il tipo di capelli selezionato
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    Boolean cercaTipoCapelli(Personaggio p, String caratteristica);

    /**
     * Definisce il metodo cercaLunghezzaCapelli che confronta la lunghezza di capelli
     * selezionata con quella del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica la lunghezza di capelli selezionata
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    Boolean cercaLunghezzaCapelli(Personaggio p, String caratteristica);

    /**
     * Definisce il metodo cercaColoreOcchi che confronta il colore degli 
     * occhi selezionato con quello del personaggio da indovinare.
     * @param p parametro di tipo Personaggio che indica il personaggio da indovinare
     * @param caratteristica stringa che indica il colore degli occhi selezionato
     * @return restituisce un booleano che indica l'esito positivo o negativo della ricerca
     */
    Boolean cercaColoreOcchi(Personaggio p, String caratteristica);

    /**
     * Definisce il metodo messaggioRicerca che fa apparire 
     * a schermo un messaggio con l'esito della ricerca.
     * @param f indica la finestra in cui inserire il messaggio
     * @param b booleano che indica l'esito positivo o negativo della ricerca
     */
    void messaggioRicerca(JFrame f, Boolean b);
}
