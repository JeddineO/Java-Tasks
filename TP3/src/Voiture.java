import java.io.Serializable;

public class Voiture implements Serializable {
	static int iter;
	public int matricule;
	public String marque;
	public String modele;
	public int annee;
	public int prix;
	
	
	
	public Voiture(String marque, String modele, int annee, int prix) {
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.prix = prix;
		this.iter++;
		this.matricule=iter;
	}

	public boolean equals(Voiture v)
	{
		if(v.marque.equals(marque) && v.modele.equals(modele) && v.annee==annee && v.prix==prix)
			return true;
		return false;
	}
	
	public String toString()
	{
		return "Marque : "+marque+" | Model :"+modele+" | Année : "+annee+" | Prix :"+prix+" | Mtricule :"+matricule;
	}

}
