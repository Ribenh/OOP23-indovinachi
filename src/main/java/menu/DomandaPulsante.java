package menu;
/**
 * Classe che definisce InterfacciaDomandaPulsante.
 */
public class DomandaPulsante implements InterfacciaDomandaPulsante {
    private String tipoCaratteristica;
    private String dettaglioCaratteristica;

    /**
     * Inizializza le variabili della classe DomandaPulsante con i seguenti parametri.
     * @param tipoCaratteristica il tipo della caratteristica a cui porre la domanda
     * @param dettaglioCaratteristica il dettaglio di caratteristica a cui porre la domanda
     */
    @Override
    public void creaDomanda(final String tipoCaratteristica, final String dettaglioCaratteristica) {
        this.tipoCaratteristica = tipoCaratteristica;
        this.dettaglioCaratteristica = dettaglioCaratteristica;
    }

    /**
     * Restituisce il tipo della caratteristica.
     * @return tipo della caratteristica
     */
    @Override
    public String getTipoCaratteristica() {
        return tipoCaratteristica;
    }
    /**
     * Assegna una stringa a tipoCaratteristica.
     */
    @Override
    public void setTipoCaratteristica(final String tipoCaratteristica) {
        this.tipoCaratteristica = tipoCaratteristica;
    }

    /**
     * Restituisce il dettaglio della caratteristica.
     * @return dettaglio della caratteristica
     */
    @Override
    public String getDettaglioCaratteristica() {
        return dettaglioCaratteristica;
    }
    /**
     * Assegna una stringa a dettaglioCaratteristica.
     */
    @Override
    public void setDettaglioCaratteristica(final String dettaglioCaratteristica) {
        this.dettaglioCaratteristica = dettaglioCaratteristica;
    }
}
