package C_2014;

public class Manutention extends Employe{
	private int nh;
	public Manutention(String _nom,String _prenom,int _age,String _date,int _nh) {
		super(_nom,_prenom,_age,_date);
		this.nh=_nh;
	}
	
	public String getNom()
	{
		return "Manutention : "+nom+prenom;
	}
	
	@Override
	public double calculerSalaire()
	{
		return 90*this.nh;
	}
}
