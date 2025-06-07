package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;



public class ComparaPerPeso implements Comparator<Attrezzo> {
	
	public int compare(Attrezzo osso, Attrezzo spada) {
		if(osso.getPeso()-spada.getPeso()==0) {
		return osso.getNome().compareTo(spada.getNome());
	}
			return osso.getPeso()-(spada.getPeso());
		
	}

	
}
