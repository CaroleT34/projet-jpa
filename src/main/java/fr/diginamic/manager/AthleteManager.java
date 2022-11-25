/**
 * EpreuveManager.java
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.Athlete;
import fr.diginamic.service.AthleteService;

/**
 * Classe qui prend en charge la totalité du traitement d'un Athlete
 * 
 * @author CaroleTOULORGE
 *
 */
public class AthleteManager {

	/** EntityManager Hibernate */
	private EntityManager em;
	/** epreuveService */
	private AthleteService athleteService;


	/**
	 * Constructeur
	 * 
	 */
	public AthleteManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		athleteService = new AthleteService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance de Athlete et de toutes
	 * ses données associées
	 * 
	 * @param Athlete à insérer en base de données.
	 */
	public void traiteAthlete(Athlete athlete) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		athleteService.insertionAthlete(athlete);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
