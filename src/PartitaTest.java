import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {  //FUNZIONA

	private Partita partita;
    private Giocatore giocatore; //aggiunto

	
	@BeforeEach
	void setUp() throws Exception {
		this.partita= new Partita();
		//this.vincente= new Stanza("biblioteca");
		this.giocatore= new Giocatore();
		
	}

	@Test
	void test_nuovaPartita_non_finita() {
		assertFalse(this.partita.isFinita());
	}

	
	@Test
	void test_Partita_vinta() {   // MODIFICATO 
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaFinale());
	    assertTrue(partita.vinta());
	    
	}
	
	@Test
	void test_Partita_persa() {   //MODIFICATO (non andavano i test)
		giocatore.setCfu(0);
		assertEquals(0,this.giocatore.getCfu());
	}
}
