/*
 * David Linke
 * s0558521
 */

package Taschenrechner;

public class Rechner {

	//Methode zur addition zweier Zahlen
	static void add(double z1, double z2)
	{
		System.out.println(z1 + " add " + z2 + " ist " + (z1+z2));	
	}

	//Methode zur Subtraktion zweier Zahlen
	static void sub(double z1, double z2)
	{
		System.out.println(z1 + " sub " + z2 + " ist " + (z1-z2));	
	}
	
	//Methode zur Multiplikation zweier Zahlen
	static void mul(double z1, double z2)
	{
		System.out.println(z1 + " mul " + z2 + " ist " + (z1*z2));	
	}
	
	//Methode zur Division zweier Zahlen
	static void div(double z1, double z2)
	{
		if(z2!=0)
			System.out.println(z1 + " div " + z2 + " ist " + (z1/z2));
		else
			System.out.println("Division durch Null ist nicht erlaubt!");
	}
	
	
	
	public static void main(String[] args)
	{
		//entscheidet um welchen Rechenoperator es sich handelt und gibt dann die Zahlen an die entsprechende Methode weiter
		if(args[1].equals("add"))
		{
			add(Double.parseDouble(args[0]), Double.parseDouble(args[2]));
		}
		else if(args[1].equals("sub"))
		{
			sub(Double.parseDouble(args[0]), Double.parseDouble(args[2]));			
		}
		else if(args[1].equals("mul"))
		{
			mul(Double.parseDouble(args[0]), Double.parseDouble(args[2]));
		}
		else if(args[1].equals("div"))
		{
			div(Double.parseDouble(args[0]), Double.parseDouble(args[2]));
		}
		//Falls ein falscher Operator angegeben wurde gibt es eine Fehlermeldung
		else
		{
			System.out.println("Falscher Operator");
		}
	}
}
