package Partie1;

public class Simulation {

	public static void main(String[] args)
	{
		VerificateurJouet Ahmed=new VerificateurJouet("Ahmed");
		VerificateurJouet Amine=new VerificateurJouet("Amine");
		
		new Thread(Ahmed).start();
		new Thread(Amine).start();
		

	}
	
}
