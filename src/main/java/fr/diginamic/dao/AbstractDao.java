/**
 * AbstractDao.java
 */
package fr.diginamic.dao;

import javax.persistence.EntityManager;

/**
 * Classe mère de toutes les DAO qui fournit quelques attributs de base
 * 
 * @author CaroleTOULORGE
 *
 */
public class AbstractDao {

	/** entityManager */
	protected EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public AbstractDao(EntityManager em) {
		super();
		this.em = em;
	}

	/**
	 * Getter
	 * 
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}
}
