import java.util.Vector;
import java.io.*;


public class Livre implements Serializable {
    
    private String titre;
    private Vector<String> auteurs=new Vector();
    private int ISBN;
    private float prix;
    
    public Livre(String titre, int ISBN, float prix, String auteur) {
        this.titre = titre;
        this.ISBN = ISBN;
        this.prix = prix;
        this.auteurs.add(auteur);
    }
    
    public String getTitre() {
        return titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public Vector<String> getAuteurs() {
        return auteurs;
    }
    
    public void setAuteurs(String auteur) {
        this.auteurs.add(auteur);
    }
    
    public int getISBN() {
        return ISBN;
    }
    
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    
    public float getPrix() {
        return prix;
    }
    
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public boolean ChercherAuteur(String auteur) {
        for (String au : auteurs) {
            if (au.toLowerCase().startsWith(auteur.toLowerCase()))
                return true;
        }
        return false;
    }

    public String toString() {
        return "titre=" + titre + ", auteurs=" + auteurs + ", ISBN=" + ISBN + ", prix=" + prix
                + "euro\n";
    }
}
