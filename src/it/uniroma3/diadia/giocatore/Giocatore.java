package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {

	private int cfu;
	private Borsa borsa;
	
	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	public Giocatore() {
		this.borsa= new Borsa();	
		}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public boolean prendereAttrezzo(Attrezzo attrezzo) {
		return  this.borsa.addAttrezzo(attrezzo);

	}
	
	public Attrezzo posareAttrezzo(String  nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}
	
	
	
}
