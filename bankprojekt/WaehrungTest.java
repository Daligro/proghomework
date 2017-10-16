package bankprojekt;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaehrungTest {

	@Test
	public void testUmrechnenLBGN() {
		Waehrung leva=Waehrung.BGN;
		assertEquals(1.95583,leva.umrechnen(1.0),0);
	}
	
	@Test
	public void testUmrechnenEUR() {
		Waehrung eur=Waehrung.EUR;
		assertEquals(1,eur.umrechnen(1.0),0);
	}
	
	@Test
	public void testUmrechnenLTL() {
		Waehrung lita=Waehrung.LTL;
		assertEquals(3.4528,lita.umrechnen(1.0),0);
	}
	
	@Test
	public void testUmrechnenKM() {
		Waehrung mark=Waehrung.KM;
		assertEquals(1.95583,mark.umrechnen(1.0),0);
	}
	
	
	@Test
	public void testUmrechnenZero() {
		Waehrung eur=Waehrung.EUR;
		assertEquals(0,eur.umrechnen(0),0);
	}
}
