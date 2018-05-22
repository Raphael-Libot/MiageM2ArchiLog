package plugins;

import application.IAfficheur;
import application.Vache;
import loader.DefaultWindows;

/**
 * Afficheur basique
 *
 */
public class DefaultAfficheur implements IAfficheur{

	@Override
	public void afficher(Vache vache, DefaultWindows fenetre) {
		if(vache!=null) {
			fenetre.afficherText(vache.toString());
		}else{
			fenetre.afficherText("Vous n'avez pas chargé de vache");
		}
	};
	
}
