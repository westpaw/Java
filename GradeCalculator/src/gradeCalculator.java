//Conor
//This program calculates the grade of a student by dividing their points earned by
//the total possible points.
public class gradeCalculator 
{	
	private int myPoints, totalPoints;
	
	/*Constructors should always have the same name as the class with no return type.  
	 * You can have multiple constructors as long as the arguments are different.
	 */
	
	public gradeCalculator()//Empty constructor
	{
		myPoints = 0;
		totalPoints = 0;		
	}

	public gradeCalculator(int myNewPoints, int newTotalPoints) //Constructor
	{		
		myPoints = myNewPoints;
		totalPoints = newTotalPoints;		
	}
	
	/*These methods are called accessers (or getters).
	 * They allow the private data to be accessed outside 
	 * of this class.
	 */
	
	public int getMyPoints()
	{
		return myPoints;
	}
	
	public int getTotalPoints()
	{
		return totalPoints;
	}
	
	/*These methods are called mutators (or setters)
	 * They allow the private data to be modified.
	 */
	
	public void setMyPoints(int myNewPoints)
	{
		myPoints = myPoints + myNewPoints;
	}
	
	public void setTotalPoints(int newTotalPoints)
	{
		totalPoints = totalPoints + newTotalPoints;
	}
	
	//This method will calculate my grade as a whole percentage
	
	public int calculateGrade()
	{
		int gradePercent = (int) Math.round((double) myPoints * 100 / totalPoints);
		return gradePercent;
	}
	
	//This method creates  a string representation of the calculated grade (for output)
	
	public String toString()
	{
		return "My current grade is " + calculateGrade() + "%";
	}
	
	/*The final part of the class is the main method.  There will only be one main method for each
	 * Java program, so if there are multiple classes, only one will contain a main method.
	 * It is where the execution of the program takes place.
	 */
	
	public static void main(String [] args)
	{
		gradeCalculator myGrade;
		myGrade = new gradeCalculator(); //The reserved word "new" followed by a constructor call is what tells the computer
										 //to set aside room in memory for a new object, stores the address to the memory 
										 //location, and sets the values to 0.
		
		myGrade.setMyPoints(20);	//Methods must be called by an object (myGrade)
		myGrade.setTotalPoints(25);
		System.out.println("My Points: " + myGrade.getMyPoints());
		System.out.println("Total Points: " + myGrade.getTotalPoints());
		System.out.println(myGrade.toString());
		System.out.println();
		
		myGrade.setMyPoints(17);
		myGrade.setTotalPoints(19);
		System.out.println("My Points: " + myGrade.getMyPoints());
		System.out.println("Total Points: " + myGrade.getTotalPoints());
		System.out.println(myGrade.toString());
		System.out.println();
		
		gradeCalculator secondGrade = new gradeCalculator(88, 100);
		System.out.println("My Second Points: " + secondGrade.getMyPoints());
		System.out.println("Total Second Points: " + secondGrade.getTotalPoints());
		System.out.println(secondGrade.toString());
	}
	/*Output:
	 * 
	 * My Points: 20
	 * Total Points: 25
	 * My current grade is 80%
	 *
	 * My Points: 37
	 * Total Points: 44
	 * My current grade is 84%
	 *
	 * My Second Points: 88
	 * Total Second Points: 100
	 * My current grade is 88%
	 */
}
