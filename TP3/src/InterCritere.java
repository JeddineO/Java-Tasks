import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class InterCritere implements Critere, Serializable{
	
	private Set<Critere> lesCriteres =new  HashSet<Critere>();

	public InterCritere() {
	}

	public void addCritere(Critere c)
	{
		lesCriteres.add(c);
	}
	@Override
	public boolean estSatisfaitPar(Voiture v)
	{
		for(Critere c:lesCriteres)
		{
			if(!c.estSatisfaitPar(v))
				return false;
		}
		return true;
	}
}
