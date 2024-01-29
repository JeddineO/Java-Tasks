package C_2014;

public abstract class Employe implements Comparable<Employe>  {
	
	protected String nom;
	protected String prenom;
	private int age;
	private String date;

	public Employe(String _nom,String _prenom,int _age,String _date) {
		this.nom=_nom;
		this.prenom=_prenom;
		this.age=_age;
		this.date=_date;
	}
	
	public String getNom()
	{
		return "l'employe"+nom+" "+prenom;
	}
	
	abstract double calculerSalaire();
	
	
	  @Override
	    public int compareTo(Employe emp) {
	        return (int) (this.calculerSalaire()-emp.calculerSalaire());
	    }
	  
	  


}
