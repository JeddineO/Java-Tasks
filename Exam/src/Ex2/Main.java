package Ex2;

public class Main {

    public static void main(String[] args) {
        Buffer Bf = new Buffer();

        Consomateur consommateur = new Consomateur(Bf);
        Producteur producteur = new Producteur(Bf);

        consommateur.start();
        producteur.start();
    }
}
