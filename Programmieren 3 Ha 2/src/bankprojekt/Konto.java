
package bankprojekt;

/**
 * stellt ein allgemeines Konto dar
 * 
 * @author ich wars
 */
public abstract class Konto {
	/**
	 * Waehrung in der das Konto gefÃ¼hrt wird
	 */
	private Waehrung waehrung = Waehrung.EUR;
	
	/**
	 * der Kontoinhaber
	 */
	private Kunde inhaber;

	/**
	 * die Kontonummer
	 */
	private final long nummer;

	/**
	 * der aktuelle Kontostand
	 */
	private double kontostand;

	/**
	 * Wenn das Konto gesperrt ist (gesperrt = true), kï¿½nnen keine Aktionen
	 * daran mehr vorgenommen werden, die zum Schaden des Kontoinhabers wï¿½ren
	 * (abheben, Inhaberwechsel)
	 */
	private boolean gesperrt;

	/**
	 * hebt den gewÃ¼nschten betrag in wÃ¤hrung w ab
	 * 
	 * @param betrag
	 *            gewÃ¼nschter betrag
	 * @param w
	 *            WÃ¤hrung die abgehoben wird
	 * @return true wenn abheben erfolgreich, false wenn nicht
	 * @throws GesperrtException
	 */
	public boolean abheben(double betrag, Waehrung w) throws GesperrtException {
		if (gesperrt)
			throw new GesperrtException(nummer);
		if (this.abheben(betrag/w.kurs))
			return true;
		else 
			return false;

	}

	/**
	 * Zahlt eine Bestimmte Menge einer Währung in das Konto ein, dabei wird nach den Kursen korrekt die Menge des gezahlten Geldes angepasst
	 * @param betrag - einzuzahlende Geldsumme
	 * @param w - Währung des einzuzahlenden Geldes
	 * @throws IllegalArgumentException
	 */
	public void einzahlen(double betrag, Waehrung w) throws IllegalArgumentException {
		if (betrag < 0)
			throw new IllegalArgumentException("Negativer Betrag");
		setKontostand(kontostand+betrag/w.kurs*this.getAktuelleWaehrung().kurs);
	}

	/**
	 * gibt die waehrung aus in der das Konto gefÃ¼hrt wird
	 * 
	 * @return waehrung in der das Konto gefÃ¼hrt wird
	 */
	public Waehrung getAktuelleWaehrung() {
		return this.waehrung;
	}

	/**
	 * Wechselt die Waehrung in der Das Konto geführt wird und passt Kontostand, Dispokredit(Giro) und die bereits abgehobene Summe(Spar) an
	 * @param neu - die Waehrung in der das Konto geführt werden soll
	 */
	public void waehrungswechsel(Waehrung neu) {
		setKontostand(kontostand/this.getAktuelleWaehrung().kurs*neu.kurs);
		waehrung = neu;
	}
	
