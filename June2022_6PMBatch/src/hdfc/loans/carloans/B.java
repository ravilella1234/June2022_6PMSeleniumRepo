package hdfc.loans.carloans;

public class B extends A // ISA Relationship
{
	public void m2()
	{
		System.out.println("iam m2 from B");
	}

	public static void main(String[] args) 
	{
		A a = new A(); // HASA Relationship
		a.m1();
		
		B b = new B();
		b.m2();
		b.m1();
	}

}
