package plugins;

import application.IComportement;
import application.Vache;

public class Mange implements IComportement{

	@Override
	public String manger(Vache vache) {
		vache.setAmange(true);
		return "la vache est en train de manger";
	}

	@Override
	public String boire(Vache vache) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String dormir(Vache vache) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String courir(Vache vache) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String jouer(Vache vache) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
