/*
 * David Linke
 * s0558521
 */

package Vererbung;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Mitarbeiter 
{
//Attribute
	private String name, vorname;
	private Double gehalt;
	NumberFormat df = new DecimalFormat("#,###.00");
	
//Konstruktoren
	public Mitarbeiter(String vorname, String name, Double gehalt)
	{
	this.name=name;
	this.vorname=vorname;
	this.gehalt=gehalt;
	}
	
	
	public Mitarbeiter() {
	}

//getter und setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public Double getGehalt() {
		return gehalt;
	}
	public void setGehalt(Double gehalt) {
		this.gehalt = gehalt;
	}
	
//Methode zur geordneten Ausgabe
//Gehalt wird sicherheitshalber gerundet und in ein schöneres Format versetzt	
	public String toString() 
	{
		
		return "Mitarbeiter [name = " + name + ", vorname = " + vorname + ", gehalt = " + df.format(Math.round(gehalt*100)/100.0) + "€]";
	}

//Methode zur Gehaltserhöhung
	public void raise(double amount)
	{
		if(amount>0)
			gehalt+=amount;
		else
			throw new IllegalArgumentException("Nur Gehaltserhöhung erlaubt.");
	}
}
