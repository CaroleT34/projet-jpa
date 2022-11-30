/**
 * EpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.Medaille;
import fr.diginamic.enumeration.Couleur;

/**
 * @author CaroleTOULORGE
 *
 */
public class MedailleDao<E extends Medaille> extends AbstractDao {

	
	/**Constructeur
	 *
	 * @param em
	 */
	public MedailleDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche une Medaille en fonction de sa couleur
	 * 
	 * @param nom de Medaille
	 * @return {@link Medaille}
	 */
	public Medaille find(Couleur couleur) {
		Query query = em.createQuery("FROM Medaille WHERE couleur=:couleur");
		query.setParameter("couleur", couleur);

		@SuppressWarnings("unchecked")
		List<E> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
	
	/**
	 * Recherche Medaille en fonction d'une Athlete
	 * 
	 * @param equipe Medaille
	 * @return {@link Medaille}
	 */
//	public E findbyNom(E entite) {
//		Query query = em.createQuery("FROM Athlete WHERE nom=:nom");
//		query.setParameter("nom", entite.getClass());
//	
//		@SuppressWarnings("unchecked")
//		List<E> results = query.getResultList();
//		if (results.isEmpty()) {
//			return null;
//		}
//
//		return results.get(0);
//	}

	/**
	 * Insère une nouvelle entité en base de données
	 * 
	 * @param entite entité
	 */
	public void insert(E entite) {
		em.persist(entite);
	}
}
