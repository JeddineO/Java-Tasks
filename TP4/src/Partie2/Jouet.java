package Partie2;

import java.util.Random;

public class Jouet {
	private int matricule;
	public Jouet(int matricule) {
		this.matricule=matricule;
	}
	public void  tuEsVerifiePar(VerificateurJouet V)
	{
		System.out.println("Verificateur "+V.nom+" commence à  vérifier le jouet  "+ matricule);
		try {
			   Random random = new Random();
	            int delai = random.nextInt(1000);
	            Thread.sleep(delai);
			}
		catch(InterruptedException e) {};
        System.out.println(V.nom + " a fini de vérifier le jouet " + matricule);

	}

}
