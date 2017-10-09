package reiseanbieter;

import kunden.Kunde;
/**
* Schnittstelle Reiseanbieter <br>
* Klassen, die diese Schnittstelle implementieren, sind Reiseanbieter wie weg.de, welche Reisen an Kunden vermitteln
* @author David Linkse s0558521
*/	
public interface Reiseanbieter {
	
	//Auswahl des Transportmittels
	public static final int EGAL = 0;
	public static final int BUS = 1;
	public static final int BAHN = 2;
	
	//Entfernung in Km auf Strassen (Busreise)
	public static final double entfernungBus = 288.2;
	//entfernung in Km auf Schienen (Bahnreise)
	public static final double entfernungBahn = 310;
	
	/**
	 * Die Methode versucht den Kunden in ein Kundenarray einzutragen, welches eine Buchungsliste für ein Transportmittel darstellt
	 * @param k - der buchende Kunde
	 * @param transport - das gewünschte Transportmittel
	 * @return gibt bei erfolgreicher Buchung true und sonst false zurück
	 */
	public abstract boolean buchen(Kunde k, int transport);
	/**
	 * Die Methode versucht die Reisegruppe in ein Kundenarray einzutragen, welches eine Buchungsliste für ein Transportmittel darstellt
	 * @param gruppe - die buchende Reisegruppe
	 * @param transport - das gewünschte Transportmittel
	 * @return gibt bei erfolgreicher Buchung true und sonst false zurück
	 */
	public abstract boolean buchen(Kunde[] gruppe, int transport);
	/**
	 * Die Methode schickt eine Buchungsbestätigung and den Kunden k
	 * @param k - der buchende Kunde
	 * @param transport - das gewünschte Transportmittel
	 */
	public abstract void buchungBestaetigen(Kunde k, int transport);
	/**
	 * Die Methode schickt eine Buchungsablehnung an den Kunden k
	 * @param k - der buchende Kunde
	 * @param transport - das gewünschte Transportmittel
	 */
	public abstract void buchungAblehnen(Kunde k, int transport);
	/**
	 * Die Methode versucht den Kunden aus einem Kundenarray zu löschen, welches eine Buchungsliste für ein Transportmittel darstellt
	 * @param k - der stornierende Kunde
	 * @param transport - das gebuchte Transportmittel
	 * @return gibt bei erfolgreicher Stornierung true und sonst false zurück
	 */
	public abstract boolean stornieren(Kunde k, int transport); 
	/**
	 * Die Methode versucht die Kunden aus einem Kundenarray zu löschen, welches eine Buchungsliste für ein Transportmittel darstellt
	 * @param gruppe - die stornierende Reisegruppe
	 * @param transport - das gewünschte Transportmittel
	 * @return gibt bei erfolgreicher Stornierung true und sonst false zurück
	 */
	public abstract boolean stornieren(Kunde[] gruppe, int transport); 
	/**
	 * Die Methode schickt eine Stornierungsbestaetigung an den Kunden k
	 * @param k - der stornierende Kunde
	 * @param transport - das gebuchte Transportmittel
	 */
	public abstract void stornoBestaetigen(Kunde k, int transport);
	/**
	 * Die Methode schickt eine Stornierungsablehnung an den Kunden k
	 * @param k - der stornierende Kunde
	 * @param transport - das gebuchte Transportmittel
	 */
	public abstract void stornoAblehnen(Kunde k, int transport);
	/**
	 * Die Methode errechnet entweder für Bus oder Bahn den jeweiligen Preis aus, <br>oder sollte man als Transport EGAL angeben haben, errechnet die Methode das billigste Transportmittel und gibt den Preis aus.
	 * @param k - der Kunde
	 * @param transport - das gewünschte Transportmittel
	 * @return double Wert, der dem Preis des gewünschten Transportmittels entspricht
	 */
	public abstract double preisErfragen(Kunde k, int transport);
	/**
	 * Die Methode errechnet entweder für Bus oder Bahn die jeweilige Fahrtdauer, <br>oder sollte man als Transport EGAL angegeben haben, errechnet die Methode das schnellste Transportmittel und gibt die errechnete Dauer aus.
	 * @param k - der Kunde
	 * @param transport - das gewünschte Transportmittel
	 * @return double Wert, der der errechneten Dauer der Fahrt entspricht
	 */
	public abstract double dauerErfragen(Kunde k, int transport);
}
