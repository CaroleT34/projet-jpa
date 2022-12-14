/**
 * Athlete.java
 */
package fr.diginamic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.diginamic.enumeration.Sexe;

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
	
	@Column(name ="sexe")
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	
	@Column(name ="age", length = 3)
	private int age;
	
	@Column(name ="taille", length = 6)
	private double taille;
	
	@Column(name ="poids", length = 6)
	private double poids;
	
	/** medailles */
	@OneToMany(mappedBy = "athlete")
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

	/**Constructeur
	 *
	 * @param nomAthlete
	 */
	public Athlete(String nom) {
		this.nom = nom;
	}
	
	

	/**Constructeur
	 *
	 * @param id
	 * @param nom
	 * @param sexe
	 * @param age
	 * @param taille
	 * @param poids
	 * @param medailles
	 * @param equipes
	 * @param epreuves
	 */
	public Athlete(int id, String nom, Sexe sexe, int age, double taille, double poids, List<Medaille> medailles,
			List<Equipe> equipes, List<Epreuve> epreuves) {
		super();
		this.id = id;
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.medailles = medailles;
		this.equipes = equipes;
		this.epreuves = epreuves;
	}

	@Override
	public String toString() {
		return "Athlete [id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", age=" + age + ", taille=" + taille
				+ ", poids=" + poids + "]";
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
	 * @return Sexe sexe
	 */
	public Sexe getSexe() {
		return sexe;
	}

	/** Setter sexe
	 * 
	 * @param sexe the sexe to set (type Sexe)
	 */
	public void setSexe(Sexe sexe) {
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
