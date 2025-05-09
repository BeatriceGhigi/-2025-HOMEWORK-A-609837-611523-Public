package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class SimulatorTest {

	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		stanza= new Stanza("atrio");
		attrezzo= new Attrezzo("osso", 1);
	}

	@Test
	public void testRaccoltaAttrezzoEUscita() {
		stanza.addAttrezzo(attrezzo);
		
		IOSimulator io=TestHelper.creaSimulazionePartitaEGioca(
				"vai nord",
				"prendi osso",
				"posa osso",
				"fine"
				);
		
		String[] messaggi=io.getMessaggiProdotti();
		
		boolean messaggioRaccolta=false;
		for(String msg : messaggi) {
			if(msg.contains("Hai preso:"+ stanza.getAttrezzo("osso"))){
			messaggioRaccolta=true;
			break;
				
			}
		}
		
		assertTrue(messaggioRaccolta);
	}

}
