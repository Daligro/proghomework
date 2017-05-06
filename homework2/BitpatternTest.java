
/*
 * David Linke
 * s0558521
 */

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;



public class BitpatternTest
{
	private Bitpattern bit;
	
	//erzeugt vor jedem Test ein Objekt der Klasse Bitpattern
	@Before
	public void BitpatternErzeugen() 
	{
	bit = new Bitpattern();
	}
	
	//Testet die Methode setBit mit normalen eingabewerten
	@Test
	public void setBitNormal()
	{
		assertEquals(14, bit.setBit(10, 2), 0);
	}
	
	//Testet die Methode setBit mit einer negativen Position, IllegalArgumentException erwartet
	@Test
	public void setBitNegativ()
	{
		try {
			
			System.out.println(bit.setBit(42, -2));
			
		} catch (IllegalArgumentException e) {}
	}
	
	//Testet die Methode setBit mit einer zu groﬂen Position, IllegalArgumentException erwartet
	@Test
	public void setBitTooHigh()
	{
		try {
			
			System.out.println(bit.setBit(42, 99999));
		
		} catch (IllegalArgumentException e) {}
	}
	
	//Testet die Methode inBinary mit normalen Werten
	@Test
	public void inBinaryNormal()
	{
		int[] numberArray = bit.inBinary(10);
		int[] testArray = new int[] {1,0,1,0};
		for( int i = 0 ; i < numberArray.length ; i++ )
		{
			assertEquals(numberArray[i], testArray[i]); 
		}
	}
	
	//Testet die Methode inBinary mit einem Negativen Wert, IllegalArgumentException erwartet
	@Test
	public void inBinaryNegativ()
	{
		try {
			
			int[] numberArray = bit.inBinary(-2);
			
			for(int a : numberArray)
				System.out.print(a);
		
		} catch (IllegalArgumentException e) {}
	}
	
	//Testet die Methode endsOn
	@Test
	public void endsOn()
	{
		assertTrue(bit.endsOn(7,"11"));
	}
}
