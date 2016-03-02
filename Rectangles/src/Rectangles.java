/*Conor Gaffney
 * May 23 2014
 * This class makes rectangles from stars with dimensions specified by the user.  It can print a rectangle with a width
 * of up to 80 stars and a length of up to 25 stars.  It continues to run until the user inputs "end" for the width.
 */

import java.io.*;

public class Rectangles 
{
	
	private final static int MAX_WIDTH = 80;
	private final static int MAX_LENGTH = 25;
	private final static int MIN_SIDE = 0;
	
	private int length;
	private int width;
	
	public Rectangles(int w,int l)
	{
		width = w;
		length = l;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public void setLength(int l)
	{
		length = l;
	}
	
	public static int inputWidth() throws IOException //asks for width, makes sure length is valid and if user wants to end program
	{
		int side;
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		System.out.println("Enter a width for your rectangle, max length of 80");
		System.out.print("Or enter " + '\"' + "end" + '\"' + " to end the program: ");
		String w = input.readLine();
		if(w.equalsIgnoreCase("end"))
			return -999;
		else
		{
			side = Integer.parseInt(w);
			while(side < MIN_SIDE || side > MAX_WIDTH)
			{
				System.out.println("Invalid width; must have length between 1 and 80, inclusive");
				System.out.print("Reenter a width for your rectangle: ");
				side = Integer.parseInt(input.readLine());
			}
		}
		return side;
	}
	
	public void makeRectangle()
	{
		System.out.println("Your rectangle has a width of " + width + " stars, a length of " + length + " stars and an area of " + length * width + " square stars");
		for(int l = 1;l <= length;l++)
		{
			for(int w = 1;w <= width;w++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int inputLength() throws IOException //asks user for length, makes sure length is valid
	{
		int side;
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		System.out.print("Enter a length for your rectangle, max length of 25: ");
		side = Integer.parseInt(input.readLine());
			while(side < MIN_SIDE || side > MAX_LENGTH)
			{
				System.out.println("Invalid length; must have length between 1 and 25, inclusive");
				System.out.print("Reenter a length for your rectangle: ");
				side = Integer.parseInt(input.readLine());
			}
		return side;
	}
	
	public static void main(String [] args) throws IOException
	{
		Rectangles rect = new Rectangles(Rectangles.inputWidth(),Rectangles.inputLength());
		while(rect.getWidth() != -999)
		{
			rect.makeRectangle();
			System.out.println("Enter another length and width");
			rect.setWidth(Rectangles.inputWidth());
			if(rect.getWidth() != -999)
				rect.setLength(Rectangles.inputLength());
		}
	}
/*Output:
 * 
Enter a width for your rectangle, max length of 80
Or enter "end" to end the program: -8
Invalid width; must have length between 1 and 80, inclusive
Reenter a width for your rectangle: 100
Invalid width; must have length between 1 and 80, inclusive
Reenter a width for your rectangle: 81
Invalid width; must have length between 1 and 80, inclusive
Reenter a width for your rectangle: 1
Enter a length for your rectangle, max length of 25: -5
Invalid length; must have length between 1 and 25, inclusive
Reenter a length for your rectangle: 30
Invalid length; must have length between 1 and 25, inclusive
Reenter a length for your rectangle: 25
Your rectangle has a width of 1 stars, a length of 25 stars and an area of 25 square stars
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*

Enter another length and width
Enter a width for your rectangle, max length of 80
Or enter "end" to end the program: 10
Enter a length for your rectangle, max length of 25: 2
Your rectangle has a width of 10 stars, a length of 2 stars and an area of 20 square stars
**********
**********

Enter another length and width
Enter a width for your rectangle, max length of 80
Or enter "end" to end the program: 5
Enter a length for your rectangle, max length of 25: 8
Your rectangle has a width of 5 stars, a length of 8 stars and an area of 40 square stars
*****
*****
*****
*****
*****
*****
*****
*****

Enter another length and width
Enter a width for your rectangle, max length of 80
Or enter "end" to end the program: end

 */
}
