package Partie4;

import java.util.Vector;

public class Simulation {
	
	public static Vector<Jouet> jouets;

	
	public static void main(String args[])
	{
		jouets = new Vector();
		for(int i=0;i<9;i++)
			jouets.add(new Jouet(i));
		
		VerificateurJouet Ahmed=new VerificateurJouet("Ahmed",2,40);
		VerificateurJouet Amine=new VerificateurJouet("Amine",2,40);
		VerificateurJouet Bachir=new VerificateurJouet("Bachir",1,20);
		
		new Thread(Ahmed).start();
		new Thread(Amine).start();
		new Thread(Bachir).start();
	}
}
