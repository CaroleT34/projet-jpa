/**
 * EpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.Sport;

/**
 * @author CaroleTOULORGE
 *
 */
public class SportDao<S extends Sport> extends AbstractDao {

	
	/**Constructeur
	 *
	 * @param em
	 */
	public SportDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche un Sport en fonction de son nom et pour un sport donné
	 * 
	 * @param nom Sport
	 * @return {@link Sport}
	 */
	public Sport find(String nom) {
		Query query = em.createQuery("FROM Sport WHERE nom=:nom");
		query.setParameter("nom", nom);

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
