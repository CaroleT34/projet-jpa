/**
 * Sport.java
 */
package fr.diginamic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente le sport avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "SPORT")
public class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="nom", length = 500)
	private String nom;
	
	/** épreuves */
	@OneToMany(mappedBy = "sport",  orphanRemoval = true, cascade = {CascadeType.ALL})
	private List<Epreuve> epreuves = new ArrayList<Epreuve>();
	
	/** traductionsSport */
	@OneToMany(mappedBy = "sport")
	private List<TraductionSport> traductionsSport = new ArrayList<TraductionSport>();

	/**Constructeur (utilisé par Hibernate)
	 *
	 */
	public Sport() {
		
	}

	
	/**Constructeur
	 *
	 * @param id
	 * @param nom
	 * @param epreuves
	 * @param traductionsSport
	 */
	public Sport(int id, String nom, List<Epreuve> epreuves, List<TraductionSport> traductionsSport) {
		super();
		this.id = id;
		this.nom = nom;
		this.epreuves = epreuves;
		this.traductionsSport = traductionsSport;
	}


	/**Constructeur
	 *
	 * @param nom
	 */
	public Sport(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", nom=" + nom + ", epreuves=" + epreuves + ", traductionsSport=" + traductionsSport
				+ "]";
	}


	/**Getter id
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/** Setter id
	 * 
	 * @param id the id to set (type int)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**Getter nom
	 * 
	 * @return String nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter nom
	 * 
	 * @param nom the nom to set (type String)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter epreuves
	 * 
	 * @return List<Epreuve> epreuves
	 */
	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	/** Setter epreuves
	 * 
	 * @param epreuves the epreuves to set (type List<Epreuve>)
	 */
	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}

	/**Getter traductionsSport
	 * 
	 * @return List<TraductionSport> traductionsSport
	 */
	public List<TraductionSport> getTraductionsSport() {
		return traductionsSport;
	}

	/** Setter traductionsSport
	 * 
	 * @param traductionsSport the traductionsSport to set (type List<TraductionSport>)
	 */
	public void setTraductionsSport(List<TraductionSport> traductionsSport) {
		this.traductionsSport = traductionsSport;
	}
	
}
