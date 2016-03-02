
public class Junior extends Student
{
	
	private String KeystoneAlg;
	
	public Junior(String fn, String ln, int g, double q, String k)
	{
		super(fn, ln, g, q);
		KeystoneAlg = k;
	}
	
	public String getKeystone()
	{
		return KeystoneAlg;
	}
	
	public void display()
	{
		super.display();
		System.out.println("This student scored a(n) " + this.getKeystone() + " on the algebra Keystone test.  ");
	}

}
