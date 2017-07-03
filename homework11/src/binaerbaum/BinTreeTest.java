package binaerbaum;

public class BinTreeTest 
{
	public static void main(String[] args)
	{
	Student s1 = new Student("Lukas","Paschen",123456);
	Student s2 = new Student("Paula","Zenker",191919);
	Student s3 = new Student("Nick","Rittich",666666);
	Student s4 = new Student("Anton","Shamin",245869);
	Student s5 = new Student("Tobias","Stengel",987654);
	Student s6 = new Student("David","Linke",558521);
	
	Student search = new Student("Linke");
	
	BinTree<Student> tree1=new BinTree<>();
	tree1.add(s4);
	tree1.add(s2);
	tree1.add(s3);
	tree1.add(s1);
	tree1.add(s5);
	System.out.println(tree1.toString());
	tree1.add(s6);
	System.out.println(tree1.toString());
	System.out.println(tree1.find(search).toString());
	
	System.out.println("\n\n");
	
	Integer i1 = new Integer(5);
	Integer i2 = new Integer(2);
	Integer i3 = new Integer(8);
	Integer i4 = new Integer(4);
	Integer i5 = new Integer(1);
	Integer i6 = new Integer(6);
	
	Integer isearch = new Integer(2);
	
	BinTree<Integer> tree2=new BinTree<>();
	tree2.add(i1);
	tree2.add(i2);
	tree2.add(i3);
	tree2.add(i4);
	tree2.add(i5);
	System.out.println(tree2.toString());
	tree2.add(i6);
	System.out.println(tree2.toString());
	System.out.println(tree2.find(isearch).toString());
	
	System.out.println("\n\n");
	
	Float f1 = new Float(5.3);
	Float f2 = new Float(5.5);
	Float f3 = new Float(5.0);
	Float f4 = new Float(6);
	Float f5 = new Float(7.8);
	Float f6 = new Float(4.9);
	
	Float fsearch = new Float(5.5);
	
	BinTree<Float> tree3=new BinTree<>();
	tree3.add(f3);
	tree3.add(f2);
	tree3.add(f5);
	tree3.add(f1);
	tree3.add(f4);
	System.out.println(tree3.toString());
	tree3.add(f6);
	System.out.println(tree3.toString());

	try{
	System.out.println(tree3.find(fsearch).toString());
	}catch(NullPointerException e){}

	}
}
