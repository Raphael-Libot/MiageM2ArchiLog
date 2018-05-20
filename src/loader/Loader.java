package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.lang.reflect.Method;

import application.IAfficheur;
import application.IChargeurVache;
import application.IComportement;
import application.IModifierVache;
import application.Vache;
import plugins.DefaultAfficheur;

/**
 * Classe principale de l application
 *
 */
public class Loader {
	
	private static List<DescripteurPlugin> listDescriptionPlugin = new ArrayList<>();
	private static IAfficheur afficheur;
	private static IModifierVache modifieur;
	private static IChargeurVache chargeur;
	private static Loader instance = new Loader();
	private static DefaultWindows fenetre;
	private static Vache vache;
	
	public static Loader getInstance(){
		return instance;
	}
	
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, FileNotFoundException, IOException {

		//cration afficheur par defaut
		afficheur = new DefaultAfficheur();
		
		//chargement de l'ensemble des plugins (fichier .properties)
		listDescriptionPlugin = chargementPlugins();

		//chargement de l interface graphique
		fenetre = new DefaultWindows();
		
		//ajout des l ensemble des boutons pours les plugins 
		for(DescripteurPlugin d : listDescriptionPlugin) {
			fenetre.ajoutBoutonAfficheur(d);
		}
		
		//affichage de l interface
		fenetre.display();
		
		//afficahge de la vacha a l aide de l afficheur par defaut
		fenetre.afficherVache("La vache de votre application n'est pas chargée");

    }
	
	public static void charger(String nom) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		for(DescripteurPlugin d : listDescriptionPlugin) {
			if(d.getNomClasse().equals(nom)){
				chargeur = (IChargeurVache) Class.forName(d.getNomClasse()).newInstance();
				vache = (Vache) chargeur.chargementVache();
				fenetre.afficherVache(afficheur.afficher(vache));
			}
		}
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
		if(vache != null) {
			//parcour de l'ensemble des descipteurs
			for(DescripteurPlugin d : listDescriptionPlugin) {
				
				// descripteur que nous voulons utiliser, attribut a modifier
				if(d.getNomClasse().equals(nomClasse) && ((DescripteurPluginModifier) d).getAttAModifier() == Attribut){
					
					//recupration du modifieur de donnees de la vache
					modifieur = (IModifierVache) Class.forName(d.getNomClasse()).newInstance();
					
					try {
						//affichage de la modification des donnes
						fenetre.modifierVache(
								
								//modification des donnes
								modifieur.modifier(vache, ((DescripteurPluginModifier) d).getAttAModifier(), nomVache),
								
								//attribut qui a ete modifie
								((DescripteurPluginModifier) d).getAttAModifier()
								
								);
						
					} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
							| SecurityException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			fenetre.afficherVache(afficheur.afficher(vache));
		}
	}
	
	public static void comportement(String nomClasse, String nomMethode) {

		IComportement comportement;
		Method methode;

		if (vache != null) {
			for (DescripteurPlugin d : listDescriptionPlugin) {
				if (d.getNomClasse().equals(nomClasse) && ((DescripteurPluginComportement) d).getMethode() == nomMethode) {
					try {
						comportement = (IComportement) Class.forName(d.getNomClasse()).newInstance();
						methode = comportement.getClass().getMethod(((DescripteurPluginComportement) d).getMethode(),Vache.class);
						fenetre.afficherText((String) methode.invoke(comportement, vache));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException | ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			fenetre.afficherVache(afficheur.afficher(vache));
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
			case "IChargeurVache" : 
				listePLugin.add(new DescripteurPlugin(properties.getProperty("nom"), properties.getProperty("class"), properties.getProperty("interface")));
				break;
			case "IModifierVache" : 
				listePLugin.add(new DescripteurPluginModifier(properties.getProperty("nom"), properties.getProperty("class"), properties.getProperty("interface"), properties.getProperty("attribut")));
				break;
			case "IComportement" :
				listePLugin.add(new DescripteurPluginComportement(properties.getProperty("nom"), properties.getProperty("class"), properties.getProperty("interface"), properties.getProperty("methode")));  
			default:
				break;
		}
		}
		return listePLugin;
	}
}
