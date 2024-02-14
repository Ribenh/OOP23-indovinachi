package serchbar;

import personaggi.PersonaggiCreati;
import personaggi.Personaggio;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class BarraRicerca implements InterfacciaBarraRicerca {
    

    @Override
    public Personaggio trovaPersonaggio(String nomePersonaggio) {
        List<Personaggio> personaggi = PersonaggiCreati.creaPersonaggi();
        int i = 0;
        while ((personaggi.get(i).getNome().equals(nomePersonaggio) == false) && (i < personaggi.size())) {
            i++;
        }
        return personaggi.get(i);
    }

    @Override
    public void messaggioRicerca(JFrame f, Boolean b) {
        if(b == true){
            JOptionPane.showMessageDialog(f, "HAI INDOVINATO");
            f.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(f, "HAI SBAGLIATO");
            f.dispose();
        }
    }

    @Override
    public Boolean cercaColoreCapelli(Personaggio p, String caratteristica) {
        return (p.getColoreCapelli().equals(caratteristica));
    }

    @Override
    public Boolean cercaTipoCapelli(Personaggio p, String caratteristica) {
        return (p.getTipologiaCapelli().equals(caratteristica));
    }

    @Override
    public Boolean cercaLunghezzaCapelli(Personaggio p, String caratteristica) {
        return (p.getLunghezzaCapelli().equals(caratteristica));
    }

    @Override
    public Boolean cercaColoreOcchi(Personaggio p, String caratteristica) {
        return (p.getColoreOcchi().equals(caratteristica));
    }
}
