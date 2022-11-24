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
import fr.diginamic.exception.ExceptionTech;

/**
 * Classe qui extrait les sports du fichier CSV
 * 
 * @author CaroleTOULORGE
 *
 */
public class ReaderSport {

	/**
	 * Retourne la liste des sports stockées dans le fichier CSV
	 * @return
	 */
	public List<Sport> getSports(InputStream is) throws Exception {

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
		ArrayList<Sport> sports = new ArrayList<>();
		lignes.forEach(ligne -> sports.add(tranformeLigneEnSport(ligne)));
		return sports;
	}

	/**
	 * Transforme une ligne du fichier en un Sport
	 * 
	 * @param ligne ligne
	 * @return Sport
	 */
	private Sport tranformeLigneEnSport(String ligne) {
		String[] morceaux = ligne.split(";", -1);

		//System.out.println(ligne);

		String nomSport = morceaux[1];

		Sport sport = new Sport();
		sport.setNom(nomSport);
		
		return sport;
	}

}
