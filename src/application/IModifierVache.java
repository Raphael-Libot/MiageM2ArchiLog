package application;

/**
 * Interface à implémenter dans le but de rajouter un pluging de modification (un plugin de modification generique est deja present dans l'app)
 */
public interface IModifierVache {
	
	public Vache modifier(Vache vache, String attribut, String nouveauNom);
	
}
