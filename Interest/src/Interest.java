/*Conor Gaffney
 * May 20 2014
 */
public class Interest 
{
	public static void main(String [] args)
	{
		for(double intRate = .06;intRate <= .12;intRate = intRate + .01)
		{
			System.out.println("Starting investment: $1000");
			System.out.println("Interest rate: " + Math.round(intRate*100) + "%");
			double money = 1000.;
			for(int year = 1;year <= 10; year++)
			{
				money = 1000 * Math.pow(1+intRate, year);
				System.out.println("Total investment after " + year + " years: $" + Math.round(money*100)/100.0);
			}
			System.out.println();
		}
	}
/* Output:
Starting investment: $1000
Interest rate: 6%
Total investment after 1 years: $1060.0
Total investment after 2 years: $1123.6
Total investment after 3 years: $1191.02
Total investment after 4 years: $1262.48
Total investment after 5 years: $1338.23
Total investment after 6 years: $1418.52
Total investment after 7 years: $1503.63
Total investment after 8 years: $1593.85
Total investment after 9 years: $1689.48
Total investment after 10 years: $1790.85

Starting investment: $1000
Interest rate: 7%
Total investment after 1 years: $1070.0
Total investment after 2 years: $1144.9
Total investment after 3 years: $1225.04
Total investment after 4 years: $1310.8
Total investment after 5 years: $1402.55
Total investment after 6 years: $1500.73
Total investment after 7 years: $1605.78
Total investment after 8 years: $1718.19
Total investment after 9 years: $1838.46
Total investment after 10 years: $1967.15

Starting investment: $1000
Interest rate: 8%
Total investment after 1 years: $1080.0
Total investment after 2 years: $1166.4
Total investment after 3 years: $1259.71
Total investment after 4 years: $1360.49
Total investment after 5 years: $1469.33
Total investment after 6 years: $1586.87
Total investment after 7 years: $1713.82
Total investment after 8 years: $1850.93
Total investment after 9 years: $1999.0
Total investment after 10 years: $2158.92

Starting investment: $1000
Interest rate: 9%
Total investment after 1 years: $1090.0
Total investment after 2 years: $1188.1
Total investment after 3 years: $1295.03
Total investment after 4 years: $1411.58
Total investment after 5 years: $1538.62
Total investment after 6 years: $1677.1
Total investment after 7 years: $1828.04
Total investment after 8 years: $1992.56
Total investment after 9 years: $2171.89
Total investment after 10 years: $2367.36

Starting investment: $1000
Interest rate: 10%
Total investment after 1 years: $1100.0
Total investment after 2 years: $1210.0
Total investment after 3 years: $1331.0
Total investment after 4 years: $1464.1
Total investment after 5 years: $1610.51
Total investment after 6 years: $1771.56
Total investment after 7 years: $1948.72
Total investment after 8 years: $2143.59
Total investment after 9 years: $2357.95
Total investment after 10 years: $2593.74

Starting investment: $1000
Interest rate: 11%
Total investment after 1 years: $1110.0
Total investment after 2 years: $1232.1
Total investment after 3 years: $1367.63
Total investment after 4 years: $1518.07
Total investment after 5 years: $1685.06
Total investment after 6 years: $1870.41
Total investment after 7 years: $2076.16
Total investment after 8 years: $2304.54
Total investment after 9 years: $2558.04
Total investment after 10 years: $2839.42

Starting investment: $1000
Interest rate: 12%
Total investment after 1 years: $1120.0
Total investment after 2 years: $1254.4
Total investment after 3 years: $1404.93
Total investment after 4 years: $1573.52
Total investment after 5 years: $1762.34
Total investment after 6 years: $1973.82
Total investment after 7 years: $2210.68
Total investment after 8 years: $2475.96
Total investment after 9 years: $2773.08
Total investment after 10 years: $3105.85
 */
}
