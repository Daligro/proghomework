package kunden;
/**
* Klasse Privatperson <br>
* erbt von Privatperson
* @author David Linke s0558521
*/	
public class Student extends Privatperson
{

	String hochschulName;
	
	public Student(String vorname, String nachname, String hochschulName) {
		super(vorname, nachname);
		this.hochschulName = hochschulName;
	}

	public String toString()
	{
		return vorname+" "+nachname+", "+hochschulName+": ";
	}
}
