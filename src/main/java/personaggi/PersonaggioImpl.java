package personaggi;

import javax.swing.ImageIcon;

import java.util.Optional;

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

    public PersonaggioImpl() {
    }

    public PersonaggioImpl(String nome, ImageIcon immagine, Boolean hasCapelli, String coloreCapelli, String tipologiaCapelli, String lunghezzaCapelli, String coloreOcchi, Boolean barba, Boolean occhiali, Boolean accessorio, Boolean baffi, Boolean uomo) {
        this.nome = nome;
        this.immagine = immagine;
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

    public PersonaggioImpl(String nome, ImageIcon immagine, Boolean hasCapelli, String coloreOcchi, Boolean barba, Boolean occhiali, Boolean accessorio, Boolean baffi, Boolean uomo) {
        this.nome = nome;
        this.immagine = immagine;
        this.hasCapelli = hasCapelli;
        this.coloreCapelli = NOT;
        this.tipologiaCapelli = NOT;
        this.lunghezzaCapelli = NOT;
        this.coloreOcchi = coloreOcchi;
        this.barba = barba;
        this.occhiali = occhiali;
        this.accessorio = accessorio;
        this.baffi = baffi;
        this.uomo = uomo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public ImageIcon getImmagine() {
        return immagine;
    }

    @Override
    public void setImmagine(ImageIcon immagine) {
        this.immagine = immagine;
    }

    @Override
    public Boolean hasCapelli() {
        return hasCapelli;
    }

    @Override
    public void setHasCapelli(Boolean hasCapelli) {
        this.hasCapelli = hasCapelli;
    }

    @Override
    public String getColoreCapelli() {
        return coloreCapelli;
    }

    @Override
    public void setColoreCapelli(String coloreCapelli) {
        this.coloreCapelli = coloreCapelli;
    }

    @Override
    public String getTipologiaCapelli() {
        return tipologiaCapelli;
    }

    @Override
    public void setTipologiaCapelli(String tipologiaCapelli) {
        this.tipologiaCapelli = tipologiaCapelli;
    }

    @Override
    public String getLunghezzaCapelli() {
        return lunghezzaCapelli;
    }

    @Override
    public void setLunghezzaCapelli(String lunghezzaCapelli) {
        this.lunghezzaCapelli = lunghezzaCapelli;
    }

    @Override
    public String getColoreOcchi() {
        return coloreOcchi;
    }

    @Override
    public void setColoreOcchi(String coloreOcchi) {
        this.coloreOcchi = coloreOcchi;
    }

    @Override
    public Boolean getBarba() {
        return barba;
    }

    @Override
    public void setBarba(Boolean barba) {
        this.barba = barba;
    }

    @Override
    public Boolean hasOcchiali() {
        return occhiali;
    }

    @Override
    public void setOcchiali(Boolean occhiali) {
        this.occhiali = occhiali;
    }

    @Override
    public Boolean hasAccessori() {
        return accessorio;
    }

    @Override
    public void setAccessori(Boolean accessorio) {
        this.accessorio = accessorio;
    }

    @Override
    public Boolean hasBaffi() {
        return baffi;
    }

    @Override
    public void setBaffi(Boolean baffi) {
        this.baffi = baffi;
    }

    @Override
    public Boolean isUomo() {
        return uomo;
    }

    @Override
    public void setUomo(Boolean uomo) {
        this.uomo = uomo;
    }
}