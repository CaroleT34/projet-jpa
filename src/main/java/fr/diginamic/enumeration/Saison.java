package fr.diginamic.enumeration;

/**
 * Enumération des saisons (utilisé pour la classe PaysOrganisteur)
 * 
 * @author CaroleTOULORGE
 *
 */
public enum Saison {

	Winter("Winter"),
	Summer("Summer");
	
	private String label;
	
	/**Constructeur
	 *
	 * @param label 
	 */
	Saison(String label) {
		this.label = label;
	}
	
	/**Getter label
	 * 
	 * @return String label
	 */
	public String getLabel() {
		return label;
	}
	
	/* Afficher la saison */
//	public static String afficheSaison(String label) {
//		label = label.substring(0, 1).toUpperCase() + label.substring(1).toLowerCase();
//		if (label.equals("Winter")) {
//			return label;
//		} else if (label.equals("Summer")){
//			return label;
//		}
//		return "Saison non conforme : " + label + " non attendu";
//	}
	

	
}
