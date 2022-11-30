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

	Gold("Gold"), 
	Silver("Silver"), 
	Bronze("Bronze"),
	NA("NA");

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
	
//	/* Afficher la couleur */
//	public static String afficheCouleur(String label) {
//		label = label.substring(0, 1).toUpperCase() + label.substring(1).toLowerCase();
//		if (label.equals("Or")) {
//			return label;
//		} else if (label.equals("Argent")){
//			return label;
//		}else if (label.equals("Bronze")){
//			return label;
//		}
//		return "Couleur non conforme : " + label + " non attendu";
//	}
}
