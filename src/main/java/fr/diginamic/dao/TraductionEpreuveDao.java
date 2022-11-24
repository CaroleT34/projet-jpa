/**
 * TraductionEpreuveDao.java
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.diginamic.entity.Epreuve;
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
	 * Recherche une traduction d'une épreuve en fonction de son cioCode
	 * 
	 * @param cioCode 
	 * @return {@link TraudctionEpreuve}
	 */
	public TraductionEpreuve find(Epreuve epreuve) {
		Query query = em.createQuery("FROM TraductionEpreuve WHERE id_epreuve=:id_epreuve");
		query.setParameter("id_epreuve", epreuve);

		
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
