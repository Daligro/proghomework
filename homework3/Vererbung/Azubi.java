/*
 * David Linke
 * s0558521
 */

package Vererbung;

public class Azubi extends Mitarbeiter 
{
	
//Attribute
	private String beruf;
	private int ausbildungsJahr;
	
//Konstruktoren	
	public Azubi(String vorname, String name, Double gehalt, String beruf, int ausbildungsJahr)
	{
		super(name, vorname, gehalt);
		this.beruf=beruf;
		this.ausbildungsJahr=ausbildungsJahr;
	}
	
	public Azubi(String vorname, String name, Double gehalt)
	{
		super(name, vorname, gehalt);
	}
	
	public Azubi() 
	{	}
	
//Getter und Setter
	public String getBeruf() {
		return beruf;
	}
	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}
	public int getAusbildungsJahr() {
		return ausbildungsJahr;
	}
	public void setAusbildungsJahr(int ausbildungsJahr) {
		this.ausbildungsJahr = ausbildungsJahr;
	}


	//Methode zur geordneten Ausgabe
	//Gehalt wird gerundet und in ein schöneres Format versetzt
	public String toString() {
		return "Azubi [Name = " + getName() + ", Vorname = " + getVorname() + ", Gehalt = " + df.format(Math.round(getGehalt()*100)/100.0) + "€, Beruf = " + beruf + ", AusbildungsJahr = " + ausbildungsJahr + ". Jahr]";
	}
	
	
	
	
}
