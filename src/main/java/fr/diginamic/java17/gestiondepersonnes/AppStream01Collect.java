package fr.diginamic.java17.gestiondepersonnes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.diginamic.java17.gestiondepersonnes.classes.Facteur;
import fr.diginamic.java17.gestiondepersonnes.classes.Personne;
import fr.diginamic.java17.gestiondepersonnes.enums.Genre;

public class AppStream01Collect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Personne> lp = new ArrayList<>();
		lp.add(new Facteur("Fact01","Jean",Genre.MR,0));
		lp.add(new Facteur("Fact02","Martine",Genre.MME,0));
		lp.add(new Facteur("Fact03","Pauline",Genre.MELLE,0));
		lp.add(new Facteur("Fact04","Paul",Genre.MR,0));
		
		/*
		 * 1 Récupérer la liste de noms des Facteurs
		 * 2 Récupérer les noms des Facteurs dans une chaîne (sans séparateur explicite)
		 * 3 Récupéere les noms des facteurs dans une chaîne (avec un séparateur)
		 */
		
		//1
		
		/*
		 * 
		 */
		List<String> lnoms = lp.stream().map(p->p.getNom()).collect(Collectors.toList());
		
		/*
		 * 
		 */
		lnoms.forEach(System.out::println);
		
		// 2 Récupérer les noms des Facteurs dans une chaîne (sans séparateur explicite)
		
		String nomsDesPersonnes = lp.stream().map(p->p.getNom()).collect(Collectors.joining());
		System.out.println(nomsDesPersonnes);
		
		// 3 Récupéere les noms des facteurs dans une chaîne (avec un séparateur)
		String nomsDesPersonnesSep = lp.stream().map(p->p.getNom()).collect(Collectors.joining(";"));
		System.out.println(nomsDesPersonnesSep);
		
	}

}
