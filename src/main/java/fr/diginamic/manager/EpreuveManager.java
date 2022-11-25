/**
 * EpreuveManager.java
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.service.EpreuveService;

/**
 * Classe qui prend en charge la totalité du traitement d'une épreuve
 * 
 * @author CaroleTOULORGE
 *
 */
public class EpreuveManager {
	
	/** LOGGER */
	//private static final Logger LOGGER = LoggerFactory.getLogger(EpreuveManager.class);

	/** EntityManager Hibernate */
	private EntityManager em;
	/** epreuveService */
	private EpreuveService epreuveService;


	/**
	 * Constructeur
	 * 
	 */
	public EpreuveManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		epreuveService = new EpreuveService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance de l'épreuve et de toutes
	 * ses données associées
	 * 
	 * @param epreuve à insérer en base de données.
	 */
	public void traiteEpreuve(Epreuve epreuve) {

		//LOGGER.debug("Epreuve" + epreuve.getNom());

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		epreuveService.insertionEpreuve(epreuve);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
