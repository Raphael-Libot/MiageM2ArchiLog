package plugins;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import application.IModifierVache;
import application.Vache;

public class ModifierVache implements IModifierVache {
	
	@Override
	public Vache modifier(Vache vache, String attribut, String nouveauNom) {
		
		Method setter;
		try {
			setter = vache.getClass().getMethod("set"+attribut.substring(0, 1).toUpperCase() + attribut.substring(1), String.class);
			setter.invoke(vache, nouveauNom);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return vache;
	}

}
