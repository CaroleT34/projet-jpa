/**
 * EpreuveManager.java
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.Medaille;
import fr.diginamic.service.MedailleService;

/**
 * Classe qui prend en charge la totalité du traitement d'une equipe
 * 
 * @author CaroleTOULORGE
 *
 */
public class MedailleManager {

	/** EntityManager Hibernate */
	private EntityManager em;
	/** medailleService */
	private MedailleService medailleService;


	/**
	 * Constructeur
	 * 
	 */
	public MedailleManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		medailleService = new MedailleService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance de medaille et de toutes
	 * ses données associées
	 * 
	 * @param medaille à insérer en base de données.
	 */
	public void traiteMedaille(Medaille medaille) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		medailleService.insertionMedaille(medaille);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
