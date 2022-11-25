/**
 * Reader.java
 */
package fr.diginamic.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.FileUtils;
import fr.diginamic.entity.Athlete;
import fr.diginamic.enumeration.Sexe;
import fr.diginamic.exception.ExceptionTech;

/**
 * Classe qui extrait les Athletes du fichier CSV
 * 
 * @author CaroleTOULORGE
 *
 */
public class ReaderAthlete {

	/**
	 * Retourne la liste des Athlete stockées dans le fichier CSV
	 * @return
	 */
	public List<Athlete> getAthletes(InputStream is) throws Exception {

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
		ArrayList<Athlete> athletes = new ArrayList<>();
		lignes.forEach(ligne -> athletes.add(tranformeLigneEnEpreuve(ligne)));
		return athletes;
	}

	/**
	 * Transforme une ligne du fichier en un Epreuve
	 * 
	 * @param ligne ligne
	 * @return Epreuve
	 */
	private Athlete tranformeLigneEnEpreuve(String ligne) {
		String[] morceaux = ligne.split(";", -1);

		String ageAthlete = morceaux[3];
		String nomAthlete = morceaux[1];
		String poidsAthlete = morceaux[5];
		String tailleAthlete = morceaux[4];
		Sexe sexe = Sexe.valueOf(morceaux[2]);
		Athlete athlete = new Athlete();
		/*Age*/
		int ageAthleteTypeInt = 0;
		if (NumberUtils.isDigits(ageAthlete)) {
			ageAthleteTypeInt = Integer.parseInt(ageAthlete);
		}
		athlete.setAge(ageAthleteTypeInt);
		athlete.setNom(nomAthlete);
		/*Poids*/
		double poidsAthleteTypeInt = 0;
		if (NumberUtils.isCreatable(poidsAthlete)) {
			poidsAthleteTypeInt = Double.parseDouble(poidsAthlete);
		}	
		athlete.setPoids(poidsAthleteTypeInt);
		/*Taille*/
		double tailleAthleteTypeInt = 0;
		if (NumberUtils.isCreatable(tailleAthlete)) {
			tailleAthleteTypeInt = Double.parseDouble(tailleAthlete);
		}	
		athlete.setTaille(tailleAthleteTypeInt);
		athlete.setSexe(sexe);
		
		return athlete;
	}
	
	

}
