/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public interface WarteschlangeSchnittstelle 
{

	/**
	 * f�gt ein Element ans Ende der Warteschlange hinzu
	 * @param i das einzureihende Element
	 */
	public abstract void enqueue(int i);
	
	/**
	 * entnimmt das erste Element aus der Warteschlange und liefert seinen Wert zur�ck
	 * @return erstes Element der Warteschlange
	 * @throws NullPointerException wenn Warteschlange leer
	 */
	public abstract int dequeue() throws NullPointerException;
	
	/**
	 * liefert den Wert des ersten Elements der Warteschlange zur�ck
	 * @return erstes Element der Warteschlange
	 * @throws NullPointerException wenn Warteschlange leer
	 */
	public abstract int first() throws NullPointerException;
	
	/**
	 * @return liefert true zur�ck, wenn die Warteschlange leer ist
	 */
	public abstract boolean isEmpty();
	
}
