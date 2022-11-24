/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.SportDao;
import fr.diginamic.entity.Sport;

/**
 *  Classe qui propose des services de traitement des sports
 * @author CaroleTOULORGE
 *
 */
public class SportService {

	/** sportDao */
	private SportDao<Sport> sportDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public SportService(EntityManager em) {
		this.sportDao = new SportDao<Sport>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionSport(Sport sport) {
		Sport epreuveBase = sportDao.find(sport.getNom());
		if (epreuveBase != null) {
			return;
		}
		sportDao.insert(sport);
	}
	
	
}
