/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public class Warteschlange extends Liste implements WarteschlangeSchnittstelle 
{

	@Override
	public void enqueue(int i) {
		addLast(i);
	}

	@Override
	public int dequeue() throws NullPointerException {
		return removeFirst();
	}

	@Override
	public int first() throws NullPointerException {
		return get(0);
	}

	@Override
	public boolean isEmpty() {
		if(top==null)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString()
	{
		Node p = top;
		String str = "<--- ";
		while(p!=null)
		{
			str+=p.data+" ";
			p=p.next;
		}
		str+="<---";
		return str;
		
	}

}
