/**
 * EpreuveManager.java
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.Equipe;
import fr.diginamic.service.EquipeService;

/**
 * Classe qui prend en charge la totalité du traitement d'une equipe
 * 
 * @author CaroleTOULORGE
 *
 */
public class EquipeManager {

	/** EntityManager Hibernate */
	private EntityManager em;
	/** equipeService */
	private EquipeService equipeService;


	/**
	 * Constructeur
	 * 
	 */
	public EquipeManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JO");
		em = entityManagerFactory.createEntityManager();

		equipeService = new EquipeService(em);
		
	}

	/**
	 * Traite un produit: gère la totalité de la persistance de Athlete et de toutes
	 * ses données associées
	 * 
	 * @param Athlete à insérer en base de données.
	 */
	public void traiteEquipe(Equipe equipe) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		equipeService.insertionEquipe(equipe);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
