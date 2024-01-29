package C_2019;

public class Livre extends Document {
	private int nbrPages;

	public Livre(String auteur,String titre,int nbrPages) {
		super(auteur,titre);
		this.nbrPages=nbrPages;
	}
	
	@Override
	public String toString()
	{
		return "Num : "+this.n+", Titre :"+this.titre+",Auteur :"+this.auteur+",Nombre Pages :"+this.nbrPages;
	}

}
