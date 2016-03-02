//Conor Gaffney            
//4-2-2014
//This is a comment, ignore this.            This comment goes through the rest of the line.
/*This is a very large comment.
 * 
 * 
 * 
 * 
 * 
 * All of this space is useless, star comments end with a * followed by a /
 * 
 */
public class hellowubbawub {

	public static void main(String [] args)
	{
		for(int row = 0;row < 8;row++)
		{
			for(int space = 0;space < 8 - row;space++)
			{
				System.out.print(" ");
			}
			
			for(int star = 0;star < 1 + 2 * (row);star++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
/*output:
 * 
 * Hello Wubbawub
*/
