package plugins;

import application.Application;
import application.IAfficheur;
import application.Vache;

/**
 * Afficheur d une vache en ascii
 *
 */
public class VacheAfficheur implements IAfficheur{
	@Override
	public void afficher(Vache vache, Application fenetre) {
		
		if(vache != null){
			fenetre.afficherText( 
		"             (__)  \n" +
		"             (oo)  \n" +
		"      /-------\\/   \n" +
		"     / |     ||    \n" + 
		"    *  ||----||    \n" +
		"       ^^    ^^    \n");
		} else {
			fenetre.afficherText("Vous n'avez pas chargé de vache");
		}
	}
}