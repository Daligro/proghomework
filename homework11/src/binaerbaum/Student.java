/**
 * @author David Linke s0558521
 */
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
	 * Methode vergleicht die Nachnamen Strings lexikalisch
	 * @param o - der mit dem aufrufenden Studenten zu vergleichende Student
	 * @return (-1) - wenn aufrufer < parameter<br>
	 * 			1 - wenn aufrufer > parameter<br>
	 * 			0 - wenn aufrufer == parameter
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
