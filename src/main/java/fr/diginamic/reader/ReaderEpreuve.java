/**
 * Reader.java
 */
package fr.diginamic.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.diginamic.FileUtils;
import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.PaysOrganisateur;
import fr.diginamic.entity.Sport;
import fr.diginamic.enumeration.Saison;
import fr.diginamic.exception.ExceptionTech;

/**
 * Classe qui extrait les epreuves du fichier CSV
 * 
 * @author CaroleTOULORGE
 *
 */
public class ReaderEpreuve {

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

		System.out.println(ligne);

		String nomEpreuve = morceaux[1];
		String nomSport = morceaux[12];
		System.out.println(nomSport);
		String ville = morceaux[11];
		String anneePo = morceaux[9];
		int annee = Integer.parseInt(anneePo);
		Date date = new Date();
		date.setYear(annee);
		Saison saison = Saison.valueOf(morceaux[10]);

		Epreuve epreuve = new Epreuve();
		epreuve.setNom(nomEpreuve);
		
		Sport sport = new Sport(nomSport);
		epreuve.setSport(sport);
		
		PaysOrganisateur paysOrganisateur = new PaysOrganisateur(ville,date,saison);
		epreuve.setPaysOrganisateur(paysOrganisateur);
		
		return epreuve;
	}
	
	

}
