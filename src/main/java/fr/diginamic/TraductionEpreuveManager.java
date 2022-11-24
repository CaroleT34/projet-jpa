/**
 * TraductionEpreuveManager.java
 */
package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.TraductionEpreuve;
import fr.diginamic.service.TraductionEpreuveService;

/**
 * Classe qui prend en charge la totalité du traitement d'une traduction d'une épreuve
 * 
 * @author CaroleTOULORGE
 *
 */
public class TraductionEpreuveManager {

	/** LOGGER */
	//private static final Logger LOGGER = LoggerFactory.getLogger(EpreuveManager.class);

	/** EntityManager Hibernate */
	private EntityManager em;
	
	/** traductionEpreuveService */
	private TraductionEpreuveService traductionEpreuveService;

	/**Constructeur
	 *
	 */
	public TraductionEpreuveManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		traductionEpreuveService = new TraductionEpreuveService(em);
	}
	
	/**
	 * Traite un produit: gère la totalité de la persistance de la traduction de l'épreuve et de toutes
	 * ses données associées
	 * 
	 * @param epreuve à insérer en base de données.
	 */
	public void traiteTraductionEpreuve(TraductionEpreuve traductionEpreuve) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		traductionEpreuveService.insertionTraductionEpreuve(traductionEpreuve);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}
	
	
}
