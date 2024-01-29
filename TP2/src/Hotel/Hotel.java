package Hotel;

import java.util.Scanner;
import java.util.Vector;

public class Hotel {
	 Vector<Chambre> chambres=new Vector();
	 Vector<Chambre> libre=new Vector();
	
	
	Scanner clavier=new Scanner(System.in);
	
	public Chambre saisieChambre()
	{
		Chambre ch=new Chambre();
		System.out.println("Entrez le numéro de chambre :");
		int a=clavier.nextInt();
		ch.nc=a;
		System.out.println("Entrez le prix :");
		int p=clavier.nextInt();
		ch.setPrix(p);
		int c;
		do
		{
			System.out.println("Entrez la capacité :");
			c=clavier.nextInt();
			ch.setCapacite(c);
		}while(c<1 || c>4);
		
		System.out.println("Entrez la catégorie :");
		int d=clavier.nextInt();
		ch.categorie=d;
		
		 return ch;
	}
	
	public void ajouterChambre(Chambre ch)
	{
		this.chambres.add(ch);
	}
	
	
	public Vector<Chambre> chercher(int motif)
	{
	Vector<Chambre> res=new Vector();
		for(Chambre chambre:chambres)
		{
			if(chambre.categorie==motif)
				res.add(chambre);
		}
		return res;
	}
	
	public String toString()
	{
		String res="";
		for(Chambre ch:chambres)
			res+=ch.toString();
		return res;
	}
	
	public String remove(int a)
    {
		int i=0;
    	for(Chambre ch:chambres)
    	{
    		if(ch.nc==a)
    		{
    			chambres.removeElementAt(i);
    			return "Chambre supprimé";
    		}
    		i++;
    	}
    	return "Aucun chambre ne correspond pas à ce numéro";
    }
	public Vector<Chambre> Lister()
	{
	     Vector<Chambre> ListOrdon = new Vector<>();

	        for (Chambre ch : chambres) {
	            int i = 0;
	            for (Chambre iter :  ListOrdon) {
	                if ( ch.categorie<iter.categorie ) {
	                    break;
	                }
	                i++;
	            }
	            ListOrdon.add(i, ch);
	        }
	        return  ListOrdon;
	}
	
	public void chambreLibre()
	{
		for(Chambre ch:chambres)
		{
			if(ch.equals("L"))
				libre.add(ch);
		}
	}


    public double calculerRecetteReelle() {
        double recetteReelle = 0;
        for (Chambre chambre : chambres) {
            if (chambre.etat.equals("O")){
                recetteReelle += chambre.prix;
            }
        }
        return recetteReelle;
    }
    
    public double calculerRecetteMaximaleJournaliere() {
        double recetteMaximale = 0;
        for (Chambre chambre : chambres) {
            recetteMaximale += chambre.prix;
        }
        return recetteMaximale;
    }
    public void reserver(int n)
    {
    	for(Chambre ch :chambres)
    	{
    		if(ch.nc==n)
    		{
    			if(ch.etat.equals("L"))
    			{
    			chambres.remove(ch);
    			ch.etat="O";
    			chambres.add(ch);
    			System.out.println("Chambre est bien réserver");
    			
    			}else
    			{
    				System.out.print("Chambre déja réserver");
    			}
    			break;	
    		}
    	}
    }
    
    
    public void Liberer(int n)
    {
    	for(Chambre ch :chambres)
    	{
    		if(ch.nc==n)
    		{
    			if(ch.etat.equals("O"))
    			{
    			chambres.remove(ch);
    			ch.etat="L";
    			chambres.add(ch);
    			System.out.println("Chambre est bien liberé");
    			
    			}else
    			{
    				System.out.print("Chambre déja libre");
    			}
    			break;	
    		}
    	}
    }

}
