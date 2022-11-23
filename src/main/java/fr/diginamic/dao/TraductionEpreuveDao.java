/**
 * TraductionEpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.Sport;
import fr.diginamic.entity.TraductionEpreuve;

/**
 * @author CaroleTOULORGE
 *
 */
public class TraductionEpreuveDao<S extends TraductionEpreuve> extends AbstractDao {

	/** Classe de l'entité */
	protected Class<S> classe;
	
	/**Constructeur
	 *
	 * @param em
	 */
	public TraductionEpreuveDao(EntityManager em) {
		super(em);
		this.classe = classe;
	}
	
	/**
	 * Recherche une traduction d'une épreuve en fonction de son cioCode
	 * 
	 * @param cioCode 
	 * @return {@link TraudctionEpreuve}
	 */
	public S find(String cioCode) {
		TypedQuery<S> query = em.createQuery("FROM Epreuve WHERE cioCode=:cioCode", classe);
		query.setParameter("cioCode", cioCode);

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
