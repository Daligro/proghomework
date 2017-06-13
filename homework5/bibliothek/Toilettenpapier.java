package bibliothek;

public class Toilettenpapier extends Warensorte
{
	
	private String typ;
	private String name;


	public Toilettenpapier(double preis, int menge, String typ)
	{
		super(preis, menge);
		setTyp(typ);
		setName("Toilettenpapier");
	}
	
	public Toilettenpapier()
	{
		System.out.println("Achtung Defaultkonstruktor verwendet!");
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	public String toString()
	{
		return super.toString()+", Typ: "+getTyp();
	}
	
}
