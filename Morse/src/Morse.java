public class Morse {

	public Morse() {
	}

	public static void main(String[] args) {
		if(args.length==0)
		{
			System.out.println("il faut entrer au moin une variable");
			return;
		}
		
		for(int i=0;i<args.length;i++)
		{
			System.out.print(args[i]+" Stop. ");
		}
		
	}

}
