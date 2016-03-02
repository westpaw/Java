/* Conor Gaffney
 * This program makes two lists of up to fifteen integers based on user input.  It sorts each of the two lists in order from
 * small to large.  It then makes a third list of all the elements in the first two lists so that the values will still be in order.
 * The third array will only have enough indexes to hold the values of the first two lists.
 */
import java.io.*;
import java.util.*;

public class Merge 
{
	
	private int [] array;
	private int fill;
	
	public Merge(int x)
	{
		array = new int[x];
	}
	
	public int getFill()
	{
		return fill;
	}
	
	public int[] getArray()
	{
		return array;
	}
	
	public void fillArray() throws IOException //fills an array with up to 15 integers, based on input
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter up to fifteen integers, separated by spaces: ");
		StringTokenizer x = new StringTokenizer(input.readLine());
		while(x.countTokens() > 15)
		{
			System.out.println("Too many numbers, try again");
			x = new StringTokenizer(input.readLine());
		}
		
		int y = 0;
		while(x.hasMoreTokens())
		{
			array[y] = Integer.parseInt(x.nextToken());
			y++;
			fill++;
		}
	}
	
	public void sortArray() //puts elements of array in numerical order
	{
		int temp;
		for(int x = 1;x < fill;x++)
		{
			int a = x;
			for(int y = x-1;y >= 0 && array[a] <= array[y];y--)
			{
				if(array[a] < array[y])
				{
					temp = array[a];
					array[a] = array[y];
					array[y] = temp;
					a = y;
				}
			}
		}
	}
	
	public void merge(int[] Y, int[] Z, int yFill, int zFill) //takes two arrays and the number of elements in each, and merges them into one, while retaining numerical order if they've both been sorted
	{														// will not merge in duplicate values
		int y = 0;
		int z = 0;
		int length = array.length;
		while(fill < length)
		{
			while(fill > 0 && length > fill && z < zFill && Z[z] == array[fill-1]) //while previous value in the array matches value in array Z
			{
				z++; //go to next value
				length--; //one less value to be moved into array
			}
			while(fill > 0 && length > fill && y < yFill && Y[y] == array[fill-1]) //while previous value in the array matches value in array Y
			{
				y++;
				length--;
			}
			
			if(y >= yFill && z == zFill)
			{
			}
			
			else if(y == yFill || z < zFill && Z[z] < Y[y])  //if all y values are used or value in array Y is less than value in array Z
			{
				array[fill] = Z[z];
				z++;
				fill++;
			}
			else if(z == zFill || y < yFill && Y[y] < Z[z]) //if all z values are used or value in array Z is less than value in array Y
			{
				array[fill] = Y[y];
				y++;
				fill++;
			}
			else if(Y[y] == Z[z]) //if array values match but value not present in combined list, arbitrarily input Y[y] and ignores value in Z[z]
			{
				array[fill] = Y[y];
				y++;
				fill++;
				z++;
				length--;
			}
			
		}
		
	}
	
	public void printList(String listName)
	{
		System.out.print(listName + ": ");
		for(int x = 0;x < fill;x++)
			System.out.print(array[x] + " ");
		System.out.println('\r');
	}
	
	public static void main(String [] args) throws IOException
	{
		Merge listA = new Merge(15);
		listA.fillArray();
		
		Merge listB = new Merge(15);
		listB.fillArray();
		
		listA.printList("List 1");
		listB.printList("List 2");
		
		listA.sortArray();
		listB.sortArray();
		
		Merge listC = new Merge(listA.getFill() + listB.getFill());
		listC.merge(listA.getArray(), listB.getArray(), listA.getFill(), listB.getFill());
		listC.printList("Combined List");
	}
