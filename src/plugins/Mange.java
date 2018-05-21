package plugins;

import application.IComportement;
import application.Vache;

public class Mange implements IComportement{

	@Override
	public String manger(Vache vache) {
		vache.setAmange(true);
		vache.setAbu(false);
		return "la vache est en train de manger. Ne pas oublier de la faire boire :-D ";
	}

	@Override
	public String boire(Vache vache) {
		vache.setAbu(true);
		return "la vache vient de boire";
		
	}

	@Override
	public String dormir(Vache vache) {
		vache.setAdormi(true);
		return "la vache est en train de dormir";

		
	}

	@Override
	public String courir(Vache vache) {
		vache.setAcourue(true);
		vache.setAbu(false);
		return "la vache vient de courir. Ne pas oublier de la faire boire :-D ";
		
	}

	@Override
	public String jouer(Vache vache) {
		vache.setAjouee(true);
		return "la vache vient de jouer";
		
	}

}
