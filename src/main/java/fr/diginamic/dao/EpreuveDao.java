/**
 * EpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.Epreuve;

/**
 * @author CaroleTOULORGE
 *
 */
public class EpreuveDao<E extends Epreuve> extends AbstractDao {

	
	/**Constructeur
	 *
	 * @param em
	 */
	public EpreuveDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche une epreuve en fonction de son nom et pour un sport donné
	 * 
	 * @param nom de l'épreuve
	 * @param class1 sport
	 * @return {@link Epreuve}
	 */
	public Epreuve find(String nom) {
		Query query = em.createQuery("FROM Epreuve WHERE nom=:nom");
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
}
