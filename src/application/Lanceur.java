package application;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Lanceur {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, FileNotFoundException, IOException {

		//chargement de l interface graphique
		Application fenetre = new Application();
		
		//affichage de l interface
		fenetre.display();
		
		//afficahge de la vacha a l aide de l afficheur par defaut
		fenetre.afficherVache("La vache de votre application n'est pas chargée");

    }
}
