package kunden;
/**
* Klasse Privatperson <br>
* implementiert das Interface Kunde
* @author David Linke s0558521
*/	
public class Privatperson implements Kunde
{

	String vorname, nachname;
	
	public Privatperson(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public Privatperson()
	{
		System.out.println("Achtung, st. Konstruktor!");
	}

	@Override
	public void empfangeNachricht(String nachricht) 
	{
		System.out.println("an "+toString()+" "+nachricht);
	}

	/**
	 * @return geordneter String zur Ausgabe aller Eigenschaften des Objekts
	 */
	public String toString()
	{
		return vorname+" "+nachname+": ";
	}
	
}
