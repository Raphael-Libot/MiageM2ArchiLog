package application;

/**
 * Objet metier de l'application
 *
 */
public class Vache {

	private String nom;

	private int age;

	private String race;

	private String type;

	private boolean amange;

	private boolean abu;

	private boolean ajouee;

	private boolean adormi;

	private boolean acourue;

	public Vache() {
	}

	public Vache(String nom, int age, String race, String type, boolean amange, boolean abu, boolean ajouee,
			boolean adormi, boolean acourue) {
		this.nom = nom;
		this.age = age;
		this.race = race;
		this.type = type;
		this.amange = amange;
		this.abu = abu;
		this.ajouee = ajouee;
		this.adormi = adormi;
		this.acourue = acourue;
	}

	@Override
	public String toString() {
		return "Vache [nom=" + nom + ", age=" + age + ", race=" + race + ", type=" + type + ", a mange=" + amange
				+ ", a bu=" + abu + ", a jouee=" + ajouee + ", a dormi=" + adormi + ", a courue=" + acourue + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getAmange() {
		return amange;
	}

	public void setAmange(boolean amange) {
		this.amange = amange;
	}

	public boolean getAbu() {
		return abu;
	}

	public void setAbu(boolean abu) {
		this.abu = abu;
	}

	public boolean getAjouee() {
		return ajouee;
	}

	public void setAjouee(boolean ajouee) {
		this.ajouee = ajouee;
	}

	public boolean getAdormi() {
		return adormi;
	}

	public void setAdormi(boolean adormi) {
		this.adormi = adormi;
	}

	public boolean getAcourue() {
		return acourue;
	}

	public void setAcourue(boolean acourue) {
		this.acourue = acourue;
	}

}
