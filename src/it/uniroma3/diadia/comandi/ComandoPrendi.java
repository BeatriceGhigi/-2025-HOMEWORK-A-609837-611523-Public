package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	
	private IO io;
	private String nomeAttrezzo;
	private static final String NOME= "prendi";
	
	public String getNome() {
		return NOME;
	}

	public void esegui(Partita partita) {
		Stanza stanzaCorrente= partita.getStanzaCorrente();
        Attrezzo attrezzo= stanzaCorrente.getAttrezzo(nomeAttrezzo);
        if(attrezzo != null) {
        	partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        	stanzaCorrente.removeAttrezzo(attrezzo);
        	io.mostraMessaggio("Attrezzo selezionato:" + nomeAttrezzo);
        } else {
        	io.mostraMessaggio("Attrezzo non trovato!");
        }
	}
	
	
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	public String getParametro() {
		return nomeAttrezzo;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
}
