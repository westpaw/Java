
public class Student
{
	
	private String fName;
	private String lName;
	private int grade;
	private double qpa;
	
	public Student()
	{
	}
	
	public Student(String f, String l, int g, double q)
	{
		this.setFName(f);
		this.setLName(l);
		this.setGrade(g);
		this.setQPA(q);
	}
	
	public String getFName()
	{
		return fName;
	}
	
	public void setFName(String n)
	{
		fName = n;
	}
	
	public String getLName()
	{
		return lName;
	}
	
	public void setLName(String n)
	{
		lName = n;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public void setGrade(int g)
	{
		grade = g;
	}
	
	public double getQPA()
	{
		return qpa;
	}
	
	public void setQPA(double q)
	{
		qpa = q;
	}

	public void display()
	{
		System.out.print(this.getFName() + " " + this.getLName() + " is in " + this.getGrade() + " grade, and has a QPA of " + this.getQPA() + ".  ");
	}
}
