import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/** 
 * Finds a path in a maze made in a txt file from a cat, marked as 'C', to a
 * mouse, marked as 'M'.  The file is selected by user input.  A maze is
 * constucted with spaces as walkable paths and '#' for walls.  The cat will
 * always start in the top row.  A wall completely surrounding the maze is
 * not necessary.  A copy of the maze will be outputted.  Following this will
 * be a statement with the dimensions of the maze.  This will also include
 * a message that the maze was solved, and would be followed by a solved
 * version of the maze, or a message saying the maze is unsolvable.  The
 * path the cat takes will be represented with 'O'.  The class will perpetuate
 * so long as the user selects to continue after inputting a maze.
 * 
 * @author Conor Gaffney
 * @version 1.7.0, 12/10/14
 */
public class Mazes 
{
	
	/**
	 * Constructs an instance to operate on maze files
	 */
	public Mazes()
	{
		
	}
	
	/**
	 * Prints the current version of the maze.  Will be called when printing
	 * original maze, and a completed version if it exists
	 * 
	 * @param maze the collection of character arrays that each hold a row
	 * of the maze
	 * @param rows the number of rows in the maze
	 * @param cols the number of columns in the maze
	 */
	public void printMaze(ArrayList<char[]> maze, int rows, int cols)
	{
		for(int a = 0; a < rows; a++)
		{
				for(int b = 0; b< cols; b++)
					System.out.print(maze.get(a)[b]);
				System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Returns whether the space down one square to the cat's position
	 * matches the specified character
	 * 
	 * @param maze the list containing the maze characters
	 * @param c the character being searched for
	 * @param row the row that the cat is located in
	 * @param col the column that the cat is located in
	 * @return true if square down to the cat matches the character
	 * @return false otherwise
	 */
	public boolean isDown(ArrayList<char[]> maze, char c, int row, int col)
	{
		return maze.get(row + 1)[col] == c;
	}
	
	/**
	 * Returns whether the space left one square to the cat's position
	 * matches the specified character
	 * 
	 * @param maze the list containing the maze characters
	 * @param c the character being searched for
	 * @param row the row that the cat is located in
	 * @param col the column that the cat is located in
	 * @return true if square left of the cat matches the character
	 * @return false otherwise
	 */
	public boolean isLeft(ArrayList<char[]> maze, char c, int row, int col)
	{
		return maze.get(row)[col - 1] == c;
	}
	
	/**
	 * Returns whether the space right one square to the cat's position
	 * matches the specified character
	 * 
	 * @param maze the list containing the maze characters
	 * @param c the character being searched for
	 * @param row the row that the cat is located in
	 * @param col the column that the cat is located in
	 * @return true if square right of the cat matches the character
	 * @return false otherwise
	 */
	public boolean isRight(ArrayList<char[]> maze, char c, int row, int col)
	{
		return maze.get(row)[col + 1] == c;
	}
	
	/**
	 * Returns whether the space up one square to the cat's position
	 * matches the specified character
	 * 
	 * @param maze the list containing the maze characters
	 * @param c the character being searched for
	 * @param row the row that the cat is located in
	 * @param col the column that the cat is located in
	 * @return true if square up to the cat matches the character
	 * @return false otherwise
	 */
	public boolean isUp(ArrayList<char[]> maze, char c, int row, int col)
	{
		return maze.get(row - 1)[col] == c;
	}
	
	/**
	 * Searches the top row for the index of the column where the cat 
	 * starts at.
	 * 
	 * @param A the list of characters in the top row
	 * @param length the length of the row
	 * @param c the character used to represent the cat
	 * @return index location of the cat
	 * @return -1 if cat is not found
	 */
	public int initialCatCol(char[] A, int length, char c)
	{
		for(int x = 0; x < length; x++)
			if(A[x] == c)
				return x;
		return -1;
	}
	
	/**
	 * Searches for a path from the cat to the mouse.  Searches in an order of
	 * down, then left, then right, then up, as long as it wouldn't send the cat
	 * out of the maze. First looks for a walkable space.  Marks travelled spaces
	 * with a character besides the wall, space, cat, or mouse characters.  If
	 * none can be found, looks for the space it just walked on.  If that can't be
	 * found, meaning it returned to the beginning with no more movement
	 * options, the mouse cannot be found.
	 * 
	 * @param maze the list containing the maze characters
	 * @param rows highest index of rows in the maze
	 * @param cols highest index of columns in the maze
	 * @param catRow the row in which the cat is
	 * @param catCol the column in which the cat is
	 * @param mouse the character representing the mouse being searched for
	 * @param open the character representing an unused walkable square
	 * @param cover the character representing a space that was walked on
	 * @return 1 if mouse could be found
	 * @return 0 if mouse could not be found
	 * @return -1 if cat returned to prior space to take different path
	 */
	public int findMouse(ArrayList<char[]> maze, int rows, int cols, int catRow, int catCol, char mouse, char open, char cover)
	{
		if(maze.get(catRow)[catCol] == mouse)
			return 1;
		int temp;
		if(catRow < rows && (isDown(maze, open, catRow, catCol) || isDown(maze, mouse, catRow, catCol)))
		{
			maze.get(catRow)[catCol] = cover;
			catRow++;
			temp = findMouse(maze, rows, cols, catRow, catCol, mouse, open, cover);
			if(temp != -1)
				return temp;
			else
			{
				catRow--;
				maze.get(catRow)[catCol] = open;
			}
		}
		if(catCol > 0 && (isLeft(maze, open, catRow, catCol) || isLeft(maze, mouse, catRow, catCol)))
		{
			maze.get(catRow)[catCol] = cover;
			catCol--;
			temp = findMouse(maze, rows, cols, catRow, catCol, mouse, open, cover);
			if(temp != -1)
				return temp;
			else
			{
				catCol++;
				maze.get(catRow)[catCol] = open;
			}
		}
		if(catCol < cols && (isRight(maze, open, catRow, catCol) || isRight(maze, mouse, catRow, catCol)))
		{
			maze.get(catRow)[catCol] = cover;
			catCol++;
			temp = findMouse(maze, rows, cols, catRow, catCol, mouse, open, cover);
			if(temp != -1)
				return temp;
			else
			{
				catCol--;
				maze.get(catRow)[catCol] = open;
			}
		}
		if(catRow > 0 && (isUp(maze, open, catRow, catCol) || isUp(maze, mouse, catRow, catCol)))
		{
			maze.get(catRow)[catCol] = cover;
			catRow--;
			temp = findMouse(maze, rows, cols, catRow, catCol, mouse, open, cover);
			if(temp != -1)
				return temp;
			else
			{
				catRow++;
				maze.get(catRow)[catCol] = open;
			}
		}
		if(catRow < rows && isDown(maze, cover, catRow, catCol) || catCol > 0 && isLeft(maze, cover, catRow, catCol) || catCol < cols && isRight(maze, cover, catRow, catCol) || catRow > 0 && isUp(maze, cover, catRow, catCol))
			return -1;
		return 0;
	}
	
	/**
	 * Retrieves the maze, given the name by the user.  Each line of the file is
	 * transfered into a character array, which is stored in an ArrayList.  It 
	 * prints the original copy of the maze, and either the success or failure
	 * messages.
	 * 
	 * @throws IOException if file name does not match any existing txt file
	 */
	public void readMaze() throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		int rows = 0;
		int cols;
		ArrayList<char[]> maze = new ArrayList<char[]>();
		
		System.out.print("Enter the name of your maze:  ");
		
		FileReader fileReader = new FileReader(input.readLine());
		BufferedReader fileInput = new BufferedReader(fileReader);
		
		String line = fileInput.readLine();
		cols = line.length();
		
		while(line != null)
		{
			maze.add(new char[cols]);
			for(int a = 0; a < cols; a ++)
			{
				maze.get(rows)[a] = line.charAt(a);
			}
			rows++;
			line = fileInput.readLine();
		}
		fileInput.close();
		
		this.printMaze(maze, rows, cols);
		
		int initCol = this.initialCatCol(maze.get(0), cols, 'C');
		if(findMouse(maze, rows - 1, cols - 1, 0, initCol, 'M', ' ', 'O') == 1)
		{
			maze.get(0)[initCol] = 'C';
			System.out.println("The cat found the mouse in this " + rows + " X " + cols + " maze using this path:");
			this.printMaze(maze, rows, cols);
		}
		else
			System.out.println("The cat is unable to find the mouse in this " + rows + " X " + cols + " maze.");
	}
	
	public static void main(String [] args) throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		String go;
		Mazes newMaze = new Mazes();
		do
		{
		newMaze.readMaze();
		System.out.println("Enter 'yes' if you would like to enter another maze or no if you would like to exit:  ");
		go = input.readLine();
		}
		while(go.equalsIgnoreCase("yes"));
	}
/*Enter the name of your maze:  
maze1.txt
##C#####################################
##         ######## ############       #
##          ####### #            ##### #
## ################ ################## #
## #######                       ##### #
## ####### ############### ######   ## #
## #######         M###### ###    #  # #
## #####  ########## ##### ### ## # ## #
## ##### # ######    #####     ## # ## #
## ##### #######  ## ##############  # #
## ##### ####    ### #########    ## # #
##       #### ###### ######### ##### # #
###        ## ###### ######### ##    # #
### ######### ######     ##### ## #### #
### ######### ######## ## #### ##      #
###             ###### ## #### ####### #
###################### ## #   ##       #
###################### ######### ##### #
######################           #     #
########################################

The cat found the mouse in this 20 X 40 maze using this path:
##C#####################################
##O        ######## ############       #
##O         ####### #            ##### #
##O################ ################## #
##O#######OOOOOOOOOOOOOOOOO      ##### #
##O#######O###############O######OOO## #
##O#######OOOOOOOOOM######O###OOOO#O # #
##O#####  ########## #####O###O## #O## #
##O##### # ######OOOO#####OOOOO## #O## #
##O##### #######OO##O##############OO# #
##O##### ####OOOO###O#########    ##O# #
##OO     ####O######O######### #####O# #
###O       ##O######O######### ##OOOO# #
###O#########O######OOO  ##### ##O#### #
###O#########O########O## #### ##OOOOOO#
###OOOOOOOOOOO  ######O## #### #######O#
######################O## #   ##OOOOOOO#
######################O#########O##### #
######################OOOOOOOOOOO#     #
########################################

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze2.txt
####C  
#### ##
###M   
       
       
       
#######

The cat found the mouse in this 7 X 7 maze using this path:
####C  
####O##
###MO  
   OO  
OOOOO  
OOOOO  
#######

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze3.txt
########C#
#     #  #
 #####   #
#       ##
#    #####
#       ##
######    
#       M#
        ##
###       

The cat found the mouse in this 10 X 10 maze using this path:
########C#
#     # O#
 ##### OO#
#   OOOO##
#   O#####
#   OOO ##
######O   
#     OOM#
      OO##
###   OO  

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze4.txt
#####C#####
#          
#          
# #### ####
  #  #    #
# # M#    #
# #  #    #
# ######## 

The cat is unable to find the mouse in this 8 X 11 maze.
Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze5.txt
M      C
        
        
######  
        
        
        
######  

The cat found the mouse in this 8 X 8 maze using this path:
MOOOOOOC
OOOOOOOO
OOOOOOOO
######OO
      OO
OOOOOOOO
OOOOOOOO
######OO

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze6.txt
M     C
       
       
#######
       
       
       
#######

The cat found the mouse in this 8 X 7 maze using this path:
MOOOOOC
OOOOOOO
OOOOOOO
#######
       
       
       
#######

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze7.txt
    C     
          
          
          
          
       M  
          
          

The cat found the mouse in this 8 X 10 maze using this path:
    C     
    O     
    O     
    O     
    O     
    OOOM  
    OOOOOO
    OOOOOO

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze8.txt
#####C    
######### 
######### 
######    
       ###
M#########

The cat found the mouse in this 6 X 10 maze using this path:
#####COOOO
#########O
#########O
######OOOO
OOOOOOO###
M#########

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze9.txt
####C    M## 
             
############ 

The cat found the mouse in this 3 X 13 maze using this path:
####C    M## 
    OOOOOO   
############ 

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze10.txt
 C  
    
    
    
  M 
    
    
    
    
    

The cat found the mouse in this 10 X 4 maze using this path:
 C  
 O  
 O  
 O  
 OMO
 OOO
 OOO
 OOO
 OOO
 OOO

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze11.txt
###C######
          
          
  #####   
  #   #   
  # M #   
  #   #   
  #####   

The cat is unable to find the mouse in this 8 X 10 maze.
Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
yes
Enter the name of your maze:  
maze12.txt
##C#####################################
##         ######## ############       #
##          ####### #            ##### #
## ################ ################## #
## #######                       ##### #
## ####### ############### ######   ## #
## #######         M###### ###    #  # #
## ################# ##### ### ## # ## #
## ##### # ######    #####     ## # ## #
## ##### #######  ## ##############  # #
## ##### ####    ### #########    ## # #
##       #### ###### ######### ##### # #
###        ## ###### ######### ##    # #
### ######### ######     ##### ## #### #
### ######### ######## ## #### ##      #
###             ###### ## #### ####### #
###################### ## #   ##       #
###################### ######### ##### #
######################           #     #
########################################

The cat found the mouse in this 20 X 40 maze using this path:
##C#####################################
##O        ######## ############       #
##O         ####### #            ##### #
##O################ ################## #
##O#######OOOOOOOOOOOOOOOOO      ##### #
##O#######O###############O######OOO## #
##O#######OOOOOOOOOM######O###OOOO#O # #
##O################# #####O###O## #O## #
##O##### # ######OOOO#####OOOOO## #O## #
##O##### #######OO##O##############OO# #
##O##### ####OOOO###O#########    ##O# #
##OO     ####O######O######### #####O# #
###O       ##O######O######### ##OOOO# #
###O#########O######OOO  ##### ##O#### #
###O#########O########O## #### ##OOOOOO#
###OOOOOOOOOOO  ######O## #### #######O#
######################O## #   ##OOOOOOO#
######################O#########O##### #
######################OOOOOOOOOOO#     #
########################################

Enter 'yes' if you would like to enter another maze or no if you would like to exit:  
no
*/
}
