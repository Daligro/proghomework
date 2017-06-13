package reiseanbieter;

import kunden.Kunde;
import transportmittel.Bahn;
import transportmittel.Bus;

public class TuiReisen implements Reiseanbieter
{

	final double BUSKOSTEN=25, BAHNKOSTEN=40;
	Bahn bahn;
	Bus bus;
	double STRECKEBAHN=310, STRECKEBUS=288.8;
	Kunde[] bahnBuchung;
	Kunde[] busBuchung;
	
	public TuiReisen(Bus bus, Bahn bahn) 
	{
		this.bahn = bahn;
		this.bus = bus;
		bahnBuchung=new Kunde[bahn.getAnzahlPlaetze()];
		busBuchung=new Kunde[bus.getAnzahlPlaetze()];
	}

	@Override
	public boolean buchen(Kunde k, int transport) 
	{
		switch(transport)
		{
		case 0:
			for(int i=0 ; i<busBuchung.length ; i++)
			{
				if(busBuchung[i]==null)
				{
					busBuchung[i]=k;
					buchungBestaetigen(k,transport);
					return true;
				}
			}
			for(int i=0 ; i<bahnBuchung.length ; i++)
			{
				if(bahnBuchung[i]==null)
				{
					bahnBuchung[i]=k;
					buchungBestaetigen(k,transport);
					return true;
				}
			}
			buchungAblehnen(k,0);			
		case 1:
			for(int i=0 ; i<busBuchung.length ; i++)
			{
				if(busBuchung[i]==null)
				{
					busBuchung[i]=k;
					buchungBestaetigen(k,transport);
					return true;
				}
			}
			buchungAblehnen(k,transport);		
			return false;
		case 2: 
			for(int i=0 ; i<bahnBuchung.length ; i++)
			{
				if(bahnBuchung[i]==null)
				{
					bahnBuchung[i]=k;
					buchungBestaetigen(k,transport);					
					return true;
				}
			}
			buchungAblehnen(k,transport);
			return false;
			
			default: 
				k.empfangeNachricht("Transportmittel existiert nicht.");
				return false;
		}
	}

	@Override
	public boolean buchen(Kunde[] gruppe, int transport) 	
	{
		int n = 0;
		switch(transport)
		{
		case 0:
			for(int i=0 ; i<busBuchung.length ; i++)
			{
				if(busBuchung[i]==null)
					n++;				
			}
			if(n>=gruppe.length)
			{
				int t=0;
				n=gruppe.length;
				for(int i=0 ; n!=0 ; i++)
				{
					if(busBuchung[i]==null)
					{
						busBuchung[i]=gruppe[t];
						buchungBestaetigen(gruppe[t],BUS);
						t++;
						n--;
					}
				}
				return true;
			}
			n=0;
			
			for(int i=0 ; i<bahnBuchung.length ; i++)
			{
				if(bahnBuchung[i]==null)
					n++;				
			}
			if(n>=gruppe.length)
			{
				int t=0;
				n=gruppe.length;
				for(int i=0 ; n!=0 ; i++)
				{
					if(bahnBuchung[i]==null)
					{
						bahnBuchung[i]=gruppe[t];
						buchungBestaetigen(gruppe[t],BAHN);
						t++;
						n--;
					}
				}
				return true;
			}else{
				for(int t = 0 ; t<gruppe.length ; t++)
					buchungAblehnen(gruppe[t],0);
				return false;
			}
			
			
		case 1:
			for(int i=0 ; i<busBuchung.length ; i++)
			{
				if(busBuchung[i]==null)
					n++;				
			}
			if(n>=gruppe.length)
			{
				int t=0;
				for(int i=0 ; n!=0 ; i++)
				{
					if(busBuchung[i]==null)
					{
						busBuchung[i]=gruppe[t];
						buchungBestaetigen(gruppe[t],transport);
						t++;
						n--;
					}
				}
				return true;
			}else{
				for(int t = 0 ; t<gruppe.length ; t++)
					buchungAblehnen(gruppe[t],transport);
				return false;
			}
			
		case 2: 
			for(int i=0 ; i<bahnBuchung.length ; i++)
			{
				if(bahnBuchung[i]==null)
					n++;				
			}
			if(n>=gruppe.length)
			{
				int t=0;
				for(int i=0 ; n!=0 ; i++)
				{
					if(bahnBuchung[i]==null)
					{
						bahnBuchung[i]=gruppe[t];
						buchungBestaetigen(gruppe[t],transport);
						t++;
						n--;
					}
				}
				return true;
			}else{
				for(int t = 0 ; t<gruppe.length ; t++)
					buchungAblehnen(gruppe[t],transport);
				return false;
			}
		default:
			for(int t = 0 ; t<gruppe.length ; t++)
				gruppe[t].empfangeNachricht("Transportmittel existiert nicht.");
			return false;
		}
	}

