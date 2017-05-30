package bibliothek;

public class Warenlager 
{
	
	private int kapazitaet;
	private int maxSorten;
	Warensorte[] waren;
		
	public Warenlager(int kapazitaet, int maxSorten) 
	{
		this.kapazitaet = kapazitaet;
		this.maxSorten = maxSorten;
		waren=new Warensorte[maxSorten];
	}

	public Warenlager() {
		System.out.println("Achtung, default-Konstruktor verwendet");
	}

	public int getKapazitaet() {
		return kapazitaet;
	}
	
	public void setKapazitaet(int kapazitaet) {
		this.kapazitaet = kapazitaet;
	}
	
	public int getMaxSorten() {
		return maxSorten;
	}
	
	public void setMaxSorten(int maxSorten) {
		this.maxSorten = maxSorten;
	}

	public void add(Warensorte ware)
	{
		int counter=0;
		for(int i = 0 ; i<maxSorten ; i++)
		{
			if(waren[i]==null)
			{
				if(ware.getMenge()<kapazitaet){
					waren[i]=ware;
					System.out.println(ware.getMenge()+" mal "+ware.getName()+" "+((Toilettenpapier) ware).getTyp()+" eingelagert.");
					break;
				}else{
					System.out.println("1 Anzahl übersteigt Kapazität.");
				}
				
			}													//TODO irgendwas mit break einfügen
			else if(((Toilettenpapier) waren[i]).getTyp().equals(((Toilettenpapier) ware).getTyp()))
			{
				if(ware.getMenge()+waren[i].getMenge()<kapazitaet){
					waren[i].setMenge(waren[i].getMenge()+ware.getMenge());
					System.out.println(ware.getMenge()+" mal "+ware.getName()+" "+((Toilettenpapier) ware).getTyp()+" hinzugefügt.");
				}else{
					System.out.println("2 Anzahl übersteigt Kapazität.");
				}
			}
			else{counter++;}
		}
		if(counter==maxSorten)
			System.out.println( ware.getName()+" konnte nicht hinzugefügt werden, maximale Menge an verschiedenen Sorten bereits erreicht.");
	}	

	public void datumCheck(String dateStr)
	{
		int counter=0;
		String[] temp=dateStr.split("\\.");
		int[] date = new int[3];
		date[0]=Integer.parseInt(temp[0]);
		date[1]=Integer.parseInt(temp[1]);
		date[2]=Integer.parseInt(temp[2]);
		for(int i = 0 ; i<maxSorten ; i++)
		{
			if(date.equals(waren[i]))
			{
				System.out.println("Milchprodukt "+waren[i].getName()+" ID "+i+"ist überschritten.");
				counter++;
			}
		}
		System.out.println("Am "+dateStr+" laufen "+counter+" Produktsorten ab.\n");
	}
	
	public void temperaturCheck(double grad)
	{
		int counter=0;
		for(int i = 0 ; i < maxSorten ; i++)
		{
			if(waren[i] instanceof Milchprodukt)
			{
				if(((Milchprodukt) waren[i]).getLagertemperatur()>grad)
				{
					System.out.println("Max. Lagertemperatur für Milchprodukt "+waren[i].getName()+" ID "+i+" ist überschritten.");
					counter++;
				}
			}
		}
		System.out.println("Bei Lagertemperatur "+grad+"° ist die maximale Lagertemperatur für "+counter+" Produktsorte/n überschritten");
	}
	
	public String toString()
	{
		String lager="\nDer Gesamtbestand des Lagers ist:\n\n";
		
		for(int i = 0 ; i < maxSorten ; i++)
		{
			lager+="ID "+i+" "+waren[i].toString()+"\n";
		}
		return lager;
	}
}
