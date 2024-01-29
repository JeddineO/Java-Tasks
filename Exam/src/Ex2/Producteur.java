package Ex2;

public class Producteur extends Thread {
    Buffer bf;

    public Producteur(Buffer _bf) {
        this.bf = _bf;
    }

    @Override
    public void run() {
        synchronized (bf) {
            while (!bf.phrase.equals("")) {
                try {
                    bf.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            bf.produire("test");

            bf.notifyAll();
        }
    }
}
