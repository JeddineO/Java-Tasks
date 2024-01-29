package Partie3;

import java.util.Vector;

public class Simulation {
	
	public static Vector<Jouet> jouets;

	
	public static void main(String args[])
	{
		jouets = new Vector();
		for(int i=0;i<9;i++)
			jouets.add(new Jouet(i));
		
		VerificateurJouet Ahmed=new VerificateurJouet("Ahmed");
		VerificateurJouet Amine=new VerificateurJouet("Amine");
		
		new Thread(Ahmed).start();
		new Thread(Amine).start();
	}
}
