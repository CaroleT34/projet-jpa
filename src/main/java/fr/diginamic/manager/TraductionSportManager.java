/**
 * EpreuveManager.java
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.TraductionSport;
import fr.diginamic.service.TraductionSportService;

/**
 * Classe qui prend en charge la totalité du traitement de la TraductionSport
 * 
 * @author CaroleTOULORGE
 *
 */
public class TraductionSportManager {
	
	/** EntityManager Hibernate */
	private EntityManager em;
	/** epreuveService */
	private TraductionSportService traductionSportService;


	/**
	 * Constructeur
	 * 
	 */
	public TraductionSportManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		traductionSportService = new TraductionSportService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance de TraductionSport et de toutes
	 * ses données associées
	 * 
	 * @param TraductionSport à insérer en base de données.
	 */
	public void traiteTraductionSport(TraductionSport traductionSport) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		traductionSportService.insertionTraductionSport(traductionSport);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
