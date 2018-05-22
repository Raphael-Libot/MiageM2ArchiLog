package plugins;

import application.Application;
import application.IComportement;
import application.Vache;

public class Mange implements IComportement{

	@Override
	public void agir(Vache vache, Application fenetre) {
		vache.setAmange(true);
		vache.setAbu(false);
		fenetre.afficherText("la vache est en train de manger. Ne pas oublier de la faire boire :-D ");
	}

}
