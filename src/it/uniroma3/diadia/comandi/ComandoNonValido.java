package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	
	private static final String NOME="non valido ";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
	io.mostraMessaggio("comando non valido");
	}
	
   @Override
	public String getNome() {
		return NOME;
	}
	 
	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setParametro(String parametro) {
		}
	
	public ComandoNonValido() {
		super.setNome(NOME);
	}

}
