
public class Freshman extends Student
{
	
	private int disciplineRef;
	
	public Freshman(String fn, String ln, int g, double q, int d)
	{
		super(fn, ln, g, q);
		disciplineRef = d;
	}
	
	public int getDisRef()
	{
		return disciplineRef;
	}
	
	public void display()
	{
		super.display();
		System.out.println("This student received " + this.getDisRef() + " discipline referrals in middle school.  ");
	}

}
