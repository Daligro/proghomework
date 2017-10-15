/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public interface StapelSchnittstelle 
{

	/**
	 * legt ein Element oben auf den Stack
	 * @param i das abzulegende Element
	 */
	public abstract void push(int i);
	
	/**
	 * nimmt das oberste Element vom Stack herunter und gibt seinen Wert zur�ck
	 * @return Oberstes Element vom Stack
	 * @throws NullPointerException wenn Stapel leer
	 */
	public abstract int pop() throws NullPointerException;
	
	/**
	 * liefert den Wert des obersten Elements des Stacks zur�ck
	 * @return Oberstes Element vom Stack
	 * @throws NullPointerException wenn Stapel leer
	 */
	public abstract int top() throws NullPointerException;
	
	/**
	 * @return true wenn Stack leer ist
	 */
	public abstract boolean isEmpty();
	
	
}
