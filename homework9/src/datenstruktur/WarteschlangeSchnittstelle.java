/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public interface WarteschlangeSchnittstelle 
{

	/**
	 * fügt ein Element ans Ende der Warteschlange hinzu
	 * @param i das einzureihende Element
	 */
	public abstract void enqueue(int i);
	
	/**
	 * entnimmt das erste Element aus der Warteschlange und liefert seinen Wert zurück
	 * @return erstes Element der Warteschlange
	 * @throws NullPointerException wenn Warteschlange leer
	 */
	public abstract int dequeue() throws NullPointerException;
	
	/**
	 * liefert den Wert des ersten Elements der Warteschlange zurück
	 * @return erstes Element der Warteschlange
	 * @throws NullPointerException wenn Warteschlange leer
	 */
	public abstract int first() throws NullPointerException;
	
	/**
	 * @return liefert true zurück, wenn die Warteschlange leer ist
	 */
	public abstract boolean isEmpty();
	
}
