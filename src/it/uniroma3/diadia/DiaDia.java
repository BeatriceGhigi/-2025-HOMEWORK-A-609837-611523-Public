package it.uniroma3.diadia;

 

import it.uniroma3.diadia.attrezzi.Attrezzo;
import IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi", "posa"};   //MODIFICATO

	private Partita partita;
	private IOConsole io;		//PER INPUT E OUTPUT

	public DiaDia() {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
	
		do		
			istruzione= io.leggiRiga();
		while (!processaIstruzione(istruzione));
		
		
	}   

	

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if(comandoDaEseguire.getNome()==null) return false;
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		}else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		}else if (comandoDaEseguire.getNome().equals("prendi")) { //AGGIUNTO
			this.prendi(comandoDaEseguire.getParametro());      //AGGIUTNO
		}else if(comandoDaEseguire.getNome().equals("posa")) { //AGGIUNTO
				this.posa(comandoDaEseguire.getParametro()); //AGGIUNTO
		}else 
			{ io.mostraMessaggio("comando sconosciuto");
			}
		if(this.partita.isFinita()) {
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
		}
			return true;
		} 
			return false;
	}   

	// implementazioni dei comandi dell'utente:
     
	/** Prendi e posa un attrezzo**/
	
        private void prendi(String nomeAttrezzo) {  //AGGIUNTO
  	
        Stanza stanzaCorrente= this.partita.getStanzaCorrente();
        Attrezzo attrezzo= stanzaCorrente.getAttrezzo(nomeAttrezzo);
        if(attrezzo != null) {
        	this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        	stanzaCorrente.removeAttrezzo(attrezzo);
        	io.mostraMessaggio("Attrezzo selezionato:" + nomeAttrezzo);
        } else {
        	io.mostraMessaggio("Attrezzo non trovato!");
        }
        }
	
        private void posa(String nomeAttrezzo) { //AGGIUNTO
        	
        	Attrezzo attrezzo= this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        	if(attrezzo!=null) {
        		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
             this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
                io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " posato nella stanza.");
        	    } else {
        	        io.mostraMessaggio("L'attrezzo non è nella borsa.");
        	    }
        	
        }
        
        
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+ " ");
		io.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
      
		if(direzione==null) {
			io.mostraMessaggio(direzione);	
			return;
			}
			Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null) {
				io.mostraMessaggio("Direzione inesistente"); }
			else {
				this.partita.setStanzaCorrente(prossimaStanza);
				int cfu = this.partita.getGiocatore().getCfu();   //MODIFICATO
				this.partita.getGiocatore().setCfu(--cfu);        //MODIFICATO (--Cfu)
				
			}
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());

			
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
		}
}