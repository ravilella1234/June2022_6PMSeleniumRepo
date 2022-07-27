package hdfc.loans.homeloans;

public class TypeCasting 
{

	public static void main(String[] args) 
	{
		// byte-1 , short-2 , int-4 , long-8 , float-4, double-8, char-2
		
		//1-Liter  ---> 500ML    ---> There is no risk ---> widening
		//1-Liter  ---> 1.5 Ltr  ---> There is a risk (water overflow)  ---> Narrowing
		
		
		//Type Casting from one Primitive type to  another one Primitive type
		int x1 = 10;
		System.out.println(x1);
		
		double x2 = x1;
		System.out.println(x2);
		
		double y1 = 12.34;
		System.out.println(y1);
		
		int y2 = (int)y1;
		System.out.println(y2);
		
		int p=97;
		System.out.println(p);
		
		char q = (char)p;
		System.out.println(q);
		
		//Type Casting from one Primitive type to  corresponding wapperClass type
		
		int i1 = 10;
		System.out.println(i1);
		
		//Integer i2 = i1;
		Integer i2 = Integer.valueOf(i1);
		System.out.println(i2);
		
		Integer i3 = 20;
		System.out.println(i3);
		
		//int i4 = i3;
		int i4 = (int)i3;
		System.out.println(i4);
		
		System.out.println("------------------------------------");
		
		//Type Casting from one wapperClass type to another wapperClass type
		
		String s1 = "200";
		String s2 = "300";
		
		System.out.println(s1+s2);
		
		int z1 = Integer.parseInt(s1);
		int z2 = Integer.parseInt(s2);
		System.out.println(z1+z2);
		
		float fp1 = Float.parseFloat(s1);
		float fp2 = Float.parseFloat(s2);
		System.out.println(fp1+fp2);
	}

}
