import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {    //FUNZIONA

	
	private Labirinto labirinto;
	
	@BeforeEach
	void setUp() throws Exception {
		this.labirinto= new Labirinto();
		
	}

	@Test
	void test_getStanzaIniziale() {
	assertEquals("Atrio", labirinto.getStanzaIniziale().getNome()); //metti maiuscola
		
	}
	
	@Test
	void test_getStanzaFinale() {
	assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());	// metti maiuscola
	}
	

}
