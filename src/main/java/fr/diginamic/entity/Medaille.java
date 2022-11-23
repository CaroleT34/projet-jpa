/**
 * Medaille.java
 */
package fr.diginamic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.diginamic.enumeration.Couleur;

/**
 * Représente une médaille avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "MEDAILLE")
public class Medaille {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="couleur")
	@Enumerated(EnumType.STRING)
	private Couleur couleur;
	
	/** epreuve */
	@ManyToOne
	@JoinColumn(name="ID_EPREUVE")
	private Epreuve epreuve;
	
	/** athlete */
	@ManyToOne
	@JoinColumn(name="ID_ATHLETE")
	private Athlete athlete;

	/**Constructeur (utilisé par Hibernate)
	 *
	 */
	public Medaille() {
		
	}

	@Override
	public String toString() {
		return "Medaille [id=" + id + ", couleur=" + couleur + ", epreuve=" + epreuve + ", athlete=" + athlete + "]";
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

	/**Getter couleur
	 * 
	 * @return Couleur couleur
	 */
	public Couleur getCouleur() {
		return couleur;
	}

	/** Setter couleur
	 * 
	 * @param couleur the couleur to set (type Couleur)
	 */
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	/**Getter epreuve
	 * 
	 * @return Epreuve epreuve
	 */
	public Epreuve getEpreuve() {
		return epreuve;
	}

	/** Setter epreuve
	 * 
	 * @param epreuve the epreuve to set (type Epreuve)
	 */
	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	/**Getter athlete
	 * 
	 * @return Athlete athlete
	 */
	public Athlete getAthlete() {
		return athlete;
	}

	/** Setter athlete
	 * 
	 * @param athlete the athlete to set (type Athlete)
	 */
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}
	
}
