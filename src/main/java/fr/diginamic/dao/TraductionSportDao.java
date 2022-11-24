/**
 * TraductionEpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.Sport;
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
	public TraductionSport find(Sport sport) {
		//si sport null
		
		Query query = em.createQuery("FROM TraductionSport WHERE id_sport=:id_sport");
		query.setParameter("id_sport", sport);

		
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
