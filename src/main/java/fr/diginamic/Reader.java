/**
 * Reader.java
 */
package fr.diginamic;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.TraductionEpreuve;

/**
 * Classe qui extrait les epreuves du fichier CSV
 * 
 * @author CaroleTOULORGE
 *
 */
public class Reader {

	/**
	 * Retourne la liste des epreuves stockées dans le fichier CSV
	 * @return
	 * @throws Exception 
	 */
	public List<Epreuve> getEpreuves(InputStream is) throws Exception {

		// Lecture du fichier CSV
		List<String> lignes = null;
		try {
			lignes = FileUtils.readFromInputStream(is);
		} catch (IOException e) {
			throw new Exception("Fichier " + is.toString() + " introuvable.");
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
		String[] morceaux = ligne.split("\\|", -1);

		// System.out.println(nbMorceaux);

		String nomEpreuve = morceaux[0];
		String traductionEpreuve = morceaux[1];

		Epreuve epreuve = new Epreuve();
		epreuve.setNom(nomEpreuve);
		
		TraductionEpreuve traductionEp = new TraductionEpreuve();
		traductionEp.setTraduction(traductionEpreuve);

		return epreuve;
	}

}
