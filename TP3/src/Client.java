import java.io.Serializable;

public class Client implements Comparable<Client>,Serializable {
	 String nom;
	private String prenom;
	private String cin;
	private String civilte;
	public Client(String nom, String prenom, String cin, String civilte) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.civilte = civilte;
	}
	@Override
	public String toString() {
		return "Nom=" + nom + ", Prenom=" + prenom + ", Cin=" + cin + ", Civilte=" + civilte ;
	}
	@Override
	public int compareTo(Client o) {

		return this.nom.compareTo(o.nom);
	}

	

}
