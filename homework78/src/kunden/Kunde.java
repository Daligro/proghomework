

package kunden;

/**
* Schnittstelle Kunde <br>
* Klassen, die diese Schnittstelle implementieren, sind Kunden eines Reiseanbieters
* @author David Linke s0558521
*/	
public interface Kunde {
	
	/**
	 * @param nachricht Nachricht, die vom Kunden empfangen wird
	 */
	public abstract void empfangeNachricht(String nachricht);

}
