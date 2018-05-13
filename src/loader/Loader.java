package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import application.IAfficheur;
import application.IModifierVache;
import application.Vache;
import plugins.ChargementVaches;
import plugins.DefaultAfficheur;
import plugins.DefaultWindows;


public class Loader {
	
	private static List<DescripteurPlugin> listDescriptionPlugin = new ArrayList<>();
	private static IAfficheur afficheur;
	private static IModifierVache modifieur;
	private static Loader instance = new Loader();
	private static DefaultWindows fenetre;
	private static Vache vache;
	
	public static Loader getInstance(){
		return instance;
	}
	
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, FileNotFoundException, IOException {

		afficheur = new DefaultAfficheur();
		
		listDescriptionPlugin = chargementPlugins();
		vache = (Vache) ChargementVaches.chargementVaches();
		System.out.println(vache.toString());
		
		fenetre = new DefaultWindows();
		
		for(DescripteurPlugin d : listDescriptionPlugin) {
			fenetre.ajoutBoutonAfficheur(d);
		}
		
		fenetre.display();
		
		fenetre.afficherVache(afficheur.afficher(vache));
		

    }
	
	
	public static void changementAfficheur(String nom) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		for(DescripteurPlugin d : listDescriptionPlugin) {
			if(d.getNomClasse().equals(nom)){
				afficheur = (IAfficheur) Class.forName(d.getNomClasse()).newInstance();
				fenetre.afficherVache(afficheur.afficher(vache));
			}
		}
	}
	
	public static void modifierVache(String nomClasse, String Attribut, String nomVache) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		for(DescripteurPlugin d : listDescriptionPlugin) {
			if(d.getNomClasse().equals(nomClasse) && ((DescripteurPluginModifier) d).getAttAModifier() == Attribut){
				modifieur = (IModifierVache) Class.forName(d.getNomClasse()).newInstance();
				fenetre.modifierVache(modifieur.modifier(vache, ((DescripteurPluginModifier) d).getAttAModifier(), nomVache));
			}
		}
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
			
			switch(properties.getProperty("interface")) {
			case "IAfficheur" : 
				listePLugin.add(new DescripteurPlugin(properties.getProperty("nom"), properties.getProperty("class"), properties.getProperty("interface")));
				break;
			case "IModifierVache" : 
				listePLugin.add(new DescripteurPluginModifier(properties.getProperty("nom"), properties.getProperty("class"), properties.getProperty("interface"), properties.getProperty("attribut")));
				break;
			default:
				break;
		}
			
			
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
				listePLugin.add(new DescripteurPlugin(properties.getProperty("nom"), properties.getProperty("class"), properties.getProperty("interface")));
			}
		}
		return null;
	}

	public static IAfficheur getAfficheur() {
		return afficheur;
	}


	
}
