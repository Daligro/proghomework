package stapel;

public class StapelGenerischTest 
{

	public static void main(String[] args)
	{
		System.out.println("Teststapel mit Long-Werten\n");
		StapelGenerisch<Long> stack = new StapelGenerisch<>();
		System.out.println(stack.top()); //stack leer also gibt top() und pop() null zurück
		System.out.println(stack.top());
		System.out.println(stack.isEmpty()); //stack ist leer -> true
		stack.push(10L); //stack wird gefüllt
		stack.push(36L);
		stack.push(27L);
		stack.push(11L);
		stack.push(69L);
		stack.push(78L);
		stack.push(25L);
		stack.push(19L);
		System.out.println(stack.isEmpty()); //stack wurde gefüllt -> nicht mehr leer -> false
		System.out.println(stack); //ausgabe stack
		System.out.println(stack.top()); //ausgabe von 19
		System.out.println(stack);	//Stack noch vollständig
		System.out.println(stack.pop()); //19 wird gelöscht und erneut ausgegeben
		System.out.println(stack); //Stack nun nichtmehr vollständig, 19 fehlt

		System.out.println("\nTeststapel mit Double-Werten\n");
		StapelGenerisch<Double> stack2 = new StapelGenerisch<>();
		System.out.println(stack.top()); //stack leer also gibt top() und pop() null zurück
		System.out.println(stack.top());
		System.out.println(stack.isEmpty()); //stack ist leer -> true
		stack2.push(10.38); //stack wird gefüllt
		stack2.push(36.87);
		stack2.push(27.99);
		stack2.push(11.55);
		stack2.push(69.49);
		stack2.push(78.97);
		stack2.push(25.32);
		stack2.push(19.19);
		System.out.println(stack2.isEmpty()); //stack wurde gefüllt -> nicht mehr leer -> false
		System.out.println(stack2); //ausgabe stack
		System.out.println(stack2.top()); //ausgabe von 19.19
		System.out.println(stack2);	//Stack noch vollständig
		System.out.println(stack2.pop()); //19.19 wird gelöscht und erneut ausgegeben
		System.out.println(stack2); //Stack nun nichtmehr vollständig, 19.19 fehlt

		
	}
	
	
}
