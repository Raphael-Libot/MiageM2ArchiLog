package application;

public class Vache {

	private String nom;

	private int age;

	private String race;

	private String type;
	
	private boolean nourri;

	public Vache(String nom, int age, String race, String type, boolean nourri) {
		super();
		this.nom = nom;
		this.age = age;
		this.race = race;
		this.type = type;
		this.nourri = nourri;
	}
	
	@Override
	public String toString() {
		return "Vache [nom=" + nom + ", age=" + age + ", race=" + race + ", type=" + type + ", nourri=" + nourri + "]";
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

	public boolean isNourri() {
		return nourri;
	}

	public void setNourri(boolean nourri) {
		this.nourri = nourri;
	}
	
	

}
