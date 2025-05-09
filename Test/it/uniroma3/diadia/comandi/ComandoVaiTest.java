package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


class ComandoVaiTest {

	private Stanza stanzaIniziale;
	private Stanza stanzaSud;
	private Partita partita;
	private Comando vai;
	
	
	@BeforeEach
	void setUp() throws Exception {
		stanzaIniziale= new Stanza("Atrio");	
		stanzaSud= new Stanza("aulaN10");
		partita=new Partita();
		vai= new ComandoVai();
	
	}

	@Test
	void test_direzioneEsistente() {
		partita.setStanzaCorrente(stanzaIniziale);
		stanzaIniziale.impostaStanzaAdiacente("sud", stanzaSud);
		 vai.setParametro("sud");
		 vai.esegui(partita);
		 assertEquals(stanzaSud, partita.getStanzaCorrente());
		
	}
	
	@Test
	void test_direzioneInesistente() {
		partita.setStanzaCorrente(stanzaIniziale);
		stanzaIniziale.impostaStanzaAdiacente("sud", stanzaSud);
		vai.setParametro("la prima a sinistra");
		vai.esegui(partita);
		assertNotEquals(stanzaSud, partita.getStanzaCorrente());
		
	}

	
}
