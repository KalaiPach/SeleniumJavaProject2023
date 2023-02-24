package day03;

public class program01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=10;
		int b=0;
		
		System.out.println(a+b);
		try
		{
		System.out.println(a/b);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
	//		System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Blocked");
		}
		System.out.println(a-b);
		System.out.println(a*b);
		
	}

}
