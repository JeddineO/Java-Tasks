package C_2014;

public class RiqueManutention extends Manutention implements Risque {

	public RiqueManutention(String _nom,String _prenom,int _age,String _date,int _nh) {
		super(_nom,_prenom,_age,_date,_nh);
		}

	@Override
	public double calculerSalaire()
	{
		return super.calculerSalaire()+prime;
	}


}
