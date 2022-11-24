/**
 * Reader.java
 */
package fr.diginamic.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.FileUtils;
import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.TraductionEpreuve;
import fr.diginamic.exception.ExceptionTech;

/**
 * Classe qui extrait les epreuves du fichier CSV
 * 
 * @author CaroleTOULORGE
 *
 */
public class ReaderTraductionEpreuve {

	/**
	 * Retourne la liste des epreuves stockées dans le fichier CSV
	 * @return
	 */
	public List<Epreuve> getEpreuves(InputStream is) throws Exception {

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
		ArrayList<Epreuve> epreuves = new ArrayList<>();
		lignes.forEach(ligne -> epreuves.add(tranformeLigneEnEpreuve(ligne)));
		return epreuves;
	}

	/**
	 * Transforme une ligne du fichier en un Epreuve
	 * 
	 * @param ligne ligne
	 * @return Epreuve
	 */
	private Epreuve tranformeLigneEnEpreuve(String ligne) {
		String[] morceaux = ligne.split(";", -1);

		//System.out.println(ligne);

		String nomEpreuve = morceaux[1];

		Epreuve epreuve = new Epreuve();
		epreuve.setNom(nomEpreuve);
		
		return epreuve;
	}
	

	/**
	 * Retourne la liste des epreuves stockées dans le fichier CSV
	 * @return
	 */
	public List<TraductionEpreuve> getTraductionEpreuves(InputStream is) throws Exception {

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
		ArrayList<TraductionEpreuve> traductionEpreuves = new ArrayList<>();
		lignes.forEach(ligne -> traductionEpreuves.add(tranformeLigneEnTraductionEpreuve(ligne)));
		
		return traductionEpreuves;
	}
	
	/**
	 * Transforme une ligne du fichier en un Epreuve
	 * 
	 * @param ligne ligne
	 * @return Epreuve
	 */
	@SuppressWarnings("unused")
	private TraductionEpreuve tranformeLigneEnTraductionEpreuve(String ligne) {
		String[] morceaux = ligne.split("\\|", -1);

		// System.out.println(nbMorceaux);

		String traductionEpreuve = morceaux[0];

		TraductionEpreuve traductionEp = new TraductionEpreuve();
		traductionEp.setTraduction(traductionEpreuve);

		return traductionEp;
	}

}
