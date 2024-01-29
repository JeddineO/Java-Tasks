package Partie4;



public class VerificateurJouet implements Runnable {

    protected String nom;
    protected int niveau;
    protected int vetisse;

    public VerificateurJouet(String _nom, int _niveau,int _vetisse) {
        this.nom = _nom;
        this.niveau = _niveau;
        this.vetisse=_vetisse;
    }

    @Override
	public void run() {
    	for(Jouet jouet:Simulation.jouets)
		{
			synchronized(jouet)
			{
				try {
					jouet.tuEsVerifiePar(this);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			
	}
}
