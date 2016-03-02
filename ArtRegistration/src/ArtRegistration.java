/*Conor Gaffney
 * May 23 2014
 * This class allows users to register for courses at an art workshop.  One enters his or her ID number
 * and the first letter of the course he or she wishes to take.  It outputs the ID and the course name.  It will 
 * stop taking registrations when 0 is entered for the ID number.  It then determines how many sections of 
 * each course are necessary.  No courses will be scheduled if less than 2 people register.  It outputs the 
 * course names, number of people registered to it, and the number of courses that need to be scheduled.
 */

import java.io.*;

public class ArtRegistration 
{
	
	private final static int MIN_ATTENDANCE = 3;
	private final static int MAX_BATIK = 6; //max number of members for each course
	private final static int MAX_CALLIGRAPHY = 4;
	private final static int MAX_PAINTING = 7;
	private final static int MAX_SCULPTURE = 4;
	private final static int MAX_WEAVING = 5;
	
	private int batik; //number of members in each course
	private int callig;
	private int paint;
	private int sculpt;
	private int weave;
	
	public ArtRegistration()
	{
		batik = 0;
		callig = 0;
		paint = 0;
		sculpt = 0;
		weave = 0;
	}
	
	public int getBatik()
	{
		return batik;
	}
	
	public int getCallig()
	{
		return callig;
	}
	
	public int getPaint()
	{
		return paint;
	}
	
	public int getSculpt()
	{
		return sculpt;
	}
	
	public int getWeave()
	{
		return weave;
	}
	
	public static int inputID() throws IOException //input
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		System.out.print("Enter your ID number: ");
		return Integer.parseInt(input.readLine());
	}
	
	public static char inputCourseLetter() throws IOException //input + checks for valid course letter
	{
		boolean check = false;
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		System.out.print("Enter the first letter of the course you wish to take: ");
		char c = input.readLine().charAt(0);
		while(check != true)
		{
			if(c == 'b' || c == 'c' || c == 'p' || c == 's' || c == 'w' || c == 'B' || c == 'C' || c == 'P' || c == 'S' || c == 'W')
				check = true;
			else
			{
				System.out.print("Invalid course letter, please submit the first letter of your course name: ");
				c = input.readLine().charAt(0);
			}
		}
		return c;
	}
	
	public void countMembers() throws IOException //records number of members taking each course
	{
		String course;
		int id = ArtRegistration.inputID();
		char cLetter; //first letter of course name
		while(id != 0)
		{
			cLetter = ArtRegistration.inputCourseLetter();
			if(cLetter == 'b' || cLetter == 'B')
			{
				batik++;
				course = "Batik";
			}
			else if(cLetter == 'c' || cLetter == 'C')
			{
				callig++;
				course = "Calligraphy";
			}
			else if(cLetter == 'p' || cLetter == 'P')
			{
				paint++;
				course = "Painting";
			}
			else if(cLetter == 's' || cLetter == 'S')
			{
				sculpt++;
				course = "Sculpture";
			}
			else
			{
				weave++;
				course = "Weaving";
			}
			System.out.println("ID Number: " + id);
			System.out.println("Registered Course : " + course);
			System.out.println();
			id = ArtRegistration.inputID();
		}
	}
	
	public int courseCount(int members, int maxMem) //determines number of course sessions needed
	{
		if(members < MIN_ATTENDANCE)
			return 0;
		else if(members%maxMem == 0)
			return members/maxMem;
		else
			return members/maxMem + 1;
	}
	
	public String toString(String course, int members, int maxMem) //formatting
	{
		return "Course: " + course + '\n' + "Number of Members: " + members + '\n' + "Number of Sessions Needed: " + courseCount(members, maxMem);
	}
	
	public static void main(String [] args) throws IOException
	{
		ArtRegistration Art = new ArtRegistration();
		Art.countMembers();
		System.out.println(Art.toString("Batik",Art.getBatik(),MAX_BATIK));
		System.out.println(Art.toString("Calligraphy", Art.getCallig(), MAX_CALLIGRAPHY));
		System.out.println(Art.toString("Painting", Art.getPaint(), MAX_PAINTING));
		System.out.println(Art.toString("Sculpture", Art.getSculpt(), MAX_SCULPTURE));
		System.out.println(Art.toString("Weaving", Art.getWeave(), MAX_WEAVING));
	}
