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
		return vache.toString();
	};
	
}
