//Conor Gaffney
//4-3-2014

public class Minutes
{
	public static void main(String [] args)
	{
		int allMin = 4642;
		int days;
		int hours;
		int min;
		days = allMin / 1440;
	// 1440 minutes in a day
		hours = allMin % 1440 / 60;
	// 60 minutes in an hour
		min = allMin % 1440 % 60;
		
		System.out.println(allMin + " minutes = " + days + " days, " + hours + " hours, and " + min + " minutes.");
		
	}
/*Output:
 * 
 * 4642 minutes = 3 days, 5 hours, and 22 minutes.
 */
}
