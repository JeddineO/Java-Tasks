import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Agence implements Serializable{
    public ArrayList<Voiture> voitures = new ArrayList<Voiture>();
    public ArrayList<Client> clients = new ArrayList<Client>();
    public Map<Client,Voiture> Locations=new TreeMap<Client, Voiture>();
    
    public Iterator<Voiture> selectionne(Critere c) {
        ArrayList<Voiture> res = new ArrayList<>();
        for (Voiture v : voitures) {
            if (c.estSatisfaitPar(v)) {
                res.add(v);
            }
        }
        return res.iterator();
    }
    
    public Voiture findVoiture(int matr)
    {
    	for(Voiture voiture:voitures)
    	{
    		if(voiture.matricule==matr)
    			return voiture;
    	}
    	return null;
    }
    
    public Client findClient(String nom)
    {
    	for(Client client:clients)
    	{
    		if(client.nom.equals(nom))
    			return client;
    	}
    	return null;
    }


    public String afficheSelection(Critere c) {
    	String a="";
        Iterator<Voiture> iterator = this.selectionne(c);
        while (iterator.hasNext()) {
            a+=iterator.next().toString()+"\n";
        }
        return a;
    }
    
    public boolean estLoueur(Client client)
    {
    	return Locations.containsKey(client);
    }
    public boolean estLoue(Voiture v)
    {
    	return Locations.containsValue(v);
    }
    public void loueVoiture(Client client, Voiture v) throws  DejaLoueur,VoitureNotFound,VDejaLouer
    {
    	if(!voitures.contains(v)) throw new  VoitureNotFound();
    	if(this.estLoueur(client)) throw new  DejaLoueur();
    	if(this.estLoue(v)) throw new  VDejaLouer();
    	 Locations.put(client, v);
    }
  
    public void rendVoiture(Client c) throws  LocationException
    {
    	if(!estLoueur(c)) throw new  LocationException();
    	   Locations.remove(c);
    }
    public Iterator<Voiture> lesVoituresLouees()
    {  
    	return this.Locations.values().iterator();
    }

    public static <T> void afficherElements(Iterator<T> iterator) {
        while (iterator.hasNext()) {
            T element = iterator.next();
            System.out.println(element);
        }
    }
    
    

}
