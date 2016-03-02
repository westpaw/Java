/*Conor Gaffney
 * 
 * This program helps the user determine if they can afford to build a house with certain qualities.  The user inputs how much
 * money he or she has available to spend, the desired dimensions (length and width), the number of stories, and a code for the
 * style of the house.  The program then calculates the cost of the desired house and notifies the user whether or not they
 * could afford that design.  If they can afford their chosen model, it outputs how many funds are left over, and asks the user
 * if they would like to change any of their selections.  The program returns to the start if no.  It ends when a sentinel of 
 * -9876 is entered for the available funds.
 */

import java.io.*;

public class Homebuilders
{
	
	private static final int MIN_COST = 100; //cost per square foot for each style of house
	private static final int STANDARD = 125;
	private static final int ENERGY_EFF = 150;
	private static final int CUSTOM = 200;
	
	private int funds; //data for determining affordability
	private int length;
	private int width;
	private int stories;
	private char style;
	
	public Homebuilders() //constructor
	{
	}
	
	public int getFunds() //getters
	{
		return funds;
	}
	
	public char getStyle()
	{
		return style;
	}
	
	public void setFunds(int x) //setters
	{
		funds = x;
	}
	
	public void setLength(int x)
	{
		length = x;
	}
	
	public void setWidth(int x)
	{
		width = x;
	}
	
	public void setStories(int x)
	{
		stories = x;
	}
	
	public int inputInt(String type) throws IOException //gets user input for funds, length, width or stories
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		int x;
		
		do
		{
		System.out.println("While ignoring units, enter your " + type + ":  ");
		x = Integer.parseInt(input.readLine());
		if(type.equals("available funds") && x == -9876)
			break;
		if(x < 1)
			System.out.println("Invalid amount; please resubmit." + '\r');
		}
		while(x < 1);
		System.out.println();
		return x;
	}
	
	public void inputStyle() throws IOException //gets user input for style
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		char c;
		
		System.out.println("Enter a code for the style of house you would like:  ");
		
		do
		{
		System.out.println("M for minimum cost" + '\r' + "S for standard" + '\r' + "E for energy efficient" + '\r' + "C for custom" + '\r');
		c = input.readLine().charAt(0);
		if(c != 'M' && c != 'S' && c != 'E' && c != 'C')
			System.out.println("Invalid code, please resubmit your choice:" + '\r');
		}
		while(c != 'M' && c != 'S' && c != 'E' && c != 'C');
		switch(c)
		{
		case 'M':
			System.out.println("Minimum cost style.");
			break;
		case 'S':
			System.out.println("Standard style.");
			break;
		case 'E':
			System.out.println("Energy-efficient style.");
			break;
		default:
			System.out.println("Custom style.");
		}
		System.out.println();
		style = c;
	}
	
	public void calcCost(char c) //finds total cost of desired house and informs user if they can afford house with available funds
	{
		int x = length*width*stories;
		switch(c)
		{
		case 'M':
			x = x*MIN_COST;
			break;
		case 'S':
			x = x*STANDARD;
			break;
		case 'E':
			x = x*ENERGY_EFF;
			break;
		default:
			x = x*CUSTOM;
		}
		System.out.println("The total cost of your desired house is $" + x);
		if(x <= funds)
			System.out.println("You will be able to afford this house!");
		else
			System.out.println("You are unable to buy this house with your available funds.");
	}
	
	public void showValues() //shows user their selections
	{
		System.out.println("Your house has the following specifications:" + '\r' + '\r' + "Available funds: $" + funds + '\r' + "Length (ft): " + length + '\r' + "Width (ft): " + width + '\r' + "Stories: " + stories);
		System.out.print("Style: ");
		switch(style)
		{
		case 'M':
			System.out.println("Minimum Cost");
			break;
		case 'S':
			System.out.println("Standard");
			break;
		case 'E':
			System.out.println("Energy-Efficient");
			break;
		default:
			System.out.println("Custom");
		}
		System.out.println();
	}
	
	public void change() throws IOException //lets the user change any selection and recalculates cost
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Are there any selections you would like to change?" + '\r' + "Enter 'y' for yes and 'n' for no");
		char yn = input.readLine().charAt(0);
		while(yn == 'y')
		{
			this.showValues();
			System.out.println("Enter the corresponding code for the selection you wish to change");
			System.out.println("F to change available funds");
			System.out.println("L to change length dimension");
			System.out.println("W to change width dimension");
			System.out.println("S to change number of stories");
			System.out.println("C to change the style");
			char c = input.readLine().charAt(0);
			switch(c)
			{
			case 'F':
				funds = this.inputInt("available funds");
				if(funds != -9876)
				{
				this.calcCost(this.getStyle());
				System.out.println("Is there another selection you wish to change?");
				System.out.println("Enter 'y' for yes and 'n' for no");
				yn = input.readLine().charAt(0);
				}
				else
					yn = 'n';
				break;
			case 'L':
				length = this.inputInt("desired length in feet");
				this.calcCost(this.getStyle());
				System.out.println("Is there another selection you wish to change?");
				System.out.println("Enter 'y' for yes and 'n' for no");
				yn = input.readLine().charAt(0);
				break;
			case 'W':
				width = this.inputInt("desired width in feet");
				this.calcCost(this.getStyle());
				System.out.println("Is there another selection you wish to change?");
				System.out.println("Enter 'y' for yes and 'n' for no");
				yn = input.readLine().charAt(0);
				break;
			case 'S':
				stories = this.inputInt("desired number of stories");
				this.calcCost(this.getStyle());
				System.out.println("Is there another selection you wish to change?");
				System.out.println("Enter 'y' for yes and 'n' for no");
				yn = input.readLine().charAt(0);
				break;
			case 'C':
				this.inputStyle();
				this.calcCost(this.getStyle());
				System.out.println("Is there another selection you wish to change?");
				System.out.println("Enter 'y' for yes and 'n' for no");
				yn = input.readLine().charAt(0);
				break;
			default:
				System.out.println("Invalid code, please resubmit:");
			}
		}
	}

}