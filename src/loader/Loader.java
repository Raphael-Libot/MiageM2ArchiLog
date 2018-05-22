package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import application.IAfficheur;
import application.IChargeurVache;
import application.IModifierVache;

/**
 * Classe principale de l application
 *
 */
public class Loader {
	
	private static Loader instance = new Loader();
	
	public static Loader getInstance(){
		return instance;
	}
	
	/**
	 * Chargement de l'ensemble de des plugins 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<DescripteurPlugin> chargementPlugins() throws FileNotFoundException, IOException{
		List<DescripteurPlugin> listePLugin = new ArrayList<>();
		File dossierPlugin = new File(System.getProperty("user.dir") + File.separator + "Plugins");
		File[] listeFichierPlugin = dossierPlugin.listFiles();
		for(File fichier : listeFichierPlugin){
			Properties properties = new Properties();
			properties.load(new FileInputStream(fichier.getAbsolutePath()));
			listePLugin.add(new DescripteurPlugin(properties.getProperty("nom"),
					properties.getProperty("class"),
					properties.getProperty("interface"),
					properties.getProperty("attrEnPlus")));
		}
		return listePLugin;
	}
	
	public static Object donnePlugin(DescripteurPlugin d) {
		Object o = null;
		try {
			Class<?> cl = Class.forName(d.getNomClasse());
			o = cl.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return o;
	}
}
