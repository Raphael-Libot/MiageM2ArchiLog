package loader;

public class DescripteurPluginComportement extends DescripteurPlugin {

	private String methode;
	
	public DescripteurPluginComportement(String nom, String nomC, String implI, String methode) {
		super(nom, nomC, implI);
		this.methode = methode;
	}

	public String getMethode() {
		return methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}

}
