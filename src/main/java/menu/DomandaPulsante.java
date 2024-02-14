package menu;

public class DomandaPulsante implements InterfacciaDomandaPulsante {
    private String tipoCaratteristica;
    private String dettaglioCaratteristica;
    
    @Override
    public void creaDomanda(String tipoCaratteristica, String dettaglioCaratteristica){
        this.tipoCaratteristica = tipoCaratteristica;
        this.dettaglioCaratteristica = dettaglioCaratteristica;
    }

    @Override
    public String getTipoCaratteristica() {
        return tipoCaratteristica;
    }
    @Override
    public void setTipoCaratteristica(String tipoCaratteristica) {
        this.tipoCaratteristica = tipoCaratteristica;
    }

    @Override
    public String getDettaglioCaratteristica() {
        return dettaglioCaratteristica;
    }
    @Override
    public void setDettaglioCaratteristica(String dettaglioCaratteristica) {
        this.dettaglioCaratteristica = dettaglioCaratteristica;
    }
}
