package Partie3;

import java.util.Random;

public class Jouet {
	private int matricule;
	private boolean etat;
	public Jouet(int matricule) {
		this.matricule=matricule;
		this.etat=false;
	}
	public boolean getEtat()
	{
		return this.etat;
	}
	public void setEtat()
	{
		 this.etat=true;
	}
	public void  tuEsVerifiePar(VerificateurJouet verificateurJouet)
	{
		if(!this.etat)
		{
			System.out.println("Verificateur "+verificateurJouet.nom+" commence à  vérifier le jouet  "+ matricule);
			try {
				   Random random = new Random();
		            int delai = random.nextInt(1000);
		            Thread.sleep(delai);
				}
			catch(InterruptedException e) {};
	        System.out.println(verificateurJouet.nom + " a fini de vérifier le jouet " + matricule);
	        this.setEtat();
		}
	

	}

}
