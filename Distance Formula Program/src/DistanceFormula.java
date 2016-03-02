//Conor Gaffney
//4-23-2014
//This program outputs the distance between two points.
//The two coordinates are given by the programmer, and it uses the distance formula to calculate the distance between them.

public class DistanceFormula 
{
	
	public static void main(String [] args)
	{
		
		double x1 = -2.15;  // Coordinates of two points
		double y1 = 8;
		double x2 = 3;
		double y2 = -5.93;
		
		double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y1-y2),2)); // Distance formula
		
		System.out.println("The distance between (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") is " + Math.round(distance*100)/100.0);
		
	}
/*Output:
 * 
 * The distance between (-2.15,8.0) and (3.0,-5.93) is 14.85
 * 	
 */

}
