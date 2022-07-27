package hdfc.loans.carloans;

public class ChildClass extends FirstAbstract
{

	public static void main(String[] args) 
	{
		ChildClass obj = new ChildClass();
		obj.m1();
		obj.m2();
	}

	public void m1()
	{
		System.out.println("iam m1 overriden in ChildClass");
	}
	
	@Override
	public void m2() 
	{
		System.out.println("iam m2 overriden in ChildClass");
	}

}
