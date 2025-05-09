package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
    
	private StanzaBuia stanza;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
	stanza= new StanzaBuia("stanzaBuia", "lampadina");
	attrezzo= new Attrezzo("lampadina", 1);	
	}

	@Test
	void test_PossoIlluminare() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanza.toString(), stanza.getDescrizione());	
	}
	
	@Test
	void test_NonPossoIlluminare() {
		String buio="qui c'è buio pesto!";
		assertEquals(buio, stanza.getDescrizione());
	}
}