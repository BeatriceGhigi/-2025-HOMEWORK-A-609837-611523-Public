package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
//import IOConsole.IOConsole;

public class ComandoVai implements Comando{
	
	private IO io;
	private String direzione;
	//private IOConsole io;
   private final static String NOME = "vai";
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.direzione == null) {
			this.io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		return;
			
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
}
    @Override
	public String getParametro() {
		return this.direzione;
	}
    
   @Override
    public  String getNome() {
   return NOME;       
    
  }

@Override
public void setIo(IO io) {
	 this.io=io;
	
}
   
  
  }