	public void buchungBestaetigen(Kunde k, int transport) 
	{
		switch(transport){
			case 1: k.empfangeNachricht("Busreise gebucht.");
				break;
			case 2: k.empfangeNachricht("Bahnreise gebucht.");
				break;
				default: k.empfangeNachricht("Transportmittel existiert nicht.");
				}
	}

	@Override
	public void buchungAblehnen(Kunde k, int transport) 
	{
		switch(transport){
		case 0: k.empfangeNachricht("Reise konnte nicht gebucht werden");
			break;
		case 1: k.empfangeNachricht("Busreise konnte nicht gebucht werden.");
			break;
		case 2: k.empfangeNachricht("Bahnreise konnte nicht gebucht werden.");
			break;
			default: k.empfangeNachricht("Transportmittel existiert nicht.");	
		}
	}

	@Override
	public boolean stornieren(Kunde k, int transport) 
	{
		switch(transport){
		case 0:
			k.empfangeNachricht("Geben sie an, welches Transportmittel sie gebucht haben.");
			return false;
		case 1:
			for(int i=0 ; i<busBuchung.length ; i++)
			{
				if(busBuchung[i].equals(k))
				{
					busBuchung[i]=null;
					stornoBestaetigen(k,transport);
					return true;
				}
			}
			stornoAblehnen(k,transport);
			return false;
		case 2:
			for(int i=0 ; i<bahnBuchung.length ; i++)
			{
				if(bahnBuchung[i].equals(k))
				{
					bahnBuchung[i]=null;
					stornoBestaetigen(k,transport);
					return true;
				}
			}
			stornoAblehnen(k,transport);
			return false;
		default: k.empfangeNachricht("Transportmittel existiert nicht.");
			return false;
		}
	}

	@Override
	public boolean stornieren(Kunde[] gruppe, int transport) 
	{
		int counter=0;
		switch(transport){
		case 0:
			for(int t=0 ; t<gruppe.length ; t++)
			{
			gruppe[t].empfangeNachricht("Geben sie an, welches Transportmittel sie gebucht haben.");
			}
			return false;
		case 1:
			for(int i=0 ; i<busBuchung.length ; i++)
			{
				for(int t=0 ; t<gruppe.length ; t++)
				{
					if(gruppe[t].equals(busBuchung[i]))
					{
						counter++;
					}
				}
			}
			if(counter==gruppe.length)
			{
				for(int i=0 ; i<busBuchung.length ; i++)
				{
					for(int t=0 ; t<gruppe.length ; t++)
					{
						if(gruppe[t].equals(busBuchung[i]))
						{
							busBuchung[i]=null;
							stornoBestaetigen(gruppe[t],transport);
						}
					}
				}
				return true;
			}else{
				for(int t=0 ; t<gruppe.length ; t++)
				{
					stornoAblehnen(gruppe[t],transport);
				}
			return false;
			}
			
		case 2:
			for(int i=0 ; i<bahnBuchung.length ; i++)
			{
				for(int t=0 ; t<gruppe.length ; t++)
				{
					if(gruppe[t].equals(bahnBuchung[i]))
					{
						counter++;
					}
				}
			}
			if(counter==gruppe.length)
			{
				for(int i=0 ; i<bahnBuchung.length ; i++)
				{
					for(int t=0 ; t<gruppe.length ; t++)
					{
						if(gruppe[t].equals(bahnBuchung[i]))
						{
							bahnBuchung[i]=null;
							stornoBestaetigen(gruppe[t],transport);
						}
					}
				}
				return true;
			}else{
				for(int t=0 ; t<gruppe.length ; t++)
				{
					stornoAblehnen(gruppe[t],transport);
				}
			return false;
			}
			
		default: 
			for(int t=0 ; t<gruppe.length ; t++)
			{
				gruppe[t].empfangeNachricht("Transportmittel existiert nicht.");			
			}
			return false;
		}
	}

