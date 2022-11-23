/**
 * TraductionBO.java
 */
package fr.diginamic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente la traduction de la banniere olympique avec tous ses attributs
 * 
 * @author CaroleTOULORGE
 *
 */

@Entity
@Table(name = "TRADUCTIONBO")
public class TraductionBO {

	@Id
	@Column(name ="codeLangue", length = 10, nullable = false)
	private String codeLangue;
	
	@Column(name ="traduction", length = 500)
	private String traduction;
	
	/** banniereOlympique */
	@ManyToOne
	@JoinColumn(name="ID_BO")
	private BanniereOlympique banniereOlympique;

	/**Constructeur (utilisé par Hibernate)
	 *
	 */
	public TraductionBO() {
		
	}

	@Override
	public String toString() {
		return "TraductionBO [codeLangue=" + codeLangue + ", traduction=" + traduction + ", banniereOlympique="
				+ banniereOlympique + "]";
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
