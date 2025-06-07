package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto; 
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private Labirinto labirinto; //riferimento lab.
	private Giocatore giocatore;  //riferimento gioc.
	private Stanza stanzaCorrente;
	private boolean finita;
	
	public Partita(Labirinto labirinto){
		this.labirinto= labirinto;
		this.stanzaCorrente= labirinto.getStanzaCorrente();
		this.finita = false;
		this.giocatore= new Giocatore();
		this.giocatore.setCfu(CFU_INIZIALI);
	}

		public Labirinto getLabirinto() {                           //MODIFICATO
		return labirinto;
	}
	
		public void setLabirinto(Labirinto labirinto) {
			this.labirinto = labirinto;
		}
		

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	 
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {  //MODIFICATO credo
		return this.getStanzaCorrente().equals(this.labirinto.getStanzaVincente());
		
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {   //MODIFICATO
		if( finita || vinta()  || (this.giocatore.getCfu()==0)) { //MODIFICATO
			setFinita();
		
		}
		return finita;
	}
	
	
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
		
	}
	

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public int getCfu() {
		return this.giocatore.getCfu();
	}

	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);		
	}	
	
}
