package application;

import loader.DefaultWindows;

/**
 * Inteface que doivent implmenter les afficheurs
 *
 */
public interface IAfficheur {
	
	public void afficher(final Vache vache, final DefaultWindows fenetre);
	

}
