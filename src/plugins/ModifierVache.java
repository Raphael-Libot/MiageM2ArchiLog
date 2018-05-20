package plugins;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import application.IModifierVache;
import application.Vache;

/**
 * Classe generique permettant de gerer l ensemble des plugin de modification
 *
 */
public class ModifierVache implements IModifierVache {

	@Override
	public Vache modifier(Vache vache, String attribut, String nouvelleValeur) {

		Method setter;
		try {

			if ("nom".equals(attribut) || "race".equals(attribut) || "type".equals(attribut)) {

				// recuperation du setter en fonction du descripteur utilise
				setter = vache.getClass().getMethod(
						"set" + attribut.substring(0, 1).toUpperCase() + attribut.substring(1), String.class);
				setter.invoke(vache, nouvelleValeur);
				
			} else if ("age".equals(attribut)) {

				// recuperation du setter en fonction du descripteur utilise
				setter = vache.getClass().getMethod(
						"set" + attribut.substring(0, 1).toUpperCase() + attribut.substring(1), int.class);
				setter.invoke(vache, Integer.valueOf(nouvelleValeur));
				
				
			} else if ("amange".equals(attribut) || "abu".equals(attribut) || "ajouee".equals(attribut) || "adormi".equals(attribut) || "acourue".equals(attribut)) {

				// recuperation du setter en fonction du descripteur utilise
				setter = vache.getClass().getMethod(
						"set" + attribut.substring(0, 1).toUpperCase() + attribut.substring(1), boolean.class);
				setter.invoke(vache, Boolean.parseBoolean(nouvelleValeur));
			}

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return vache;
	}

}
