package personaggi;

import javax.swing.ImageIcon;

/**
 * Implementazione dell'interfaccia {@link Personaggio} che definisce le caratteristiche di un personaggio del gioco.
 */
public class PersonaggioImpl implements Personaggio {
    private String nome;
    private ImageIcon immagine;
    private Boolean hasCapelli;
    private String coloreCapelli;
    private String tipologiaCapelli;
    private String lunghezzaCapelli;
    private String coloreOcchi;
    private Boolean barba;
    private Boolean occhiali;
    private Boolean accessorio;
    private Boolean baffi;
    private Boolean uomo;
    private static final String NOT = "not";

    /**
    * Costruttore per creare un personaggio con tutte le caratteristiche definite.
    * @param nome Il nome del personaggio.
    * @param immagine L'immagine del personaggio.
    * @param hasCapelli True se il personaggio ha i capelli, altrimenti False.
    * @param coloreCapelli Il colore dei capelli del personaggio.
    * @param tipologiaCapelli La tipologia dei capelli del personaggio.
    * @param lunghezzaCapelli La lunghezza dei capelli del personaggio.
    * @param coloreOcchi Il colore degli occhi del personaggio.
    * @param barba True se il personaggio ha la barba, altrimenti False.
    * @param occhiali True se il personaggio indossa gli occhiali, altrimenti False.
    * @param accessorio True se il personaggio ha accessori, altrimenti False.
    * @param baffi True se il personaggio ha i baffi, altrimenti False.
    * @param uomo True se il personaggio è di sesso maschile, altrimenti False.
    */
    public PersonaggioImpl(final String nome, final ImageIcon immagine, final Boolean hasCapelli, final String coloreCapelli, 
    final String tipologiaCapelli, final String lunghezzaCapelli, final String coloreOcchi, final Boolean barba, 
    final Boolean occhiali, final Boolean accessorio, final Boolean baffi, final Boolean uomo) {
        this.nome = nome;
        this.immagine = new ImageIcon(immagine.getImage());
        this.hasCapelli = hasCapelli;
        this.coloreCapelli = coloreCapelli;
        this.tipologiaCapelli = tipologiaCapelli;
        this.lunghezzaCapelli = lunghezzaCapelli;
        this.coloreOcchi = coloreOcchi;
        this.barba = barba;
        this.baffi = baffi;
        this.occhiali = occhiali;
        this.accessorio = accessorio;
        this.occhiali = occhiali;
        this.accessorio = accessorio;
        this.baffi = baffi;
        this.uomo = uomo;
    }

    /**
     * Costruttore per creare un personaggio con caratteristiche parziali.
     * @param nome Il nome del personaggio.
     * @param immagine L'immagine del personaggio.
     * @param hasCapelli True se il personaggio ha i capelli, altrimenti False.
     * @param coloreOcchi Il colore degli occhi del personaggio.
     * @param barba True se il personaggio ha la barba, altrimenti False.
     * @param occhiali True se il personaggio indossa gli occhiali, altrimenti False.
     * @param accessorio True se il personaggio ha accessori, altrimenti False.
     * @param baffi True se il personaggio ha i baffi, altrimenti False.
     * @param uomo True se il personaggio è di sesso maschile, altrimenti False.
     */
    public PersonaggioImpl(final String nome, final ImageIcon immagine, final Boolean hasCapelli, final String coloreOcchi, 
    final Boolean barba, final Boolean occhiali, final Boolean accessorio, final Boolean baffi, final Boolean uomo) {
        this.nome = nome;
        this.immagine = new ImageIcon(immagine.getImage());
        this.hasCapelli = hasCapelli;
        this.coloreCapelli = NOT;
        this.tipologiaCapelli = NOT;
        this.lunghezzaCapelli = NOT;
        this.coloreOcchi = coloreOcchi;
        this.barba = barba;
        this.baffi = baffi;
        this.occhiali = occhiali;
        this.accessorio = accessorio;
        this.baffi = baffi;
        this.uomo = uomo;
    }

    // Implementazione dei metodi dell'interfaccia Personaggio
    /**
     * Restituisce il nome del personaggio.
     * @return Il nome del personaggio.
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del personaggio.
     * @param nome Il nuovo nome del personaggio.
     */
    @Override
    public void setNome(final String nome) {
        this.nome = nome;
    }

    /**
    * Restituisce un'istanza di ImageIcon che rappresenta l'immagine del personaggio.
    * Nota: Questo metodo restituisce una copia dell'immagine anziché l'oggetto originale
    * per proteggere la rappresentazione interna della classe da modifiche esterne.
    * Modifiche all'immagine restituita non influenzeranno l'immagine interna della classe.
    * @return Una copia dell'immagine del personaggio.
    */
    @Override
    public ImageIcon getImmagine() {
        // Restituisce una copia dell'immagine
        return new ImageIcon(immagine.getImage());
    }

