package Ex2;

public class Consomateur extends Thread  {
	
	Buffer bf;
	public Consomateur(Buffer _bf) {
		this.bf=_bf;
	}
	
	
	@Override
    public void run() {
        synchronized (bf) {
            while (bf.phrase.equals("")) {
                try {
                    bf.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bf.consomer();
            bf.notifyAll();
        }
    }

}
