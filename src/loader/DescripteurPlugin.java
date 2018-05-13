package loader;

/**
 * Descripteur des plugins simples
 *
 */
public class DescripteurPlugin {
	
	private String nom;
    private String nomClasse;
    private String implementedInterface;

    public DescripteurPlugin(String nom, String nomC, String implI) {
    	this.nom = nom;
        this.nomClasse = nomC;
        this.implementedInterface = implI;
    }

    public String getImplementedInterface(){
    	return implementedInterface;
    }
    
    public String getNomClasse() {
        return nomClasse;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public void setImplementedInterface(String implementedInterface) {
		this.implementedInterface = implementedInterface;
	}
    
    
}
