package C_2014;

public class main {

	public static void main(String[] args) {
		Personnel pers=new Personnel();
		Employe emp1=new Technicien("ZADDI","Abdelmajid",23,"2023",1000);
		Employe emp2=new Technicien("ZAHIR","Ismail",23,"2023",900);
		Employe emp3=new Vendeur("TOTO","Titi",23,"2023",6);
		
		pers.ajouterEmploye(emp1);
		pers.ajouterEmploye(emp2);
		pers.ajouterEmploye(emp3);
		
		pers.affichageTrieParSalaire();
	}

}
