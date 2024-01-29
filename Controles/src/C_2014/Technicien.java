package C_2014;

public class Technicien extends Employe {
	private int nu;
	public Technicien(String _nom,String _prenom,int _age,String _date,int _nu) {
		super(_nom,_prenom,_age,_date);
		this.nu=_nu;
	}
	
	public String getNom()
	{
		return "Technicien: "+nom+prenom;
	}
	
	@Override
	public double calculerSalaire()
	{
		return 5*this.nu;
	}

}
