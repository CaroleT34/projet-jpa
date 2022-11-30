/**
 * EpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.Equipe;

/**
 * @author CaroleTOULORGE
 *
 */
public class EquipeDao<E extends Equipe> extends AbstractDao {

	
	/**Constructeur
	 *
	 * @param em
	 */
	public EquipeDao(EntityManager em) {
		super(em);
	}
	
	/**
	 * Recherche une Equipe en fonction de son nom
	 * 
	 * @param nom de Equipe
	 * @return {@link Equipe}
	 */
	public Equipe find(String nom) {
		Query query = em.createQuery("FROM Equipe WHERE nom=:nom");
		query.setParameter("nom", nom);

		@SuppressWarnings("unchecked")
		List<E> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
	
	/**
	 * Recherche l'epreuve en fonction d'une equipe
	 * 
	 * @param equipe Equipe
	 * @return {@link Equipe}
	 */
	public Equipe findbyNom(E entite) {
		Query query = em.createQuery("FROM Equipe WHERE nom=:nom");
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
