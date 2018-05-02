package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import application.Vache;
import plugins.ChargementVaches;

public class Loader {
	
	private static List<DescripteurPlugin> listDescriptionPlugin = new ArrayList<>();
	
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, FileNotFoundException, IOException {

		listDescriptionPlugin = chargementPlugins();
		Vache vache = (Vache) ChargementVaches.chargementVaches();
		System.out.println(vache.toString());
		
		System.out.println(listDescriptionPlugin.get(0).getNomClasse());
		System.out.println(listDescriptionPlugin.get(1).getNomClasse());

    }
	
	private static List<DescripteurPlugin> chargementPlugins() throws FileNotFoundException, IOException{
		List<DescripteurPlugin> listePLugin = new ArrayList<>();
		File dossierPlugin = new File(System.getProperty("user.dir") + File.separator + "Plugins");
		File[] listeFichierPlugin = dossierPlugin.listFiles();
		for(File fichier : listeFichierPlugin){
			Properties properties = new Properties();
			properties.load(new FileInputStream(fichier.getAbsolutePath()));
			listePLugin.add(new DescripteurPlugin(properties.getProperty("class")));
		}
		return listePLugin;
	}
}
