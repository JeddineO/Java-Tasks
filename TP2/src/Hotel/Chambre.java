package Hotel;

public class Chambre {
	public int nc;
	public int prix;
	public int capacite;
	public String etat;
	public int categorie;

	public Chambre(int _nc,int _prix,int _cap,int _cat) {
		this.nc=_nc;
		this.categorie=_cat;
		setPrix(_prix);
		setCapacite(_cap);
		this.etat="L";
	}
	
	public Chambre() {
		this.etat="L";
	}

	

	public void setPrix(int _prix)
	{
		if(_prix>0)
			this.prix=_prix;
		else
			System.out.println("Le prix doit etre supérieur à 0");
	}
	public void setCapacite(int a)
	{
		if(a>=1 && a<=4)
		{
			this.capacite=a;
		}	
		else
		{
			System.out.println("La capacité doit etre entre 1 et 4");
		}
			
	}

	@Override
	public String toString() {
		return "Chambre :" + nc + ", prix=" + prix + "MAD, capacite=" + capacite + ", etat=" + etat + ", catégorie="+categorie+"\n";
	}
	
	

}
