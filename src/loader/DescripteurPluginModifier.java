package loader;

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
