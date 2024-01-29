import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws DejaLoueur, VoitureNotFound, VDejaLouer {
		Agence G = new Agence();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("loaction"))) {
			G = (Agence) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);

		int choix;
		do {
			System.out.println("1. Ajouter une voiture");
			System.out.println("2. Ajouter un client");
			System.out.println("3. Afficher tous les clients");
			System.out.println("4. Afficher tous les voitures");
			System.out.println("5. Louer voiture");
			System.out.println("6. Rendre voiture");
			System.out.println("7. Afficher les voitures lou�");
			System.out.println("8. Afficher les loueur");
			System.out.println("9. Afficher les voitures selon des criti�res");
			System.out.println("0. Quitter");
			System.out.print("Choisissez une option (0-9): ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				System.out.println("Marque : ");
				String marque = scanner.nextLine();
				System.out.println("Mod�l : ");
				String model = scanner.nextLine();
				System.out.println("Ann�e : ");
				int annee = scanner.nextInt();
				System.out.println("Prix : ");
				int prix = scanner.nextInt();
				G.voitures.add(new Voiture(marque, model, annee, prix));
				System.out.println("Voiture ajout� ");
				break;
			case 2:
				System.out.println("Civilte : ");
				String civilte = scanner.nextLine();
				System.out.println("Nom : ");
				String nom = scanner.nextLine();
				System.out.println("Pr�nom : ");
				String prenom = scanner.nextLine();
				System.out.println("Cin : ");
				String cin = scanner.nextLine();
				G.clients.add(new Client(nom, prenom, cin, civilte));
				System.out.println("Client ajout� ");
				break;
			case 3:
				System.out.println("Liste des client: \n");
				for(Client client:G.clients)
					System.out.println(client);
				break;
			case 4:
				System.out.println("Liste des voitures: \n");
				for (Voiture voiture : G.voitures)
					System.out.println(voiture);
				break;
			case 5:
				Voiture v;
				do {
					System.out.println("Matricul du voiture : ");
					int matricule = scanner.nextInt();
					v = G.findVoiture(matricule);
					if (v!=(null))
						break;
					System.out.println("Voiture n'existe pas ");
				} while (true);
				Client c;
				scanner.nextLine();
				do {
					System.out.println("Nom du client : ");
					nom = scanner.nextLine();
					c = G.findClient(nom);
					if (c!=(null))
						break;
					System.out.println("Client n'existe pas ");
				} while (true);
				try {
					G.loueVoiture(c, v);
					System.out.println("Voiture est bien lou� :");
				}catch(VoitureNotFound VE)
				{
					System.out.println(VE);
					System.out.println("Liste des voitures: \n");
					for (Voiture voiture : G.voitures)
						System.out.println(voiture);
					
				}catch(VDejaLouer vd)
				{
					System.out.println(vd);
					G.lesVoituresLouees();
				}catch(DejaLoueur dl)
				{
					
					System.out.println(dl);
					System.out.println("Les loueur de voiture : ");
					Iterator<Client> keyIterator = G.Locations.keySet().iterator();
					Agence.afficherElements(keyIterator);
				}
				

				break;
			case 6:
				do {
					System.out.println("Nom du client : ");
					nom = scanner.nextLine();
					c=G.findClient(nom);
					if (c!=null)
					{
						try {
							G.rendVoiture(c);
						} catch (LocationException e) {
							e.printStackTrace();
						}
						System.out.println("Voiture est bien rendu :");
						break;
					}
						
				} while (true);
				
				break;
			case 7:
				System.out.println("Les Voitures Louees :");
				Iterator<Voiture> ValueIterator = G.lesVoituresLouees();
				Agence.afficherElements(ValueIterator);
				break;
			case 8:
				System.out.println("Les loueur de voiture : ");
				Iterator<Client> keyIterator = G.Locations.keySet().iterator();
				Agence.afficherElements(keyIterator);
				break;
			case 9:
				prix=-1;
				annee=-1;
				marque="";
				Critere Cprix,Cannee,Cmarque;
				InterCritere InterC =new InterCritere();
				int choix1=0;
			do {
				System.out.println("1. Ajouter Crit�re prix  ");
				System.out.println("2. Ajouter Crit�re marque  ");
				System.out.println("3. Ajouter Crit�re annee ");
				System.out.println("4. Afficher les voitures ");
				System.out.println("5. Reset Criteres ");
				System.out.println("0. Retourner ");
				System.out.println("Votre choix entre 0-4 : ");
				choix1 = scanner.nextInt();
				scanner.nextLine();
				switch(choix1)
				{
				case 1:
					System.out.println("Prix : ");
					prix=scanner.nextInt();
					Cprix=new CriterePrix(prix);
					InterC.addCritere(Cprix);
					System.out.println("Critiere est bien Ajout� ");
					break;
				case 2:
					System.out.println("Marque : ");
					marque=scanner.nextLine();
					Cmarque=new CritereMarque(marque);
					InterC.addCritere(Cmarque);
					System.out.println("Critiere est bien Ajout� ");
					break;
				case 3:
					System.out.println("Ann�e : ");
					annee=scanner.nextInt();
					Cannee=new CritereAnnee(annee);
					InterC.addCritere(Cannee);
					System.out.println("Critiere est bien Ajout� ");
					break;
				case 5:
					InterC= new InterCritere();
					System.out.println("Critieres mise � zero ");
					break;
				case 4:
					System.out.println("Liste des voiture selon les critieres ");
					G.afficheSelection(InterC);
					break;
				}
			}while(choix1!=0);
				break;
			case 0:
				System.out.println("Programme termin�.");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir une option valide.");
			}

		} while (choix != 0);

		scanner.close();

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loaction"))) {
			oos.writeObject(G);
			System.out.println("Object est bien serialis�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
