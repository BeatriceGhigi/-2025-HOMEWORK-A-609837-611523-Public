package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private String torcia;

	public StanzaBuia(String nome, String torcia) {
		super(nome);
		this.torcia = torcia;
		
	}
 
	@Override
	public String getDescrizione() {
		String buio= new String();
		buio= "qui c'è buio pesto!";
		if(!this.hasAttrezzo(torcia)) 
			return buio;
			return super.getDescrizione();
		
	}
}
