package bankprojekt;

/**
 * Stellt verschiedene Währungen und Umtauschkurse zur Verfügung<br>
 * EUR- Euro<br>
 * BGN- Bulgarische Leva<br>
 * LTL- Litauische Litas<br>
 * KM- Konvertible Mark
 * @author david
 *
 */
public enum Waehrung {
	//Euro, Bulgarische Leva, Litauische Litas, Konvertible Mark
	EUR(1),
	BGN(1.95583),
	LTL(3.4528),
	KM(1.95583);
	
	double kurs;
	
	private Waehrung(double d)
	{
		kurs=d;
	}
	
	/**
	 * rechnet Euro in eine der in Waehrung enthaltenen Währungen um.
	 * @param betrag - wird in Euro angegeben und in die Waehrung von this umgerechnet
	 * @return betrag in der Währung von this
	 */
	public double umrechnen(double betrag)
	{
		return betrag*this.kurs;
	}
	
}
