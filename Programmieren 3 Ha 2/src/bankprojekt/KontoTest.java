package bankprojekt;

import static org.junit.Assert.*;

import org.junit.Test;

public class KontoTest {

	@Test
	public void testAbhebenDoubleWaehrung() throws GesperrtException {
		Girokonto test = new Girokonto();
		test.einzahlen(200.0);
		test.abheben(100);
		assertEquals(100.0,test.getKontostand(),0);	}
	
	@Test
	public void testAbhebenDoubleWaehrungEURfromBGN() throws GesperrtException {
		Sparbuch test = new Sparbuch();
		test.waehrungswechsel(Waehrung.BGN);
		test.einzahlen(200.0);
		test.abheben(100,Waehrung.EUR);
		assertEquals((200-100*Waehrung.BGN.kurs),test.getKontostand(),0.1);	}

	@Test
	public void testAbhebenDoubleWaehrungBGNfromEUR() throws GesperrtException {
		Sparbuch test = new Sparbuch();
		test.einzahlen(200.0);
		test.abheben(100,Waehrung.BGN);
		assertEquals((200-100/Waehrung.BGN.kurs),test.getKontostand(),0.1);	}
	
	@Test
	public void testAbhebenDoubleWaehrungKMfromBGN() throws GesperrtException {
		Sparbuch test = new Sparbuch();
		test.waehrungswechsel(Waehrung.BGN);
		test.einzahlen(200.0);
		test.abheben(100,Waehrung.KM);
		assertEquals((200-100/Waehrung.KM.kurs*Waehrung.BGN.kurs),test.getKontostand(),0.1);	}
	
	@Test (expected = GesperrtException.class)
	public void testAbhebenDoubleWaehrungGesperrt() throws GesperrtException {
		Girokonto test = new Girokonto();
		test.einzahlen(200.0);
		test.sperren();
		test.abheben(100);
	}
	
	@Test
	public void testEinzahlenDoubleWaehrungGiro() {
		Girokonto test = new Girokonto();
		test.einzahlen(200.0);
		assertEquals(200.0,test.getKontostand(),0);
	}
	
	@Test
	public void testEinzahlenDoubleWaehrungSpar() {
		Sparbuch test = new Sparbuch();
		test.einzahlen(200.0);
		assertEquals(200.0,test.getKontostand(),0);
	}
	
	@Test
	public void testEinzahlenDoubleWaehrungEURtoBGN() {
		Girokonto test = new Girokonto();
		test.waehrungswechsel(Waehrung.BGN);
		test.einzahlen(200.0,Waehrung.EUR);
		assertEquals(200.0*Waehrung.BGN.kurs,test.getKontostand(),0);
	}
	
	@Test
	public void testEinzahlenDoubleWaehrungBGNtoEUR() {
		Girokonto test = new Girokonto();
		test.einzahlen(200.0,Waehrung.BGN);
		assertEquals(200.0/Waehrung.BGN.kurs,test.getKontostand(),0);
	}
	
	@Test
	public void testEinzahlenDoubleWaehrungBGNtoKM() {
		Girokonto test = new Girokonto();
		test.waehrungswechsel(Waehrung.KM);
		test.einzahlen(200.0,Waehrung.BGN);
		assertEquals(200.0/Waehrung.BGN.kurs*Waehrung.KM.kurs,test.getKontostand(),0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEinzahlenDoubleWaehrungZero() {
		Girokonto test = new Girokonto();
		test.einzahlen(-200.0);
		assertEquals(-200.0,test.getKontostand(),0);
	}


	@Test
	public void testGetAktuelleWaehrung() {
		Girokonto test = new Girokonto();
		assertEquals(Waehrung.EUR,test.getAktuelleWaehrung());
	}
	
	@Test
	public void testGetAktuelleWaehrungChanged() {
		Girokonto test = new Girokonto();
		test.waehrungswechsel(Waehrung.BGN);
		assertEquals(Waehrung.BGN,test.getAktuelleWaehrung());
	}

	@Test
	public void testWaehrungswechsel() {
		Girokonto test = new Girokonto();
		test.waehrungswechsel(Waehrung.BGN);
		assertEquals(Waehrung.BGN,test.getAktuelleWaehrung());
	}

	@Test
	public void testWaehrungswechselSame() {
		Girokonto test = new Girokonto();
		test.waehrungswechsel(Waehrung.EUR);
		assertEquals(Waehrung.EUR,test.getAktuelleWaehrung());
	}
	
	@Test
	public void testWaehrungswechselDispo() throws GesperrtException {
		Girokonto test = new Girokonto();
		test.abheben(200.0);
		test.waehrungswechsel(Waehrung.BGN);
		assertEquals(-200*Waehrung.BGN.kurs,test.getKontostand(),0);
	}
	
	@Test
	public void testWaehrungswechselBereitsAbgehoben() throws GesperrtException{
		Sparbuch test = new Sparbuch();
		test.einzahlen(300.0);
		test.abheben(200.0);
		test.waehrungswechsel(Waehrung.BGN);
		assertEquals(200*Waehrung.BGN.kurs,test.getBereitsAbgehoben(),0);
	}
	
}
