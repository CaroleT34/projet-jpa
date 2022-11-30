/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.EquipeDao;
import fr.diginamic.entity.Equipe;

/**
 *  Classe qui propose des services de traitement des Equipes
 * @author CaroleTOULORGE
 *
 */
public class EquipeService {

	/** epreuveDao */
	private EquipeDao<Equipe> equipeDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public EquipeService(EntityManager em) {
		this.equipeDao = new EquipeDao<Equipe>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEquipe(Equipe equipe) {
		Equipe equipeBase = equipeDao.find(equipe.getNom());
		if (equipeBase != null) {
			return;
		}
		equipeDao.insert(equipe);
	}
	
	
}
