package fr.diginamic.java17.gestiondepersonnes;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

import fr.diginamic.java17.gestiondepersonnes.classes.Facteur;
import fr.diginamic.java17.gestiondepersonnes.classes.Personne;
import fr.diginamic.java17.gestiondepersonnes.classes.PersonneServices;
import fr.diginamic.java17.gestiondepersonnes.enums.Genre;

public class AppStream03Reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Personne> lp = new ArrayList<>();
		lp.add(new Facteur("Fact01","Jean",Genre.MR,20));
		lp.add(new Facteur("Fact02","Martine",Genre.MME,50));
		lp.add(new Facteur("Fact03","Pauline",Genre.MELLE,30));
		lp.add(new Facteur("Fact04","Paul",Genre.MR,55));
		
		PersonneServices.calculSommeAge(lp).
		ifPresentOrElse(System.out::println, ()->System.err.println("Aucun calcul !"));
		
		PersonneServices.calculSommeAge(lp, PersonneServices::somme).
		ifPresentOrElse(System.out::println, ()->System.err.println("Aucun calcul !"));
		
		System.out.println(PersonneServices.calculMoyenneAge(lp, Personne::getAge));
		
		//Nombre des âges pour âge >= 50 de la liste de personne
		
		Predicate<Personne> pred50 = (p)->p.getAge()>=50;
		System.out.println(PersonneServices.getCumul(lp,pred50));
		
		
		//Nombre des Genre.MR de la liste de Personne
		
		Predicate<Personne>	predMr = p->p.getGenre()== Genre.MR;
		System.out.println(PersonneServices.getCumul(lp, predMr));
	}

}
