/**
 * EpreuveManager.java
 */
package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.TraductionEpreuve;
import fr.diginamic.service.EpreuveService;
import fr.diginamic.service.TraductionEpreuveService;

/**
 * Classe qui prend en charge la totalité du traitement d'une épreuve
 * 
 * @author CaroleTOULORGE
 *
 */
public class EpreuveManager {
	
	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(EpreuveManager.class);

	/** EntityManager Hibernate */
	private EntityManager em;
	/** epreuveService */
	private EpreuveService epreuveService;
	/** traductionEpreuveService */
	private TraductionEpreuveService traductionEpreuveService;


	/**
	 * Constructeur
	 * 
	 */
	public EpreuveManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		epreuveService = new EpreuveService(em);
		traductionEpreuveService = new TraductionEpreuveService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance du produit et de toutes
	 * ses données associées
	 * 
	 * @param epreuve à insérer en base de données.
	 */
	public void traiteEpreuve(Epreuve epreuve) {

		LOGGER.debug("Epreuve" + epreuve.getNom());

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
