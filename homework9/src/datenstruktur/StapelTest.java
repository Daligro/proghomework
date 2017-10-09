/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public class StapelTest 
{
	public static void main(String[] args)
	{
		Stapel stack = new Stapel();
		System.out.println(stack);
		if(stack.isEmpty())
			System.out.println("Stack ist leer");
		try{
			stack.pop();
		}catch (Exception e)
		{System.out.println("Stack ist leer");}
		try{
			stack.top();
		}catch (Exception e)
		{System.out.println("Stack ist leer");}
		stack.push(4);
		stack.push(2);
		stack.push(6);
		stack.push(4);
		stack.push(5);
		stack.push(8);
		stack.push(9);
		stack.push(1);
		System.out.println(stack);
		if(!stack.isEmpty())
			System.out.println("Stack ist nicht leer");
		System.out.println(stack.top());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
