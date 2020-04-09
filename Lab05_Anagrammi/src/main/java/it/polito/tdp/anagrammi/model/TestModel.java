package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.*;

import it.polito.tdp.anagrammi.model.Model;

public class TestModel {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagrammaDAO prova = new AnagrammaDAO();
		Model model = new Model() ;
		Set<String> ana_dog = model.anagrammi("ciao") ;
		System.out.println(ana_dog) ;
		System.out.println(model.anagrammiErrati()) ;

	}

}
