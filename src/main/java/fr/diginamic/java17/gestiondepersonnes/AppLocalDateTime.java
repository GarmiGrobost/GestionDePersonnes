package fr.diginamic.java17.gestiondepersonnes;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AppLocalDateTime {

	public static void main(String[] args) {
		
		System.out.println(ZonedDateTime.now());
		
		//System.out.println(ZonedDateTime.now(ZoneId.of("America/Indiana/IndianaPolis")));
		
		//Parser une date au format iso
		//LocalDate result = LocalDate.parse("2017-02-24");
		//Parser une date au format non ISO
		
		LocalDate result = LocalDate.parse("24/02/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(result);
		
		//Afficher une date au format BASIC-ISO (chaine="20170227")
		
		System.out.println(result.format(DateTimeFormatter.BASIC_ISO_DATE));
		
		//Afficher une date au format ISO (chaine="2017-02-27")
		
		System.out.println(result.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		//Afficher une date au format personnalisé (chaine="2017-02-27")
		
		System.out.println(result.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		Period period = Period.between(
				LocalDate.parse("20/06/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
				LocalDate.parse("27/06/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(period.getDays());
	}
}
