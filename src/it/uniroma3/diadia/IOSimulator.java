package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

    private List<String> righeLette;
    private int indiceRigheLette;

    private List<String> messaggiProdotti;
    private int indiceMessaggiProdotti;

    public IOSimulator(List<String> righeDaLeggere) {
        this.righeLette = righeDaLeggere;
        this.messaggiProdotti = new ArrayList<>();
        this.indiceRigheLette = 0;
        this.indiceMessaggiProdotti = 0;
    }

    @Override
    public void mostraMessaggio(String msg) {
        this.messaggiProdotti.add(msg);
    }

    @Override
    public String leggiRiga() {
        String riga = this.righeLette.get(indiceRigheLette);
        this.indiceRigheLette++;
        return riga;
    }

    public boolean hasNextMessaggio() {
        return this.indiceMessaggiProdotti < this.messaggiProdotti.size();
    }

    public String nextMessaggio() {
        if (this.hasNextMessaggio()) {
            String messaggio = this.messaggiProdotti.get(indiceMessaggiProdotti);
            this.indiceMessaggiProdotti++;
            return messaggio;
        }
        return null;
    }

    public List<String> getMessaggiProdotti() {
        return messaggiProdotti;
    }

    public void setMessaggiProdotti(List<String> messaggiProdotti) {
        this.messaggiProdotti = messaggiProdotti;
    }
}
