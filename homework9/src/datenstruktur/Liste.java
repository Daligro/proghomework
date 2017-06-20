/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public class Liste implements AbstrakteListe 
{

	protected Node top = null;
	
	@Override
	public int size() {
		Node p = top;
		int counter=1;
		if(p==null)
		{
			return 0;
		}else{
			//zählt jeden Node der nicht null aus und gibt die gesamtzahl zurück
			while(p.next!=null)
			{
				counter++;
				p=p.next;
			}
			return counter;
		}
	}

	@Override
	public boolean contains(int wert) {	
		Node p = top;
		while(p!=null)
		{
			//guckt bei jedem Node nach ob er den gesuchten Wert besitzt
			if(p.data==wert)
				return true;
			else
				p=p.next;
		}
		return false;
	}

	@Override
	public int get(int index) throws NullPointerException {	
		Node p = top;
		//geht bis zum Node mit dem gewünschten Index und gibt den dazugehörigen Wert zurück
		for(int i = 0 ; i<=index ; i++)
		{
			if(i==index)
				
				return p.data;
			else
				p=p.next;
		}
		return 0;
	}

	@Override
	public int set(int wert, int index) throws NullPointerException {
		Node p = top;
		//geht bis zum gewünschten Index
		for(int i = 0 ; i<=index ; i++)
		{
			//wenn Index erreicht ist, wird das einzusetzende Node, zum Nachfolger des Elements davor
			//und der ehemalige Nachfolger des Elements davor wird zum Nachfolger des einzusetzenden Elements
			if(i==index)
			{
				int temp = p.data;
				p.data=wert;
				return temp;
			}
			else
				p=p.next;
		}
		return 0;
	}

	@Override
	public void addFirst(int wert) { 
		Node p = new Node(wert);
		p.next=top;
		top=p;
	}

	@Override
	public void addLast(int wert) {
		Node neu = new Node(wert);
		Node p = top;
		//wenn die Liste leer ist wird das einzusetzende Element das erste und gleichzeitig das letzte Element der Liste sein
		//also wird addFirst aufgerufen
		if(p==null)
		{
			addFirst(wert);
		}else{
			//das einzusetzende Node wird der Nachfolger vom bis jetzt letzten Node
			while(p.next!=null)
			{
				p=p.next;
			}
			p.next=neu;
		}
	}

	@Override
	public boolean add(int wert, int index) {
		//wenn die Liste leer ist wird das einzusetzende Element das erste und gleichzeitig das letzte Element der Liste sein
		//also wird addFirst aufgerufen
		if(index==0)
		{
			addFirst(wert);
			return true;
		}
		else{
			Node neu = new Node(wert);
			Node p = top;
			//das einzusetzende Element erhält als Nachfolger das Element das bis dahin den gewünschten index hatte
			//das Node davor erhält als Nachfolger das neue Element
			for(int i = 0 ; i<index ; i++)
			{
				if(p==null)
					return false;
				else{
					if(i==index-1)
					{
						neu.next=p.next;
						p.next=neu;
						return true;
					}else
						p=p.next;
				}
			}
		}
		return false;
	}

	@Override
	public boolean remove(int wert) {
		//wenn das erste Element == wert, dann wird das erste Element mit der Methode removeFirst gelöscht
		if(top.data==wert)
		{
			removeFirst();
			return true;
		}else{
			Node p = top;
			//Es wird nach dem Element mit dem bestimmten Wert gesucht und dann erhält der Vorgänger des Elements
			//als Nachfolger den Nachfolger des Elements mit dem bestimmten Wert
			while(p.next.data!=wert&&p!=null)
			{
					p=p.next;
					if(p.next==null)
						return false;
			}
			p.next=p.next.next;
			return true;
		}
	}

	@Override
	public int removeFirst() throws NullPointerException {
		Node p = top;
		top=top.next;
		return p.data;
	}

	@Override
	public int removeLast() throws NullPointerException {
		Node p = top;
		//das Letzte Element wird gesucht und gelöscht
		while(p.next.next!=null)
		{
			p=p.next;
		}
		int temp = p.next.data;
		p.next=p.next.next;
		return temp;
	}

	@Override
	public int removeAtIndex(int index) throws NullPointerException {
		if(index==0)
			return removeFirst();
		else
		{
			Node p = top;
			//es wird das Element mit dem bestimmten Index gesucht, der vorgänger erhält als nachfolger
			//den Nachfolger des gesuchten Elements
			for(int i = 0 ; i<index ; i++)
			{
				if(i==index-1)
				{
					int temp = p.next.data;
					p.next=p.next.next;
					return temp;
				}else
					p=p.next;
			}
		}
		return 0;
	}

	@Override
	public String toString(){
		Node p = top;
		String str = "[ ";
		while(p!=null)
		{
			str+=p.data+" ";
			p=p.next;
		}
		str+="]";
		return str;
	}

}
