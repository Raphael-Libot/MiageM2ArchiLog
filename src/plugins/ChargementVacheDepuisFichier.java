package plugins;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import application.IChargeurVache;

/**
 * Classe de création d un objet vache a partir d un fichier de properties
 *
 */
public class ChargementVacheDepuisFichier implements IChargeurVache {

	public Object chargementVache() {
		File fileReader = new File("vaches.txt");
		Properties properties = new Properties();
		Object vache = null;
		try {
			//chargement du fichier de donnees
			properties.load(new FileInputStream(fileReader));
			
			//recuperation de la classe vache
			Class<?> cl = Class.forName(properties.get("class").toString());
			
			//nouvelle instance vide
			vache = cl.newInstance();

			// recuperation du constructeur de la classe vache
			 Constructor<?> constructeur = vache.getClass().getConstructor(String.class, int.class, String.class, String.class,
					 boolean.class,boolean.class,boolean.class,boolean.class,boolean.class);

			// constrction de la vache
			vache = constructeur.newInstance( //
					properties.get("nom").toString(), //
					Integer.valueOf((String) properties.get("age")), //
					properties.get("type").toString(), //
					properties.get("race").toString(), //
					Boolean.valueOf((String) properties.get("amange")), //
					Boolean.valueOf((String) properties.get("abu")), //
					Boolean.valueOf((String) properties.get("ajouee")), //
					Boolean.valueOf((String) properties.get("adormi")), //
					Boolean.valueOf((String) properties.get("acourue")) //
			);

		} catch (NoSuchMethodException | IOException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return vache;
	}

}
