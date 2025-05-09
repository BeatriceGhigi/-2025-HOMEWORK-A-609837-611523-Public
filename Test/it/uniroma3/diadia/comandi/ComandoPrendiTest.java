package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

//import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPrendiTest {
 
	private Attrezzo attrezzo;   
    private Comando prendi;
    private Partita partita;
	private Stanza stanza;
	 
	@BeforeEach
	void setUp() throws Exception {
		 attrezzo= new Attrezzo("arco", 2);
		 partita=new Partita();
		 prendi= new ComandoPrendi();
		 stanza=new Stanza("atrio");
		
	}

	@Test
	void test__AttrezzoPreso_Rimosso() {
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		prendi.setParametro("arco");
		prendi.esegui(partita);
		assertEquals(attrezzo, partita.getGiocatore().getBorsa().getAttrezzo("arco"));
		assertNull( partita.getStanzaCorrente().getAttrezzo("arco"));
	}
	@Test
	void test_AttrezzoNonPreso_NonRimosso() {
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		prendi.setParametro("spada");
		prendi.esegui(partita);
		assertNotEquals(attrezzo, partita.getGiocatore().getBorsa().getAttrezzo("spada"));
		assertNotNull(partita.getStanzaCorrente().getAttrezzo("arco"));
	}
		
}
