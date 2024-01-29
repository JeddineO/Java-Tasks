package C_2021;

import java.util.*;

public class Promotion {
	private final String name;
	private final List<Etudiant> etudiants=new LinkedList();
	
	public Promotion(String name) {
		this.name=name;
	}
	public void addEtudinat(Etudiant etudiant)
	{
		etudiants.add(etudiant);
	}
	public void peintEtudiantResultats()
	{
		System.out.println(this.name);
		for(Etudiant e:etudiants)
		{
			e.printResultats();
		}
	}
	public int compteurEtudiantFiltre(Predicat<Etudiant> predicat)
	{
		int n=0;
		for(Etudiant e:etudiants)
		{
			if(predicat.test(e))n++;
		}
		return n;
	}
	
	public int compteurEtudiantValide() throws IllegalArgumentException
	{
		int n=0;
		for(Etudiant e:etudiants)
		{
			if(e.NoteMoyenne().getValeur()>=10)n++;
		}
		return n;
	}
}
