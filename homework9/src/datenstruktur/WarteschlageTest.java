/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public class WarteschlageTest {
	
	public static void main(String[] args)
	{
		Warteschlange queue = new Warteschlange();
		System.out.println(queue);
		if(queue.isEmpty())
			System.out.println("Warteschlange ist leer");
		try{
			queue.dequeue();
		}catch (Exception e)
		{
			System.out.println("Warteschlange ist leer");
		}
		try{
			queue.first();
		}catch (Exception e)
		{
			System.out.println("Warteschlange ist leer");
		}
		queue.enqueue(4);
		queue.enqueue(2);
		queue.enqueue(6);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(1);
		System.out.println(queue);
		if(!queue.isEmpty())
			System.out.println("Warteschlange ist nicht leer");
		System.out.println(queue.first());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
	}
}
