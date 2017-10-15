/*
 * David Linke
 * S0558521
 */

package datenstruktur;

public class TestListe 
{
	public static void main(String[] args)
	{
		Liste list = new Liste();
		list.addFirst(5);
		list.addFirst(2);
		list.addLast(5);
		list.add(3, 2);
		list.add(4, 3);
		list.add(67, 4);
		list.add(4, 5);
		System.out.println(list);
		list.addFirst(1);
		list.addLast(1);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		if(list.contains(3))
			System.out.println("3 enthalten");
		if(list.contains(10))
			System.out.println("10 enthalten");
		System.out.println(list.size());
		list.removeAtIndex(4);
		list.removeFirst();
		System.out.println(list);
		
		
		Liste list2 = new Liste();
		System.out.println("\n"+list2);
		System.out.println(list2.size());
		if(list2.contains(2))
			System.out.println("enthält 2");
		list2.addLast(1);
		list2.addLast(2);
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		try{
		System.out.println(list2.get(2));
		}catch (Exception e) 
		{
			System.out.println("Wert mit diesem Index existiert nicht");
		}
		list2.set(99, 0);
		System.out.println(list2);
		try{
			list2.set(123, 50);
			}catch (Exception e) 
			{
				System.out.println("Wert mit diesem Index existiert nicht");
			}
		if(list2.add(5, 2))
			System.out.println("5 erfolgreich hinzugefügt");
		if(list2.add(55, 22))
			System.out.println("55 erfolgreich hinzugefügt");
		list2.remove(50);
		
		Liste list3 = new Liste();
		try{
			list3.removeFirst();
			}catch (Exception e) 
			{
				System.out.println("Liste leer");
			}
		try{
			list3.removeLast();
			}catch (Exception e) 
			{
				System.out.println("Liste leer");
			}
		try{
			list3.removeAtIndex(4);
			}catch (Exception e) 
			{
				System.out.println("Wert mit diesem Index existiert nicht");
			}
	}
}