package C_2021;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Etudiant {
	private final String nom;
	private final String prenom;
	private final List<ResultatModule> resultats;
	
	public Etudiant(String _nom,String _prenom) {
		this.nom=_nom;
		this.prenom=_prenom;
		resultats=new ArrayList();
	}
	public void addResultats(String NomModule,Note note)
	{
		resultats.add(new ResultatModule(NomModule,note));
	}
	
	public List<Note> getNotes()
	{
		List<Note> res=new LinkedList();
		for(ResultatModule rs:resultats)
		{
			res.add(rs.getNote());
		}
		return res;
	}
	public Note NoteMoyenne() throws IllegalArgumentException 
	{		
		return Note.NoteMoyenne(this.getNotes());
	}
	
	public void printResultats()
	{
		System.out.println(this.nom+" "+this.prenom); 
		for(ResultatModule a:resultats)
		{
			System.out.println(a.toString());
		}
	}
	
	
}
