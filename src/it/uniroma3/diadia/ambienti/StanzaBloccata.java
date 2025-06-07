package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

private String ariete;
private Direzione dir;
	
	public StanzaBloccata(String nome, String ariete, Direzione dir) {
		super(nome);
		this.dir= dir;
		this.ariete=ariete;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(dir.equals(direzione) && !this.hasAttrezzo(ariete)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
		}
	
	@Override
	public String  getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ dir+"\nPrendi la " + ariete + " e posalo nella stanza";

		if(!this.hasAttrezzo(ariete))
			return bloccata;
		return super.getDescrizione();
	}
}
