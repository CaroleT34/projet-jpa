/**
 * EpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.Athlete;

/**
 * @author CaroleTOULORGE
 *
 */
public class AthleteDao<E extends Athlete> extends AbstractDao {

	
	/**Constructeur
	 *
	 * @param em
	 */
	public AthleteDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche une epreuve en fonction de son nom
	 * 
	 * @param nom de Athlete
	 * @return {@link Athlete}
	 */
	public Athlete find(String nom) {
		Query query = em.createQuery("FROM Athlete WHERE nom=:nom");
		query.setParameter("nom", nom);

		@SuppressWarnings("unchecked")
		List<E> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
	
	/**
	 * Recherche l'epreuve en fonction du epreuve 
	 * 
	 * @param athlete Athlete
	 * @return {@link Athlete}
	 */
	public Athlete findbyNom(E entite) {
		Query query = em.createQuery("FROM Athlete WHERE nom=:nom");
		query.setParameter("nom", entite.getNom());
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
