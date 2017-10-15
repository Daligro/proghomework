package transportmittel;

/**
 * Klasse Bus <br>
 * implementiert das interface Transportmittel
 * @author David Linke s0558521
 */

public class Bus implements Transportmittel
{

	private double geschwindigkeit;
	private int anzahlPlaetze;	
	
	public Bus(double geschwindigkeit, int anzahlPlaetze) {
		this.geschwindigkeit = geschwindigkeit;
		this.anzahlPlaetze = anzahlPlaetze;
	}
	public Bus()
	{
		System.out.println("Achtung, st. Konstruktor!");
	}

	@Override
	public double getGeschwindigkeit() {
		return geschwindigkeit;
	}

	@Override
	public int getAnzahlPlaetze() {
		return anzahlPlaetze;
	}

}
