/**
 * Reader.java
 */
package fr.diginamic.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.FileUtils;
import fr.diginamic.entity.Sport;
import fr.diginamic.entity.TraductionSport;
import fr.diginamic.exception.ExceptionTech;

/**
 * Classe qui extrait les TraductionSports du fichier CSV
 * 
 * @author CaroleTOULORGE
 *
 */
public class ReaderTraductionSport {
	
	/**
	 * Retourne la liste des epreuves stockées dans le fichier CSV
	 * @return
	 */
	public ArrayList<TraductionSport> getTraductionSports(InputStream is) throws Exception {

		// Lecture du fichier CSV
		List<String> lignes = null;
		try {
			lignes = FileUtils.readFromInputStream(is);
		} catch (IOException e) {
			throw new ExceptionTech("Fichier " + is.toString() + " introuvable.");
		}

		// On supprime la ligne d'entête
		lignes.remove(0);

		// On traite toutes les lignes 1 par 1
		ArrayList<TraductionSport> traductionSports = new ArrayList<>();
		lignes.forEach(ligne -> traductionSports.add(tranformeLigneEnTraductionSport(ligne)));
		
		return traductionSports;
	}
	
	/**
	 * Transforme une ligne du fichier en un Epreuve
	 * 
	 * @param ligne ligne
	 * @return Epreuve
	 */
	private TraductionSport tranformeLigneEnTraductionSport(String ligne) {
		String[] morceaux = ligne.split(";", -1);

		// System.out.println(ligne);

		String traductionSport = morceaux[0];
		String nomSport = morceaux[1];
		
		
		TraductionSport traductionSp = new TraductionSport();
		traductionSp.setTraduction(traductionSport);
		Sport sport = new Sport(nomSport);

		traductionSp.setSport(sport);
		
		
		return traductionSp;
	}

}
