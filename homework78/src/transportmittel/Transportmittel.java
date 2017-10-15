

package transportmittel;

/**
* Schnittstelle Transportmittel <br>
* Klassen, die diese Schnittstelle implementieren, sind konkrete Transportmittel, wie Bus, Bahn, Minibus, Sammeltaxi usw.
* @author Adrianna Alexander
* @version 1.0
*/	
public interface Transportmittel {
	
	/**
	 * liefert die Durchschnittsgeschwindigkeit des Transportmittels
	 * @return Durchnittsgeschwindigkeit
	 */
	public abstract double getGeschwindigkeit();
	
	/**
	 * liefert die maximale Anzahl der Plätze (für die Fahrgäste) in dem Transportmittel
	 * @return Anzahl der Plätze
	 */
	public abstract int getAnzahlPlaetze();
}
