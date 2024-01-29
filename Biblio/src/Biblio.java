import java.io.Serializable;
import java.util.Vector;
import java.io.*;



public class Biblio implements Serializable{
    private Vector<Livre> livres = new Vector<>();
    private int capacite;
    
    public Biblio(int cap)
    {
    	this.capacite=cap;
    }
	public int capacite()
	{
		return this.capacite;
	}
	public boolean ajouteLivre(Livre L)
    {
		if(this.size()<this.capacite)
			return livres.add(L);
		return false;
    }
	public int size()
	{
		return livres.size();
	}
	
	
	public Vector<Livre> chercher(String auteur) {
	    Vector<Livre> res = new Vector<>();
	    for (Livre livre : livres) {
	        for (String aut : livre.getAuteurs()) {
	            if (aut.toLowerCase().startsWith(auteur.toLowerCase())) {
	                res.add(livre);
	            }
	        }
	    }
	    return res;
	}
	public Livre chercher(int isbn) {
	    for (Livre livre : livres) {
	            if (livre.getISBN()==isbn) {
	                return livre;
	        }
	    }
	    return null;
	}

	
	
	public String toString() {
		String res="";
		for(Livre lv:livres)
			res+=lv.toString();
		return res;
	}
	

}
