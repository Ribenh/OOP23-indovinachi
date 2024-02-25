package menu;

import searchbar.ListaDomande;

/**
 * Classe statica Domanda Pulsante.
 */
public final class DomandaPulsante {
    private static String tipoCaratteristica;
    private static String dettaglioCaratteristica;

    /**
     * Inizializza le variabili della classe DomandaPulsante con i seguenti parametri.
     * fonde le due stringhe e le aggiunge alla lista di domande
     * @param tipoCaratteristica il tipo della caratteristica a cui porre la domanda
     * @param dettaglioCaratteristica il dettaglio di caratteristica a cui porre la domanda
     */
    public static void creaDomanda(final String tipoCaratteristica, final String dettaglioCaratteristica) {
        DomandaPulsante.tipoCaratteristica = tipoCaratteristica;
        DomandaPulsante.dettaglioCaratteristica = dettaglioCaratteristica;
        ListaDomande.addDomandA(tipoCaratteristica + " " + dettaglioCaratteristica);
    }

    /**
     * Restituisce il tipo della caratteristica.
     * @return tipo della caratteristica
     */
    public static String getTipoCaratteristica() {
        return tipoCaratteristica;
    }

    /**
     * Assegna a tipoCaratteristica il valore passato come parametro.
     * @param tipoCaratteristica stringa
     */
    public static void setTipoCaratteristica(final String tipoCaratteristica) {
        DomandaPulsante.tipoCaratteristica = tipoCaratteristica;
    }

    /**
     * Restituisce il dettaglio della caratteristica.
     * @return dettaglio della caratteristica
     */
    public static String getDettaglioCaratteristica() {
        return dettaglioCaratteristica;
    }

    /**
     * Assegna a dettaglioCaratteristica il valore passato come parametro.
     * @param dettaglioCaratteristica stringa
     */
    public static void setDettaglioCaratteristica(final String dettaglioCaratteristica) {
        DomandaPulsante.dettaglioCaratteristica = dettaglioCaratteristica;
    }

    private DomandaPulsante() { 
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
