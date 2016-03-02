/* Conor Gaffney
 * This class is a profile for a student, which includes an ID number, test score, and code for the student's major.
 * It can display this information.
 */
public class Student 
{
	private static final int MIN_SCORE = 0;
	private static final int MAX_SCORE = 100;
	
	private int ID;
	private int score;
	private char major;
	private boolean goodScore = true;
	
	public Student(int id, int s, char m)
	{
		ID = id;
		score = s;
		if(score < MIN_SCORE || score > MAX_SCORE)
			goodScore = false;
		major = m;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public static final int getMIN()
	{
		return MIN_SCORE;
	}
	
	public boolean isGoodScore()
	{
		return goodScore;
	}

	public void displayInfo()
	{
		System.out.print(ID); 
		System.out.print('\t');
		System.out.print(score);
		System.out.print('\t');
		switch(major)
		{
		case('C'):
		case('c'):
			System.out.println("Computer Science");
			break;
		case('E'):
		case('e'):
			System.out.println("Education");
			break;
		case('M'):
		case('m'):
			System.out.println("Mathematics");
			break;
		case('B'):
		case('b'):
			System.out.println("Business");
			break;
		case('N'):
		case('n'):
			System.out.println("Engineering");
			break;
		case('A'):
		case('a'):
			System.out.println("Art");
			break;
		default:
			System.out.println("Incorrect Course Code");
		}
	}
	
}
