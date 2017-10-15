
/*
 * David Linke
 * s0558521
 */

import org.junit.Test;


public class Bitpattern {
	
	//setBit wandelt eine Dezimalzahl in eine Bin�rzahl um, setzt das Bit einer bestimmten position auf 1 und wandelt die neue Zahl wieder in Dezimal um
	public int setBit(int number, int position)
	{
		//wandelt Dezimal int in Bin�r String um
		String binary = Integer.toBinaryString(number);
		if(position<0 || position>binary.length())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			//das zu ver�ndernde bit wird festgestellt
			int index = binary.length()-position-1;
			//der Bin�rzahl String wird in ein Chararray umgewandelt
			char[] binaryChar = binary.toCharArray();
			//das gew�nschte bit wird 1 gesetzt
			binaryChar[index]='1';
			//das ver�nderte Chararray wird zu einem String umgewandelt
			String binaryNew = new String(binaryChar);
			//der String wird in einen Dezimalzahl int umgewandelt und zur�ckgegeben
			return Integer.parseInt(binaryNew,2);
		}	
	}
	
	//inBinary wandelt eine Dezimalzahl in eine Bin�rzahl als int Array um
	public static int[] inBinary(int number)
	{
		if(number<0)
		{
			throw new IllegalArgumentException();
		}else{
			//die Intzahl wird in eine bin�re Zahl umgewandelt und als int Array zur�ckgegeben
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
			
	//endsOn wandelt eine Dezimalzahl in eine Bin�rzahl um und vergleicht die letzten Stellen der Bin�rzahl mit dem beim Aufruf �bergeben String, bei �bereinstimmung wird True zur�ckgegeben
	public static boolean endsOn(int number, String pattern)
	{
		//die Intzahl wird in eine Bin�re Stringzahl umgewandelt
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