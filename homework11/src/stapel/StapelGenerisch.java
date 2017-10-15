/**
 * @author David Linke s0558521
 */
package stapel;

public class StapelGenerisch<T> implements StapelSchnittstelle<T>
{

	Node<T> top = null;
	
	@Override
	public void push(T obj)
	{
	
		Node<T> n = new Node<>(obj);
		n.next=top;
		top=n;
		
	}

	@Override
	public T pop() 
	{
		if(top!=null)
		{
			T temp = top.data;
			top=top.next;
			return temp;
		}
		else
			return null;
	}

	@Override
	public T top() 
	{

		if(top!=null)
			return top.data;
		else
			return null;
	}

	@Override
	public boolean isEmpty() 
	{
		
		if(top==null)
			return true;
		else
			return false;
		
	}
		
	@Override
	public String toString() 
	{
		
		String str = "";
		Node<T> n = top;
		while(n!=null)
		{
			str+=" # "+n.data+" # \n";
			n=n.next;
		}
		str+="#############";
		return str;
		
	}

}