	/**
	 * setzt den aktuellen Kontostand
	 * 
	 * @param kontostand
	 *            neuer Kontostand
	 */
	protected void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}


	/**
	 * Setzt die beiden Eigenschaften kontoinhaber und kontonummer auf die
	 * angegebenen Werte, der anfï¿½ngliche Kontostand wird auf 0 gesetzt.
	 *
	 * @param inhaber
	 *            Kunde
	 * @param kontonummer
	 *            long
	 * @throws IllegalArgumentException
	 *             wenn der Inhaber null
	 */
	public Konto(Kunde inhaber, long kontonummer) {
		if (inhaber == null)
			throw new IllegalArgumentException("Inhaber darf nicht null sein!");
		this.inhaber = inhaber;
		this.nummer = kontonummer;
		this.kontostand = 0;
		this.gesperrt = false;
	}

	/**
	 * setzt alle Eigenschaften des Kontos auf Standardwerte
	 */
	public Konto() {
		this(Kunde.MUSTERMANN, 1234567);
		// noch was tun
	}

	/**
	 * liefert den Kontoinhaber zurï¿½ck
	 * 
	 * @return Kunde
	 */
	public final Kunde getInhaber() {
		return this.inhaber;
	}

	/**
	 * setzt den Kontoinhaber
	 * 
	 * @param kinh
	 *            neuer Kontoinhaber
	 * @throws GesperrtException
	 *             wenn das Konto gesperrt ist
	 * @throws IllegalArgumentException
	 *             wenn kinh null ist
	 */
	public final void setInhaber(Kunde kinh) throws GesperrtException {
		if (kinh == null)
			throw new IllegalArgumentException("Der Inhaber darf nicht null sein!");
		if (this.gesperrt)
			throw new GesperrtException(this.nummer);
		this.inhaber = kinh;

	}

	/**
	 * liefert den aktuellen Kontostand
	 * 
	 * @return double
	 */
	public final double getKontostand() {
		return kontostand;
	}

	/**
	 * liefert die Kontonummer zurï¿½ck
	 * 
	 * @return long
	 */
	public final long getKontonummer() {
		return nummer;
	}

	/**
	 * liefert zurï¿½ck, ob das Konto gesperrt ist oder nicht
	 * 
	 * @return
	 */
	public final boolean isGesperrt() {
		return gesperrt;
	}

	/**
	 * Erhï¿½ht den Kontostand um den eingezahlten Betrag.
	 *
	 * @param betrag
	 *            double
	 * @throws IllegalArgumentException
	 *             wenn der betrag negativ ist
	 */
	public void einzahlen(double betrag) {
		if (betrag < 0) {
			throw new IllegalArgumentException("Negativer Betrag");
		}
		setKontostand(getKontostand() + betrag);
	}

	/**
	 * Gibt eine Zeichenkettendarstellung der Kontodaten zurï¿½ck.
	 */
	@Override
	public String toString() {
		String ausgabe;
		ausgabe = "Kontonummer: " + this.getKontonummerFormatiert() + System.getProperty("line.separator");
		ausgabe += "Inhaber: " + this.inhaber;
		ausgabe += "Aktueller Kontostand: " + this.kontostand + " Euro ";
		ausgabe += this.getGesperrtText() + System.getProperty("line.separator");
		return ausgabe;
	}

	/**
	 * Mit dieser Methode wird der geforderte Betrag vom Konto abgehoben, wenn
	 * es nicht gesperrt ist.
	 *
	 * @param betrag
	 *            double
	 * @throws GesperrtException
	 *             wenn das Konto gesperrt ist
	 * @throws IllegalArgumentException
	 *             wenn der betrag negativ ist
	 * @return true, wenn die Abhebung geklappt hat, false, wenn sie abgelehnt
	 *         wurde
	 */
	public abstract boolean abheben(double betrag) throws GesperrtException;

	/**
	 * sperrt das Konto, Aktionen zum Schaden des Benutzers sind nicht mehr
	 * mï¿½glich.
	 */
	public final void sperren() {
		this.gesperrt = true;
	}

	/**
	 * entsperrt das Konto, alle Kontoaktionen sind wieder mï¿½glich.
	 */
	public final void entsperren() {
		this.gesperrt = false;
	}

	/**
	 * liefert eine String-Ausgabe, wenn das Konto gesperrt ist
	 * 
	 * @return "GESPERRT", wenn das Konto gesperrt ist, ansonsten ""
	 */
	public final String getGesperrtText() {
		if (this.gesperrt) {
			return "GESPERRT";
		} else {
			return "";
		}
	}

	/**
	 * liefert die ordentlich formatierte Kontonummer
	 * 
	 * @return auf 10 Stellen formatierte Kontonummer
	 */
	public String getKontonummerFormatiert() {
		return String.format("%10d", this.nummer);
	}

	/**
	 * liefert den ordentlich formatierten Kontostand
	 * 
	 * @return formatierter Kontostand mit 2 Nachkommastellen und
	 *         Wï¿½hrungssymbol ï¿½
	 */
	public String getKontostandFormatiert() {
		return String.format("%10.2f Euro", this.getKontostand());
	}

	/**
	 * Vergleich von this mit other; Zwei Konten gelten als gleich, wen sie die
	 * gleiche Kontonummer haben
	 * 
	 * @param other
	 * @return true, wenn beide Konten die gleiche Nummer haben
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (this.getClass() != other.getClass())
			return false;
		if (this.nummer == ((Konto) other).nummer)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return 31 + (int) (this.nummer ^ (this.nummer >>> 32));
	}

	/*
	 * public void aufKonsole() { System.out.println(this.toString()); }
	 */
}
