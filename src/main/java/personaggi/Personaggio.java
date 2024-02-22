package personaggi;

import javax.swing.ImageIcon;

/**
 * Interfaccia che definisce le caratteristiche di un personaggio nel gioco dell'indovina chi.
 */
public interface Personaggio {

    /**
     * Restituisce il nome del personaggio.
     * @return Il nome del personaggio.
     */
    String getNome();

    /**
     * Imposta il nome del personaggio.
     * @param nome Il nome da assegnare al personaggio.
     */
    void setNome(String nome);

    /**
     * Restituisce l'immagine del personaggio.
     * @return L'immagine del personaggio.
     */
    ImageIcon getImmagine();

    /**
     * Imposta l'immagine del personaggio.
     * @param immagine L'immagine da assegnare al personaggio.
     */
    void setImmagine(ImageIcon immagine);

    /**
     * Verifica se il personaggio ha i capelli.
     * @return True se il personaggio ha i capelli, altrimenti False.
     */
    Boolean hasCapelli();

    /**
     * Imposta la presenza o l'assenza dei capelli per il personaggio.
     * @param hasCapelli True se il personaggio ha i capelli, altrimenti False.
     */
    void setHasCapelli(Boolean hasCapelli);

    /**
     * Restituisce il colore dei capelli del personaggio.
     * @return Il colore dei capelli del personaggio.
     */
    String getColoreCapelli();

    /**
     * Imposta il colore dei capelli del personaggio.
     * @param coloreCapelli Il colore dei capelli da assegnare al personaggio.
     */
    void setColoreCapelli(String coloreCapelli);

    /**
     * Restituisce la tipologia di capelli del personaggio.
     * @return La tipologia di capelli del personaggio.
     */
    String getTipologiaCapelli();

    /**
     * Imposta la tipologia di capelli del personaggio.
     * @param tipologiaCapelli La tipologia di capelli da assegnare al personaggio.
     */
    void setTipologiaCapelli(String tipologiaCapelli);

    /**
     * Restituisce la lunghezza dei capelli del personaggio.
     * @return La lunghezza dei capelli del personaggio.
     */
    String getLunghezzaCapelli();

    /**
     * Imposta la lunghezza dei capelli del personaggio.
     * @param lunghezzaCapelli La lunghezza dei capelli da assegnare al personaggio.
     */
    void setLunghezzaCapelli(String lunghezzaCapelli);

    /**
     * Restituisce il colore degli occhi del personaggio.
     * @return Il colore degli occhi del personaggio.
     */
    String getColoreOcchi();

    /**
     * Imposta il colore degli occhi del personaggio.
     * @param coloreOcchi Il colore degli occhi da assegnare al personaggio.
     */
    void setColoreOcchi(String coloreOcchi);

    /**
     * Verifica se il personaggio ha la barba.
     * @return True se il personaggio ha la barba, altrimenti False.
     */
    Boolean hasBarba();

    /**
     * Imposta la presenza o l'assenza della barba per il personaggio.
     * @param barba True se il personaggio ha la barba, altrimenti False.
     */
    void setBarba(Boolean barba);

    /**
     * Verifica se il personaggio indossa gli occhiali.
     * @return True se il personaggio indossa gli occhiali, altrimenti False.
     */
    Boolean hasOcchiali();

    /**
     * Imposta la presenza o l'assenza degli occhiali per il personaggio.
     * @param occhiali True se il personaggio indossa gli occhiali, altrimenti False.
     */
    void setOcchiali(Boolean occhiali);

    /**
     * Verifica se il personaggio ha accessori.
     * @return True se il personaggio ha accessori, altrimenti False.
     */
    Boolean hasAccessori();

    /**
     * Imposta la presenza o l'assenza degli accessori per il personaggio.
     * @param accessorio True se il personaggio ha accessori, altrimenti False.
     */
    void setAccessori(Boolean accessorio);

    /**
     * Verifica se il personaggio ha i baffi.
     * @return True se il personaggio ha i baffi, altrimenti False.
     */
    Boolean hasBaffi();

    /**
     * Imposta la presenza o l'assenza dei baffi per il personaggio.
     * @param baffi True se il personaggio ha i baffi, altrimenti False.
     */
    void setBaffi(Boolean baffi);

    /**
     * Verifica se il personaggio è di sesso maschile.
     * @return True se il personaggio è di sesso maschile, altrimenti False.
     */
    Boolean isUomo();

    /**
     * Imposta il sesso del personaggio.
     * @param uomo True se il personaggio è di sesso maschile, altrimenti False.
     */
    void setUomo(Boolean uomo);

    Boolean hasCaratteristica(Personaggio personaggio, String caratteristicaScelta, String dettaglioScelto);

    /**
     * Crea una copia dell'oggetto Personaggio corrente.
     * @return Una nuova istanza di Personaggio.
     */
    public Personaggio creaCopia();
}