	@Override
	public void stornoBestaetigen(Kunde k, int transport) 
	{
		switch(transport){
		case 1: k.empfangeNachricht("Busreise erfolgreich storniert.");
			break;
		case 2: k.empfangeNachricht("Bahnreise erfolgreich storniert.");
			break;
		default: k.empfangeNachricht("Beim Stornieren ist ein Fehler aufgetreten");
		}
	}

	@Override
	public void stornoAblehnen(Kunde k, int transport) 	
	{
		switch(transport){
		case 1: k.empfangeNachricht("Busreise konnte nicht storniert werden.");
			break;
		case 2: k.empfangeNachricht("Bahnreise konnte nicht storniert werden.");
			break;
		default: k.empfangeNachricht("Beim Stornieren ist ein Fehler aufgetreten");
		}		
	}

	@SuppressWarnings("unused")
	@Override
	public double preisErfragen(Kunde k, int transport) 
	{
		switch(transport)
		{
		case 0: if(BUSKOSTEN<BAHNKOSTEN)
				{		
					k.empfangeNachricht("Am günstigsten ist die Busreise und kostet "+BUSKOSTEN+" EUR.");
					return BUSKOSTEN;
				}else if(BUSKOSTEN > BAHNKOSTEN)
				{
					k.empfangeNachricht("Am günstigsten ist die Bahnreise und kostet "+BAHNKOSTEN+" EUR.");
					return BAHNKOSTEN;
				}
				else
				{
					k.empfangeNachricht("Beide Verkehrsmittel kosten "+BUSKOSTEN+" EUR.");
					return BUSKOSTEN;
				}
		case 1: k.empfangeNachricht("Die Busreise kostet "+BUSKOSTEN+" EUR.");
				return BUSKOSTEN;
		case 2: k.empfangeNachricht("Die Bahnreise kostet "+BUSKOSTEN+" EUR.");
				return BAHNKOSTEN;
		default:
				return 0;
		}
	}

	@Override
	public double dauerErfragen(Kunde k, int transport) 
	{
		double dauerBus=STRECKEBUS/bus.getGeschwindigkeit();
		double dauerBahn=STRECKEBAHN/bahn.getGeschwindigkeit();
		
		switch(transport)
		{
		case 0:
				if(dauerBus<dauerBahn)
				{
					k.empfangeNachricht("Die Busreise ist am schnellsten und dauert "+(Math.round(dauerBus*100)/100.0)+" Stunden.");
					return (Math.round(dauerBus*100)/100.0);
				}else if(dauerBus>dauerBahn)
				{
					k.empfangeNachricht("Die Bahnreise ist am schnellsten und dauert "+(Math.round(dauerBahn*100)/100.0)+" Stunden.");
					return (Math.round(dauerBahn*100)/100.0);
				}
				else
				{
					k.empfangeNachricht("Beide Reisen dauern "+(Math.round(dauerBus*100)/100.0)+" Stunden.");
					return (Math.round(dauerBus*100)/100.0);
				}
		case 1:
			k.empfangeNachricht("Die Busreise dauert "+(Math.round(dauerBus*100)/100.0)+" Stunden.");
			return (Math.round(dauerBus*100)/100.0);
		case 2:
			k.empfangeNachricht("Die Bahnreise dauert "+(Math.round(dauerBahn*100)/100.0)+" Stunden.");
			return (Math.round(dauerBahn*100)/100.0);

			default: return 0;
		}
		
	}

	@Override
	public boolean buchen(Kunde k, int transport) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buchen(Kunde[] gruppe, int transport) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buchungBestaetigen(Kunde k, int transport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buchungAblehnen(Kunde k, int transport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean stornieren(Kunde k, int transport) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stornieren(Kunde[] gruppe, int transport) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stornoBestaetigen(Kunde k, int transport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stornoAblehnen(Kunde k, int transport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double preisErfragen(Kunde k, int transport) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double dauerErfragen(Kunde k, int transport) {
		// TODO Auto-generated method stub
		return 0;
	}

}
