/**
 * Epreuve.java
 */
package fr.diginamic.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente une épreuve avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "EPREUVE")
public class Epreuve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="nom", length = 1000)
	private String nom;
	
	/** sport */
	@ManyToOne
	@JoinColumn(name="ID_SPORT")
	private Sport sport;
	
	/** paysOrganisateur */
	@ManyToOne
	@JoinColumn(name="ID_PaysOrganisateur")
	private PaysOrganisateur paysOrganisateur;
	
	/** medailles */
	@OneToMany(mappedBy = "Epreuve")
	private List<Medaille> medailles = new ArrayList<Medaille>();
	
	/** traductionsEpreuves */
	@OneToMany(mappedBy = "Epreuve")
	private List<TraductionEpreuve> traductionsEpreuves = new ArrayList<TraductionEpreuve>();
	
	/** Epreuve_Athlete */
	@ManyToMany
	@JoinTable(name = "Epreuve_Athlete", joinColumns = @JoinColumn(name = "ID_EPREUVE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ATHLETE", referencedColumnName = "ID"))
	private Set<Athlete> athletes = new HashSet<>();

	/**Constructeur (utilisé par Hibernate)
	 *
	 */
	public Epreuve() {
		
	}

	@Override
	public String toString() {
		return "Epreuve [id=" + id + ", nom=" + nom + ", sport=" + sport + ", paysOrganisateur=" + paysOrganisateur
				+ ", medailles=" + medailles + ", traductionsEpreuves=" + traductionsEpreuves + "]";
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

	/**Getter sport
	 * 
	 * @return Sport sport
	 */
	public Sport getSport() {
		return sport;
	}

	/** Setter sport
	 * 
	 * @param sport the sport to set (type Sport)
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
	}

	/**Getter paysOrganisateur
	 * 
	 * @return PaysOrganisateur paysOrganisateur
	 */
	public PaysOrganisateur getPaysOrganisateur() {
		return paysOrganisateur;
	}

	/** Setter paysOrganisateur
	 * 
	 * @param paysOrganisateur the paysOrganisateur to set (type PaysOrganisateur)
	 */
	public void setPaysOrganisateur(PaysOrganisateur paysOrganisateur) {
		this.paysOrganisateur = paysOrganisateur;
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

	/**Getter traductionsEpreuves
	 * 
	 * @return List<TraductionEpreuve> traductionsEpreuves
	 */
	public List<TraductionEpreuve> getTraductionsEpreuves() {
		return traductionsEpreuves;
	}

	/** Setter traductionsEpreuves
	 * 
	 * @param traductionsEpreuves the traductionsEpreuves to set (type List<TraductionEpreuve>)
	 */
	public void setTraductionsEpreuves(List<TraductionEpreuve> traductionsEpreuves) {
		this.traductionsEpreuves = traductionsEpreuves;
	}

	/**Getter athletes
	 * 
	 * @return Set<Athlete> athletes
	 */
	public Set<Athlete> getAthletes() {
		return athletes;
	}

	/** Setter athletes
	 * 
	 * @param athletes the athletes to set (type Set<Athlete>)
	 */
	public void setAthletes(Set<Athlete> athletes) {
		this.athletes = athletes;
	}
	
	
	
}
