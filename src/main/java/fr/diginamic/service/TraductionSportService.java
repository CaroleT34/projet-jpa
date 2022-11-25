/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.SportDao;
import fr.diginamic.dao.TraductionSportDao;
import fr.diginamic.entity.Sport;
import fr.diginamic.entity.TraductionSport;

/**
 *  Classe qui propose des services de traitement TraductionSport
 * @author CaroleTOULORGE
 *
 */
public class TraductionSportService {

	/** sportDao */
	private TraductionSportDao<TraductionSport> traductionSportDao;

	/** sportDao */
	private SportDao<Sport> sportDao;
	
	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public TraductionSportService(EntityManager em) {
		this.traductionSportDao = new TraductionSportDao<TraductionSport>(em);
		this.sportDao = new SportDao<Sport>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionTraductionSport(TraductionSport traductionSport) {
		TraductionSport traductionSportBase = traductionSportDao.find(traductionSport.getTraduction());

		//Créer dans sportDao pour récupérer l'id_sport
		Sport sportBase = sportDao.findbyNom(traductionSport.getSport());
		//System.out.println("sportBase " + sportBase.getId());
		
		if (traductionSportBase != null) {
			return;
		}
		
		traductionSport.setSport(sportBase);
		traductionSportDao.insert(traductionSport);
	}
	
	
}
