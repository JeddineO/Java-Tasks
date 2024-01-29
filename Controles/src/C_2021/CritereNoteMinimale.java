package C_2021;

public class CritereNoteMinimale implements Predicat<Etudiant> {
	private final double NoteMinimale;

	public CritereNoteMinimale(double NoteMinimale)  {
		this.NoteMinimale=NoteMinimale;
	}
	
	public boolean test(Etudiant etudiant)
	{
		Note n=etudiant.NoteMoyenne();
		if(n.Absent()!=true && n.getValeur()>NoteMinimale)
			return true;
		return false;
	}

}
