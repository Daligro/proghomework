import kunden.Privatperson;
import kunden.Student;
import reiseanbieter.Reiseanbieter;
import reiseanbieter.TuiReisen;
import transportmittel.Bahn;
import transportmittel.Bus;

/**
 * Klasse zum durchführen von Ad-Hoc Tests
 * @author David Linke s0558521
 */

public class Test 
{

	public static void main(String[] args)
	{
		//Bus erzeugen; dieser Bus fährt durchschnittlich 80 km/h und hat nur 3 Plätze
		Bus bus = new Bus(80.5, 3);
		//Bahn erzeugen; diese Bahn fährt durchschnittlich 120 km/h und hat 10 Plätze
		Bahn bahn = new Bahn(120, 10);
		//Filiale von TuiReisen erzeugen, die über das o.g. bus und bahn verfügt
		TuiReisen tui1 = new TuiReisen(bus, bahn);
		//Privatpersonen als Kunden erzeugen
		Privatperson p1 = new Privatperson("Robert", "Neumann");
		//Studenten als Kunden erzeugen
		Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
		Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
		Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
		Student[] reisegruppe ={s1,s2,s3};
		tui1.buchen(p1, Reiseanbieter.BUS);
		tui1.buchen(reisegruppe, Reiseanbieter.BUS);
		tui1.buchen(reisegruppe, Reiseanbieter.EGAL);
		tui1.dauerErfragen(p1, Reiseanbieter.EGAL);
		tui1.dauerErfragen(p1, Reiseanbieter.BUS);
		tui1.preisErfragen(p1, Reiseanbieter.EGAL);
		tui1.preisErfragen(p1, Reiseanbieter.BAHN);
		tui1.stornieren(p1, Reiseanbieter.BUS);
		tui1.buchen(p1, Reiseanbieter.BAHN);
		
		tui1.stornieren(reisegruppe, Reiseanbieter.BUS);
		tui1.stornieren(reisegruppe, Reiseanbieter.EGAL);
		tui1.stornieren(reisegruppe, Reiseanbieter.BAHN);
	}
}
