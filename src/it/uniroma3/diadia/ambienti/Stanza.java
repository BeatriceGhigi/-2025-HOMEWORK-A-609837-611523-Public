package it.uniroma3.diadia.ambienti;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	public static final int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	
    private Map<String, Attrezzo> attrezzi;
    private int numeroAttrezzi;
    private Map<Direzione, Stanza> stanzeAdiacenti;
    private AbstractPersonaggio personaggio;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroAttrezzi = 0;
		this.stanzeAdiacenti = new HashMap<>();		//la chiave è la direzione, il valore è l'oggetto Stanza
		this.attrezzi = new HashMap<>();
      
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
      
    	//controlla se la direzione non è gia presente e se non hai raggiunto il num max di direzioni
    			if(this.stanzeAdiacenti.containsKey(direzione) || this.stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI) {
    				//allora aggiorni la direzione nella mappa
    				this.stanzeAdiacenti.put(direzione, stanza);
    				//se non era presente viene aggiunta se no sovrascritta
    			}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param string
     */
	
	public Stanza getStanzaAdiacente( Direzione string) {
        Stanza stanza = null;
        	if (this.stanzeAdiacenti.containsKey(string)) {
        		stanza= this.stanzeAdiacenti.get(string);
		}
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Collection<Attrezzo> getAttrezzi() {
        return this.attrezzi.values();
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI ) {
        attrezzi.put(attrezzo.getNome(), attrezzo);
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (Direzione direzione : this.getDirezioni())
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.getAttrezzi()) {
    		risultato.append(attrezzo.toString()+" ");
    	}
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi.values()) {
			if (attrezzo !=null && attrezzo.getNome().equals(nomeAttrezzo))  //MODIFICATO
				trovato = true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato ;
		attrezzoCercato = null;
		if ( this.attrezzi.containsKey(nomeAttrezzo)) {
				attrezzoCercato = attrezzi.get(nomeAttrezzo);
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.containsKey(attrezzo.getNome())) {
			this.attrezzi.remove(attrezzo.getNome());
			return true;
			}
		
		return false;
	}

	public Set<Direzione> getDirezioni() {
		return this.stanzeAdiacenti.keySet();	//keySet restituisce un Set<String> di tutte le direzioni 
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}

	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}



	

}