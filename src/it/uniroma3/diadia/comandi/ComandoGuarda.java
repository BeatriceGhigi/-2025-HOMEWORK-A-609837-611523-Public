package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


 
 public class ComandoGuarda extends AbstractComando {
	
	 
	 private IO io;
	 private static final String NOME= "guarda";
	
	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override
	public void esegui(Partita partita) {
		
		io.mostraMessaggio("Stanza:" + partita.getStanzaCorrente().getDescrizione() );
		io.mostraMessaggio("Cfu: "+ partita.getGiocatore().getCfu());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
	
	
	
	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setParametro(String parametro) {
		}
}
