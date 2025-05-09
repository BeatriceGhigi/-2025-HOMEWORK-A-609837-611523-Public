package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	private final static String NOME= "fine";
	private IO io;
	
	public String getNome() {
		return NOME;
	}
    
	@Override
	public void esegui(Partita partita){
		partita.setFinita();
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	@Override
	public void setParametro(String parametro) {
		}

	

    @Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setIo(IO io) {
		 this.io=io;
		
	}
}
