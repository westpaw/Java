//Conor Gaffney
//Notice that different parts of the program are in different colors.
//Use the tab key to indent.

public class Operations
{
	public static void main(String [] args)
	{
		int int1, int2,int3;
		double double1, double2;
		
		int1 = 35;
		int2 = 8;
		int3 = int1%int2;
				
		double1 = 32.112233445566778899;
		double2 = 9.15;
		
		System.out.println("Conor Gaffney");
		System.out.println();
				
		System.out.println(int1 + "+" + int2 + "=" + (int1+int2));
		System.out.println(int1 + "/" + int2 + "=" + (int1/int2));
		System.out.println(int1 + "%" + int2 + "=" + int3);
		System.out.println();
		
		System.out.println(double1 + "+" + double2 + "=" + (double1+double2));
		System.out.println(double1 + "/" + double2 + "=" + (double1/double2));
		
	}

}

/* Output:
 * 
 * Conor Gaffney

35+8=43
35/8=4
35%8=3

32.11223344556678+9.15=41.26223344556678
32.11223344556678/9.15=3.5095337098980086

*/

