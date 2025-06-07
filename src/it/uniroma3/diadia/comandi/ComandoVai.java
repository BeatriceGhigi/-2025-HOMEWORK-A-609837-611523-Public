package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
//import IOConsole.IOConsole;

public class ComandoVai extends AbstractComando{
	
	private IO io;
	private Direzione direzione;
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

		Direzione direzione;
		
		try {
			direzione = Direzione.valueOf(super.getParametro().toUpperCase());
		} catch (IllegalArgumentException e) {
			//caso in cui viene specificata una direzione non contemplata dall'enum Direzione
			super.getIO().mostraMessaggio("Direzione inesistente");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			super.getIO().mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		super.getIO().mostraMessaggio(partita.getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}
	
	
    
   @Override
    public  String getNome() {
   return NOME;       
    
  
  }


   @Override
	public void setIO(IO io) {
		this.io = io;
	}
   
  
  }
