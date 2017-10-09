package bibliothek;

public class Warenlager 
{
	
	private int kapazitaet;
	private int maxSorten;
	Warensorte[] waren;
	private int warenBestand=0;
		
	public Warenlager(int kapazitaet, int maxSorten) 
	{
		this.kapazitaet = kapazitaet;
		this.maxSorten = maxSorten;
		waren=new Warensorte[3];
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
		if(ware.getMenge()+warenBestand>kapazitaet)
		{
			int counter=0;
			for(int i = 0 ; i<maxSorten ; i++)
			{
				if(waren[i]==null)
				{
					if(ware.getMenge()>kapazitaet)
					{
						waren[i]=ware;
						warenBestand+=ware.getMenge();
					}
				}
				else if(waren[i].getName().equals(ware.getName()))
				{
					waren[i].setMenge(waren[i].getMenge()+ware.getMenge());
					warenBestand+=ware.getMenge();
				}
				else{counter++;}
			}
			if(counter==maxSorten)
				System.out.println(ware.getName()+" konnte nicht hinzugefügt werden, maximale Menge an verschiedenen Sorten bereits erreicht.");
		}else
			System.out.println(ware.getName()+" konnte nicht hinzugefügt werden, maximale Kapazität bereits erreicht.");		
	}	
}
