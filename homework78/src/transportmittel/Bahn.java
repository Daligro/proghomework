package transportmittel;

/**
 * Klasse Bahn<br>
 * implementiert das Interface Transportmittel
 * @author David Linke s0558521
 */

public class Bahn implements Transportmittel
{

	private double geschwindigkeit;
	private int anzahlPlaetze;

	public Bahn(double geschwindigkeit, int anzahlPlaetze) {
		super();
		this.geschwindigkeit = geschwindigkeit;
		this.anzahlPlaetze = anzahlPlaetze;
	}
	public Bahn()
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
