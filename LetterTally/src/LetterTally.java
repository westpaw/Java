/* Conor Gaffney
 * 
 * This program uses a .txt file, and keeps a tally of how many times each letter is stored.  Capital and lower case is not
 * considered.  It outputs the entire .txt file, the number of times each letter is used, and the percentage of use for each
 * letter.
 */
import java.io.*;

public class LetterTally
{
	
	private int [] letters = new int [26];
	private int totalLet = 0;
	
	public LetterTally() //constructor
	{
	}
	
	public void countLetters() throws IOException //finds .txt file, reads it in, and keeps count of how many of each letter are present in the file
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the name of the .txt file to be read: ");
		
		FileReader readFile = new FileReader(input.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		
		System.out.println("Reading file..." + '\r');
		String inputString = inFile.readLine();
		
		while(inputString != null)
		{
			System.out.println(inputString);
			for(int x = 0;x < inputString.length();x++)
			{
				int l = (int)inputString.charAt(x);
				if(l-97 >= 0 && l-122 <=0) //if ASCII value of char is for lower case a-z
				{
					letters[Math.abs(97-l)]++;
					totalLet++;
				}
				else if(l-65 >= 0 && l-90 <= 0) //if ASCII value of char is for upper case a-z
				{
					letters[Math.abs(65-l)]++;
					totalLet++;
				}
			}
			inputString = inFile.readLine();
		}
		
		inFile.close();
		System.out.println('\r' + "Reading completed.");
	}
	
	public double percent(int x)
	{
		return Math.round(1000.0*x/totalLet)/10.0;
	}
	
	public void output(int x)
	{
		System.out.println("There are " + letters[x] + " " + (char)(x+65) + "'s in this file, making up " + this.percent(letters[x]) + "% of the letters used.");
	}
	
	public static void main(String [] args) throws IOException
	{
		LetterTally tally = new LetterTally();
		tally.countLetters();
		for(int x = 0;x < 26;x++)
			tally.output(x);
	}
/* Enter the name of the .txt file to be read: 
sample.txt
Reading file...

The quick brown fox jumps over the lazy dog.

Reading completed.
There are 1 A's in this file, making up 2.9% of the letters used.
There are 1 B's in this file, making up 2.9% of the letters used.
There are 1 C's in this file, making up 2.9% of the letters used.
There are 1 D's in this file, making up 2.9% of the letters used.
There are 3 E's in this file, making up 8.6% of the letters used.
There are 1 F's in this file, making up 2.9% of the letters used.
There are 1 G's in this file, making up 2.9% of the letters used.
There are 2 H's in this file, making up 5.7% of the letters used.
There are 1 I's in this file, making up 2.9% of the letters used.
There are 1 J's in this file, making up 2.9% of the letters used.
There are 1 K's in this file, making up 2.9% of the letters used.
There are 1 L's in this file, making up 2.9% of the letters used.
There are 1 M's in this file, making up 2.9% of the letters used.
There are 1 N's in this file, making up 2.9% of the letters used.
There are 4 O's in this file, making up 11.4% of the letters used.
There are 1 P's in this file, making up 2.9% of the letters used.
There are 1 Q's in this file, making up 2.9% of the letters used.
There are 2 R's in this file, making up 5.7% of the letters used.
There are 1 S's in this file, making up 2.9% of the letters used.
There are 2 T's in this file, making up 5.7% of the letters used.
There are 2 U's in this file, making up 5.7% of the letters used.
There are 1 V's in this file, making up 2.9% of the letters used.
There are 1 W's in this file, making up 2.9% of the letters used.
There are 1 X's in this file, making up 2.9% of the letters used.
There are 1 Y's in this file, making up 2.9% of the letters used.
There are 1 Z's in this file, making up 2.9% of the letters used.

Enter the name of the .txt file to be read: 
paragraph.txt
Reading file...

	An array is a data structure made up of a group of locations having the 
same type and given a common name.  Each individual location is accessed by 
its name and position (index) in the group.  The position numbering starts at 
zero.

	Described below are some typical types of processing that occur when 
using arrays:  searching, sorting, and parallel arrays.

	Searching is looking systematically through the elements of an array for a 
specific value.  You may need to know only if the value is in the array, or you 
may need to know its position in the array.  There are two algorithms for 
searching:  linear and binary.

	Arranging values in ascending, descending, or alphabetical order is 
called sorting.  There are many different algorithms for sorting.  The ones we will 
study include selection, bubble, insertion, merge, and quick.  Which of these do 
you already know? 

	In many problems there are several pieces which go together.  For 
example, you might have student id numbers, gender codes (M or F), and qpas.  
You could use an integer array for the id numbers, a character array for the 
gender codes, and a double array for the qpas.  A particular id number goes
with a particular gender code and a particular qpa because they have the same 
position in their respective arrays, that is, they have the same index!  Such
arrays are called parallel arrays.

Reading completed.
There are 115 A's in this file, making up 10.7% of the letters used.
There are 15 B's in this file, making up 1.4% of the letters used.
There are 41 C's in this file, making up 3.8% of the letters used.
There are 42 D's in this file, making up 3.9% of the letters used.
There are 125 E's in this file, making up 11.6% of the letters used.
There are 17 F's in this file, making up 1.6% of the letters used.
There are 30 G's in this file, making up 2.8% of the letters used.
There are 45 H's in this file, making up 4.2% of the letters used.
There are 76 I's in this file, making up 7.1% of the letters used.
There are 0 J's in this file, making up 0.0% of the letters used.
There are 5 K's in this file, making up 0.5% of the letters used.
There are 42 L's in this file, making up 3.9% of the letters used.
There are 26 M's in this file, making up 2.4% of the letters used.
There are 74 N's in this file, making up 6.9% of the letters used.
There are 70 O's in this file, making up 6.5% of the letters used.
There are 25 P's in this file, making up 2.3% of the letters used.
There are 4 Q's in this file, making up 0.4% of the letters used.
There are 93 R's in this file, making up 8.7% of the letters used.
There are 67 S's in this file, making up 6.2% of the letters used.
There are 70 T's in this file, making up 6.5% of the letters used.
There are 34 U's in this file, making up 3.2% of the letters used.
There are 11 V's in this file, making up 1.0% of the letters used.
There are 11 W's in this file, making up 1.0% of the letters used.
There are 3 X's in this file, making up 0.3% of the letters used.
There are 33 Y's in this file, making up 3.1% of the letters used.
There are 1 Z's in this file, making up 0.1% of the letters used.

 * 
 */
}
