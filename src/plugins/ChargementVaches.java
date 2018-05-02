package plugins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ChargementVaches {
	
	public static Object chargementVaches() throws FileNotFoundException {
		File fileReader = new File("vaches.txt");
		Properties properties = new Properties();
		Object vache = null;
		try {
			properties.load(new FileInputStream(fileReader));
			Class<?> cl = Class.forName(properties.get("class").toString());
			vache = cl.newInstance();
			Method[] vacheMethods = cl.getMethods();
			for(Method method : vacheMethods) {
				switch(method.getName()) {
					case "setNom" : method.invoke(vache, properties.get("nom").toString());
						break;
					case "setAge" : method.invoke(vache, Integer.valueOf((String) properties.get("age")));
						break;
					case "setType" : method.invoke(vache, properties.get("type").toString());
						break;
					case "setRace" : method.invoke(vache, properties.get("race").toString());
						break;
					case "setNourri" : method.invoke(vache, Boolean.valueOf((String) properties.get("nourri")));
						break;
					default:
						break;
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vache;
	}

}
