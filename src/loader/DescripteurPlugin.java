package loader;

/**
 * Descripteur des plugins simples
 *
 */
public class DescripteurPlugin {
	
	private String nom;
    private String nomClasse;
    private String implementedInterface;
    private String attrEnPlus;

    public DescripteurPlugin(String nom, String nomC, String implI) {
    	this.nom = nom;
        this.nomClasse = nomC;
        this.implementedInterface = implI;
    }

    public DescripteurPlugin(String nom, String nomClasse, String implementedInterface, String attrEnPlus) {
		super();
		this.nom = nom;
		this.nomClasse = nomClasse;
		this.implementedInterface = implementedInterface;
		this.attrEnPlus = attrEnPlus;
	}

	public String getAttrEnPlus() {
		return attrEnPlus;
	}

	public void setAttrEnPlus(String attrEnPlus) {
		this.attrEnPlus = attrEnPlus;
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
