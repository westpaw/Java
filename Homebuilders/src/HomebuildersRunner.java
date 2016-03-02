import java.io.IOException;

/* Conor Gaffney
 * Runs Homebuilders
 */
public class HomebuildersRunner 
{
	
	public static void main(String [] args) throws IOException //main
	{
		Homebuilders YourHouse = new Homebuilders();
		
		do
		{
		System.out.println("Hello!  Use this program to see if you can afford to build your ideal home!");
		YourHouse.setFunds(YourHouse.inputInt("available funds"));
		if(YourHouse.getFunds() != -9876)
		{
			YourHouse.setLength(YourHouse.inputInt("desired length in feet"));
			YourHouse.setWidth(YourHouse.inputInt("desired width in feet"));
			YourHouse.setStories(YourHouse.inputInt("desired number of stories"));
			YourHouse.inputStyle();
			YourHouse.showValues();
			YourHouse.calcCost(YourHouse.getStyle());
			YourHouse.change();
			System.out.println("Goodbye!  Thank you and have a nice day!" + '\r' + '\r');
		}
		}
		while(YourHouse.getFunds() != -9876);
	}
/*
 * Hello!  Use this program to see if you can afford to build your ideal home!
While ignoring units, enter your available funds:  
-400000
Invalid amount; please resubmit.

While ignoring units, enter your available funds:  
-1
Invalid amount; please resubmit.

While ignoring units, enter your available funds:  
0
Invalid amount; please resubmit.

While ignoring units, enter your available funds:  
1

While ignoring units, enter your desired length in feet:  
32

While ignoring units, enter your desired width in feet:  
45

While ignoring units, enter your desired number of stories:  
3

Enter a code for the style of house you would like:  
M for minimum cost
S for standard
E for energy efficient
C for custom

S
Standard style.

Your house has the following specifications:

Available funds: $1
Length (ft): 32
Width (ft): 45
Stories: 3
Style: Standard

The total cost of your desired house is $540000
You are unable to buy this house with your available funds.
Are there any selections you would like to change?
Enter 'y' for yes and 'n' for no
y
Your house has the following specifications:

Available funds: $1
Length (ft): 32
Width (ft): 45
Stories: 3
Style: Standard

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
F
While ignoring units, enter your available funds:  
450000

The total cost of your desired house is $540000
You are unable to buy this house with your available funds.
Is there another selection you wish to change?
Enter 'y' for yes and 'n' for no
y
Your house has the following specifications:

Available funds: $450000
Length (ft): 32
Width (ft): 45
Stories: 3
Style: Standard

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
S
While ignoring units, enter your desired number of stories:  
2

The total cost of your desired house is $360000
You will be able to afford this house!
Is there another selection you wish to change?
Enter 'y' for yes and 'n' for no
y
Your house has the following specifications:

Available funds: $450000
Length (ft): 32
Width (ft): 45
Stories: 2
Style: Standard

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
C
Enter a code for the style of house you would like:  
M for minimum cost
S for standard
E for energy efficient
C for custom

E
Energy-efficient style.

The total cost of your desired house is $432000
You will be able to afford this house!
Is there another selection you wish to change?
Enter 'y' for yes and 'n' for no
n
Goodbye!  Thank you and have a nice day!


Hello!  Use this program to see if you can afford to build your ideal home!
While ignoring units, enter your available funds:  
524000

While ignoring units, enter your desired length in feet:  
23

While ignoring units, enter your desired width in feet:  
65

While ignoring units, enter your desired number of stories:  
1

Enter a code for the style of house you would like:  
M for minimum cost
S for standard
E for energy efficient
C for custom

C
Custom style.

Your house has the following specifications:

Available funds: $524000
Length (ft): 23
Width (ft): 65
Stories: 1
Style: Custom

The total cost of your desired house is $299000
You will be able to afford this house!
Are there any selections you would like to change?
Enter 'y' for yes and 'n' for no
y
Your house has the following specifications:

Available funds: $524000
Length (ft): 23
Width (ft): 65
Stories: 1
Style: Custom

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
L
While ignoring units, enter your desired length in feet:  
48

The total cost of your desired house is $624000
You are unable to buy this house with your available funds.
Is there another selection you wish to change?
Enter 'y' for yes and 'n' for no
y
Your house has the following specifications:

Available funds: $524000
Length (ft): 48
Width (ft): 65
Stories: 1
Style: Custom

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
W
While ignoring units, enter your desired width in feet:  
54

The total cost of your desired house is $518400
You will be able to afford this house!
Is there another selection you wish to change?
Enter 'y' for yes and 'n' for no
y
Your house has the following specifications:

Available funds: $524000
Length (ft): 48
Width (ft): 54
Stories: 1
Style: Custom

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
C
Enter a code for the style of house you would like:  
M for minimum cost
S for standard
E for energy efficient
C for custom

M
Minimum cost style.

The total cost of your desired house is $259200
You will be able to afford this house!
Is there another selection you wish to change?
Enter 'y' for yes and 'n' for no
y
Your house has the following specifications:

Available funds: $524000
Length (ft): 48
Width (ft): 54
Stories: 1
Style: Minimum Cost

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
V
Invalid code, please resubmit:
Your house has the following specifications:

Available funds: $524000
Length (ft): 48
Width (ft): 54
Stories: 1
Style: Minimum Cost

Enter the corresponding code for the selection you wish to change
F to change available funds
L to change length dimension
W to change width dimension
S to change number of stories
C to change the style
C
Enter a code for the style of house you would like:  
M for minimum cost
S for standard
E for energy efficient
C for custom

A
Invalid code, please resubmit your choice:

M for minimum cost
S for standard
E for energy efficient
C for custom

S
Standard style.

The total cost of your desired house is $324000
You will be able to afford this house!
Is there another selection you wish to change?
Enter 'y' for yes and 'n' for no
n
Goodbye!  Thank you and have a nice day!


Hello!  Use this program to see if you can afford to build your ideal home!
While ignoring units, enter your available funds:  
-9876


 */
}
