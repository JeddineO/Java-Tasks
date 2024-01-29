package C_2021;

import java.util.List;

public class Note {
	private static final int MAXIMUM_NOTE=20;
	private final double valeur;
	private final boolean Absent;
	public Note() {
		this.valeur=0;
		this.Absent=false;
	}
	public Note(double val,boolean abs) throws IllegalArgumentException 
	{
		if(val<=MAXIMUM_NOTE || val>=0) throw new IllegalArgumentException(val);
			this.valeur=val;
			this.Absent=abs;
		
	}
	public Note(double val)  throws IllegalArgumentException
	{
		if(val<=MAXIMUM_NOTE || val>=0) throw new IllegalArgumentException(val);
			this.valeur=val;
			this.Absent=false;
	}
	public boolean Absent()
	{
		return this.Absent;
	}
	public double getValeur()
	{
		return this.valeur;
	}
	public String toString()
	{
		if(this.Absent)
			return this.valeur+"/20";
		else
			return "ABS";
	}
	public static Note NoteMoyenne(List<Note> notes) throws IllegalArgumentException
	{
		double sum=0;
		for(Note n:notes)
		{
			if(n.Absent())
				return new Note();
			sum+=n.getValeur();
		}
		return new Note(sum/notes.size(),false);
	}
}
