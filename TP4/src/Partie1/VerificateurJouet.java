package Partie1;
import java.util.Random;

public class VerificateurJouet implements Runnable {
	
	private String nom;
	public VerificateurJouet(String _nom) {
		this.nom=_nom;
	}
	
	public void verifieJouet(int numJouet) 
	{
		System.out.println("Verificateur "+this.nom+" commence à  vérifier le jouet  "+ numJouet);
		try {
			   Random random = new Random();
	            int delai = random.nextInt(1000);
	            Thread.sleep(delai);
			}
		catch(InterruptedException e) {};
        System.out.println(this.nom + " a fini de vérifier le jouet " + numJouet);

	}
	
	@Override
	public void run() {
		for(int i=0;i<=9;i++)
			verifieJouet(i);		
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
