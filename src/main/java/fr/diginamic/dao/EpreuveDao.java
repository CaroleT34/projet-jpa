/**
 * EpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.Sport;

/**
 * @author CaroleTOULORGE
 *
 */
public class EpreuveDao<E extends Epreuve> extends AbstractDao {

	/** Classe de l'entité */
	protected Class<E> classe;
	
	/**Constructeur
	 *
	 * @param em
	 */
	public EpreuveDao(EntityManager em) {
		super(em);
		this.classe = classe;
	}
	
	/**
	 * Recherche une epreuve en fonction de son nom et pour un sport donné
	 * 
	 * @param nom de l'épreuve
	 * @param class1 sport
	 * @return {@link Epreuve}
	 */
	public Epreuve find(String nom, Class<Sport> class1) {
		TypedQuery<E> query = em.createQuery("FROM Epreuve WHERE nom=:nom AND sport=:sport", classe);
		query.setParameter("nom", nom);
		query.setParameter("sport", class1);

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
