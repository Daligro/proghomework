
/*
 * David Linke
 * s0558521
 */

import org.junit.Test;


public class Bitpattern {
	
	//setBit wandelt eine Dezimalzahl in eine Binärzahl um, setzt das Bit einer bestimmten position auf 1 und wandelt die neue Zahl wieder in Dezimal um
	public int setBit(int number, int position)
	{
		//wandelt Dezimal int in Binär String um
		String binary = Integer.toBinaryString(number);
		if(position<0 || position>binary.length())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			//das zu verändernde bit wird festgestellt
			int index = binary.length()-position-1;
			//der Binärzahl String wird in ein Chararray umgewandelt
			char[] binaryChar = binary.toCharArray();
			//das gewünschte bit wird 1 gesetzt
			binaryChar[index]='1';
			//das veränderte Chararray wird zu einem String umgewandelt
			String binaryNew = new String(binaryChar);
			//der String wird in einen Dezimalzahl int umgewandelt und zurückgegeben
			return Integer.parseInt(binaryNew,2);
		}	
	}
	
	//inBinary wandelt eine Dezimalzahl in eine Binärzahl als int Array um
	public static int[] inBinary(int number)
	{
		if(number<0)
		{
			throw new IllegalArgumentException();
		}else{
			//die Intzahl wird in eine binäre Zahl umgewandelt und als int Array zurückgegeben
			String numberString = Integer.toBinaryString(number);
			char[] numberCharArray = numberString.toCharArray();
			int[] numberIntArray = new int[numberCharArray.length];
			for(int i = 0 ; i < numberCharArray.length ; i++)
			{
				numberIntArray[i]=Character.getNumericValue(numberCharArray[i]);
			}
			return numberIntArray;
		}
	}
			
	//endsOn wandelt eine Dezimalzahl in eine Binärzahl um und vergleicht die letzten Stellen der Binärzahl mit dem beim Aufruf übergeben String, bei Übereinstimmung wird True zurückgegeben
	public static boolean endsOn(int number, String pattern)
	{
		//die Intzahl wird in eine Binäre Stringzahl umgewandelt
		String numberString = Integer.toBinaryString(number);
		//von dem eben gebildeten String vergleicht man einen substring der genauso lang ist wie der String: pattern mit eben diesen pattern
		String numberStringNew = numberString.substring(numberString.length()-1-pattern.length());
		if(numberStringNew.equals(numberString))
		{
			return true;
		}else{
			return false;
		}
	}
}