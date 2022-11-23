/**
 * Athlete.java
 */
package fr.diginamic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente un athlète avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "ATHLETE")
public class Athlete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="nom", length = 500)
	private String nom;
	
	@Column(name ="sexe", length = 10)
	private String sexe;
	
	@Column(name ="age", length = 3)
	private int age;
	
	@Column(name ="taille", length = 6)
	private double taille;
	
	@Column(name ="poids", length = 6)
	private double poids;
	
	/** medailles */
	@OneToMany(mappedBy = "Athlete")
	private List<Medaille> medailles = new ArrayList<Medaille>();
	
	/** Athlete_Equipe */
	@ManyToMany
	@JoinTable(name = "Athlete_Equipe", joinColumns = @JoinColumn(name = "ID_ATHLETE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_EQUIPE", referencedColumnName = "ID"))
	private List<Equipe> equipes = new ArrayList<>();
	
	/** Epreuve_Athlete */
	@ManyToMany
	@JoinTable(name = "Epreuve_Athlete", joinColumns = @JoinColumn(name = "ID_ATHLETE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_EPREUVE", referencedColumnName = "ID"))
	private List<Epreuve> epreuves = new ArrayList<>();
	
	/**Constructeur (utilisé par Hibernate)
	 *
	 * 
	 */
	public Athlete() {
		
	}

	@Override
	public String toString() {
		return "Athlete [id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", age=" + age + ", taille=" + taille
				+ ", poids=" + poids + ", medailles=" + medailles + ", equipes=" + equipes + ", epreuves=" + epreuves
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

	/**Getter sexe
	 * 
	 * @return String sexe
	 */
	public String getSexe() {
		return sexe;
	}

	/** Setter sexe
	 * 
	 * @param sexe the sexe to set (type String)
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/**Getter age
	 * 
	 * @return int age
	 */
	public int getAge() {
		return age;
	}

	/** Setter age
	 * 
	 * @param age the age to set (type int)
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**Getter taille
	 * 
	 * @return double taille
	 */
	public double getTaille() {
		return taille;
	}

	/** Setter taille
	 * 
	 * @param taille the taille to set (type double)
	 */
	public void setTaille(double taille) {
		this.taille = taille;
	}

	/**Getter poids
	 * 
	 * @return double poids
	 */
	public double getPoids() {
		return poids;
	}

	/** Setter poids
	 * 
	 * @param poids the poids to set (type double)
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}

	/**Getter medailles
	 * 
	 * @return List<Medaille> medailles
	 */
	public List<Medaille> getMedailles() {
		return medailles;
	}

	/** Setter medailles
	 * 
	 * @param medailles the medailles to set (type List<Medaille>)
	 */
	public void setMedailles(List<Medaille> medailles) {
		this.medailles = medailles;
	}

	/**Getter equipes
	 * 
	 * @return List<Equipe> equipes
	 */
	public List<Equipe> getEquipes() {
		return equipes;
	}

	/** Setter equipes
	 * 
	 * @param equipes the equipes to set (type List<Equipe>)
	 */
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
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
	
}
