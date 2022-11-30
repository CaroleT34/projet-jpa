/**
 * EpreuveService.java
 */
package fr.diginamic.service;

import javax.persistence.EntityManager;

import fr.diginamic.dao.AthleteDao;
import fr.diginamic.dao.EpreuveDao;
import fr.diginamic.dao.MedailleDao;
import fr.diginamic.entity.Athlete;
import fr.diginamic.entity.Epreuve;
import fr.diginamic.entity.Medaille;

/**
 *  Classe qui propose des services de traitement des Equipes
 * @author CaroleTOULORGE
 *
 */
public class MedailleService {

	/** medailleDao */
	private MedailleDao<Medaille> medailleDao;
	
	/** epreuveDao */
	private EpreuveDao<Epreuve> epreuveDao;
	
	/** athleteDao */
	private AthleteDao<Athlete> athleteDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public MedailleService(EntityManager em) {
		this.medailleDao = new MedailleDao<Medaille>(em);
		this.epreuveDao = new EpreuveDao<Epreuve>(em);
		this.athleteDao = new AthleteDao<Athlete>(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionMedaille(Medaille medaille) {
		Medaille medailleBase = medailleDao.find(medaille.getCouleur());
		Epreuve epreuveBase = epreuveDao.findbyNom(medaille.getEpreuve()) ;
		System.out.println("epreuveBase" + epreuveBase);
		Athlete athleteBase = athleteDao.findbyNom(medaille.getAthlete());
		System.out.println("athleteBase" + athleteBase);
		//System.out.println("epreuveBase : " + epreuveBase);
		if (medailleBase != null) {
			return;
		}
		medaille.setAthlete(athleteBase);
		medaille.setEpreuve(epreuveBase);
		medailleDao.insert(medaille);
	}
	
	
}
