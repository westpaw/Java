/*Conor Gaffney
 * May 8, 2014
 * This class will determine the taxes for the inhabitants of Zaitland.  The rates are each fixed for a certain bracket of income; 
 * 1% on the first $10000, 5% on the next $20000, and 10% on any additional income.  There is also a flat $500 living expense
 * for anyone with an income greater than $1000.  
 */

import java.io.*;

public class ZaitlandTaxes
{
	
	private final static int LIVING_COST = 500;
	private final static int INCOME_LIVING = 1000; //minimum income needed to be charged living cost
	private final static int FIRST_INCOME_BRACKET = 10000; //maximum income to be taxed the first tax rate and max size of first bracket
	private final static int SECOND_INCOME_BRACKET = 30000; //maximum income to be taxed the second tax rate after first income bracket
	private final static int SECOND_INCOME_ROOF = 20000; //maximum size of second bracket
	private final static double FIRST_TAX = 0.01; //tax rate for first income bracket
	private final static double SECOND_TAX = 0.05; //tax rate for second income bracket
	private final static double THIRD_TAX = 0.1; //tax rate for additional income
	
	private int income = 0;
	private double tax;
	
	public ZaitlandTaxes(int money) //constructor
	{
		income = money;
		tax = 0;
	}
	
	public int getIncome() //getters
	{
		return income;
	}
	
	public double getTax()
	{
		return tax;
	}
	
	public void setIncome(int inc) //setters
	{
		income = inc;
	}

	public void setTax(int money)
	{
		tax = money;
	}
	
	public double calcTax() //calculates taxes without including a living charge
	{
		if(income <= FIRST_INCOME_BRACKET)
			tax = FIRST_TAX * income;
		else 
			if(income <= SECOND_INCOME_BRACKET)
				tax = FIRST_INCOME_BRACKET * FIRST_TAX + SECOND_TAX * (income - FIRST_INCOME_BRACKET);
			else
				tax = FIRST_INCOME_BRACKET * FIRST_TAX + SECOND_INCOME_ROOF * SECOND_TAX + THIRD_TAX * (income - SECOND_INCOME_BRACKET);
		return tax;
	}
	
	public double checkLivingCost() //includes the living charge to the tax, if applicable
	{
		if(income >= INCOME_LIVING)
			tax = tax + LIVING_COST;
		return tax;
	}
	
	public static int inputIncome() throws IOException //asks user for income
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter your income in whole dollars without a $; enter -999 to end the program ");
		int inc = Integer.parseInt(input.readLine());
		return inc;
	}
	
	public String toString() //formats output
	{
		return "Income: $" + income + '\n' + "Taxes: $" + tax; 
	}
	
	public static void main(String [] args) throws IOException
	{		
		double totalTax = 0;
		ZaitlandTaxes Taxes = new ZaitlandTaxes(ZaitlandTaxes.inputIncome());
		while(Taxes.getIncome() != -999)
		{
			Taxes.calcTax();
			Taxes.checkLivingCost();
			System.out.println(Taxes.toString());
			Taxes.setIncome(ZaitlandTaxes.inputIncome());
			totalTax += Taxes.getTax();
		}
		System.out.println("Total Taxes paid: $" + totalTax);
	}
/* Output:
 * 
Enter your income in whole dollars without a $; enter -999 to end the program 
0
Income: $0
Taxes: $0.0
Enter your income in whole dollars without a $; enter -999 to end the program 
500
Income: $500
Taxes: $5.0
Enter your income in whole dollars without a $; enter -999 to end the program 
5432
Income: $5432
Taxes: $554.32
Enter your income in whole dollars without a $; enter -999 to end the program 
15006
Income: $15006
Taxes: $850.3
Enter your income in whole dollars without a $; enter -999 to end the program 
32999
Income: $32999
Taxes: $1899.9
Enter your income in whole dollars without a $; enter -999 to end the program 
100555
Income: $100555
Taxes: $8655.5
Enter your income in whole dollars without a $; enter -999 to end the program 
-999
Total Taxes paid: $11965.02
 * 
 */
}