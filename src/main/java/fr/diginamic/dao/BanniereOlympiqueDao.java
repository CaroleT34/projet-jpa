/**
 * EpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.BanniereOlympique;
import fr.diginamic.entity.TraductionBO;

/**
 * @author CaroleTOULORGE
 *
 */
public class BanniereOlympiqueDao<E extends BanniereOlympique> extends AbstractDao {

	
	/**Constructeur
	 *
	 * @param em
	 */
	public BanniereOlympiqueDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche une BanniereOlympique en fonction de son nom
	 * 
	 * @param nom BanniereOlympique
	 * @return {@link BanniereOlympique}
	 */
	public BanniereOlympique find(String nom) {
		Query query = em.createQuery("FROM BanniereOlympique WHERE nom=:nom");
		query.setParameter("nom", nom);

		@SuppressWarnings("unchecked")
		List<E> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}

	/**
	 * Insère une nouvelle entité en base de données
	 * 
	 * @param entite entité
	 */
	public void insert(E entite) {
		em.persist(entite);
	}
	
	/**
	 * Recherche une BanniereOlympique en fonction de son nom
	 * 
	 * @param nom BanniereOlympique
	 * @return {@link BanniereOlympique}
	 */
	public TraductionBO findTraduction(String traduction) {
		Query query = em.createQuery("FROM TraductionBO WHERE traduction=:traduction");
		query.setParameter("traduction", traduction);

		@SuppressWarnings("unchecked")
		List<TraductionBO> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}

	/**
	 * @param traductionBO
	 */
	public void insert(TraductionBO traductionBO) {
		em.persist(traductionBO);
		
	}
}
