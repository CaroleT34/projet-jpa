package fr.diginamic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entity.Athlete;
import fr.diginamic.enumeration.Sexe;

/**
 * @author CaroleTOULORGE
 *
 */
public class ConnexionJPA {

	public static void main(String[] args) {
		// Créer une instance d’entityManagerFactory
		EntityManagerFactory entity = Persistence.createEntityManagerFactory("JO");
		// Créer une instance d’entityManager
		EntityManager em = entity.createEntityManager();
		EntityTransaction transac = em.getTransaction();
		 
		transac.begin();
		
		//Test
		Athlete athlete = new Athlete();
		athlete.setNom("Georges W");
		athlete.setSexe(Sexe.MASCULIN);
		athlete.setAge(23);
		athlete.setTaille(1.83);
		athlete.setPoids(56);
		
		em.persist(athlete);
		
		transac.commit();
		
		
		
		// transformation de la liste des lignes en objets
		
//		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
//		// Afficher les données du fichier ligne par ligne
//		for (String line : lines) {
//			// System.out.println(line);
//		}
		
		// création des objets (Athlete, Epreuve ...)

//		// Initilisation des données concernant l'Athlete
//		ArrayList<Athlete> listAthletes = new ArrayList<Athlete>();
//		int id = 0;
//		String nom = "";
//		String sexe = "";
//		int age = 0;
//		double taille = 0;
//		double poids = 0;
//
//		
//
//		// Parcours le fichier
//		for (int i = 1; i < lines.size(); i++) {
//			String[] tab = lines.get(i).split(";");
//			athlete.setId(tab[0]);
//			nom = tab[1];
//			sexe = tab[2];
//			age = Integer.parseInt(tab[3]);
//			taille = Double.parseDouble(tab[4]);
//			poids = Double.parseDouble(tab[5]);
//			System.out.println(listAthletes.get(1));
//		}

	}
}
