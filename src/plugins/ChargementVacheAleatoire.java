package plugins;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import application.IChargeurVache;

/**
 * Classe d'un plugin de création de vache
 * 
 */
public class ChargementVacheAleatoire implements IChargeurVache {

	public Object chargementVache() {
		
		Object vache = null;
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
		
		//recuperation de la classe vache
		Class<?> cl;
		try {
			cl = Class.forName("application.Vache");
			
			//nouvelle instance vide
			vache = cl.newInstance();

			// recuperation du constructeur de la classe vache
			 Constructor<?> constructeur = vache.getClass().getConstructor(String.class, int.class, String.class, String.class,
					 boolean.class,boolean.class,boolean.class,boolean.class,boolean.class);

			// constrction de la vache
			vache = constructeur.newInstance( //
					listeNom.get(ThreadLocalRandom.current().nextInt(0, 4 + 1)), 
					ThreadLocalRandom.current().nextInt(1, 22 + 1),
					listeRace.get(ThreadLocalRandom.current().nextInt(0, 4 + 1)),
					listeType.get(ThreadLocalRandom.current().nextInt(0, 1 + 1)),
					false,
					true,
					true,
					false,
					true);
			
		} catch (NoSuchMethodException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return vache;	
	}

}
