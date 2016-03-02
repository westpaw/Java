//Conor Gaffney
//4-3-2014
public class Change
{
	public static void main(String [] args)
	{
		int change,leftover,dollar50,dollar20,dollar10,dollar5,dollar1,quarter,dime,nickel,penny;
		double cost100,pay100;
		cost100 = 54.39 * 100;
		pay100 = 100 * 100;
		change = (int)pay100 - (int)cost100;
		dollar50 = change/5000;
		leftover = change%5000;
	//5000 pennies per $50
		dollar20 = leftover/2000;
		leftover = leftover%2000;
	//2000 pennies per $20
		dollar10 = leftover/1000;
		leftover = leftover%1000;
	//1000 pennies per $10
		dollar5 = leftover/500;
		leftover = leftover%500;
	//500 pennies per $5	
		dollar1 = leftover/100;
		leftover = leftover%100;
	//100 pennies per $1	
		quarter = leftover/25;
		leftover = leftover%25;
	//25 pennies per quarter	
		dime = leftover/10;
		leftover = leftover%10;
	//10 pennies per dime	
		nickel = leftover/5;
		leftover = leftover%5;
	// 5 pennies per nickel	
		penny = leftover;
		
		System.out.println("Cost of items: $" + cost100/100);
		System.out.println("Amount paid: $" + pay100/100);
		System.out.println("Amount of change: $" + (double)change/100);
		System.out.println();
		System.out.println("Number of $50 bills: " + dollar50);
		System.out.println();
		System.out.println("Number of $20 bills: " + dollar20);
		System.out.println();
		System.out.println("Number of $10 bills: " + dollar10);
		System.out.println();
		System.out.println("Number of $5 bills: " + dollar5);
		System.out.println();
		System.out.println("Number of $1 bills: " + dollar1);
		System.out.println();
		System.out.println("Number of quarters: " + quarter);
		System.out.println();
		System.out.println("Number of dimes: " + dime);
		System.out.println();
		System.out.println("Number of nickels: " + nickel);
		System.out.println();
		System.out.println("Number of pennies: " + penny);
		
	}
/*Output:
 * 
 * Cost of items: $54.39
Amount paid: $100.0
Amount of change: $45.61

Number of $50 bills: 0

Number of $20 bills: 2

Number of $10 bills: 0

Number of $5 bills: 1

Number of $1 bills: 0

Number of quarters: 2

Number of dimes: 1

Number of nickels: 0

Number of pennies: 1
 */
}
