/**
 * TraductionEpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.TraductionEpreuve;

/**
 * @author CaroleTOULORGE
 *
 */
public class TraductionEpreuveDao<S extends TraductionEpreuve> extends AbstractDao {

	/**Constructeur
	 *
	 * @param em
	 */
	public TraductionEpreuveDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche une traduction d'une épreuve en fonction de sa traduction
	 * 
	 * @param cioCode 
	 * @return {@link TraudctionEpreuve}
	 */
	public TraductionEpreuve find(String traduction) {
		Query query = em.createQuery("FROM TraductionEpreuve WHERE traduction=:traduction");
		query.setParameter("traduction", traduction);

		//System.out.println(epreuve);
		
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
