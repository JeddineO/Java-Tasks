package Partie3;

public class VerificateurJouet implements Runnable {
	
	protected String nom;
	public VerificateurJouet(String _nom) {
		this.nom=_nom;
	}
	
	@Override
	public void run() {
		for(Jouet jouet:Simulation.jouets)
		{
			synchronized(jouet)
			{
				jouet.tuEsVerifiePar(this);
			}
		}
			
	}
	


}
