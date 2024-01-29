import java.io.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int a = 1;
        Scanner clavier = new Scanner(System.in);
        Biblio Bib = new Biblio(5);
        Livre lvr;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializedObject"))) {
          	Bib = (Biblio) ois.readObject();
              
          } catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
          }
        

        do {
            System.out.println("1-Ajouter un livre ");
            System.out.println("2-Ajouter un auteur ");
            System.out.println("3-Afficher les livres ");
            System.out.println("4-Chercher par auteur ");
            System.out.println("5-Sortir ");
            System.out.println("Entrez votre choix : ");
            a = clavier.nextInt();
            clavier.nextLine(); 
            

            switch (a) {
                case 1:
                    System.out.println("Entrez le titre du livre :");
                    String titre = clavier.nextLine();
                    System.out.println("Entrez ISBN du livre :");
                    int isbn = clavier.nextInt();
                    System.out.println("Entrez le prix du livre :");
                    float prix = clavier.nextFloat();
                    clavier.nextLine(); 
                    System.out.println("Entrez le nom d'auteur :");
                    String aut = clavier.nextLine();
                    Bib.ajouteLivre(new Livre(titre, isbn, prix, aut));
                    break;
                case 2:
                    System.out.println("Entrez Isbn du livre :");
                    isbn = clavier.nextInt();
                    lvr = Bib.chercher(isbn);
                    if (lvr == null) {
                        System.out.println("Aucun livre ne correspond pas à votre identifiant");
                    } else {
                        clavier.nextLine(); // Consume the newline character
                        System.out.println("Entrez le nom d'auteur :");
                        aut = clavier.nextLine();
                        lvr.setAuteurs(aut);
                    }
                    break;
                case 3:
                	 System.out.println( Bib.toString());
                    break;
                case 4:
                	System.out.println("Entrez le nom d'auteur :");
                    aut = clavier.nextLine();
                	System.out.println(Bib.chercher(aut));
                    break;
               default:
                   System.out.println("Enterez un choix valable !!");
                   break;
                    	
            }

        } while (a != 5);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializedObject"))) {
            oos.writeObject(Bib);
            System.out.println("Object est bien serialisé.");
        } catch (IOException e) {
            e.printStackTrace();
        }

     
        
        
      

    }
}
