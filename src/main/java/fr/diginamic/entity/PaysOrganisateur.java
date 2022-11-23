/**
 * PaysOrganisateur.java
 */
package fr.diginamic.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.diginamic.enumeration.Saison;

/**
 * Représente le pays organisateur avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "PAYSORGANISATEUR")
public class PaysOrganisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="ville", length = 500)
	private String ville;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name ="annee")
	private Date annee;
	
	@Column(name ="saison")
	@Enumerated(EnumType.STRING)
	private Saison saison;
	
	/** epreuves */
	@OneToMany(mappedBy = "paysOrganisateur")
	private List<Epreuve> epreuves = new ArrayList<Epreuve>();
	
	/**Constructeur (utilisé par Hibernate)
	 *
	 */
	public PaysOrganisateur() {
		
	}


	@Override
	public String toString() {
		return "PaysOrganisateur [id=" + id + ", ville=" + ville + ", annee=" + annee + ", saison=" + saison
				+ ", epreuves=" + epreuves + "]";
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

	/**Getter ville
	 * 
	 * @return String ville
	 */
	public String getVille() {
		return ville;
	}

	/** Setter ville
	 * 
	 * @param ville the ville to set (type String)
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**Getter annee
	 * 
	 * @return Date annee
	 */
	public Date getAnnee() {
		return annee;
	}

	/** Setter annee
	 * 
	 * @param annee the annee to set (type Date)
	 */
	public void setAnnee(Date annee) {
		this.annee = annee;
	}

	/**Getter saison
	 * 
	 * @return Saison saison
	 */
	public Saison getSaison() {
		return saison;
	}

	/** Setter saison
	 * 
	 * @param saison the saison to set (type Saison)
	 */
	public void setSaison(Saison saison) {
		this.saison = saison;
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
