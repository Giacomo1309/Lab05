package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private Set<String> soluzione;
	private Set<String> soluzioniErrate;
	private AnagrammaDAO dao = new AnagrammaDAO();

	public Set<String> anagrammi(String parola) {
		this.soluzione = new HashSet<String>();
		this.soluzioniErrate = new HashSet<String>();
		parola = parola.toLowerCase();
		List<Character> disponibili = new ArrayList<>();
		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		// avvia la ricorsione
		cerca("", 0, disponibili);

		return this.soluzione;
	}

	public Set<String> anagrammiErrati() {
		return this.soluzioniErrate;
	}

	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if (0 == disponibili.size()) {
			// if(parziale è nel dizionario)
			// if( parziale non è presente nella soluzione )
			if (soluzione.contains(parziale) == false && dao.isCorrect(parziale)) {
				soluzione.add(parziale);
			} else if (soluzioniErrate.contains(parziale) == false && dao.isCorrect(parziale) == false) {
				soluzioniErrate.add(parziale);
			}
		}
		for (Character ch : disponibili) {
			String tentativo = parziale + ch;
//			if(nel dizionario esistono delle parole che iniziano con 'tentativo'?)
			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			// System.out.println(tentativo) ;
			cerca(tentativo, livello + 1, rimanenti);
		}
	}
}
