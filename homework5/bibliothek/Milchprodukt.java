package bibliothek;

public class Milchprodukt extends Toilettenpapier 
{

	private int[] verfallsdatum;
	private int lagertemperatur;
	
	public Milchprodukt(String name, double preis, int menge, String typ, String verfallsdatum, int lagertemperatur)
	{
		super(preis, menge ,typ);
		setName(name);
		setVerfallsdatum(verfallsdatum);
		setLagertemperatur(lagertemperatur);
	}
	
	public Milchprodukt()
	{
		System.out.println("Achtung Defaultkonstruktor verwendet!");
	}
		
	public int[] getVerfallsdatum() 
	{	
		return verfallsdatum;
	}
	
	public void setVerfallsdatum(String verfallsdatum) 
	{
		String[] temp=verfallsdatum.split("\\.");
		int[] verfall = new int[3];
		verfall[0]=Integer.parseInt(temp[0]);
		verfall[1]=Integer.parseInt(temp[1]);
		verfall[2]=Integer.parseInt(temp[2]);
		this.verfallsdatum = verfall;
	}
	
	public int getLagertemperatur() 
	{
		return lagertemperatur;
	}
	
	public void setLagertemperatur(int lagertemperatur) 
	{
		this.lagertemperatur = lagertemperatur;
	}
}

