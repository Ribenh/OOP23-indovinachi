package personaggi;

import javax.swing.ImageIcon;
import java.util.Optional;

public interface Personaggio {

    String getNome();
    void setNome(String nome);

    ImageIcon getImmagine();
    void setImmagine(ImageIcon immagine);

    Boolean hasCapelli();
    void setHasCapelli(Boolean hasCapelli);

    String getColoreCapelli();
    void setColoreCapelli(String coloreCapelli);

    String getTipologiaCapelli();
    void setTipologiaCapelli(String tipologiaCapelli);

    String getLunghezzaCapelli();
    void setLunghezzaCapelli(String lunghezzaCapelli);

    String getColoreOcchi();
    void setColoreOcchi(String coloreOcchi);

    Boolean getBarba();
    void setBarba(Boolean barba);

    Boolean hasOcchiali();
    void setOcchiali(Boolean occhiali);

    Boolean hasAccessori();
    void setAccessori(Boolean accessorio);

    Boolean hasBaffi();
    void setBaffi(Boolean baffi);

    Boolean isUomo();
    void setUomo(Boolean uomo);
}