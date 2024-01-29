package Partie4;

import java.util.Random;

public class Jouet {
    private int matricule;
    private boolean etat;

    public Jouet(int matricule) {
        this.matricule = matricule;
        this.etat = false;
    }

    public boolean getEtat() {
        return this.etat;
    }

    public void setEtat() {
        this.etat = true;
    }

    public synchronized void tuEsVerifiePar(VerificateurJouet V) throws InterruptedException {
        if (!this.etat || V.niveau == 1) {
        	 while (!this.etat &&  V.niveau == 1)    
        		 this.wait();
        		 
            
            System.out.println("Verificateur " + V.nom + " commence à vérifier le jouet " + matricule);
            try {
                Random random = new Random();
                int delai = random.nextInt(1000)/V.vetisse;
                Thread.sleep(delai);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(V.nom + " a fini de vérifier le jouet " + matricule);
            this.setEtat(); 
            this.notifyAll();
        }
    }

}
