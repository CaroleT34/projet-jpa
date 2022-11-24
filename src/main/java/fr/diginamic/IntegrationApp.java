/**
 * IntegrationApp.java
 */
package fr.diginamic;

import java.util.List;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.TraductionEpreuve;
import fr.diginamic.reader.ReaderEpreuve;
import fr.diginamic.reader.ReaderTraductionEpreuve;

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

		// Lecture du fichier des traductions épreuves
		ReaderEpreuve readerEpreuve = new ReaderEpreuve();
		List<Epreuve> epreuves = null;
		
		ReaderTraductionEpreuve readerTraductionEpreuve = new ReaderTraductionEpreuve();
		List<TraductionEpreuve> traductionEpreuves = null;
		try {
			epreuves = readerEpreuve.getEpreuves(readerEpreuve.getClass().getClassLoader().getResourceAsStream("liste_des_epreuves.csv"));
			traductionEpreuves = readerTraductionEpreuve.getTraductionEpreuves(readerTraductionEpreuve.getClass().getClassLoader().getResourceAsStream("liste_des_epreuves.csv"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(epreuves);
		// Lecture du fichier athlete_epreuves
		EpreuveManager epreuveManager = new EpreuveManager();
		TraductionEpreuveManager traductionEpreuveManager = new TraductionEpreuveManager();
		
		// Lecture du fichier ..
		for (int i = 1; i < epreuves.size(); i++) {
			epreuveManager.traiteEpreuve(epreuves.get(i));
			traductionEpreuveManager.traiteTraductionEpreuve(traductionEpreuves.get(i));
		}
		
		// Fermeture des ressources (connexion)
		epreuveManager.close();
	}

}
