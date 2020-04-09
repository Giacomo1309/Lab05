package it.polito.tdp.anagrammi.model;

import java.util.List;
import it.polito.tdp.anagrammi.DAO.*;

import it.polito.tdp.anagrammi.model.Model;

public class TestModel {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagrammaDAO prova = new AnagrammaDAO();
		Model model = new Model() ;
		
		List<String> ana_dog = model.anagrammi("dog") ;
		System.out.println(ana_dog) ;
		System.out.println(prova.isCorrect(""));
		
	//	List<String> ana_vac = model.anagrammi("vacanze") ;
	//	System.out.println(ana_vac) ;

	//	List<String> ana_prg = model.anagrammi("programmazione") ;
	//	System.out.println(ana_prg) ;

	}

}
