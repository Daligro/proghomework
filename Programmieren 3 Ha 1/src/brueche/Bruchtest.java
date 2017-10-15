package brueche;

import static org.junit.Assert.*;

import org.junit.Test;

public class Bruchtest {
	
	@Test
	public void compareToBiggerTest()
	{
		Bruch a = new Bruch(1,2);
		Bruch b = new Bruch(2,2);
		assertEquals(-1,a.compareTo(b));
	}
	
	@Test
	public void compareToSmallerTest()
	{
		Bruch a = new Bruch(2,2);
		Bruch b = new Bruch(1,2);
		assertEquals(1,a.compareTo(b));
	}

	@Test
	public void compareToSameTest()
	{
		Bruch a = new Bruch(1,2);
		Bruch b = new Bruch(2,4);
		assertEquals(0,a.compareTo(b));
	}
	
	@Test
	public void toStringTest()
	{
		Bruch a = new Bruch(1,2);
		assertEquals("1/2",a.toString());
	}
	
	@Test
	public void multiplizierenTest()
	{
		Bruch a = new Bruch(2,2);
		Bruch b = new Bruch(1,2);
		Bruch c = new Bruch(1,2);
		assertTrue(0==c.compareTo(a.multiplizieren(b)));
	}

	@Test
	public void ausrechnenTest()
	{
		Bruch a = new Bruch(1,2);
		assertEquals(0.5,a.ausrechnen(),0);
	}
	
	@Test
	public void ausrechnenZeroTest()
	{
		Bruch a = new Bruch(0,2);
		assertEquals(0,a.ausrechnen(),0);
	}
	
	@Test
	public void kuerzenTest()
	{
		Bruch a = new Bruch(2,4);
		Bruch b = new Bruch(1,2);
		a.kuerzen(); 
		assertTrue(a.toString().equals(b.toString()));
	}
	
	@Test
	public void kehrwertTest()
	{
		Bruch a = new Bruch(1,2);
		Bruch b = new Bruch(2,1);
		assertTrue(a.toString().equals(b.kehrwert().toString()));
	}
	
	//TODO funktioniert nicht
	@Test
	public void kehrwertZeroTest()
	{
		Bruch a = new Bruch(0,2);
		assertTrue(a.kehrwert().toString().equals("2/0"));
	}
}
