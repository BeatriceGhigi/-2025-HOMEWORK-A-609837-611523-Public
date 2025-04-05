import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {   //FUNZIONA

	private Borsa borsa;
	private Attrezzo attrezzo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.borsa= new Borsa();
		this.attrezzo= new Attrezzo("attrezzo",10);
	}

	@Test
	void test_addAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(attrezzo));
	//	assertTrue(borsa.hasAttrezzo("attrezzo"));  
	}
	
	
	@Test
	void test_removeAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertNotNull(this.borsa.removeAttrezzo("attrezzo"));  //verifica che l'attrezzo sia stato rimosso correttamente
		assertNull(this.borsa.removeAttrezzo("attrezzo")); // verifica chel'atttrezzo non esista più nella borsa
	}
	
	@Test
	void test_isEmpty() {
		assertEquals(true,borsa.isEmpty());
		//borsa.addAttrezzo(attrezzo);
		//assertFalse(borsa.isEmpty());
	}
	
	@Test //bea
	void test_hasAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
//assertFalse(borsa.hasAttrezzo("spada"));
		
	}
	
	
}
