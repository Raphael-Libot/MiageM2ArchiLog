package plugins;

import application.Application;
import application.IAfficheur;
import application.Vache;

/**
 * Afficheur basique
 *
 */
public class DefaultAfficheur implements IAfficheur{

	@Override
	public void afficher(Vache vache, Application fenetre) {
		if(vache!=null) {
			fenetre.afficherText(vache.toString());
		}else{
			fenetre.afficherText("Vous n'avez pas chargé de vache");
		}
	};
	
}
