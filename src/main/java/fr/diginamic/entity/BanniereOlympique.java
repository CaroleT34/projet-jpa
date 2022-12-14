/**
 * BanniereOlympique.java
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
 * Représente la banniere olympique avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "BANNIEREOLYMPIQUE")
public class BanniereOlympique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name ="cioCode", length = 10, nullable = false)
	private String cioCode;
	
	@Column(name ="nom", length = 500)
	private String nom;
	
	@Column(name ="statut")
	private boolean statut;
	
	/** traductionsBO */
	@OneToMany(mappedBy = "banniereOlympique",  orphanRemoval = true, cascade = {CascadeType.ALL})
	private List<TraductionBO> traductionsBO = new ArrayList<TraductionBO>();
	
	/** Equipe */
	@OneToMany(mappedBy = "banniereOlympique")
	private List<Equipe> equipes = new ArrayList<Equipe>();
	
	
	/**Constructeur (utilisé par Hibernate)
	 *
	 */
	public BanniereOlympique() {
		
	}

	/**Constructeur
	 *
	 * @param id
	 * @param cioCode
	 * @param nom
	 * @param statut
	 * @param traductionsBO
	 * @param equipes
	 */
	public BanniereOlympique(int id, String cioCode, String nom, boolean statut, List<TraductionBO> traductionsBO,
			List<Equipe> equipes) {
		super();
		this.id = id;
		this.cioCode = cioCode;
		this.nom = nom;
		this.statut = statut;
		this.traductionsBO = traductionsBO;
		this.equipes = equipes;
	}




	@Override
	public String toString() {
		return "BanniereOlympique [id=" + id + ", cioCode=" + cioCode + ", nom=" + nom + ", statut=" + statut
				+ ", traductionsBO=" + traductionsBO + ", equipes=" + equipes + "]";
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
	
	/**Getter cioCode
	 * 
	 * @return String cioCode
	 */
	public String getCioCode() {
		return cioCode;
	}


	/** Setter cioCode
	 * 
	 * @param cioCode the cioCode to set (type String)
	 */
	public void setCioCode(String cioCode) {
		this.cioCode = cioCode;
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


	/**Getter statut
	 * 
	 * @return boolean statut
	 */
	public boolean isStatut() {
		return statut;
	}


	/** Setter statut
	 * 
	 * @param statut the statut to set (type boolean)
	 */
	public void setStatut(boolean statut) {
		this.statut = statut;
	}


	/**Getter traductionsBO
	 * 
	 * @return List<TraductionBO> traductionsBO
	 */
	public List<TraductionBO> getTraductionsBO() {
		return traductionsBO;
	}


	/** Setter traductionsBO
	 * 
	 * @param traductionsBO the traductionsBO to set (type List<TraductionBO>)
	 */
	public void setTraductionsBO(List<TraductionBO> traductionsBO) {
		this.traductionsBO = traductionsBO;
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
	
	
}