/* 
Enter up to fifteen integers, separated by spaces: 
1
Enter up to fifteen integers, separated by spaces: 
4 2 3
List 1: 1 

List 2: 4 2 3 

Combined List: 1 2 3 4 

Enter up to fifteen integers, separated by spaces: 
8
Enter up to fifteen integers, separated by spaces: 
7 6
List 1: 8 

List 2: 7 6 

Combined List: 6 7 8 

Enter up to fifteen integers, separated by spaces: 
7 11
Enter up to fifteen integers, separated by spaces: 
8 13 2 9
List 1: 7 11 

List 2: 8 13 2 9 

Combined List: 2 7 8 9 11 13 

Enter up to fifteen integers, separated by spaces: 
6 4 2
Enter up to fifteen integers, separated by spaces: 
5 3 1
List 1: 6 4 2 

List 2: 5 3 1 

Combined List: 1 2 3 4 5 6

Enter up to fifteen integers, separated by spaces: 
5 2 7 8
Enter up to fifteen integers, separated by spaces: 
3 5 4
List 1: 5 2 7 8 

List 2: 3 5 4 

Combined List: 2 3 4 5 7 8 

Enter up to fifteen integers, separated by spaces: 
2
Enter up to fifteen integers, separated by spaces: 
2
List 1: 2 

List 2: 2 

Combined List: 2 

Enter up to fifteen integers, separated by spaces: 
7 9 8
Enter up to fifteen integers, separated by spaces: 
2 1
List 1: 7 9 8 

List 2: 2 1 

Combined List: 1 2 7 8 9 

Enter up to fifteen integers, separated by spaces: 
7 9 8 1
Enter up to fifteen integers, separated by spaces: 
9 1 7 2 3
List 1: 7 9 8 1 

List 2: 9 1 7 2 3 

Combined List: 1 2 3 7 8 9 

Enter up to fifteen integers, separated by spaces: 
5 6
Enter up to fifteen integers, separated by spaces: 
3 6 4
List 1: 5 6 

List 2: 3 6 4 

Combined List: 3 4 5 6 

Enter up to fifteen integers, separated by spaces: 
9 8 7 4
Enter up to fifteen integers, separated by spaces: 
4 3 2 1
List 1: 9 8 7 4 

List 2: 4 3 2 1 

Combined List: 1 2 3 4 7 8 9 

Enter up to fifteen integers, separated by spaces: 
4 3 2 1 9
Enter up to fifteen integers, separated by spaces: 
4 9 1 3 2
List 1: 4 3 2 1 9 

List 2: 4 9 1 3 2 

Combined List: 1 2 3 4 9 

Enter up to fifteen integers, separated by spaces: 
4 8 7 6 2 5
Enter up to fifteen integers, separated by spaces: 
5 6 1 9 3 4
List 1: 4 8 7 6 2 5 

List 2: 5 6 1 9 3 4 

Combined List: 1 2 3 4 5 6 7 8 9 

Enter up to fifteen integers, separated by spaces: 
9 1
Enter up to fifteen integers, separated by spaces: 
7 1 6 3 5 2
List 1: 9 1 

List 2: 7 1 6 3 5 2 

Combined List: 1 2 3 5 6 7 9 

Enter up to fifteen integers, separated by spaces: 
15 14 13 12 1 2 3 4 5 6 11 10 9 8 7
Enter up to fifteen integers, separated by spaces: 
21 20 22
List 1: 15 14 13 12 1 2 3 4 5 6 11 10 9 8 7 

List 2: 21 20 22 

Combined List: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 20 21 22 

Enter up to fifteen integers, separated by spaces: 
10 20 30 40 50 60 70 80 90 21 31 41 51 61 71 81 91
Too many numbers, try again
10 20 30 40 50 60 70 80 90 21 31 41 51 61 71
Enter up to fifteen integers, separated by spaces: 
22 32 42 52 62 72 82 92 10 20 30 40 50 31 41 51 81
Too many numbers, try again
22 32 42 52 62 72 82 92 10 20 30 40 50 31 41
List 1: 10 20 30 40 50 60 70 80 90 21 31 41 51 61 71 

List 2: 22 32 42 52 62 72 82 92 10 20 30 40 50 31 41 

Combined List: 10 20 21 22 30 31 32 40 41 42 50 51 52 60 61 62 70 71 72 80 82 90 92 

Extra:

Enter up to fifteen integers, separated by spaces: 
5 9 2 5 5 5 9 2 2 2 7
Enter up to fifteen integers, separated by spaces: 
8 8 8 2 1 9 1 9 5 7 3 4 9
List 1: 5 9 2 5 5 5 9 2 2 2 7 

List 2: 8 8 8 2 1 9 1 9 5 7 3 4 9 

Combined List: 1 2 3 4 5 7 8 9 

Enter up to fifteen integers, separated by spaces: 
5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
Too many numbers, try again
5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
Enter up to fifteen integers, separated by spaces: 
5 5 5 5 5 5 5 5
List 1: 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 

List 2: 5 5 5 5 5 5 5 5 

Combined List: 5 
 * 
 */
}
