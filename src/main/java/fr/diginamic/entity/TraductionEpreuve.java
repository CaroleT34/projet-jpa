/**
 * TraductionEpreuve.java
 */
package fr.diginamic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente la traduction des épreuves avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "TRADUCTIONEPREUVE")
public class TraductionEpreuve {
	
	@Id
	@Column(name ="codeLangue", length = 10, nullable = false)
	private String codeLangue;
	
	@Column(name ="traduction", length = 500)
	private String traduction;
	
	/** epreuve */
	@ManyToOne
	@JoinColumn(name="ID_EPREUVE")
	private Epreuve epreuve;

	/**Constructeur (utilisé par Hibernate)
	 * 
	 */
	public TraductionEpreuve(String codeLangue, String traduction, Sport sport) {
		
	}

	@Override
	public String toString() {
		return "TraductionEpreuve [codeLangue=" + codeLangue + ", traduction=" + traduction + ", epreuve=" + epreuve
				+ "]";
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

}
