package loader;

public class DescripteurPlugin {
	
    private String nomClasse;
    private String implementedInterface;

    public DescripteurPlugin(String nomC, String implI) {
        this.nomClasse = nomC;
        this.implementedInterface = implI;
    }

    public String getImplementedInterface(){
    	return implementedInterface;
    }
    
    public String getNomClasse() {
        return nomClasse;
    }
}
