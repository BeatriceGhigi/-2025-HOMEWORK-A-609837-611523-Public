package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparaPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;  
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;


	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}


	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
		this.numeroAttrezzi = 0;
		this.pesoAttuale=0;
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		this.pesoAttuale+=attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		//for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi.containsKey(nomeAttrezzo)) { //containsKey mi controlla se è presente un elemento
		a = attrezzi.get(nomeAttrezzo);
			}
		return a;
	}

	public int getPeso() {
		return this.pesoAttuale;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	} 

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo!=null) {
			a=this.attrezzi.remove(nomeAttrezzo); //salvo l'attrezzo da rimuovere
		}

		return a;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerPeso().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> lista= new  TreeSet<Attrezzo> (new ComparaPerPeso());
		lista.addAll(this.attrezzi.values());
		return lista;
	}	 

	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> ordinatoPerNome= new TreeSet<>(Comparator.comparing(Attrezzo::getNome));
		ordinatoPerNome.addAll(this.attrezzi.values());		
		return ordinatoPerNome;
	}

	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaAttrezzi= new ArrayList<>();
		listaAttrezzi.addAll(this.attrezzi.values());
		
		Collections.sort(listaAttrezzi, new ComparaPerPeso());
		return listaAttrezzi;
	}

	
	Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<>();
		
		for(Attrezzo attrezzo : this.attrezzi.values()) {
			int peso= attrezzo.getPeso();
			
			if(!mappa.containsKey(peso)) {
				
				mappa.put(peso, new HashSet<>());
			}
			
			mappa.get(peso).add(attrezzo);
			
		}
		return mappa;
	}

}
