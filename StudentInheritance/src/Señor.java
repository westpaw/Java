
public class Señor extends Student
{
	
	private boolean service;
	private double feesOwed;
	
	public Señor(String fn, String ln, int g, double q, boolean s, double f)
	{
		super(fn, ln, g, q);
		service = s;
		feesOwed = f;
	}

	public boolean serviceIsDone()
	{
		return service;
	}
	
	public double getFees()
	{
		return Math.round(feesOwed * 100) / 100.;
	}
	
	public void display()
	{
		super.display();
		if(this.serviceIsDone())
			System.out.print("This student has completed his/her community service requirements.  ");
		else
			System.out.print("This student has not completed his/her community service requirements.  ");
		System.out.println("He/she owes $" + this.getFees() + " to the school.  ");
	}
}
