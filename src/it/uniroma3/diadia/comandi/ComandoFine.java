package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

    private static final String NOME = "fine";
    public static final String MESSAGGIO_FINE = "Grazie di aver giocato!";
    private IO io;

    @Override
    public void esegui(Partita partita) {
        partita.setFinita();
        if (this.io != null) {
            this.io.mostraMessaggio(MESSAGGIO_FINE);
        }
    }

    @Override
    public void setIO(IO io) {
        this.io = io;
    }

    @Override
    public String getNome() {
        return NOME;
    }
}
