package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Model {

	private List<String> soluzione;
	
	public List<String> anagrammi (String parola) {
		this.soluzione=new ArrayList<String>();
		
		parola=parola.toUpperCase() ;
		List<Character> disponibili = new ArrayList<>() ;
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i)) ;
		}
		// avvia la ricorsione
		cerca("", 0, disponibili) ; 
		
		return this.soluzione ;
	}
	
	private void cerca(String parziale,int livello, List<Character> disponibili) {
		if(0==disponibili.size()) {
			// if(parziale è nel dizionario)
			// if( parziale non è presente nella soluzione )
			soluzione.add(parziale);
			
			}
		for(Character ch : disponibili) {
			String tentativo = parziale + ch;
//			if(nel dizionario esistono delle parole che iniziano con 'tentativo'?)
			List<Character> rimanenti = new ArrayList<>(disponibili) ;
			rimanenti.remove(ch) ;
			//System.out.println(tentativo) ;
			cerca( tentativo, livello+1, rimanenti) ;
		}
	}
}
