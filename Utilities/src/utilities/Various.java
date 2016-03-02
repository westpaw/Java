package utilities;
/* Conor Gaffney
 * useful methods
 * 
 */
import java.io.*;

public class Various 
{
	
	public void readTextFile() throws IOException //reads tokens from a text file
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the name of the file to be read: ");
		
		FileReader readFile = new FileReader(input.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		
		System.out.println("Reading file..." + '\r');
		String inputString = inFile.readLine();
		
		while(inputString != null)
		{
			//whatever you need the string for
			inputString = inFile.readLine();
		}
		
		inFile.close();
		System.out.println('\r' + "Reading completed.");
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
	
	public int binarySearch(int[] array, int target) //finds a target in an array, returns -1 if target not found
	{
		int left = 0;
		int right = array[fill] - 1;
		while(left <= right)
		{
			int middle = (left + right) / 2;
			if(target < array[middle])
				right = middle - 1;
			else if(target > array[middle])
				left = middle + 1;
			else
				return middle;
		}
		return -1;
	}

}
