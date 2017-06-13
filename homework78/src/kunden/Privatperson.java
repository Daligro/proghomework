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

	@Override
	public void empfangeNachricht(String nachricht) 
	{
		System.out.println("an "+toString()+" "+nachricht);
	}

	public String toString()
	{
		return vorname+" "+nachname+": ";
	}
	
}
