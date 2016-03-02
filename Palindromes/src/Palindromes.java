/*Conor Gafffney
 * This program checks if a String is a palindrome, which is a word or words spelled the same forwards and backwards.  It 
 * doesn't consider any non-alpha-numeric characters (punctuation, spaces, etc.) when determining this, and ignores case.
 */

import java.io.*;

public class Palindromes 
{
	
	public Palindromes() //constructor
	{
	}
	
	public String findString() throws IOException //gets String to be checked
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		System.out.println("Enter a word or phrase to see if it's a palindrome!");
		String x = input.readLine();
		int check = 0;
		while(!Character.isLetterOrDigit(x.charAt(check)))
		{
			check++;
			if(check == x.length())
			{
				x = "";
				break;
			}
		}
		while(x.length() == 0)
		{
			System.out.println("Please enter something, nothing doesn't cut it!");
			x = input.readLine();
			check = 0;
			while(!Character.isLetterOrDigit(x.charAt(check)))
			{
				check++;
				if(check == x.length())
				{
					x = "";
					break;
				}
			}
		}
		return x;
	}
	
	public boolean checkPali(String line) //checks for palindrome conditions
	{
		int length = line.length() - 1;
		int start = 0;
		do
		{
			while(!Character.isLetterOrDigit(line.charAt(start))) //gets to next alpha-num going front to back
			{
				start++;
			}
			while(!Character.isLetterOrDigit(line.charAt(length))) //gets to next alpha-num going back to front
			{
				length--;
			}
			
			if(Character.isLetter(line.charAt(start)) && Character.isLetter(line.charAt(length)))
			{
				if(Character.toLowerCase(line.charAt(start)) != Character.toLowerCase(line.charAt(length)))
					return false;
			}
			else if(line.charAt(start) != line.charAt(length))
				return false;
			start++;
			length--;
		}
		while(length-start >= 0);
		
		return true;
	}
	
	public static void main(String [] args) throws IOException //runner
	{
		Palindromes BothWays = new Palindromes();
		
		if(BothWays.checkPali(BothWays.findString()))
			System.out.println("This is a palindrome!");
		else
			System.out.println("This is not a palindrome!");
	}
/*Enter a word or phrase to see if it's a palindrome!
man   o       nam
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
I palindrome I
This is not a palindrome!

Enter a word or phrase to see if it's a palindrome!
Egad, a base tone denotes a bad age.
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
#$%^&*)+=-!@#$%BUB@#$%^&*
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
z
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
%%%%%%%%%%%%%%%%%%%%%%%%%%b        o     !@#$%  b 
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
1 2 3 4 5 4 3 2 1
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
!@#$%^&*+{
Please enter something, nothing doesn't cut it!
!*!
Please enter something, nothing doesn't cut it!
#
Please enter something, nothing doesn't cut it!
@@@@@@@@@@@@@@@@@@@@h%#aNnAh
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
###############h%#anxah
This is not a palindrome!

Enter a word or phrase to see if it's a palindrome!
***!!!Z
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
%$#@!Z_______________
This is a palindrome!

Enter a word or phrase to see if it's a palindrome!
Ma 7 dam, I'm, Ad 7 am.
This is a palindrome!
 * 
 */

}
