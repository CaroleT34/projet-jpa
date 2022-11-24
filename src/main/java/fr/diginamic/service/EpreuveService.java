/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.EpreuveDao;
import fr.diginamic.entity.Epreuve;

/**
 *  Classe qui propose des services de traitement des épreuves
 * @author CaroleTOULORGE
 *
 */
public class EpreuveService {

	/** epreuveDao */
	private EpreuveDao<Epreuve> epreuveDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public EpreuveService(EntityManager em) {
		this.epreuveDao = new EpreuveDao<Epreuve>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEpreuve(Epreuve epreuve) {
		Epreuve epreuveBase = epreuveDao.find(epreuve.getNom());
		if (epreuveBase != null) {
			return;
		}
		epreuveDao.insert(epreuve);
	}
	
	
}
