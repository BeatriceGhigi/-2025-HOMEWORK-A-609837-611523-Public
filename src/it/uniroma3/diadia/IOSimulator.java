package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] righeLette;
	private int indiceRigheLette;
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	//private int indiceMessaggiMostrati;
	
	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}
	
	public void setMessaggiProdotti(String[] messaggiProdotti) {
         this.messaggiProdotti= messaggiProdotti;
	}
	
	
	public IOSimulator(String[] righeDaLeggere) {
		this.righeLette= righeDaLeggere;
		//this.indiceMessaggiMostrati=0;
		this.messaggiProdotti=new String[40*20];
		this.indiceRigheLette=0;
	}
	
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti[indiceMessaggiProdotti]=msg;
		this.indiceMessaggiProdotti++;
		
	}
	
  @Override
	public String leggiRiga() {
		String riga= null;
		
		riga= this.righeLette[indiceRigheLette];
		this.indiceMessaggiProdotti++;
		return riga;
	}
  
  
		
	
}
