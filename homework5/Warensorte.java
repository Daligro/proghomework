package bibliothek;

public class Warensorte 
{
	private double preis;
	private String name;
	private int menge;
	
	
	public Warensorte(String name, double preis, int menge)
	{
		this.name=name;
		this.preis=preis;
		this.menge=menge;
	}
	
	public Warensorte()
	{
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	
	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public String toString()
	{
		return "Bezeichnung: "+getName()+"Anzahl: "+getMenge()+"Preis/Stück: "+getPreis();
	}
}
