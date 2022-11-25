/**
 * Sexe.java
 */
package fr.diginamic.enumeration;

/**
 * Enumération identités sexuelles possibles (utilisé pour la classe athlète)
 * 
 * @author CaroleTOULORGE
 *
 */
public enum Sexe {

	F("F"), 
	M("M");

	private String label;
	
	/**Constructeur
	 *
	 * @param label 
	 */
	Sexe(String label) {
		this.label = label;
	}
	/**Getter label
	 * 
	 * @return String label
	 */
	public String getLabel() {
		return label;
	}
	
	/* Afficher sexe */
	public static String afficheSexe(String label) {
		label = label.substring(0, 1).toUpperCase() + label.substring(1).toLowerCase();
		if (label.equals("F")) {
			return label;
		} else if (label.equals("M")){
			return label;
		}
		return "Identité sexuelle non conforme : " + label + " non attendu";
	}
}
