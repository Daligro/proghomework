/**
 * @author David Linke s0558521
 */
package binaerbaum;

public class BinTree<T> {

	BinNode<T> root = null;
	
	public BinTree()
	{
	}
	
	public BinTree(BinNode<T> root)
	{
	this.root=root;
	}

	/**
	 * Methode wird vom Benutzer aufgerufen und ruft selbstständig sich selbst auf um root als weiteren Parameter zu übergeben um den Baum vom Beginn an zu traversieren(außer root ist null, dann wird root ein BinNode<T> mit data=n)
	 * @param n - daten des einzufügenden BinNode<T>
	 */
	public void add(T n)
	{
		if(root!=null)
			add(n, root);
		else
			root=new BinNode<T>(n);
	}
	
	/**
	 * Methode wird von sich selbst aufgerufen und sucht Node für Node nach dem richtigen Platz um ein BinNode<T> mit den Daten n einzufügen
	 * @param n - daten des einzufügenden BinNode<T>
	 * @param k - zurzeit traversierter BinNode<T>, seine daten werden mit n verglichen um festzustellen wo der neue BinNode<T> eingefügt werden soll
	 */
	@SuppressWarnings("unchecked")
	public void add(T n, BinNode<T> k)
	{
			
		if(k==null)
			k=new BinNode<T>(n);
		else
		{
			switch (((Comparable<T>) n).compareTo(k.data))
			{
			case -1:	
					if(k.left==null)
						k.left=new BinNode<T>(n);
					else
						add(n, k.left);
				break;
			case 1: if(k.right==null)
						k.right=new BinNode<T>(n);
			   		else
			   			add(n, k.right);
				break;
			default: System.out.println("Knoten bereits vorhanden");
					break;
			}
		}

	}
	
	/**
	 * Methode wird vom Nutzer aufgerufen, ruft sich selbst mit root als weiterem Parameter auf um den Baum von beginn an zu traversieren
	 * @param k - die Gesuchten Daten(z.B. bei Student auch nur der Nachname)
	 * @return die Kompletten gefundenen Daten(z.B. bei Student zusätzlich zum gesuchten Nachnamen auch den Vornamen und die Matrikelnummer)
	 */
	public T find(T k)
	{
		return find(k, root);
	}
	/**
	 * @param k - die Gesuchten Daten(z.B. bei Student auch nur der Nachname)
	 * @param n - zurzeit traversierter BinNode<T>, seine daten werden mit n verglichen um festzustellen wo der BinNode<T> mit den Daten k gesucht werden soll
	 * @return die Kompletten gefundenen Daten(z.B. bei Student zusätzlich zum gesuchten Nachnamen auch den Vornamen und die Matrikelnummer)
	 * @thows java.lang.NullPointerException
	 */
	@SuppressWarnings("unchecked")
	public T find(T k, BinNode<T> n)
	{
		if(n==null)
			return null;
		else
		{
			switch (((Comparable<T>) n.data).compareTo(k))
			{
			case 1: return find(k, n.left);
			case -1: return find(k, n.right);
			case 0: return n.data;
			default: return null;
			}
		}
	}
	
	public String toString()
	{
		return toString(root);
	}
	
	public String toString(BinNode<T> k)
	{
		if(k!=null)
			return "["+toString(k.left)+"] "+k.data.toString()+" ["+toString(k.right)+"]";
		else
			return "-";
	}
	
}
