package hdfc.loans.homeloans;

public class Student
{
	int sno;
	String sname;
	
	public Student()
    {
		System.out.println("iam default constructor...");
    }

	public Student(int i, String string)
	{
		sno = i;
		sname= string;
	}

	public static void main(String[] args) 
	{
		Student s1 = new Student();
		System.out.println(s1.sno);
		System.out.println(s1.sname);
		
		Student s2 = new Student(1744,"ravi");
		System.out.println(s2.sno);
		System.out.println(s2.sname);
	}

}
