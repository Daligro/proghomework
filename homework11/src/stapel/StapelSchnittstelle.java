package stapel;

public interface StapelSchnittstelle <T>
{
	
	/**
	 * Methode legt ein Objekt oben auf einen Stapel
	 * @param obj - Datentyp irgendeiner Art, welches auf den Stapel oben abgelegt wird
	 */
	public abstract void push(T obj); 
	
	/**
	 * Methode nimmt das oberste Element vom Stapel runter und gibt es zurueck
	 * @return oberstes Element des Stapels
	 */
	public abstract T pop();
	
	/**
	 * Methode gibt das oberste Element des Stapels zurueck ohne es zu entfernen
	 * @return Oberstes Element des Stapels
	 */
	public abstract T top();
	
	/**
	 * Methode ueberprueft ob der Stapel leer ist
	 * @return true, wenn der Stapel leer ist
	 */
	public abstract boolean isEmpty();


}
