/**
 * IntegrationApp.java
 */
package fr.diginamic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.utils.RecensementUtils;

/**
 * @author CaroleTOULORGE
 *
 */
public class IntegrationApp {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationApp.class);

	/**
	 * Point d'entrée
	 * 
	 * @param args non utilisés ici
	 */
	public static void main(String[] args) {

		// Lecture du fichier des traductions épreuves
		Reader reader = new Reader();
		List<Epreuve> epreuves = reader.getEpreuves(reader.getClass().getClassLoader().getResourceAsStream("liste_des_epreuves.csv"));
		
		// Lecture du fichier athlete_epreuves
		EpreuveManager epreuveManager = new EpreuveManager();
		
		// Lecture du fichier ..
		for (int i = 1; i < epreuves.size(); i++) {
			epreuveManager.traiteEpreuve(epreuves.get(i));
		
		}
		
		// Fermeture des ressources (connexion)
		epreuveManager.close();
	}

}
