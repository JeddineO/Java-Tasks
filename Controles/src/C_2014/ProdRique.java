package C_2014;

public class ProdRique extends Technicien implements Risque {

	public ProdRique(String _nom,String _prenom,int _age,String _date,int _nu) {
		super(_nom,_prenom,_age,_date,_nu);
	}
	
	@Override
	public double calculerSalaire()
	{
		return super.calculerSalaire()+prime;
	}

}
