/*
 * David Linke
 * s0558521
 */

package Vererbung;

public class GelaTest 
{

	public static void main(String[] args)
	{
		//erzeugt die Objekte frankWalser und evaFlink vom Typ Mitarbeiter mit dem gleichen Konstruktor
		Mitarbeiter frankWalser = new Mitarbeiter("Frank", "Walser", 1600.0);
		Mitarbeiter evaFlink = new Mitarbeiter("Eva", "Flink", 1650.0);
		
		//erzeugt das Objekt hansBoss vom Typ Mitarbeiter mit einem anderen Konstruktor
		Mitarbeiter hansBoss = new Mitarbeiter();
		
		//Attribute werden im Nachhinein belegt
		hansBoss.setName("Boss");
		hansBoss.setVorname("Hans");
		hansBoss.setGehalt(4000.0);
		
		//erzeugt das Objekt svenVogel vom Typ Azubi
		Azubi svenVogel = new Azubi("Sven", "Walser", 450.0);
		svenVogel.setBeruf("Maurer");
		svenVogel.setAusbildungsJahr(1);
		
		//gibt die Inhalte der erzeugten Objekte geordnet aus
		System.out.println(frankWalser.toString()+"\n");
		System.out.println(evaFlink.toString()+"\n");
		System.out.println(hansBoss.toString()+"\n");
		System.out.println(svenVogel.toString()+"\n");
	
		//erstellt ein weiteres Azubi Objekt, gibt die Inhalte des Objekts geordnet aus, führt eine Gehaltserhöhung durch und gibt dann erneut die Inhalte aus, wobei der Gehalt erhöht wurde
		Azubi maxMustermann = new Azubi("Max", "Mustermann", 1337.0, "Software-Entwickler", 2);
		
		System.out.println("Vor der Gehaltserhöhung:");
		System.out.println(maxMustermann.toString()+"\n");
		
		maxMustermann.raise(663.0);
		
		System.out.println("Nach der Gehaltserhöhung:");
		System.out.println(maxMustermann.toString()+"\n");

		
	}
	
}
