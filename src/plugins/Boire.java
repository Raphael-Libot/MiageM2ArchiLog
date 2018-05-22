package plugins;

import application.Application;
import application.IComportement;
import application.Vache;

public class Boire implements IComportement{

	@Override
	public void agir(Vache vache, Application fenetre) {
		vache.setAbu(true);
		fenetre.afficherText("la vache a bu");
	}

}
