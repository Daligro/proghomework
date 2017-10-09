package bibliothek;

public class Toilettenpapier extends Warensorte
{
	
	private String typ;


	public Toilettenpapier(String typ)
	{
		setTyp(typ);
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
