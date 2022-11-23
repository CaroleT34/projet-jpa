/**
 * Equipe.java
 */
package fr.diginamic.entity;

import java.util.HashSet;
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
import javax.persistence.Table;

/**
 * Représente l'équipe avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "EQUIPE")
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="nom", length = 1000)
	private String nom;
	
	/** Epreuve_Athlete */
	@ManyToMany
	@JoinTable(name = "Epreuve_Athlete", joinColumns = @JoinColumn(name = "ID_EPREUVE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ATHLETE", referencedColumnName = "ID"))
	private Set<Athlete> athletes = new HashSet<>();
	
	/** banniereOlympique */
	@ManyToOne
	@JoinColumn(name="ID_BO")
	private BanniereOlympique banniereOlympique;
	
	/**Constructeur (utilisé par Hibernate)
	 *
	 * 
	 */
	public Equipe() {

	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nom=" + nom + ", banniereOlympique=" + banniereOlympique + "]";
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

	/**Getter banniereOlympique
	 * 
	 * @return BanniereOlympique banniereOlympique
	 */
	public BanniereOlympique getBanniereOlympique() {
		return banniereOlympique;
	}

	/** Setter banniereOlympique
	 * 
	 * @param banniereOlympique the banniereOlympique to set (type BanniereOlympique)
	 */
	public void setBanniereOlympique(BanniereOlympique banniereOlympique) {
		this.banniereOlympique = banniereOlympique;
	}

	
}
