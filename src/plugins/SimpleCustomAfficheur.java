package plugins;

import application.IAfficheur;
import application.Vache;

/**
 * Afficheur plus develope 
 *
 */
public class SimpleCustomAfficheur implements IAfficheur {

	@Override
	public String afficher(Vache vache) {
		return "Je suis une vache, mes informations sont les suivantes : \n" + vache.toString();
	}

}
