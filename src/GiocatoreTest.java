import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {   //FUNZIONA
	private Giocatore giocatore;
   	private Attrezzo attrezzo;
    
    
   	
	@BeforeEach
	void setUp() throws Exception {
		this.giocatore= new Giocatore();
		this.attrezzo= new Attrezzo("attrezzo", 10);
	}
	
	@Test
	void test_prendere_attrezzo() {
   assertTrue(this.giocatore.prendereAttrezzo(this.attrezzo));
	
	}
	
	@Test
	void test_posare_attrezzo() {
	this.giocatore.prendereAttrezzo(this.attrezzo);
	assertTrue(this.giocatore.posareAttrezzo("attrezzo")!=null);
	assertFalse(this.giocatore.getBorsa().hasAttrezzo("attrezzo"));
	
	}
	
	@Test
	void test_setGetCfu() {
		giocatore.setCfu(10);
		assertEquals(10, giocatore.getCfu());
	}
	
}
