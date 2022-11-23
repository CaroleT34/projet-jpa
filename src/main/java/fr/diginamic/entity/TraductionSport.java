/**
 * TraductionSport.java
 */
package fr.diginamic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente la traduction des sports avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "TRADUCTIONSPORT")
public class TraductionSport {

	@Id
	@Column(name ="codeLangue", length = 10, nullable = false)
	private String codeLangue;
	
	@Column(name ="traduction", length = 500)
	private String traduction;
	
	/** sport */
	@ManyToOne
	@JoinColumn(name="ID_SPORT")
	private Sport sport;
	
	/**Constructeur (utilisé par Hibernate)
	 *
	 */
	public TraductionSport() {
		
	}

	@Override
	public String toString() {
		return "TraductionSport [codeLangue=" + codeLangue + ", traduction=" + traduction + ", sport=" + sport + "]";
	}

	/**Getter codeLangue
	 * 
	 * @return String codeLangue
	 */
	public String getCodeLangue() {
		return codeLangue;
	}

	/** Setter codeLangue
	 * 
	 * @param codeLangue the codeLangue to set (type String)
	 */
	public void setCodeLangue(String codeLangue) {
		this.codeLangue = codeLangue;
	}

	/**Getter traduction
	 * 
	 * @return String traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/** Setter traduction
	 * 
	 * @param traduction the traduction to set (type String)
	 */
	public void setTraduction(String traduction) {
		this.traduction = traduction;
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
	
}
