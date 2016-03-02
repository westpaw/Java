
//Conor Gaffney
//April 10 2014

public class ISBNprogram 
{
	
	public static void main(String [] args)
	{
		
		String ISBN = "957-621-541-2";
		String numbers9; // 9 digits of ISBN not including check digit
		String digits = "0123456789X";// Used to sub X in for 10
		
		int hyphen1 = ISBN.indexOf('-');
		int hyphen2 = ISBN.indexOf('-',hyphen1+1);
		
		String part1 = ISBN.substring(0,hyphen1); // digits up to first hyphen
		String part2 = ISBN.substring(hyphen1+1,hyphen2); // digits up to second hyphen
		String part3 = ISBN.substring(hyphen2+1,11); // digits up to third hyphen
		
		numbers9 = part1+part2+part3;
		
		String index0 = numbers9.substring(0,1); // index# identifiers separate the digits of the ISBN
		String index1 = numbers9.substring(1,2);
		String index2 = numbers9.substring(2,3);
		String index3 = numbers9.substring(3,4);
		String index4 = numbers9.substring(4,5);
		String index5 = numbers9.substring(5,6);
		String index6 = numbers9.substring(6,7);
		String index7 = numbers9.substring(7,8);
		String index8 = numbers9.substring(8,9);
		
		int digit1 = Integer.parseInt(index0); // digit# identifiers are the integer forms of the ISBN digits
		int digit2 = Integer.parseInt(index1);
		int digit3 = Integer.parseInt(index2);
		int digit4 = Integer.parseInt(index3);
		int digit5 = Integer.parseInt(index4);
		int digit6 = Integer.parseInt(index5);
		int digit7 = Integer.parseInt(index6);
		int digit8 = Integer.parseInt(index7);
		int digit9 = Integer.parseInt(index8);
		
		int check = 10-((10*digit1)+(9*digit2)+(8*digit3)+(7*digit4)+(6*digit5)+(5*digit6)+(4*digit7)+(3*digit8)+(2*digit9)-1)%11;
		// check value should match the last ISBN digit, with 10 = X
		
		System.out.println("ISBN Number: "+ISBN);
		System.out.println("Check digit from number: "+ISBN.charAt(12));
		System.out.println("Check digit from calculations: "+digits.charAt(check));
		
		
	}
/*Output:
 * 
 * ISBN Number: 0-7645-0417-7
Check digit from number: 7
Check digit from calculations: 7
 * 
 * ISBN Number: 0-7654-0417-6
Check digit from number: 6
Check digit from calculations: 6
 * 
 *ISBN Number: 0-912517-31-X
Check digit from number: X
Check digit from calculations: X
 * 
 * ISBN Number: 3-314-21145-7
Check digit from number: 7
Check digit from calculations: 7
 * 
 * ISBN Number: 91-29-65497-1
Check digit from number: 1
Check digit from calculations: 1
 * 
 * ISBN Number: 957-621-541-2
Check digit from number: 2
Check digit from calculations: 2
 */
}
