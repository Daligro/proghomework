package bibliothek;

public class Testlager 
{

	public static void main(String[] args) 	
	{
		Warenlager lagerTest = new Warenlager(800, 4);
		Milchprodukt milch1 = new Milchprodukt("Milch",3.99,300,"Fettarme","30.7.2017",5);
		Milchprodukt milch2 = new Milchprodukt("Milch",2.99,500,"Frisch","10.7.2017",10);
		Milchprodukt milch3 = new Milchprodukt("Kaese",3.99,300,"Gouda","10.7.2017",9);
		Milchprodukt milch4 = new Milchprodukt("Milch",3.99,300,"H-Milch","30.7.2017",6);
		Milchprodukt milch5 = new Milchprodukt("Milch",3.99,300,"Fettarme","31.7.2017",9);
		Milchprodukt milch6 = new Milchprodukt("Kaese",3.99,300,"Gouda","2.7.2017",9);
		Toilettenpapier klo1 = new Toilettenpapier(1.5,19,"extra-rau");

		lagerTest.add(milch1);
		lagerTest.add(milch2);
		lagerTest.add(milch3);
		lagerTest.add(milch4);
		lagerTest.add(milch5);
		lagerTest.add(milch6);
		lagerTest.add(klo1);
		
		System.out.println(lagerTest.toString());
		
		lagerTest.datumCheck("24.5.2017");
		lagerTest.datumCheck("30.7.2017");
		
		lagerTest.temperaturCheck(7.1);
	}

}
