package EX2;

import java.util.Scanner;

public class TriSimple {

    public int increment;
    public int capacite;
    public int courant;
    public int[] tab;

    public static void main(String[] args) {
    	
    	
    	String a ;
        TriSimple tr = new TriSimple(2,2);
        Scanner clavier = new Scanner(System.in);
        do {
            System.out.println("A-Insere une valeur dans le tableau ");
            System.out.println("S-Suprimer une valeur dan le tableau ");
            System.out.println("D-Afficher le tableau ");
            System.out.println("Q-Quitter ");
            System.out.println("Entrez votre choix : ");
            a = clavier.next();
            
            switch(a)
            {
            case "A":
            	  System.out.println("Entrez votre valeur  : ");
                  int n = clavier.nextInt();
                  tr.inserer(n);
                  break;
            case "S":
            	System.out.println("Entrez votre valeur  : ");
                 n = clavier.nextInt();
                tr.suprimer(n);
                break;
            case "D":
            	System.out.println("Tableau : ");
            	System.out.println(tr.toString());
            	break;
            case "Q":
            	break;
            default:
            	System.out.println("Veulliez entrez une valeur valable !!!  : ");
            }
        }while(a!="q");
      
    }

    public TriSimple() {
        this.capacite = 10;
        this.courant = 0;
        this.increment=3;
        this.tab = new int[capacite];  
    }

    public TriSimple(int n,int cre) {
        this.capacite = n;
        this.courant = 0;
        this.increment=cre;
        this.tab = new int[capacite];  
        }

    public void inserer(int val) {
        int tmp;
        if(courant==capacite)
        {
        	this.capacite+=increment;
        	int[] tab1=new int[this.capacite];
        	for(int i=0;i<courant;i++)
        		tab1[i]=tab[i];
        	tab=tab1;
        }
        tab[this.courant++] = val;
        for (int i = this.courant - 1; i > 0; i--) {
            if (tab[i] < tab[i - 1]) {
                tmp = tab[i];
                tab[i] = tab[i - 1];
                tab[i - 1] = tmp;
            } else {
                break;
            }
        }
    }
    
    public void suprimer(int val) {
        for (int i = 0; i <this.courant ; i++) {
            if (tab[i] == val ) {
                for(int j=i;j<this.courant-1;j++)
                	tab[j]=tab[j+1];
                this.courant--;
                break;
            } 
            if(this.courant<this.capacite-2*this.increment)
            {
            	this.capacite-=increment;
            	int[] tab1=new int[capacite];
            	for(i=0;i<capacite;i++)
            		tab1[i]=tab[i];
            	tab=tab1;
            }
        }
    }

    public String toString() {  
        String str = "";
        for (int i = 0; i < courant; i++) {
            str += tab[i] + "\t";
        }
        return str;
    }
}
