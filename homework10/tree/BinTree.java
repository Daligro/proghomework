package tree;

public class BinTree
{
	private BinNode root = null;
	BinTree() 
	{
		root = null;
	}
	
	BinTree(BinNode rn) 
	{
		root = rn;
	}
	
	/**
	 * überprüft, ob der Binärbaum leer ist indem er guckt ob die Wurzel leer ist
	 * @return true, wenn der Binärbaum leer ist
	 */
	public boolean isEmpty()
	{
		if(root==null)
			return true;
		else
			return false;
	}
	
	/**
	 * gibt der Methode countinnerNodes als parameter root, die Wurzel des Binärbaums
	 * und sorgt dafür dass die Wurzel nicht als innerer Knoten mitgezählt wird
	 * @return Anzahl der inneren Knoten des Binärbaums
	 */
	public int countInnerNodes()
	{
		if(countInnerNodes(root)==1 || countInnerNodes(root)==0)
			return 0;
		else
			return countInnerNodes(root)-1;
	}
	
	/**
	 * rekursive Methode die einen counter um 1 erhöht, wenn k ein innerer Knoten ist
	 * ruft sich selbst erneut auf für die Nachfolger von k
	 * @param k - Knoten des Binärbaums
	 * @return Anzahl der inneren Knoten von k abwärts
	 */
	public int countInnerNodes(BinNode k)
	{
		int counter = 0;
		if(k!=null)
		{
			if(k.left!=null || k.right!=null)
				counter=1+countInnerNodes(k.left)+countInnerNodes(k.right);
		}
		return counter;
	}
	
	/**
	 * ruft die Methode isSorted mit dem Parameter root auf
	 * @return true, wenn der Binärbaum sortiert ist
	 */
	public boolean isSorted()
	{
		return isSorted(root);
	}
	
	/**
	 * überprüft ob die Nachfolger von k sortiert sind und ruft die selbe Methode für die Nachfolger auf
	 * gibt Fehlermeldung aus wenn der selbe Wert mehr als einmal vorkommt
	 * @param k - Knoten des Binärbaums
	 * @return true, wenn der Binärbaum von k an abwärts sortiert ist
	 */
	public boolean isSorted(BinNode k)
	{
		if(k!=null && isSorted(k.left) && isSorted(k.right))
		{
			if(k.left!=null)
			{
				if(k.left.data > k.data)
					return false;
				else if(k.left.data == k.data)
				{
					System.out.println("Binärbaum beinhaltet mehr als einmal den selben Wert");
					return false;
				}
			}
			if(k.right!=null)
			{
				if(k.right.data < k.data)
					return false;
				else if(k.right.data == k.data)
				{
					System.out.println("Binärbaum beinhaltet mehr als einmal den selben Wert");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * sucht den Knoten mit dem Wert i und löscht diesen
	 * beginnt die Suche an der Wurzel
	 * sorgt dafür das der Binärbaum danach immernoch geordnet ist
	 * @param i - der Knoten mit diesem Wert wird gelöscht
	 */
	public void removeNode(int i)
	{
		removeNode(root, i);
	}
	
	/**
	 * löscht die Wurzel des Binärbaums und wahrt dabei die Ordnung
	 */
	public void removeNode()
	{
		if(root!=null)
			removeNode(root, root.data);
		else
			System.out.println("der Binärbaum ist null");
	}
	
	/**
	 * sucht den Knoten mit dem Wert i und löscht diesen
	 * sorgt dafür das der Binärbaum danach immernoch geordnet ist
	 * @param k - vergleicht ob k den gesuchten Wert i hat, wenn ja wird er gelöscht, wenn nein wird die Methode für die Nachfolger von k aufgerufen
	 * @param i - der Knoten mit diesem Wert wird gelöscht
	 */
	public void removeNode(BinNode k, int i)
	{
		if(k!=null)
		{
			if(k.data == i)
			{
				if(k.left == null && k.right == null)
					k=null;
				else if(k.left == null && k.right != null)
					k=k.right;
				else if(k.right == null && k.left != null)
					k=k.left;
				else
				{
					BinNode tempLeft=k.left, tempRight=k.right;
					k=removeLeft(k.left);
					k.left=tempLeft;
					k.right=tempRight;
				}
			}
			else
			{
				removeNode(k.left, i);
				removeNode(k.right, i);
			}
		}
	}

	/**
	 * wenn removeNode() versucht ein Node zu löschen, dass 2 Kinder hat, dann wird diese Methode aufgerufen sodass die Ordnung gewahrt wird
	 * removeLeft() versucht den zu löschenden Knoten mit dem kleineren In-Order-Nachbar zu ersetzen 
	 * @param k - Der Knoten bei dem Überprüft wird ob er der kleinere In-Order-Nachbar ist
	 * @return der In-Order-Nachbar, der den durch removeNode() zu löschenden Knoten ersetzen soll
	 */
	public BinNode removeLeft(BinNode k)
	{
		if(k.left == null && k.right == null)
		{
			BinNode temp = k;
			k=null;
			return temp;
		}
		else if(k.left == null && k.right != null)
		{
			return removeLeft(k.right);
		}
		else if(k.right == null && k.left != null)
		{
			BinNode temp = k;
			k=k.left;
			return k;
		}
		else
		{
			return removeLeft(k.right);
		}
	}
	
	public String toString()
	{
		return toString(root);
	}
	
	public String toString(BinNode k)
	{
		//if(k!=null)
			//return "("+getTreeString(k.left)+")"+k.data+"("+getTreeString(k.right)+")";
		//else
			//return "~";
		
	    // Ausdrucken des Teilbaums ab b, Reihenfolge inorder
	    String s = "";
	    
	    if (k.left != null) 
	    {
	      s += "("+toString(k.left)+")";
	    }
	    s += k.data;
	    if (k.right != null) 
	    {
	      s += "("+toString(k.right)+")";
	    }
	    
	    return s;
	}

}