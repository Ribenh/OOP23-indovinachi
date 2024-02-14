package serchbar;

import personaggi.Personaggio;

import javax.swing.JFrame;

public interface InterfacciaBarraRicerca {
    
    public Personaggio trovaPersonaggio(String nomePersonaggio);

    public Boolean cercaColoreCapelli(Personaggio p, String caratteristica);

    public Boolean cercaTipoCapelli(Personaggio p, String caratteristica);

    public Boolean cercaLunghezzaCapelli(Personaggio p, String caratteristica);

    public Boolean cercaColoreOcchi(Personaggio p, String caratteristica);

    public void messaggioRicerca(JFrame f, Boolean b);
}
