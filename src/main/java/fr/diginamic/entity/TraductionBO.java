/**
 * TraductionBO.java
 */
package fr.diginamic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeLangue;
	
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

	/**Constructeur
	 *
	 * @param traduction
	 * @param banniereOlympique
	 */
	public TraductionBO(String traduction) {
		super();
		this.traduction = traduction;
	}



	@Override
	public String toString() {
		return "TraductionBO [traduction=" + traduction + ", banniereOlympique="
				+ banniereOlympique + "]";
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
