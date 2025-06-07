package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

import it.uniroma3.diadia.ambienti.Stanza;

public class ComparaPerNAttrezzi implements Comparator<Stanza>{
	
	@Override
	public int compare(Stanza stanza1, Stanza stanza2) {
		return stanza2.getAttrezzi().size() - stanza1.getAttrezzi().size();		//Ordine decrescente
	}
}