import java.io.Serializable;

public class CritereMarque implements Critere , Serializable{
	public String marque;
	public CritereMarque(String _marque) {
		this.marque=_marque;
	}

	public boolean estSatisfaitPar(Voiture v) {
        return v.marque.equals(this.marque);
	}

}
