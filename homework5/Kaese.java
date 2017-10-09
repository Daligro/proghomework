package bibliothek;

public class Kaese extends Toilettenpapier 
{

	private int[] verfallsdatum;
	private int lagertemperatur;
	
	public Kaese(String typ, String Verfallsdatum, int lagertemperatur)
	{
		super();
		setVerfallsdatum(Verfallsdatum);
		setLagertemperatur(lagertemperatur);
	}
	
	public Kaese()
	{
		System.out.println("Achtung Defaultkonstruktor verwendet!");
	}
	
	
	public int[] getVerfallsdatum() 
	{	
		return verfallsdatum;
	}
	
	public void setVerfallsdatum(String verfallsdatum) 
	{
		String[] temp=verfallsdatum.split(".");
		int[] verfall = {3};
		verfall[0]=Integer.parseInt(temp[0]);
		verfall[0]=Integer.parseInt(temp[1]);
		verfall[0]=Integer.parseInt(temp[2]);
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

