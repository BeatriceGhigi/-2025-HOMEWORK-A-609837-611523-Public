package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;


class LabirintoBuilderTest {

	LabirintoBuilder l;



	@BeforeEach
	void setUp() throws Exception {
		l = new LabirintoBuilder();
	}


	@Test
	public void testGetLabirinto() {
		assertNotNull(l.getLabirinto());
		assertEquals(Labirinto.class, l.getLabirinto().getClass());
	}

	@Test
	void test_addStanza() {
		l.addStanza("bagno");	
		Stanza stanza = l.getNomeStanza().get("bagno");
		assertEquals("bagno", stanza.getNome());	
	}
	
	@Test
	void test_addStanzaConAttrezzoAggiornata() {
		l.addStanza("n11").addAttrezzo("osso", 3);
		l.addAttrezzo("osso", 3);
		assertTrue(l.getNomeStanza().get("n11").hasAttrezzo("osso"));
		
	}
	
	
	@Test
	void test_addAttrezzo() {
		//l.addAttrezzo("spada", 2);
		//Attrezzo a= new Attrezzo("spada", 2);
		assertEquals(LabirintoBuilder.class, l.addAttrezzo("cacciavite", 3).getClass());
	}
	
	@Test
    public void testAddAttrezzoConStanza() {
        l.addStanza("stanzetta");
        l.addAttrezzo("cacciavite", 3);
        assertTrue(l.getNomeStanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }




}
