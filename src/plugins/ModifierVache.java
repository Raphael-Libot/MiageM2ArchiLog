package plugins;

import application.IModifierVache;
import application.Vache;

public class ModifierVache implements IModifierVache {
	
	@Override
	public Vache modifierNom(Vache vache, String nouveauNom) {
		vache.setNom(nouveauNom);
		return vache;
	}

}
