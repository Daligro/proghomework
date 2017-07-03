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

	public void add(T n)
	{
		if(root!=null)
			add(n, root);
		else
			root=new BinNode<T>(n);
	}
	
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
	
	public T find(T k)
	{
		return find(k, root);
	}
	/**
	 * @thows java.lang.NullPointerException
	 * @param k
	 * @param n
	 * @return
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
