
public class Sophomore extends Student
{
	
	private int psatScore;
	
	public Sophomore(String fn, String ln, int g, double q, int p)
	{
		super(fn, ln, g, q);
		psatScore = p;
	}
	
	public int getScore()
	{
		return psatScore;
	}
	
	public void display()
	{
		super.display();
		System.out.println("This student scored a(n) " + this.getScore() + " on the PSATs.  ");
	}

}
