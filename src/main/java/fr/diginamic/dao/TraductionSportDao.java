/**
 * TraductionEpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.TraductionSport;

/**
 * @author CaroleTOULORGE
 *
 */
public class TraductionSportDao<S extends TraductionSport> extends AbstractDao {

	/**Constructeur
	 *
	 * @param em
	 */
	public TraductionSportDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche une traduction d'un Sport 
	 * 
	 * @return {@link TraductionSport}
	 */
	public TraductionSport find(String traduction) {
		//si sport null
		
		Query query = em.createQuery("FROM TraductionSport WHERE traduction=:traduction");
		query.setParameter("traduction", traduction);

		
		@SuppressWarnings("unchecked")
		List<S> results = query.getResultList();
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
	public void insert(S entite) {
		em.persist(entite);
	}
}
