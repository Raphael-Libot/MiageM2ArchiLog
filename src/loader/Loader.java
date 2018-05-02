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

import plugins.DefaultWindows;


public class Loader {
	
	private static List<DescripteurPlugin> listDescriptionPlugin = new ArrayList<>();
	
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, FileNotFoundException, IOException {

		listDescriptionPlugin = chargementPlugins();
		Vache vache = (Vache) ChargementVaches.chargementVaches();
		System.out.println(vache.toString());
		
		DefaultWindows fenetre = new DefaultWindows();
		fenetre.display();

    }
	
	/**
	 * Chargement de l'ensemble de des plugins 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static List<DescripteurPlugin> chargementPlugins() throws FileNotFoundException, IOException{
		List<DescripteurPlugin> listePLugin = new ArrayList<>();
		File dossierPlugin = new File(System.getProperty("user.dir") + File.separator + "Plugins");
		File[] listeFichierPlugin = dossierPlugin.listFiles();
		for(File fichier : listeFichierPlugin){
			Properties properties = new Properties();
			properties.load(new FileInputStream(fichier.getAbsolutePath()));
			listePLugin.add(new DescripteurPlugin(properties.getProperty("class"), properties.getProperty("interface")));
		}
		return listePLugin;
	}

	
	/**
	 * Permet le chargement des plugins d'un type donné soécifique
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static List<DescripteurPlugin> loadPluginsType(Class<?> clas) throws FileNotFoundException, IOException{
		List<DescripteurPlugin> listePLugin = new ArrayList<>();
		File dossierPlugin = new File(System.getProperty("user.dir") + File.separator + "Plugins");
		File[] listeFichierPlugin = dossierPlugin.listFiles();
		for(File fichier : listeFichierPlugin){
			Properties properties = new Properties();
			properties.load(new FileInputStream(fichier.getAbsolutePath()));
			// TO-DO pour le moement c'est merdique mais c'est temporaire, car la je check le nom de la class mais c'est plus le type 
			if(properties.getProperty("interface").equals(clas.getName())){
				listePLugin.add(new DescripteurPlugin(properties.getProperty("class"), properties.getProperty("interface")));
			}
		}
		return null;
	}


}
