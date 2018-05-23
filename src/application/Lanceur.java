package application;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Lanceur {
	
	/**
	 * Main de l'application qui va lancer l'application est afficher la fenetre.
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, FileNotFoundException, IOException {

		//chargement de l interface graphique
		Application fenetre = new Application();
		
		//affichage de l interface
		fenetre.display();
		
		//affichage du message initial 
		fenetre.afficherVache("La vache de votre application n'est pas chargée");

    }
}
