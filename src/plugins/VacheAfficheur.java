package plugins;

import application.IAfficheur;
import application.Vache;

/**
 * Afficheur d une vache en ascii
 *
 */
public class VacheAfficheur implements IAfficheur{
	@Override
	public String afficher(Vache vache) {
		
		if(vache != null){
return 
		"             (__)  \n" +
		"             (oo)  \n" +
		"      /-------\\/   \n" +
		"     / |     ||    \n" + 
		"    *  ||----||    \n" +
		"       ^^    ^^    \n";
		} else {
			return "Vous n'avez pas chargé de vache";
		}
	}
}