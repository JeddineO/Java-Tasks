package C_2019;

public class Test {


	public static void main(String[] args) throws PlusDePlaceException{
		Biblio MyBib=new Biblio("ILISI",5);
		Document Liv1=new Livre("ZADDI","Test1",10);
		Document Liv2=new Livre("ZAHIR","Test2",15);
		Document Rmn1=new Roman("TOTO","Test3",100);
		Document Rmn2=new Roman("TITI","Test4",200);
		
	    MyBib.addDocument(Liv1);
		MyBib.addDocument(Liv2);
		MyBib.addDocument(Rmn1);
		MyBib.addDocument(Rmn2);

		
		MyBib.findDocuments();
		
		
		
	}

}
