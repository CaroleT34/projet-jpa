/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.BanniereOlympiqueDao;
import fr.diginamic.entity.BanniereOlympique;
import fr.diginamic.entity.TraductionBO;

/**
 *  Classe qui propose des services de traitement des épreuves
 * @author CaroleTOULORGE
 *
 */
public class BanniereOlympiqueService {

	/** epreuveDao */
	private BanniereOlympiqueDao<BanniereOlympique> banniereOlympiqueDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public BanniereOlympiqueService(EntityManager em) {
		this.banniereOlympiqueDao = new BanniereOlympiqueDao<BanniereOlympique>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionBanniereOlympique(BanniereOlympique banniereOlympique) {
		BanniereOlympique banniereOlympiqueBase = banniereOlympiqueDao.find(banniereOlympique.getNom());
		if (banniereOlympiqueBase != null) {
			return;
		}
		System.out.println("banniereOlympique" + banniereOlympique);
		banniereOlympiqueDao.insert(banniereOlympique);
	}

	/**
	 * @param traductionBO
	 */
	public void insertionTraductionBO(TraductionBO traductionBO) {
		TraductionBO traductionBOBase = banniereOlympiqueDao.findTraduction(traductionBO.getTraduction());
		if (traductionBOBase != null) {
			return;
		}
		banniereOlympiqueDao.insert(traductionBO);
		
	}
	
	
}
