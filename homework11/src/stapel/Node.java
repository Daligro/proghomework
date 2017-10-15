/**
 * @author David Linke s0558521
 */
package stapel;

public class Node <T>
{
	public T data;
	public Node<T> next;
	
		public Node(T obj) {
		data = obj;
		next = null;
	}
}
