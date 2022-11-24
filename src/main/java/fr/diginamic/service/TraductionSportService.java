/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.TraductionSportDao;
import fr.diginamic.entity.TraductionSport;

/**
 *  Classe qui propose des services de traitement TraductionSport
 * @author CaroleTOULORGE
 *
 */
public class TraductionSportService {

	/** sportDao */
	private TraductionSportDao<TraductionSport> traductionSportDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public TraductionSportService(EntityManager em) {
		this.traductionSportDao = new TraductionSportDao<TraductionSport>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionTraductionSport(TraductionSport traductionSport) {
		TraductionSport traductionSportBase = traductionSportDao.find(traductionSport.getSport());
		if (traductionSportBase != null) {
			return;
		}
		traductionSportDao.insert(traductionSport);
	}
	
	
}
