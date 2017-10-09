package brueche;

import java.math.BigInteger;

public class Bruch implements Comparable<Bruch>
{

	private int zaehler, nenner;
	
	public double getZaehler() 
	{
		return zaehler;
	}

	public double getNenner() 
	{
		return nenner;
	}

	//standartkonstruktor
	public Bruch()
	{
		System.out.println("Achtung Standartkonstruktor!");
	}
	
	//richtiger konstruktor
	public Bruch(int zaehler, int nenner)
	{
		if(nenner==0)
			throw new ArithmeticException();
		else
		{
		this.zaehler=zaehler;
		this.nenner=nenner;
		}
	}

	
	@Override
	public int compareTo(Bruch arg) 
	{
		if(this.zaehler/(double) this.nenner<arg.zaehler/(double) arg.nenner)
			return -1;
		else if(this.zaehler/(double) this.nenner==arg.zaehler/(double) arg.nenner)
			return 0;
		else
			return 1;
	}

	public String toString()
	{
		return zaehler+"/"+nenner;
	}
	
	public Bruch multiplizieren(Bruch arg)
	{
		Bruch produkt = new Bruch(this.zaehler*arg.zaehler, this.nenner*arg.nenner);
		return produkt;
	}
	
	public double ausrechnen()
	{
		return zaehler/(double) nenner;
	}
	
	public void kuerzen()
	{
		BigInteger bigZaehler=new BigInteger(Integer.toString(zaehler));
		BigInteger bigNenner=new BigInteger(Integer.toString(nenner));
		BigInteger bigTeiler=bigZaehler.gcd(bigNenner);
		int teiler=bigTeiler.intValue();
		zaehler=zaehler/teiler;
		nenner=nenner/teiler;
	}
	
	public Bruch kehrwert()
	{
		if(zaehler==0)
		{
			System.out.println("Achtung: Nenner bei Kehrwert == 0");
			return new Bruch(nenner, zaehler);
		}
		else
			return new Bruch(nenner, zaehler);
	}

	public Bruch dividieren(Bruch b)
	{
		return this.multiplizieren(b.kehrwert());
	}
	
}
