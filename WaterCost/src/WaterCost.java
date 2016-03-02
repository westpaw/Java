/* Conor Gaffney
 * May 12, 2014
 * This class calculates the cost of water usage.  The rates depend on whether the water is being used
 * domestically, commercially or industrially.  The user inputs his or her ID number, usage code and
 * number of gallons used.  The class outputs the ID number, reason for use and cost.
 */

import java.io.*;

public class WaterCost
{
	private final static int HOME_START = 5; //initial cost for home use
	private final static double HOME_RATE = .0005; //cost per gallon of water
	private final static int COMMERCIAL_START = 1000; //cost of first 4 million gallons
	private final static double COMMERCIAL_RATE = .00025; //cost per additional gallon
	private final static int INDUSTRIAL_FIRST_COST = 1000; //for up to 4 million gallons
	private final static int INDUSTRIAL_SECOND_COST = 2000; //for between 4 million and 10 million gallons
	private final static int INDUSTRIAL_THIRD_COST = 3000; //for over 10 million gallons
	private final static int FIRST_GALLON_LIMIT = 4000000; //point that cost changes for commercial and industrial use
	private final static int SECOND_GALLON_LIMIT = 10000000; //point that cost changes again for industrial use
	
	private int idNum;
	private int gallons;
	private char useCode;
	private String usage;
	
	public WaterCost(int id, int gal, char use) //constructor
	{
		idNum = id;
		gallons = gal;
		useCode = use;
		if(use == 'h')
			usage = "Home";
		else if(use == 'c')
			usage = "Commercial";
		else
			usage = "Industrial";
	}
	
	public int getID() //getters
	{
		return idNum;
	}
	
	public int getGallons()
	{
		return gallons;
	}
	
	public char getUseCode()
	{
		return useCode;
	}
	
	public String getUsage()
	{
		return usage;
	}
	
	public void setID(int id) //setters
	{
		idNum = id;
	}
	
	public void setGallons(int gal)
	{
		gallons = gal;
	}
	
	public void setUseCode(char use)
	{
		useCode = use;
	}
	
	public void setUsage(String use)
	{
		usage = use;
	}
	
	public static int inputID() throws IOException //asks user for ID number
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter your account number: ");
		int id = Integer.parseInt(input.readLine());
		return id;
	}
	
	public static int inputGallons() throws IOException //asks user for number of gallons used
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter the number of gallons used: ");
		int gal = Integer.parseInt(input.readLine());
		return gal;
	}
	
	public static char inputUse() throws IOException //asks user for usage code
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter your single character usage code: ");
		char use = input.readLine().charAt(0);
		return use;
	}
	
	public double calcCost() //calculates the cost
	{
		double cost;
		if(useCode == 'h')
			cost = HOME_START + HOME_RATE * gallons;
		else if(useCode == 'c')
			if(gallons > FIRST_GALLON_LIMIT)
				cost = COMMERCIAL_START + COMMERCIAL_RATE * (gallons - FIRST_GALLON_LIMIT);
			else cost = COMMERCIAL_START;
		else if(gallons <= FIRST_GALLON_LIMIT)
			cost = INDUSTRIAL_FIRST_COST;
		else if(gallons <= SECOND_GALLON_LIMIT)
			cost = INDUSTRIAL_SECOND_COST;
		else cost = INDUSTRIAL_THIRD_COST;
		return Math.round(cost*100)/100.0;
	}
	
	public String toString() //formats the output
	{
		return "ID Number: " + idNum + '\n' + "Purpose for Use: " + usage + '\n' + "Cost: $" + calcCost();
	}
	
	public static void main(String [] args) throws IOException
	{
		WaterCost cost = new WaterCost(WaterCost.inputID(),WaterCost.inputGallons(),WaterCost.inputUse());
		System.out.println(cost.toString());
	}
/* Output:
 * 
 * Please enter your account number: 
 * 10
 * Please enter the number of gallons used: 
 * 5000022
 * Please enter your single character usage code: 
 * c
 * ID Number: 10
 * Purpose for Use: Commercial
 * Cost: $1250.01
 * 
 * Please enter your account number: 
 * 11
 * Please enter the number of gallons used: 
 * 1234567
 * Please enter your single character usage code: 
 * i
 * ID Number: 11
 * Purpose for Use: Industrial
 * Cost: $1000.0
 * 
 * Please enter your account number: 
 * 12
 * Please enter the number of gallons used: 
 * 8765
 * Please enter your single character usage code: 
 * h
 * ID Number: 12
 * Purpose for Use: Home
 * Cost: $9.38
 * 
 * Please enter your account number: 
 * 13
 * Please enter the number of gallons used: 
 * 444444
 * Please enter your single character usage code: 
 * c
 * ID Number: 13
 * Purpose for Use: Commercial
 * Cost: $1000.0
 * 
 * Please enter your account number: 
 * 14
 * Please enter the number of gallons used: 
 * 5555555
 * Please enter your single character usage code: 
 * i
 * ID Number: 14
 * Purpose for Use: Industrial
 * Cost: $2000.0
 * 
 * Please enter your account number: 
 * 15
 * Please enter the number of gallons used: 
 * 20000000
 * Please enter your single character usage code: 
 * i
 * ID Number: 15
 * Purpose for Use: Industrial
 * Cost: $3000.0
 */
}
