/**
 * TraductionEpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.TraductionEpreuveDao;
import fr.diginamic.entity.TraductionEpreuve;

/**
 *  Classe qui propose des services de traitement des traductions des épreuves
 * @author CaroleTOULORGE
 *
 */
public class TraductionEpreuveService {
	
	/** traductionEpreuveDao */
	private TraductionEpreuveDao<TraductionEpreuve> traductionEpreuveDao;

	/**Constructeur
	 *
	 * @param em {@link EntityManager}
	 */
	public TraductionEpreuveService(EntityManager em) {
		this.traductionEpreuveDao = new TraductionEpreuveDao<TraductionEpreuve>(em);
	}
	
	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionTraductionEpreuve(TraductionEpreuve traductionEpreuve) {
		TraductionEpreuve traductionEpreuveBase = traductionEpreuveDao.find();
		if (traductionEpreuveBase != null) {
			return;
		}
		traductionEpreuveDao.insert(traductionEpreuve);
	}
	
}
