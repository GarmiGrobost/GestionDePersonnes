package fr.diginamic.java17.gestiondepersonnes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.diginamic.java17.gestiondepersonnes.classes.Facteur;
import fr.diginamic.java17.gestiondepersonnes.classes.Personne;
import fr.diginamic.java17.gestiondepersonnes.enums.Genre;

public class AppStream02Reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Personne> lp = new ArrayList<>();
		lp.add(new Facteur("Fact01","Jean",Genre.MR,20));
		lp.add(new Facteur("Fact02","Martine",Genre.MME,50));
		lp.add(new Facteur("Fact03","Pauline",Genre.MELLE,30));
		lp.add(new Facteur("Fact04","Paul",Genre.MR,55));
		
		/*
		 * 1 Cumul de tous les âges de la liste de Personnes
		 * 2 Cumul des âges pour les Genre.MME de la liste de Personnes
		 * 3 Cumul des âges pour âges >= 50 da la liste de personnes
		 * 4 Nombre des âges pour âges >= 50 de la liste de personnes
		 * 5 Count des Genre.MR de la liste de Personne
		 */
		
		// 1 Cumul de tous les âges de la liste de Personnes
		int cumul = lp.stream()//Point de départ c'est le stream de ma liste
				.map(p->p.getAge())//Je cible sur quoi je vais travailler
				.reduce((ageCalcule,ageCourant)->ageCalcule+ageCourant)//Traitement attendu : je mets en place l'agrégat
				// de la formule de calcul attendu CUMUL
				.get();
		System.out.println(cumul);
		
		// 2 Cumul des âges pour les Genre.MME de la liste de Personnes
		int cumulMme = lp.stream()//Point de départ c'est le stream de ma liste
				.filter(p->p.getGenre()== Genre.MME)
				.map(p->p.getAge())//Je cible sur quoi je vais travailler
				.reduce((ageCalcule,ageCourant)->ageCalcule+ageCourant)//Traitement attendu : je mets en place l'agrégat
				// de la formule de calcul attendu CUMUL
				.get();
		System.out.println(cumulMme);
		
		// 3 Cumul des âges pour âges >= 50 da la liste de personnes
		int cumulPlusEq50 = lp.stream()//Point de départ c'est le stream de ma liste
				.map(p->p.getAge())//Je cible sur quoi je vais travailler
				.filter(age->age >= 50)//Filtre sur âge en direct de la map(..)
				.reduce((ageCalcule,ageCourant)->ageCalcule+ageCourant)//Traitement attendu : je mets en place l'agrégat
				// de la formule de calcul attendu CUMUL
				.get();
		System.out.println(cumulPlusEq50);
		
		// 4 Nombre des âges pour âges >= 50 de la liste de personnes
		long nombrePlusEq50 = lp.stream()//Point de départ c'est le stream de ma liste
				.filter(p->p.getAge() >= 50)//
				.count();
		System.out.println(nombrePlusEq50);
		
		//  5 Count des Genre.MR de la liste de Personne
		long nombreMr = lp.stream()//Point de départ c'est le stream de ma liste
				.filter(p->p.getGenre()== Genre.MR)//Ici j'ai un objet personne
				.count();
		System.out.println(nombreMr);
		
		long nombreMrCollect = lp.stream()//Point de départ c'est le stream de ma liste
				.filter(p->p.getGenre()== Genre.MR)//Ici j'ai un objet personne
				.collect(Collectors.counting());
		System.out.println(nombreMrCollect);
		
		double moyenneAgeCollect = lp.stream()//Point de départ c'est le stream de ma liste
				.collect(Collectors.averagingDouble(p->p.getAge()));
		System.out.println(moyenneAgeCollect);
	}

}
