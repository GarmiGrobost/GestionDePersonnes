package fr.diginamic.java17.gestiondepersonnes.classes;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class PersonneServices {

		public static Optional<Personne> findByNamePersonne(List<Personne> lp, String nom){
			for(Personne p : lp) {
				if(p.getNom().equalsIgnoreCase(nom)){
					return Optional.of(p);
				}
			}
			return Optional.empty();
		}
		
		/*
		 * .reduce((ageCalcule,ageCourant)->ageCalcule+ageCourant)
		 */
		public static Integer somme(Integer cumul, Integer valeurEnCours) {
			return cumul + valeurEnCours;
		}
		
		/*
		 * Service pour récupérer la somme par exemple à partir
		 * d'un stream d'une liste de type Personnes
		 * 
		 * lp.stream() //Point de départ c'est le stream de ma liste
		 * .map(???)//je cible sur quoi je vais travailler
		 * .reduce(???)
		 */
		
		public static Optional<Integer> calculSomme(List<Personne> maListeDePersonnes){
			return maListeDePersonnes.stream()
			.map(Personne::getAge)
			.reduce(PersonneServices::somme);
			//return Optional.empty();
		}

		//Ecrire une méthode retournant la moyenne des âges
		
		public static Optional<Integer> calculSommeAge(List<Personne> maListeDePersonnes){
			return maListeDePersonnes.stream()
			.map(Personne::getAge)
			.reduce(PersonneServices::somme);
			//return Optional.empty();
		}
		
		public static Optional<Integer> calculSommeAge(List<Personne> maListeDePersonnes, BinaryOperator<Integer>bo) {
			return maListeDePersonnes.stream()
					.map(Personne::getAge)
					.reduce(bo);
					//return Optional.empty();
		}
		
		// Ecrire une méthode retournant la moyenne des âges
		
		public static Double calculMoyenneAge(List<Personne> maListeDePersonnes, ToDoubleFunction<? super Personne> op) {
			return maListeDePersonnes.stream().collect(Collectors.averagingDouble(op));
		}
		
		//Nombre des âges pour âge >= 50 de la liste de personne
		//Nombre des Genre.MR de la liste de Personne
		
		public static Long getCumul(List<Personne> maListeDePersonnes,Predicate<? super Personne> monFiltre) {
			return maListeDePersonnes.stream()
					.filter(monFiltre)
					.collect(Collectors.counting());
		}
		
}
