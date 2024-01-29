package C_2014;

public class Represtant extends Employe {
	private double ca;
	public Represtant(String _nom,String _prenom,int _age,String _date,double ca) {
		super(_nom,_prenom,_age,_date);
		this.ca=ca;
	}
	
	public String getNom()
	{
		return "Represtant : "+nom+prenom;
	}
	
	@Override
	public double calculerSalaire()
	{
		return 0.2*this.ca+1200;
	}

}
