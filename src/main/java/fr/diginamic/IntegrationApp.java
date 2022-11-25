/**
 * IntegrationApp.java
 */
package fr.diginamic;

import java.util.List;

import fr.diginamic.entity.Athlete;
import fr.diginamic.entity.BanniereOlympique;
import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.Sport;
import fr.diginamic.entity.TraductionEpreuve;
import fr.diginamic.entity.TraductionSport;
import fr.diginamic.manager.AthleteManager;
import fr.diginamic.manager.BanniereOlympiqueManager;
import fr.diginamic.manager.EpreuveManager;
import fr.diginamic.manager.SportManager;
import fr.diginamic.manager.TraductionEpreuveManager;
import fr.diginamic.manager.TraductionSportManager;
import fr.diginamic.reader.ReaderAthlete;
import fr.diginamic.reader.ReaderEpreuve;
import fr.diginamic.reader.ReaderPays;
import fr.diginamic.reader.ReaderSport;
import fr.diginamic.reader.ReaderTraductionEpreuve;
import fr.diginamic.reader.ReaderTraductionSport;

/**
 * @author CaroleTOULORGE
 *
 */
public class IntegrationApp {

	/**
	 * Point d'entrée
	 * 
	 * @param args non utilisés ici
	 */
	public static void main(String[] args) {

		// Lecture du fichier des épreuves
		ReaderEpreuve readerEpreuve = new ReaderEpreuve();
		List<Epreuve> epreuves = null;
		
		// Lecture du fichier des traductions épreuves
		ReaderTraductionEpreuve readerTraductionEpreuve = new ReaderTraductionEpreuve();
		List<TraductionEpreuve> traductionEpreuves = null;
		
		
		// Lecture du fichier listes des sports
		ReaderSport readerSport = new ReaderSport();
		List<Sport> sports = null;
		
		// Lecture du fichier des traductions sports
		ReaderTraductionSport readerTraductionSport = new ReaderTraductionSport();
		List<TraductionSport> traductionSports = null;
		
		// Lecture du fichier des pays
		ReaderPays readerPays = new ReaderPays();
		List<BanniereOlympique> pays = null;
		
		// Lecture du fichier des Athlete
		ReaderAthlete readerAthlete = new ReaderAthlete();
		List<Athlete> athletes = null;
		
		try {
			epreuves = readerEpreuve.getEpreuves(readerEpreuve.getClass().getClassLoader().getResourceAsStream("liste_des_epreuves.csv"));
			traductionEpreuves = readerTraductionEpreuve.getTraductionEpreuves(readerTraductionEpreuve.getClass().getClassLoader().getResourceAsStream("liste_des_epreuves.csv"));
			sports = readerSport.getSports(readerSport.getClass().getClassLoader().getResourceAsStream("liste des sports.csv"));
			traductionSports = readerTraductionSport.getTraductionSports(readerTraductionSport.getClass().getClassLoader().getResourceAsStream("liste des sports.csv"));
			pays = readerPays.getPays(readerPays.getClass().getClassLoader().getResourceAsStream("wikipedia-iso-country-codes.csv"));
			athletes = readerAthlete.getAthletes(readerAthlete.getClass().getClassLoader().getResourceAsStream("athlete_epreuves.csv"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(traductionEpreuves);
		
		EpreuveManager epreuveManager = new EpreuveManager();
		TraductionEpreuveManager traductionEpreuveManager = new TraductionEpreuveManager();
		
		SportManager sportManager = new SportManager();
		TraductionSportManager traductionSportManager = new TraductionSportManager();
		
		BanniereOlympiqueManager banniereOlympiqueManager = new BanniereOlympiqueManager();
		
		AthleteManager athleteManager = new AthleteManager();
		
//		// Lecture du fichier epreuve
//		for (int i = 1; i < epreuves.size(); i++) {
//			epreuveManager.traiteEpreuve(epreuves.get(i));
//			traductionEpreuveManager.traiteTraductionEpreuve(traductionEpreuves.get(i));
//		}
//		// Lecture du fichier sport
//		for (int i = 1; i < sports.size(); i++) {
//			sportManager.traiteSport(sports.get(i));
//			traductionSportManager.traiteTraductionSport(traductionSports.get(i));
//		}
//		
		// Lecture du fichier wikipedia-iso-country-codes
		for (int i = 1; i < pays.size(); i++) {
			//banniereOlympiqueManager.traiteBanniereOlympique(pays.get(i));
		}
		
		// Lecture du fichier athlete_epreuves
		for (int i = 1; i < 100; i++) {
			athleteManager.traiteAthlete(athletes.get(i));
		}
		// Fermeture des ressources (connexion)
		epreuveManager.close();
		sportManager.close();
	}

}
