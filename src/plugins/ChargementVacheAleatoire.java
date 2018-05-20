package plugins;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import application.IChargeurVache;
import application.Vache;

public class ChargementVacheAleatoire implements IChargeurVache {

	public Vache chargementVache() {
		List<String> listeNom = new ArrayList<String>();
		listeNom.add("Rose");
		listeNom.add("Azalée");
		listeNom.add("Paquerette");
		listeNom.add("Princesse");
		listeNom.add("Marguerite");
		
		List<String> listeRace = new ArrayList<String>();
		listeRace.add("Aubrac");
		listeRace.add("Charolaise");
		listeRace.add("Tarentaise");
		listeRace.add("Aberdeen Angus");
		listeRace.add("Holstein");
		
		List<String> listeType = new ArrayList<String>();
		listeType.add("Laitière");
		listeType.add("A viande");
		
		return new Vache( 
				listeNom.get(ThreadLocalRandom.current().nextInt(0, 4 + 1)), 
				ThreadLocalRandom.current().nextInt(1, 22 + 1),
				listeRace.get(ThreadLocalRandom.current().nextInt(0, 4 + 1)),
				listeType.get(ThreadLocalRandom.current().nextInt(0, 1 + 1)),
				false,
				true,
				true,
				false,
				true);
	}

}
