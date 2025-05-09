package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata stanza;
	private Attrezzo attrezzo;
	private Stanza st;
	
	@BeforeEach
	void setUp() throws Exception {
		stanza= new StanzaBloccata("StanzaBloccata", "chiave", "sud");
		attrezzo= new Attrezzo("chiave",1);
		st=new Stanza("patio");	
		
		stanza.impostaStanzaAdiacente("sud", st);
	}
	
	
	@Test
	void test_StanzaAdiacenteBloccata() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(attrezzo, stanza.getAttrezzo("chiave"));
		}
	
	@Test
	void test_StanzaAdiecenteAperta(){
		stanza.addAttrezzo(attrezzo);
		assertNotEquals(attrezzo, stanza.getAttrezzo("martello"));
	}
	
	@Test
	void test_getDescrzioneBloccata() {
		String bloccata= "Stanza bloccata nella direzione: sud"+"\nPrendi la chiave e posalo nella stanza";
		assertEquals(bloccata, stanza.getDescrizione())	;	
	}
	
	@Test
	void test_getDescrzioneAperta() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	

}
