package fr.diginamic.enumeration;

/**
 * Enumération des saisons (utilisé pour la classe PaysOrganisteur)
 * 
 * @author CaroleTOULORGE
 *
 */
public enum Saison {

	Hiver("Hiver"),
	Printemps("Printemps"),
	Ete("Ete"),
	Automne("Automne");
	
	private String label;
	
	/**Constructeur
	 *
	 * @param label 
	 */
	private Saison(String label) {
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
	public static String afficheSaison(String label) {
		label = label.substring(0, 1).toUpperCase() + label.substring(1).toLowerCase();
		if (label.equals("Hiver")) {
			return label;
		} else if (label.equals("Printemps")){
			return label;
		}else if (label.equals("Ete")){
			return label;
		}else if (label.equals("Automne")){
			return label;
		}
		return "Saison non conforme : " + label + " non attendu";
	}
	

	
}
