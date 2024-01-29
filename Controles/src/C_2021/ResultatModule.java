package C_2021;

public class ResultatModule {
	private final String NomModule;
	private final Note note;
	
	public ResultatModule(String _NomModule,Note _note) {
		this.NomModule=_NomModule;
		this.note=_note;
	}
	
	public Note getNote()
	{
		return this.note;
	}
	public String toString()
	{
		return this.NomModule+" : "+this.note;
	}

}
