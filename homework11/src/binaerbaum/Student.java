package binaerbaum;

public class Student implements Comparable<Student>{

	String vorname=null, nachname=null;
	int matrikelnr=0;
	
	public Student()
	{
		System.out.println("Achtung!");
	}
	
	public Student(String nachname)
	{
		this.nachname=nachname;
	}
	
	public Student(String vorname, String nachname, int matrikelnr)
	{
		this.vorname=vorname;
		this.nachname=nachname;
		this.matrikelnr=matrikelnr;
	}

	/**
	 * @return -1 - wenn aufrufer < parameter
	 * 			1 - wenn aufrufer > parameter
	 * 			0 - darf nicht kommen ( wenn gleichgroﬂ)
	 */
	@Override
	public int compareTo(Student o) 
	{
		if(nachname.compareTo(o.nachname) < 0)
			return -1;
		else if(nachname.compareTo(o.nachname) > 0)
			return 1;
		else
		{
			return 0;
		}
		
	}
	
	@Override
	public String toString()
	{
		return "( "+nachname+", "+vorname+", "+matrikelnr+" )";
	}

}
