/**
 * EpreuveManager.java
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.BanniereOlympique;
import fr.diginamic.entity.TraductionBO;
import fr.diginamic.service.BanniereOlympiqueService;

/**
 * Classe qui prend en charge la totalité du traitement de l'entité BanniereOlympique
 * 
 * @author CaroleTOULORGE
 *
 */
public class BanniereOlympiqueManager {
	
	/** EntityManager Hibernate */
	private EntityManager em;
	/** banniereOlympiqueService */
	private BanniereOlympiqueService banniereOlympiqueService;


	/**
	 * Constructeur
	 * 
	 */
	public BanniereOlympiqueManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		banniereOlympiqueService = new BanniereOlympiqueService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance de l'épreuve et de toutes
	 * ses données associées
	 * 
	 * @param epreuve à insérer en base de données.
	 */
	public void traiteBanniereOlympique(BanniereOlympique banniereOlympique) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		banniereOlympiqueService.insertionBanniereOlympique(banniereOlympique);

		transaction.commit();
	}
	
	/**
	 * Traite un produit: gère la totalité de la persistance de l'épreuve et de toutes
	 * ses données associées
	 * 
	 * @param epreuve à insérer en base de données.
	 */
	public void traiteTraductionBO(TraductionBO traductionBO) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		banniereOlympiqueService.insertionTraductionBO(traductionBO);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
