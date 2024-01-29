package Hotel;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "Data.txt";

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        Hotel myHotel = loadFromFile();
        int choice;

        do {
            System.out.println("1-Ajouter une chambre");
            System.out.println("2-Supprimer une chambre");
            System.out.println("3-Modifier une chambre");
            System.out.println("4-Lister les chambres");
            System.out.println("5-Chercher chambres par catégorie");
            System.out.println("6-Lister les chambres par capacité");
            System.out.println("7-Stocker les chambres par catégorie");
            System.out.println("8-Stocker les chambres Libre");
            System.out.println("9-Reserver une chambre");
            System.out.println("10-Reserver une chambre");
            System.out.println("11-Recette Maximal");
            System.out.println("12-Recette Réelle");
            System.out.println("13-Quitter et Enregistrer");
            System.out.println("Votre choix :");
            choice = clavier.nextInt();

            switch (choice) {
                case 1:
                    myHotel.ajouterChambre(myHotel.saisieChambre());
                    break;
                case 2:
                	System.out.println("Entrez le numéro de chambre :");
                    int n = clavier.nextInt();
                    System.out.println(myHotel.remove(n));
                	break;
                case 3:
                	System.out.println("Entrez ne numéro de chambre à modifier :");
                	n = clavier.nextInt();
                	myHotel.remove(n);
                    myHotel.ajouterChambre(myHotel.saisieChambre());
                	break;
                case 4:
                    System.out.println(myHotel.toString());
                    break;
                case 5:
                    System.out.println("Entrez la catégorie :");
                    n = clavier.nextInt();
                    System.out.println(myHotel.chercher(n));
                    break;
                case 6:
                	System.out.println(myHotel.Lister());
                	break;
                case 7:
                	System.out.println("Entrez la catégorie :");
                	n = clavier.nextInt();
                	BufferedWriter writer1;
                	try {
                	    writer1 = new BufferedWriter(new FileWriter("chambres.txt"));
                	    for (Chambre chambre : myHotel.chambres) {
                	        if (chambre.categorie == n) {
                	            writer1.write(formatChambre(chambre));
                	            writer1.newLine();
                	        }
                	    }
                	    writer1.close();
                	} catch (IOException e) {
                	    e.printStackTrace();
                	}
                	break;
                case 8:
                	myHotel.chambreLibre();
                	System.out.println(myHotel.libre);
                	break;
                case 9:
                	System.out.println("Entrez le numéro de chambre :");
                	n = clavier.nextInt();
                	myHotel.reserver(n);
                	break; 
                case 10:
                	System.out.println("Entrez le numéro de chambre :");
                	n = clavier.nextInt();
                	myHotel.Liberer(n);
                	break;
                case 11:
                	System.out.println("Recette Maximal est :"+myHotel.calculerRecetteMaximaleJournaliere());
                	break;
                case 12:
                	System.out.println("Recette réelle est :"+myHotel.calculerRecetteReelle());
                	break;
                case 13:
                    saveToFile(myHotel);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (choice != 12);
    }

    private static Hotel loadFromFile() {
        Hotel hotel = new Hotel();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Chambre chambre = parseChambre(line);
                hotel.ajouterChambre(chambre);
            }
        } catch (IOException e) {
            System.out.println("Fichier vide. Création d'une nouvelle instance de l'hôtel.");
        }
        return hotel;
    }

    private static void saveToFile(Hotel hotel) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Chambre chambre : hotel.chambres) {
                writer.write(formatChambre(chambre));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatChambre(Chambre chambre) {
        return String.format("%d %d %d %d %s", chambre.nc, chambre.prix, chambre.capacite,chambre.categorie,chambre.etat);
    }

    private static Chambre parseChambre(String line) {
        String[] parts = line.split(" ");
        int nc = Integer.parseInt(parts[0]);
        int prix = Integer.parseInt(parts[1]);
        int cap = Integer.parseInt(parts[2]);
        int cat = Integer.parseInt(parts[3]);
        String etat = parts[4];
        Chambre ch=new Chambre(nc , prix, cap,cat);
        ch.etat=etat;
        return ch;
    }
    
    
}
