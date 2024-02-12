package menu;

public class domandaPulsante implements InterfacciaDomandaPulsante {

    public static String domanda;

    public void creaDomanda(String nomeCaratteristica, String dettaglioCaratteristica) {
        domanda = nomeCaratteristica.toLowerCase() + " " + dettaglioCaratteristica.toLowerCase();
    }
    
}