/* Output:
 * 
Enter your ID number: 18
Enter the first letter of the course you wish to take: S
ID Number: 18
Registered Course : Sculpture

Enter your ID number: 24
Enter the first letter of the course you wish to take: S
ID Number: 24
Registered Course : Sculpture

Enter your ID number: 21
Enter the first letter of the course you wish to take: C
ID Number: 21
Registered Course : Calligraphy

Enter your ID number: 19
Enter the first letter of the course you wish to take: W
ID Number: 19
Registered Course : Weaving

Enter your ID number: 32
Enter the first letter of the course you wish to take: B
ID Number: 32
Registered Course : Batik

Enter your ID number: 20
Enter the first letter of the course you wish to take: S
ID Number: 20
Registered Course : Sculpture

Enter your ID number: 10
Enter the first letter of the course you wish to take: S
ID Number: 10
Registered Course : Sculpture

Enter your ID number: 11
Enter the first letter of the course you wish to take: C
ID Number: 11
Registered Course : Calligraphy

Enter your ID number: 12
Enter the first letter of the course you wish to take: C
ID Number: 12
Registered Course : Calligraphy

Enter your ID number: 35
Enter the first letter of the course you wish to take: R
Invalid course letter, please submit the first letter of your course name: Y
Invalid course letter, please submit the first letter of your course name: M
Invalid course letter, please submit the first letter of your course name: W
ID Number: 35
Registered Course : Weaving

Enter your ID number: 38
Enter the first letter of the course you wish to take: W
ID Number: 38
Registered Course : Weaving

Enter your ID number: 40
Enter the first letter of the course you wish to take: B
ID Number: 40
Registered Course : Batik

Enter your ID number: 19
Enter the first letter of the course you wish to take: S
ID Number: 19
Registered Course : Sculpture

Enter your ID number: 98
Enter the first letter of the course you wish to take: S
ID Number: 98
Registered Course : Sculpture

Enter your ID number: 87
Enter the first letter of the course you wish to take: C
ID Number: 87
Registered Course : Calligraphy

Enter your ID number: 18
Enter the first letter of the course you wish to take: W
ID Number: 18
Registered Course : Weaving

Enter your ID number: 51
Enter the first letter of the course you wish to take: S
ID Number: 51
Registered Course : Sculpture

Enter your ID number: 52
Enter the first letter of the course you wish to take: W
ID Number: 52
Registered Course : Weaving

Enter your ID number: 67
Enter the first letter of the course you wish to take: S
ID Number: 67
Registered Course : Sculpture

Enter your ID number: 15
Enter the first letter of the course you wish to take: C
ID Number: 15
Registered Course : Calligraphy

Enter your ID number: 44
Enter the first letter of the course you wish to take: R
Invalid course letter, please submit the first letter of your course name: C
ID Number: 44
Registered Course : Calligraphy

Enter your ID number: 48
Enter the first letter of the course you wish to take: S
ID Number: 48
Registered Course : Sculpture

Enter your ID number: 0
Course: Batik
Number of Members: 2
Number of Sessions Needed: 0
Course: Calligraphy
Number of Members: 6
Number of Sessions Needed: 2
Course: Painting
Number of Members: 0
Number of Sessions Needed: 0
Course: Sculpture
Number of Members: 9
Number of Sessions Needed: 3
Course: Weaving
Number of Members: 5
Number of Sessions Needed: 1
 * 
 */
}
