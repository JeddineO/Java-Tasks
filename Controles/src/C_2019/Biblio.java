package C_2019;
import java.util.*;
public class Biblio {
	private String nom;
	private int capacite;
	private Vector<Document> docs=new Vector();
	public Biblio(String nom,int capacite) {
		this.nom=nom;
		this.capacite=capacite;
	}
	
	public void findDocuments()
	{
		for(Document doc:docs)
			System.out.println(doc.toString());
	}
	
	public void findDocumentsByTitre(String titre)
	{
		for(Document doc:docs)
		{
			if(doc.titre.equals(titre))
				doc.toString();
		}
			
	}
	
	public void addDocument(Document doc) throws PlusDePlaceException
	{
		if(docs.size()>capacite) throw new PlusDePlaceException("Biblio Saturé");
		docs.add(doc);

	}

}
