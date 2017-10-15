/**
 * @author David Linke s0558521
 */
package binaerbaum;

public class BinNode <T> {

	T data;
	BinNode<T> left, right;
	
	public BinNode()
	{
		System.out.println("Achtung!");
	}
	
	public BinNode(T data)
	{
		this.data=data;
	}
	
	public BinNode(T data, BinNode<T> left, BinNode<T> right)
	{
		this.data=data;
		this.left=left;
		this.right=right;
	}
	
}
