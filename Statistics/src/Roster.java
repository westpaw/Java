/* Conor Gaffney
 * 
 * This class holds an array containing the profiles of all the students in a class, where the maximum number is 30.  Reads the list of
 * the students from a .txt file.  The students' information is displayed in order of ascending ID number.  The highest, lowest, average
 * and median scores are displayed.  Then percentage of each letter grade.  Tells how many scores were invalid (not used in calculations
 * for other scores) or if an invalid code for the major is incorrect.  
 * 
 */

import java.io.*;
import java.util.StringTokenizer;

public class Roster
{
	
	private static final int MAX_CLASS = 30; //max number enrolled
	private static final int LOW_A = 90;
	private static final int LOW_B = 80;
	private static final int LOW_C = 70;
	private static final int LOW_D = 65;
	
	private Student [] list;
	private int fill;
	
	public Roster()
	{
		list = new Student [MAX_CLASS];
		fill = 0;
	}
	
	public void readSpecs() throws IOException //takes sequence of ID number - score - major code from .txt file and assigns it to a Student object
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the name of the .txt file with the formatted student details: ");
		
		FileReader readFile = new FileReader(input.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		
		System.out.println("Reading file...");
		String in = inFile.readLine();
		
		int id;
		int s;
		char m;
		
		while(in != null)
		{
			StringTokenizer st = new StringTokenizer(in);
			while(st.hasMoreTokens())
			{
				id = Integer.parseInt(st.nextToken()); //takes 3 consecutive tokens, uses them to make one object
				s = Integer.parseInt(st.nextToken());
				m = st.nextToken().charAt(0);
				list[fill] = new Student(id, s, m);
				fill++;
			}
			in = inFile.readLine();
		}
		
		inFile.close();
		System.out.println("Reading completed." + '\r');
	}
	
	public void sortStudents(char type)
	{
		Student temp = new Student(0, 0, ' ');
		for(int x = 1;x < fill;x++)
		{
			int a = x;
			if(type == 'i')
			{
				for(int y = x-1;y >= 0 && list[a].getID() <= list[y].getID();y--)
				{
					if(list[a].getID() < list[y].getID())
					{
						temp = list[a];
						list[a] = list[y]; //check to see if this works or if setters needed for each change
						list[y] = temp;
						a = y;
					}
				}
			}
			else if(type == 's')
			{
				for(int y = x-1;y >= 0 && list[a].getScore() <= list[y].getScore();y--)
				{
					if(list[a].getScore() < list[y].getScore())
					{
						temp = list[a];
						list[a] = list[y]; //check to see if this works or if setters needed for each change
						list[y] = temp;
						a = y;
					}
				}
			}
		}
	}
	
	public void displayRoster()
	{
		System.out.println("ID Num" + '\t' + "Score" + '\t' + "Major" + '\n');	
		for(int x = 0;x < fill;x++)
			list[x].displayInfo();
	}
	
	public void displayScores() //finds and displays high, low, mean, and median scores, finds and prints percentage of each letter grade, prints number of bad scores inputed
	{
        int lo = 0;
		int total = 0; //total score to be used in mean calc
		int a = 0; //number of a's, b's, etc
		int b = 0;
		int c = 0;
		int d = 0;
		int f = 0;
		int bad = 0; //num of bad scores
		
		for(int x = 0;x < fill;x++)
		{
			if(list[x].isGoodScore())
			{
				while(list[lo].getScore() < Student.getMIN())
					lo++;
				total += list[x].getScore();
				if(list[x].getScore() > LOW_A)
					a++;
				else if(list[x].getScore() > LOW_B)
					b++;
				else if(list[x].getScore() > LOW_C)
					c++;
				else if(list[x].getScore() > LOW_D)
					d++;
				else
					f++;
			}
			else
				bad++;
		}
		System.out.println('\n' + "Highest Score: " + list[fill-1].getScore());
		System.out.println("Lowest Score: " + list[lo].getScore());
		System.out.println("Average Score: " + Math.round(total*100/fill)/100.0);
		System.out.print("Median Score: ");
		if(fill%2 != 0)
			System.out.println(list[fill/2 + 1].getScore() + '\n');
		else
			System.out.println(Math.round(list[fill/2].getScore() + list[fill/2 + 1].getScore() * 50.0/* *100 for round and /2.0 for average */)/100.0 + '\n');
		System.out.println("Letter Grade Percentages: ");
		System.out.println("A: " + Math.round(1000 * a/(fill - bad))/10.0 + '%');
		System.out.println("B: " + Math.round(1000 * b/(fill - bad))/10.0 + '%');
		System.out.println("C: " + Math.round(1000 * c/(fill - bad))/10.0 + '%');
		System.out.println("D: " + Math.round(1000 * d/(fill - bad))/10.0 + '%');
		System.out.println("F: " + Math.round(1000 * f/(fill - bad))/10.0 + '%' + '\n');
		System.out.println(bad + " invalid score values were entered.  These scores were not used in calculating the above results. ");
	}
	
	public int findID(Student [] array, int target) //finds a target in an array, returns index of targer, returns -1 if target not found
	{
		int left = 0;
		int right = fill - 1;
		while(left <= right)
		{
			int middle = (left + right) / 2;
			if(target < array[middle].getID())
				right = middle - 1;
			else if(target > array[middle].getID())
				left = middle + 1;
			else
				return middle;
		}
		return -1;
	}
	
	public void search() throws IOException
	{
		char go;
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		do
		{
			System.out.println("Enter an ID number to see the student's information: ");
			int a = this.findID(list, Integer.parseInt(input.readLine()));
			if(a == -1)
				System.out.println("That student does not exist.");
			else
			{
				System.out.println("ID Num" + '\t' + "Score" + '\t' + "Major");	
				list[a].displayInfo();
				System.out.println();
			}
			System.out.println("Enter 'Y' if you'd like to search for another student, or 'N' if not. ");
			go = input.readLine().charAt(0);
		}
		while(go == 'y' || go == 'Y');
	}

}
