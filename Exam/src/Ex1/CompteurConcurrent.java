package Ex1;

public class CompteurConcurrent extends Thread {
    private static final int TAILLE_MIN = 10;
    private int cpt = 0;

    int tab[], debut, fin;
    int val;

    CompteurConcurrent(int tab[], int debut, int fin, int val) {
        System.out.println("Nouveau thred est créer");
        this.tab = tab;
        this.debut = debut;
        this.fin = fin;
        this.val = val;
    }

    public int getValue() {
        return cpt;
    }

    public String toString() {
        return "" + cpt;
    }

    public synchronized void incremente() {
        System.out.println("Nouveau occurence trouvé");
        cpt++;
    }

    @Override
    public void run() {
        for (int i = debut; i <= fin; i++) {
            if (tab[i] == val) {
                incremente();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int tab[] = {1,2,1,2,1,2,1, 2,1, 2,1, 2};

        if (tab.length <= TAILLE_MIN) {
            CompteurConcurrent C1 = new CompteurConcurrent(tab, 0, 1, 1);
            C1.start();
            C1.join(); 
            System.out.println("Le nombre des occurrences de " + C1.val + " est : " + C1.getValue());
        } else {
            CompteurConcurrent C1 = new CompteurConcurrent(tab, 0, 10, 1);
            CompteurConcurrent C2 = new CompteurConcurrent(tab, 10, tab.length - 1, 1);

            C1.start();
            C2.start();

            try {
                C1.join();
                C2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Le nombre des occurrences de " + C1.val + " est : " + (C1.getValue() + C2.getValue()));
        }
    }
}
