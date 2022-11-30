/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.AthleteDao;
import fr.diginamic.entity.Athlete;

/**
 *  Classe qui propose des services de traitement des épreuves
 * @author CaroleTOULORGE
 *
 */
public class AthleteService {

	/** athleteDao */
	private AthleteDao<Athlete> athleteDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public AthleteService(EntityManager em) {
		this.athleteDao = new AthleteDao<Athlete>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionAthlete(Athlete athlete) {
		Athlete athleteBase = athleteDao.find(athlete.getNom());
		if (athleteBase != null) {
			return;
		}
		athleteDao.insert(athlete);
	}
	
	
}
