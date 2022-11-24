/**
 * IntegrationApp.java
 */
package fr.diginamic;

import java.util.List;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.Sport;
import fr.diginamic.entity.TraductionEpreuve;
import fr.diginamic.entity.TraductionSport;
import fr.diginamic.reader.ReaderEpreuve;
import fr.diginamic.reader.ReaderSport;
import fr.diginamic.reader.ReaderTraductionEpreuve;
import fr.diginamic.reader.ReaderTraductionSport;

/**
 * @author CaroleTOULORGE
 *
 */
public class IntegrationApp {

	/** LOGGER */
	//private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationApp.class);

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
		
		
		EpreuveManager epreuveManager = new EpreuveManager();
		TraductionEpreuveManager traductionEpreuveManager = new TraductionEpreuveManager();
		
		
		// Lecture du fichier listes des sports
		ReaderSport readerSport = new ReaderSport();
		List<Sport> sports = null;
		
		// Lecture du fichier des traductions sports
		ReaderTraductionSport readerTraductionSport = new ReaderTraductionSport();
		List<TraductionSport> traductionSports = null;
		
		try {
			epreuves = readerEpreuve.getEpreuves(readerEpreuve.getClass().getClassLoader().getResourceAsStream("liste_des_epreuves.csv"));
			traductionEpreuves = readerTraductionEpreuve.getTraductionEpreuves(readerTraductionEpreuve.getClass().getClassLoader().getResourceAsStream("liste_des_epreuves.csv"));
			sports = readerSport.getSports(readerSport.getClass().getClassLoader().getResourceAsStream("liste des sports.csv"));
			traductionSports = readerTraductionSport.getTraductionSports(readerTraductionSport.getClass().getClassLoader().getResourceAsStream("liste des sports.csv"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(traductionEpreuves);
		
		SportManager sportManager = new SportManager();
		TraductionSportManager traductionSportManager = new TraductionSportManager();
		
		// Lecture du fichier epreuve
		for (int i = 1; i < epreuves.size(); i++) {
			epreuveManager.traiteEpreuve(epreuves.get(i));
			traductionEpreuveManager.traiteTraductionEpreuve(traductionEpreuves.get(i));
		}
		// Lecture du fichier sport
		for (int i = 1; i < sports.size(); i++) {
			sportManager.traiteSport(sports.get(i));
			traductionSportManager.traiteTraductionSport(traductionSports.get(i));
		}
		
		// Lecture du fichier athlete_epreuves
		
		// Fermeture des ressources (connexion)
		epreuveManager.close();
		sportManager.close();
	}

}
