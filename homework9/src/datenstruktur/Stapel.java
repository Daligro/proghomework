/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public class Stapel extends Liste implements StapelSchnittstelle 
{

	@Override
	public void push(int i) {
		addFirst(i);
	}

	@Override
	public int pop() throws NullPointerException {
		return removeFirst();
	}

	@Override
	public int top() throws NullPointerException {
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
		String str="";
		while(p!=null)
		{
			str+="** "+p.data+" **\n";
			p=p.next;
		}
		str+="*******";
		return str;
	}

}
