
public class Somme {

	public Somme() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int sum=0;
		if(args.length==0)
		{
			System.out.println("Il faut entrer au moins un argument");
			return;
		}
		
		
            for (String arg : args) {
            	try {
                int nombre = Integer.parseInt(arg);
                sum += nombre;
            	} catch (NumberFormatException e) {
                    System.out.println("Erreur de format dans : "+arg+" ,Veuillez fournir des nombres valides en argument.");
                }

            }
            System.out.println("La somme des nombres est : " + sum);
        
	}

}
