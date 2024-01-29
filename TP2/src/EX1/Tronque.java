package EX1;

import java.util.*;

public class Tronque {

    public static void main(String[] args) {

        if (args.length < 2 ) {
            System.out.println("Respeceter ce model Double Int ... ");
            return;
        }
        
        for(int i=0;i<args.length;i+=2)
        {
        try {
            double x = Double.parseDouble(args[i]);
            try {
                int nbDecimales = Integer.parseInt(args[i+1]);
                if (nbDecimales >= 0) {
                    String resultat = tronque(x, nbDecimales);
                    System.out.println(resultat);
                }{
                    System.out.println("Le nombre de décimales doit être positif ou nul.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Le deuxième argument doit être un entier.");
            }catch(ArrayIndexOutOfBoundsException e1) {
                System.out.println("Il faut entrez nombre pair des arguments.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Le premier argument doit être un double.");
        }
        }
        	
      
    }

    public static String tronque(double x, int nbDecimales) {
        String chaine = Double.toString(x);
        StringTokenizer st = new StringTokenizer(chaine, ".");
        String partieEntiere = st.nextToken();

        if (st.hasMoreTokens()) {
            String partieDecimale = st.nextToken().substring(0, nbDecimales);
            return partieEntiere + "." + partieDecimale;
        } else {
            return partieEntiere;
        }
    }
}
