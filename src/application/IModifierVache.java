package application;

/**
 * Interface que doit implmenter la classe de modification
 *
 */
public interface IModifierVache {
	
	public Vache modifier(Vache vache, String attribut, String nouveauNom);
	
}
