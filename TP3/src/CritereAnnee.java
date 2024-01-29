
public class CritereAnnee implements Critere{
	private int annee;
	public CritereAnnee(int _annee) {
		this.annee=_annee;
	}
	 @Override
	    public boolean estSatisfaitPar(Voiture v) {
	        return (v.annee == this.annee);
	}

}
