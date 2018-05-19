package plugins;

import application.IAfficheur;
import application.Vache;

/**
 * Afficheur basique
 *
 */
public class DefaultAfficheur implements IAfficheur{

	@Override
	public String afficher(Vache vache) {
		if(vache!=null) {
			return vache.toString();
		}else{
			return "Vous n'avez pas chargé de vache";
		}
	};
	
}
