package menu;

import java.util.Locale;

public final class DomandaPulsante implements InterfacciaDomandaPulsante {

    @Override
    public String creaDomanda(final String nomeCaratteristica, final String dettaglioCaratteristica) {
        return  nomeCaratteristica.toLowerCase(Locale.ENGLISH) + " " + dettaglioCaratteristica.toLowerCase(Locale.ENGLISH);
    }
    
}
