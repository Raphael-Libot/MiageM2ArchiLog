package plugins;

import application.Application;
import application.IAfficheur;
import application.Vache;

/**
 * Afficheur plus develope
 *
 */
public class SimpleCustomAfficheur implements IAfficheur {

	@Override
	public void afficher(Vache vache, Application fenetre) {
		if(vache!=null) {
			fenetre.afficherText("Je suis une vache, mes informations sont les suivantes : \n" + vache.toString());
		} else {
			fenetre.afficherText("Vous n'avez pas chargé de vache");
		}
	}

}
