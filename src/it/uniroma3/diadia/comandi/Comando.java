package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */
public interface Comando {  //NELLE INTERFACCE POSSONO ANDARE SOLO FUNZIONI PUBLIC... NIENTE PRIVATE, 
	//QUINDI NIENTE PARAMETRI

	//set parametro del comando
	public  void setParametro(String parametro);


	//esegui partita
	public void esegui(Partita partita);

	public void setIo(IO io);


	public String getNome();

	public String getParametro();

}












//	public String nome;
//  public String parametro;
// public String istruzione;

//public Comando(String istruzione) {
//Scanner scannerDiParole = new Scanner(istruzione);

// prima parola: nome del comando
//if (scannerDiParole.hasNext())
//this.nome = scannerDiParole.next(); 

// seconda parola: eventuale parametro
//if (scannerDiParole.hasNext())
//this.parametro = scannerDiParole.next();
//}

// public String getNome() {    
//  return this.nome;
//}

//public String getParametro() {
//  return this.parametro;
//}

//public boolean sconosciuto() {
//  return (this.nome == null);
//}


