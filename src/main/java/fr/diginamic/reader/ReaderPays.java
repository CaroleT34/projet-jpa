/**
 * Reader.java
 */
package fr.diginamic.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.FileUtils;
import fr.diginamic.entity.BanniereOlympique;
import fr.diginamic.entity.TraductionBO;
import fr.diginamic.exception.ExceptionTech;

/**
 * Classe qui extrait les pays du fichier CSV
 * 
 * @author CaroleTOULORGE
 *
 */
public class ReaderPays {

	/**
	 * Retourne la liste des pays stockées dans le fichier CSV
	 * @return
	 */
	public List<BanniereOlympique> getPays(InputStream is) throws Exception {

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
		ArrayList<BanniereOlympique> banniereOlympiques = new ArrayList<>();
		lignes.forEach(ligne -> banniereOlympiques.add(tranformeLigneEnBanniereOlympiques(ligne)));
		return banniereOlympiques;
	}

	/**
	 * Transforme une ligne du fichier en BanniereOlympique
	 * 
	 * @param ligne ligne
	 * @return BanniereOlympique
	 */
	private BanniereOlympique tranformeLigneEnBanniereOlympiques(String ligne) {
		String[] morceaux = ligne.split(";", -1);

		//System.out.println(ligne);

		String cioCode = morceaux[0];
		String nomBO = morceaux[1];
		String statut = morceaux[4];
		

		BanniereOlympique banniereOlympique = new BanniereOlympique();
		banniereOlympique.setCioCode(cioCode);
		banniereOlympique.setNom(nomBO);
		
		boolean newStatut;
		if (statut == "O") {
			newStatut = true;
		} else {
			newStatut = false;
		} 
		banniereOlympique.setStatut(newStatut);
		
		return banniereOlympique;
	}
	
//	/**
//	 * Transforme une ligne du fichier en BanniereOlympique
//	 * 
//	 * @param ligne ligne
//	 * @return BanniereOlympique
//	 */
//	@SuppressWarnings("unused")
//	private TraductionBO tranformeLigneEnTraductionBanniereOlympiques(String ligne) {
//		String[] morceaux = ligne.split(";", -1);
//
//		//System.out.println(ligne);
//
//		String nomBO = morceaux[2];
//		//String id_bo = morceaux[0];
//		
//		BanniereOlympique banniereOlympique = new BanniereOlympique();
//		//banniereOlympique.setCioCode(id_bo);
//
//		TraductionBO traductionBO = new TraductionBO();
//		traductionBO.setTraduction(nomBO);
//		traductionBO.setBanniereOlympique(banniereOlympique);
//		
//		return traductionBO;
//	}
	

}
