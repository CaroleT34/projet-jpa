/**
 * Couleur.java
 */
package fr.diginamic.enumeration;

/**
 * Enumération des couleurs possibles (utilisé pour la classe médaille)
 * 
 * @author CaroleTOULORGE
 *
 */
public enum Couleur {

	OR("Or"), 
	ARGENT("Argent"), 
	BRONZE("Bronze");

	private String label;
	
	/**Constructeur
	 *
	 * @param label 
	 */
	Couleur(String label) {
		this.label = label;
	}
	/**Getter label
	 * 
	 * @return String label
	 */
	public String getLabel() {
		return label;
	}
}
