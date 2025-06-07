package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	
	private IO io;
	private String nomeAttrezzo;
	private static final String NOME= "posa";
	
	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override	
	public void esegui(Partita partita) {
		Attrezzo attrezzo= partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
    	if(attrezzo!=null) {
    		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
       partita.getStanzaCorrente().addAttrezzo(attrezzo);
                 io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " posato nella stanza.");
    	    } else {
    	        io.mostraMessaggio("L'attrezzo non è nella borsa.");
    	    }
	}

	@Override
	public void setParametro(String parametro) {
      this.nomeAttrezzo=parametro;
	
	}
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
		}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	}