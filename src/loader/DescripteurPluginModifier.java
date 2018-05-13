package loader;

/**
 * Descripteur des plugins permettant la modification
 * Presence de l attribut de la vache qui sera modifie par le plugin
 *
 */
public class DescripteurPluginModifier extends DescripteurPlugin {

	private String AttAModifier;
	
	public DescripteurPluginModifier(String nom, String nomC, String implI, String attAmodifier) {
		super(nom, nomC, implI);
		this.AttAModifier = attAmodifier;
	}

	public String getAttAModifier() {
		return AttAModifier;
	}

	public void setAttAModifier(String attAModifier) {
		AttAModifier = attAModifier;
	}	

}
