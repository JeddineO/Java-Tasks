package C_2019;

public abstract class Document {
	public static int num=0;
	protected  int n;
	protected String auteur;
	protected String titre;
	public Document(String auteur,String titre) {
		num++;
		this.n=num;
		this.auteur=auteur;
		this.titre=titre;
	}
	@Override
	public String toString()
	{
		return "Titre :"+this.titre+",Auteur"+this.auteur;
	}

}
