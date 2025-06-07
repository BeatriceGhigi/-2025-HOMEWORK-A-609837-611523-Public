package it.uniroma3.diadia.ambienti;





import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

    private Stanza stanzaCorrente;
    private Stanza stanzaVincente;

    // Costruttore privato
    public Labirinto() {}

    public void setStanzaCorrente(Stanza s) {
        this.stanzaCorrente = s;
    }

    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }

    public void setStanzaVincente(Stanza s) {
        this.stanzaVincente = s;
    }

    public Stanza getStanzaVincente() {
        return stanzaVincente;
    }

    // Factory method per ottenere il builder
    public static LabirintoBuilder newBuilder() {
        return new LabirintoBuilder();
    }

    // Classe statica nidificata pubblica
    public static class LabirintoBuilder {

        private Labirinto labirinto;
        private Stanza ultimaStanza;
        private Map<String, Stanza> nomeStanza;

        public LabirintoBuilder() {
            this.labirinto = new Labirinto();
            this.nomeStanza = new HashMap<>();
        }

        public Map<String, Stanza> getNomeStanza() {
            return nomeStanza;
        }

        public Labirinto getLabirinto() {
            return this.labirinto;
        }

        private void aggiornaStanza(Stanza s) {
            this.ultimaStanza = s;
            nomeStanza.put(s.getNome(), s);
        }

        public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
            Stanza stanza = new Stanza(stanzaIniziale);
            this.labirinto.setStanzaCorrente(stanza);
            aggiornaStanza(stanza);
            return this;
        }

        public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
            Stanza stanza = new Stanza(stanzaVincente);
            this.labirinto.setStanzaVincente(stanza);
            aggiornaStanza(stanza);
            return this;
        }

        public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
            if (ultimaStanza == null)
                return this;
            Attrezzo at = new Attrezzo(attrezzo, peso);
            ultimaStanza.addAttrezzo(at);
            return this;
        }

        public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
            Stanza sc = nomeStanza.get(stanzaCorrente);
            Stanza sa = nomeStanza.get(stanzaAdiacente);
            if (sc != null && sa != null)
                sc.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()), sa);
            return this;
        }

        public LabirintoBuilder addStanza(String stanza) {
            Stanza s = new Stanza(stanza);
            aggiornaStanza(s);
            return this;
        }

        public LabirintoBuilder addStanzaMagica(String stanza) {
            Stanza sm = new StanzaMagica(stanza);
            aggiornaStanza(sm);
            return this;
        }

        public LabirintoBuilder addStanzaBuia(String stanza, String attrezzo) {
            Stanza sb = new StanzaBuia(stanza, attrezzo);
            aggiornaStanza(sb);
            return this;
        }

        public LabirintoBuilder addStanzaBloccata(String stanza, String attrezzo, String direzione) {
            Stanza sb = new StanzaBloccata(stanza, attrezzo, Direzione.valueOf(direzione.toUpperCase()));
            aggiornaStanza(sb);
            return this;
        }

        public LabirintoBuilder addAttrezzo(String nomeStanza, String nome, int peso) {
            Attrezzo a = new Attrezzo(nome, peso);
            Stanza s = this.nomeStanza.get(nomeStanza);

            if (s != null)
                s.addAttrezzo(a);
            return this;
        }

        public LabirintoBuilder addMago(String nomeStanza, String nome, String presentazione, String attrezzoNome, int attrezzoPeso) {
            Stanza stanza = this.nomeStanza.get(nomeStanza);
            if (stanza != null) {
                AbstractPersonaggio mago = new Mago(nome, presentazione, new Attrezzo(attrezzoNome, attrezzoPeso));
                stanza.setPersonaggio(mago);
            }
            return this;
        }

        public LabirintoBuilder addStrega(String nomeStanza, String nome, String presentazione) {
            Stanza stanza = this.nomeStanza.get(nomeStanza);
            if (stanza != null) {
                AbstractPersonaggio strega = new Strega(nome, presentazione);
                stanza.setPersonaggio(strega);
            }
            return this;
        }

        public LabirintoBuilder addCane(String nomeStanza, String nome, String presentazione, String ciboPreferito, String attrezzoRegalato) {
            Stanza stanza = this.nomeStanza.get(nomeStanza);
            if (stanza != null) {
                AbstractPersonaggio cane = new Cane(nome, presentazione, ciboPreferito, attrezzoRegalato);
                stanza.setPersonaggio(cane);
            }
            return this;
        }
    }
}






	/**public Labirinto() {
		creaStanze();

	}


	private void creaStanze() {
		crea le stanze 
		Stanza atrio = new Stanza("Atrio");
		Stanza biblioteca= new Stanza("Biblioteca");
		Stanza aulaN11= new Stanza("Aula N11");
		Stanza aulaN10= new Stanza("Aula N10");
		Stanza laboratorio= new Stanza("Laboratorio");

		 crea gli attrezzi 
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		// il gioco comincia nell'atrio
		this.stanzaIniziale=atrio;
		this.stanzaFinale=biblioteca;

		 collega le stanze
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);


		 pone gli attrezzi nelle stanze 
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

	}*/

	





