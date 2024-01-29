package Ex2;

public class Buffer {
	String phrase;
	public Buffer() {
		phrase="";
	}
	
	public void consomer()
	{
		System.out.println("Consommation du :"+this.phrase);
		phrase="";
	}
	
	public void produire(String _phrase)
	{
		System.out.println("Production");
		this.phrase=_phrase;
	}

}
