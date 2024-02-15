package menu;
/**
 * interfaccia che definisce le operazioni di DomandaPulsante.
 */
public interface InterfacciaDomandaPulsante {

    /**
     * Getter della variabile tipoCaratteristica.
     * @return ritorna una stringa
     */
    String getTipoCaratteristica();
    /**
     * Setter della variabile tipoCaratteristica.
     * @param tipoCaratteristica
     */
    void setTipoCaratteristica(String tipoCaratteristica);

    /**
     * Getter della variabile dettaglioCaratteristica.
     * @return ritorna una stringa
     */
    String getDettaglioCaratteristica();
    /**
     * Setter della variabile dettaglioCaratteristica.
     * @param dettaglioCaratteristica
     */
    void setDettaglioCaratteristica(String dettaglioCaratteristica);

    /**
     * Inizializza le variabili della classe DomandaPulsante con i seguenti parametri.
     * @param tipoCaratteristica il tipo della caratteristica a cui porre la domanda
     * @param dettaglioCaratteristica il dettaglio di caratteristica a cui porre la domanda
     */
    void creaDomanda(String tipoCaratteristica, String dettaglioCaratteristica);
}
