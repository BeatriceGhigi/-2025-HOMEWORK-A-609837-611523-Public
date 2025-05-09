package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private IO io;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi", "posa", "guarda"};   
	private final static String NOME= "aiuto";
	
	@Override
	public String getNome() {
		return NOME;
	}

	@Override
    public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+ " ");      //LO FAREMO DOPO
		 io.mostraMessaggio(" ");
	}

      @Override
      public void setParametro(String parametro) {  //NON METTO NESSUN PARAMETRO
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