package menu;

public interface InterfacciaDomandaPulsante {

    String getTipoCaratteristica();
    void setTipoCaratteristica(String tipoCaratteristica);

    String getDettaglioCaratteristica();
    void setDettaglioCaratteristica(String dettaglioCaratteristica);

    void creaDomanda(String tipoCaratteristica, String dettaglioCaratteristica);
}
