/**
 * EpreuveManager.java
 */
package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.Sport;
import fr.diginamic.service.SportService;

/**
 * Classe qui prend en charge la totalité du traitement d'un sport
 * 
 * @author CaroleTOULORGE
 *
 */
public class SportManager {
	
	/** EntityManager Hibernate */
	private EntityManager em;
	/** epreuveService */
	private SportService sportService;


	/**
	 * Constructeur
	 * 
	 */
	public SportManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		sportService = new SportService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance de l'épreuve et de toutes
	 * ses données associées
	 * 
	 * @param epreuve à insérer en base de données.
	 */
	public void traiteSport(Sport sport) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		sportService.insertionSport(sport);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
