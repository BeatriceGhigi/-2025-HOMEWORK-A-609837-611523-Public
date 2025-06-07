package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AbstractComandoTest { 
	
	private static class ComandoDiTest extends AbstractComando{  //classe concreta
		  @Override
	        public void esegui(it.uniroma3.diadia.Partita partita) {}
	        @Override
	        public String getNome() { return "test"; }
	        @Override
	        public String getParametro() { return null; }
	        @Override
	        public void setIO(it.uniroma3.diadia.IO io) {}
	}
	

	@Test
	void test_setParametro() {
		ComandoDiTest cmd = new ComandoDiTest();
        assertDoesNotThrow(() -> cmd.setParametro("qualsiasiParametro"));
	}

}   //quando faccio un test di una classe astratta devo sempre prima creare una classe concreta di prova
