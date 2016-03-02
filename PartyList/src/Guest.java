import java.util.ArrayList;

/* Stores the information of one guest.  This includes their first and last name, the company they work for, and their status (coming, not, unsure).
 * It can display this information, and compare itself to another guest.
 * 
 */
public class Guest
{
	
	private String fName;
	private String lName;
	private String comp;
	private String RSVP;
	protected ArrayList<Guest> known = new ArrayList<Guest>();
	
	public Guest(String a, String b, String c, String d)
	{
		fName = a;
		lName = b;
		comp = c;
		RSVP = d;
	}
	
	public String getFName()
	{
		return fName;
	}
	
	public String getLName()
	{
		return lName;
	}
	
	public String getComp()
	{
		return comp;
	}
	
	public String getRSVP()
	{
		return RSVP;
	}
	
	public void setComp(String c)
	{
		comp = c;
	}
	
	public void setRSVP(String r)
	{
		RSVP = r;
	}
	
	public void display() // prints the info of the guest
	{
		System.out.print(lName + ", " + fName + " " + comp + " ");
		if(!RSVP.equals("?"))
			System.out.println(RSVP);
		else
			System.out.println("maybe");
	}
	
	public int compareGuest(Guest g) // compares the name of two guests, if the one calling the method is earlier,  -1 is returned; if the argument is earlier, 1 is returned; if they're the same, 0 is returned
	{
		int x = lName.compareToIgnoreCase(g.getLName());
		if(x < 0)
			return -1;
		else if(x > 0)
			return 1;
		int y = fName.compareToIgnoreCase(g.getFName());
		if(y < 0)
			return -1;
		else if(y > 0)
			return 1;
		else 
			return 0;	
	}
	
	public void meet(Guest g) //adds guests to each other's 'known' list
	{
		this.known.add(g);
		g.known.add(this);
	}
	
	public boolean sameComp(Guest g) //if both guests work for the same company, return true, false if not
	{
		if(comp.equals(g.getComp()))
			return true;
		else
			return false;
	}
}
