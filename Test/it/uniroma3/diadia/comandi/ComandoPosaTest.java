package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {

	private Stanza stanza;
	private Partita partita;
	private Comando posa;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		stanza= new Stanza("atrio");
		partita= new Partita();
		attrezzo= new Attrezzo("arco", 2);
		posa= new ComandoPosa();	
		
	
	}

	@Test
	void test_AttrezzoPosato_Rimosso() {
	partita.setStanzaCorrente(stanza);
	partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	posa.setParametro("arco");
	posa.esegui(partita);
	assertEquals( attrezzo, partita.getStanzaCorrente().getAttrezzo("arco"));
	assertNull(partita.getGiocatore().getBorsa().getAttrezzo("arco"));
	}

	
	@Test
	void test_AttrezzoNonPosato_NonRimosso() {
	partita.setStanzaCorrente(stanza);
	partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	posa.setParametro("spada");
	posa.esegui(partita);
	assertNotEquals( attrezzo, partita.getStanzaCorrente().getAttrezzo("spada"));
	assertNotNull(partita.getGiocatore().getBorsa().getAttrezzo("arco"));	
		
		
	}

}
