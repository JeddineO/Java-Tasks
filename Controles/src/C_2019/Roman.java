package C_2019;

public class Roman extends Document {
	private double prix;
	public Roman(String auteur,String titre,double prix) {
		super(auteur,titre);
		this.prix=prix;
	}
	
	@Override
	public String toString()
	{
		return "Num : "+this.n+", Titre :"+this.titre+",Auteur :"+this.auteur+",Prix :"+this.prix;
	}
	

}
