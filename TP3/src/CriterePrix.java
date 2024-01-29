import java.io.Serializable;

public class CriterePrix implements Critere , Serializable {
    public int prix;
    public CriterePrix(int _prix) {
        this.prix = _prix;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        if (v.prix <= this.prix)
        	 return true;
        return false;
    }
}
