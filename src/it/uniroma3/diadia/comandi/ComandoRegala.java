package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {
	
	private String nomeAttrezzo;
	private IO io;
	private final static String NOME= "regala";
	
	public String getNome() {
		return NOME;
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
	public void esegui(Partita partita) {
		Giocatore giocatore= partita.getGiocatore();
		Stanza stanza= partita.getStanzaCorrente();
		AbstractPersonaggio personaggio= stanza.getPersonaggio();
		
		
		if(personaggio==null) {
			io.mostraMessaggio("Nessun personaggio presente nella stanza!");	
			return;
		}
		
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("specifica il nome dell'oggetto da regalare: ");
			return;
		}
		
		
	Attrezzo at= giocatore.getBorsa().getAttrezzo(nomeAttrezzo);
	if (at == null) {
        this.getIO().mostraMessaggio("Attrezzo \"" + nomeAttrezzo + "\" non presente nella borsa.");
        return;
    }

    giocatore.getBorsa().removeAttrezzo(nomeAttrezzo);
    String messaggio = personaggio.riceviRegalo(at, partita);
    this.getIO().mostraMessaggio(messaggio);
}
		
		
}
