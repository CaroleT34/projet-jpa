/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.EpreuveDao;
import fr.diginamic.dao.SportDao;
import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.Sport;

/**
 *  Classe qui propose des services de traitement des épreuves
 * @author CaroleTOULORGE
 *
 */
public class EpreuveService {

	/** epreuveDao */
	private EpreuveDao<Epreuve> epreuveDao;
	
	/** sportDao */
	private SportDao<Sport> sportDao;
	
	

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public EpreuveService(EntityManager em) {
		this.epreuveDao = new EpreuveDao<Epreuve>(em);
		this.sportDao = new SportDao<Sport>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEpreuve(Epreuve epreuve) {
		Epreuve epreuveBase = epreuveDao.find(epreuve.getNom());
		Sport sportBase = sportDao.findbyNom(epreuve.getSport());
		if (epreuveBase != null) {
			return;
		}
		epreuve.setSport(sportBase);
		epreuveDao.insert(epreuve);
	}
	
	
}
