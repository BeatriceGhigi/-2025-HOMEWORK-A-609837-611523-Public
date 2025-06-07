/*package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;


import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class LabirintoBuilder {

	private Labirinto labirinto;
	private Stanza ultimaStanza;
	private Map<String, Stanza> nomeStanza;

	LabirintoBuilder() {
		this.labirinto =  new Labirinto();  //creo il nuovo labirinto
		this.nomeStanza= new HashMap<String, Stanza>();   // mi permette di recuperare una stanza conoscendone il nome;

	}

	public Map<String, Stanza> getNomeStanza(){  //mi ritorna il valore associato alla chiave (String)
		return nomeStanza;
	}


	public Labirinto getLabirinto() {  //ritorna il labirinto appena creato.
		return this.labirinto;
	}


	public void aggiornaStanza(Stanza s) {  //costruttore che mi permette di aggiornare il labirinto
		this.ultimaStanza=s;
		nomeStanza.put(s.getNome(), s);
	}

	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza stanza= new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(stanza);
		//ultimaStanza= stanza;                         // voledo si potevano scrivere per ogni funz.
		//nomeStanza.put(stanza.getNome(), stanza);
		this.aggiornaStanza(stanza);
		return this;
	}


	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza stanza= new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(stanza);
		//ultimaStanza= stanza;
		//nomeStanza.put(stanza.getNome(), stanza);
		this.aggiornaStanza(stanza);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo at= new Attrezzo(attrezzo, peso);
		if(ultimaStanza==null) {
			return this;
		}	
		this.ultimaStanza.addAttrezzo(at);
		return this;
	}

	
	public LabirintoBuilder addAdiacenza(String stanzaCorrente,String stanzaAdiacente, String direzione) {
		Stanza sc= this.nomeStanza.get(stanzaCorrente);
		Stanza sa= this.nomeStanza.get(stanzaAdiacente);
		sc.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()),sa);
		return this;
	}

   public LabirintoBuilder addStanza(String stanza) {
	   Stanza s= new Stanza(stanza);
	  this. aggiornaStanza(s);
	   return this;
   }
   
   
   public LabirintoBuilder addStanzaMagica(String stanza) { //il tizio mette solo stanza come parametro, però boh
	   Stanza sm= new StanzaMagica(stanza);
	   this.aggiornaStanza(sm);
	   return this;
   }
   
   
   public LabirintoBuilder addStanzaBuia(String stanza, String attrezzo) {
	   Stanza sb= new StanzaBuia(stanza, attrezzo);
	   this.aggiornaStanza(sb);
	   return this;
   }
   
   public LabirintoBuilder addStanzaBloccata(String stanza, String attrezzo, String direzione) {
	   Stanza sb= new StanzaBloccata(stanza , attrezzo, Direzione.valueOf(direzione.toUpperCase()));
	   this.aggiornaStanza(sb);
	   return this;
   }
   
   public LabirintoBuilder addAttrezzo(String nomeStanza, String nome, int peso) {
		Attrezzo a= new Attrezzo(nome, peso);
		this.nomeStanza.get(nomeStanza).addAttrezzo(a);
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


}*/