    /**
    * Imposta l'immagine del personaggio.
    * Nota: Questo metodo accetta una copia dell'immagine anziché l'oggetto originale
    * per proteggere la rappresentazione interna della classe da modifiche esterne.
    * Modifiche all'immagine fornita non influenzeranno l'immagine interna della classe.
    * @param immagine Una copia dell'immagine da impostare per il personaggio.
    */
    @Override
    public void setImmagine(final ImageIcon immagine) {
        // Imposta una copia dell'immagine anziché l'oggetto originale
        this.immagine = new ImageIcon(immagine.getImage());
    }

    /**
     * Verifica se il personaggio ha i capelli.
     * @return True se il personaggio ha i capelli, altrimenti False.
     */
    @Override
    public Boolean hasCapelli() {
        return hasCapelli;
    }

    /**
     * Imposta se il personaggio ha i capelli.
     * @param hasCapelli True se il personaggio ha i capelli, altrimenti False.
     */
    @Override
    public void setHasCapelli(final Boolean hasCapelli) {
        this.hasCapelli = hasCapelli;
    }

    /**
     * Restituisce il colore dei capelli del personaggio.
     * @return Il colore dei capelli del personaggio.
     */
    @Override
    public String getColoreCapelli() {
        return coloreCapelli;
    }

    /**
     * Imposta il colore dei capelli del personaggio.
     * @param coloreCapelli Il nuovo colore dei capelli del personaggio.
     */
    @Override
    public void setColoreCapelli(final String coloreCapelli) {
        this.coloreCapelli = coloreCapelli;
    }

    /**
     * Restituisce la tipologia dei capelli del personaggio.
     * @return La tipologia dei capelli del personaggio.
     */
    @Override
    public String getTipologiaCapelli() {
        return tipologiaCapelli;
    }

    /**
     * Imposta la tipologia dei capelli del personaggio.
     * @param tipologiaCapelli La nuova tipologia dei capelli del personaggio.
     */
    @Override
    public void setTipologiaCapelli(final String tipologiaCapelli) {
        this.tipologiaCapelli = tipologiaCapelli;
    }

    /**
     * Restituisce la lunghezza dei capelli del personaggio.
     * @return La lunghezza dei capelli del personaggio.
     */
    @Override
    public String getLunghezzaCapelli() {
        return lunghezzaCapelli;
    }

    /**
     * Imposta la lunghezza dei capelli del personaggio.
     * @param lunghezzaCapelli La nuova lunghezza dei capelli del personaggio.
     */
    @Override
    public void setLunghezzaCapelli(final String lunghezzaCapelli) {
        this.lunghezzaCapelli = lunghezzaCapelli;
    }

    /**
     * Restituisce il colore degli occhi del personaggio.
     * @return Il colore degli occhi del personaggio.
     */
    @Override
    public String getColoreOcchi() {
        return coloreOcchi;
    }

    /**
     * Imposta il colore degli occhi del personaggio.
     * @param coloreOcchi Il nuovo colore degli occhi del personaggio.
     */
    @Override
    public void setColoreOcchi(final String coloreOcchi) {
        this.coloreOcchi = coloreOcchi;
    }

    /**
     * Verifica se il personaggio ha la barba.
     * @return True se il personaggio ha la barba, altrimenti False.
     */
    @Override
    public Boolean getBarba() {
        return barba;
    }

    /**
     * Imposta se il personaggio ha la barba.
     * @param barba True se il personaggio ha la barba, altrimenti False.
     */
    @Override
    public void setBarba(final Boolean barba) {
        this.barba = barba;
    }

    /**
     * Verifica se il personaggio indossa gli occhiali.
     * @return True se il personaggio indossa gli occhiali, altrimenti False.
     */
    @Override
    public Boolean hasOcchiali() {
        return occhiali;
    }

    /**
     * Imposta se il personaggio indossa gli occhiali.
     * @param occhiali True se il personaggio indossa gli occhiali, altrimenti False.
     */
    @Override
    public void setOcchiali(final Boolean occhiali) {
        this.occhiali = occhiali;
    }

    /**
     * Verifica se il personaggio ha accessori.
     * @return True se il personaggio ha accessori, altrimenti False.
     */
    @Override
    public Boolean hasAccessori() {
        return accessorio;
    }

    /**
     * Imposta se il personaggio indossa un accessorio.
     * @param accessorio True se il personaggio indossa un accessorio, altrimenti False.
     */
    @Override
    public void setAccessori(Boolean accessorio) {
        this.accessorio = accessorio;
    }
    
    /**
     * Verifica se il personaggio ha i baffi.
     * @return True se il personaggio ha i baffi, altrimenti False.
     */
    @Override
    public Boolean hasBaffi() {
        return baffi;
    }

    /**
     * Imposta se il personaggio ha i baffi.
     * @param baffi True se il personaggio ha i baffi, altrimenti False.
     */
    @Override
    public void setBaffi(final Boolean baffi) {
        this.baffi = baffi;
    }

    /**
     * Verifica se il personaggio è di sesso maschile.
     * @return True se il personaggio è di sesso maschile, altrimenti False.
     */
    @Override
    public Boolean isUomo() {
        return uomo;
    }

    /**
     * Imposta se il personaggio è di sesso maschile.
     * @param uomo True se il personaggio è di sesso maschile, altrimenti False.
     */
    @Override
    public void setUomo(final Boolean uomo) {
        this.uomo = uomo;
    }
}

    
