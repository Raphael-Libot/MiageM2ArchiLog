package application;

/**
 * Interface que doit implementer la classe de modification
 *
 */
public interface IModifierVache {
	
	public Vache modifier(Vache vache, String attribut, String nouveauNom);
	
}
