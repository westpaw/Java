//Conor Gaffney
//May 1 2014
//This class can add, subtract, multiply and divide two fractions.

public class Fraction
{
	
	private int numerator;
	private int denominator;
	
	public Fraction(int num, int denom) //Constructor
	{
		numerator = num;
		denominator = denom;
	}
	
	public int getNumerator() //get numerator
	{
		return numerator;
	}
	
	public int getDenominator() //get denominator
	{
		return denominator;
	}
	
	public void setNumerator(int num) //change numerator
	{
		numerator = num;
	}
	
	public void setDenominator(int denom) //change denominator
	{
		denominator = denom;
	}
	
	public Fraction add(Fraction f) //add two fractions
	{
		int sumNum = numerator * f.getDenominator() + f.getNumerator() * denominator;
		int sumDenom = denominator * f.getDenominator();
		Fraction result = new Fraction(sumNum,sumDenom);
		return result;
	}
	
	public Fraction subtract(Fraction f) //subtract two fractions
	{
		int diffNum = numerator * f.getDenominator() - f.getNumerator() * denominator;
		int diffDenom = denominator * f.getDenominator();
		Fraction result = new Fraction(diffNum,diffDenom);
		return result;
	}
	
	public Fraction multiply(Fraction f) //multiply two fractions
	{
		int prodNum = numerator * f.getNumerator();
		int prodDenom = denominator * f.getDenominator();
		Fraction result = new Fraction(prodNum,prodDenom);
		return result;
	}
	
	public Fraction divide(Fraction f) //divide two fractions
	{
		int quotNum = numerator * f.getDenominator(); //dividing by a fraction is the same as multiplying by its reciprocal
		int quotDenom = denominator * f.getNumerator();
		Fraction result = new Fraction(quotNum, quotDenom);
		return result;
	}
	
	public String toString() //formats fraction as numerator/denominator
	{
		return numerator + "/" + denominator;
	}
	
	public static void main(String [] args)
	{
		Fraction f1, f2, sum, diff, prod, quot;
		f1 = new Fraction(1,2);
		f2 = new Fraction(3,5);
		
		sum = f1.add(f2);
		diff = f1.subtract(f2);
		prod = f1.multiply(f2);
		quot = f1.divide(f2);
		
		System.out.println(f1.toString() + " + " + f2.toString() + " = " + sum.toString());
		System.out.println(f1.toString() + " - " + f2.toString() + " = " + diff.toString());
		System.out.println(f1.toString() + " * " + f2.toString() + " = " + prod.toString());
		System.out.println(f1.toString() + " / " + f2.toString() + " = " + quot.toString());
	}
	/* Output:
	 * 1/2 + 3/5 = 11/10
	 * 1/2 - 3/5 = -1/10
	 * 1/2 * 3/5 = 3/10
	 * 1/2 / 3/5 = 5/6
	 */
}
