package C_2014;
import java.util.Collections;
import java.util.Vector;

public class Personnel {
	Vector<Employe> employees=new Vector();
	public Personnel() {
	}
	public void ajouterEmploye(Employe E)
	{
		this.employees.add(E);
	}
	public void afficherSalaire()
	{
		for(Employe e:employees)
		{
			System.out.print(e.calculerSalaire()+"\t");
		}
	}
	public double salaireMoyen()
	{
		double sum=0;
		for(Employe e:employees)
		{
			sum+=e.calculerSalaire();
		}
		return sum/employees.size();
	}
	
	public void affichageTrieParSalaire()
	  {
		  Collections.sort(employees);
		  for(Employe e:employees)
			{
				System.out.println(e.getNom()+",salaire : "+e.calculerSalaire());
			}
	  }

}
