import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* Conor Gaffney
 * This stores an arrayList of all the guests invited to a party.  The data is read from a file.  The user can then request a guest's information, list the guests in alphabetical order by last name
 * first, or show the number of guests that have RSVP'd as yes, no or maybe.
 * Addition: user can also add a new guest to the list, change the response of a guest, and list all guests that work for the same company as a specific guest.
 */
public class Registry
{
	
	private Guest person; // dummy guest to make comparisons and additions to list
	protected ArrayList<Guest> list = new  ArrayList<Guest>();
	
	public Registry()
	{
	}

	public void readGuestList() throws IOException // registers the invited guests into the ArrayList
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the name of the file to be read: ");
		
		FileReader readFile = new FileReader(input.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		
		System.out.println("Reading file...");
		String inputString = inFile.readLine();
		
		String fName, lName, comp, RSVP;
		
		while(inputString != null)
		{
			StringTokenizer part = new StringTokenizer(inputString);
			while(part.hasMoreTokens())
			{
				fName = part.nextToken();
				lName = part.nextToken();
				comp = part.nextToken();
				RSVP = part.nextToken();
				list.add(new Guest(fName, lName, comp, RSVP));
			}
			inputString = inFile.readLine();
		}
		
		inFile.close();
		System.out.println("Reading completed.");
	}
	
	public void sortGuests(ArrayList<Guest>list) //puts guests in alphabetical order by last name, then first
	{
		for(int x  = 0; x < list.size() - 1; x++)
		{
			int small = x;
			for(int a = x + 1; a < list.size(); a++)
			{
				if(list.get(a).compareGuest(list.get(small)) < 0)
					small = a;
			}
			list.add(x, list.remove(small));
		}
	}
	
	public void interact() throws IOException // creates prompt for user to view different guest info
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		String code;
		do
			{
				System.out.println("Enter 'G' to retrieve guest information, 'L' to display a list of all guests, 'N' to show the number of people that have and have not RSVP'd,");
				System.out.println("'A' to add a guest to the list, 'R' to change a guest's RSVP, 'C' to list all guests that work for the same company as a certain guest,");
				System.out.println("'M' to record that two guests have met, 'K' to list all the guests that know a certain guest, or 'Q' to exit: ");
				code = input.readLine();
				if(code.equalsIgnoreCase("G"))
					this.showInfo();
				else if(code.equalsIgnoreCase("L"))
					this.listGuests();
				else if(code.equalsIgnoreCase("N"))
					this.listRSVP();
				else if(code.equalsIgnoreCase("A"))
					this.addGuest();
				else if(code.equalsIgnoreCase("R"))
					this.changeRSVP();
				else if(code.equalsIgnoreCase("C"))
					this.listColleagues();
				else if(code.equalsIgnoreCase("M"))
					this.meeting();
				else if(code.equalsIgnoreCase("K"))
					this.knows();
				System.out.println();
			}
		while(!code.equalsIgnoreCase("Q"));
	}
	
	public void meeting() throws IOException
	{
		int result1, result2;
		do
		{
		System.out.println("Enter the full name of the first guest: ");
		result1 = this.findInfo();
		if(result1 == -1)
			System.out.println("Guest does not exist.");
		}
		while(result1 == -1);
		do
		{
		System.out.println("Enter the full name of the second guest: ");
		result2 = this.findInfo();
		if(result2 == -1)
			System.out.println("Guest does not exist.");
		}
		while(result2 == -1);
		if(!list.get(result1).sameComp(list.get(result2)) && this.searchList(list.get(result1).known, list.get(result2)) == -1)
				list.get(result1).meet(list.get(result2));
		else
			System.out.println("Guests already know each other");
	}
	
	public void knows() throws IOException
	{
		System.out.println("Enter the full name of the guest: ");
		int result = this.findInfo();
		if(result == -1)
			System.out.println("Guest does not exist");
		else
		{
			ArrayList<Guest> temp = new ArrayList<Guest>(list.get(result).known);
			for(int x = 0; x < list.size(); x++)
				if(x != result && list.get(x).sameComp(list.get(result)))
					temp.add(list.get(x));
			this.sortGuests(temp);
			for(int x = 0; x < temp.size(); x++)
				temp.get(x).display();
		}
	}
	
	public void addGuest() throws IOException // adds a guest if they aren't already in the list
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the full name of the new guest: ");
		int result = this.findInfo();
		if(result != -1)
		{
			System.out.println("Guest already exists");
			list.get(result).display();
		}
		else
		{
			System.out.println("Enter the company of this new guest: ");
			person.setComp(input.readLine());
			System.out.println("Enter the response of this new guest: either 'yes', 'no', or '?' ");
			person.setRSVP(input.readLine());
			int spot = 0;
			while(spot < list.size() && person.compareGuest(list.get(spot)) == 1)
				spot++;
			list.add(spot, person);
		}
	}
	
	public void changeRSVP() throws IOException // changes the response of a guest, notifies the user if the desired response was already selected
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the full name of the guest that changed his or her response: ");
		int result = this.findInfo();
		if(result == -1)
		{
			System.out.println("Guest does not exist");
		}
		else
		{
			System.out.println("Enter the new response for this guest: either 'yes', 'no', or '?' ");
			String comp = input.readLine();
			if(comp.equals(list.get(result).getRSVP()))
				System.out.println("Guest had already answered with this response. ");
			else
				list.get(result).setRSVP(comp);
		}
		
	}
	
	public void listColleagues() throws IOException // lists all guests that work for the same company as the specified guest
	{
		System.out.println("Enter the full name of a guest: ");
		int result = this.findInfo();
		if(result == -1)
		{
			System.out.println("Guest does not exist");
		}
		else
		{
			for(int x = 0; x < list.size(); x++)
				if(list.get(x).sameComp(list.get(result)))
						list.get(x).display(); 
		}
	}
	
	public int searchList(ArrayList<Guest>list, Guest x) //returns index of guest x, -1 if not found in list
	{
			int left = 0;
			int right = list.size() - 1;
			while(left <= right)
			{
				int middle = (left + right) / 2;
				int last = x.compareGuest(list.get(middle));
				if(last < 0)
					right = middle - 1;
				else 
					if(last > 0)
						left = middle + 1;
				else
						return middle;
			}
			return -1;
	}
	
	public int findInfo() throws IOException // gets the index of a guest when the user supplies a full name
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		StringTokenizer part = new StringTokenizer(input.readLine());
		person = new Guest(part.nextToken(), part.nextToken(), "", "");
		return this.searchList(list, person);
	}
	
	public void showInfo() throws IOException // prints all info of a guest
	{
		System.out.println("Enter the full name of the guest: ");
		int result = this.findInfo();
		if(result == -1)
			System.out.println("Guest does not exist. ");
		else
			list.get(result).display();
	}
	
	public void listGuests() //lists all guests
	{
		for(int x = 0; x < list.size(); x++)
		{
			list.get(x).display();
		}
	}
	
	public void listRSVP() // displays how many guests have RSVP'd 'yes', how many 'no', and how many haven't responded
	{
		String s;
		int y = 0;
		int n = 0;
		int dnr = 0;
		for(int x = 0; x < list.size(); x++) 
		{
			s = list.get(x).getRSVP();
			if(s.equals("yes"))
					y++;
			else if(s.equals("no"))
					n++;
			else
				dnr++;
		}
		System.out.println(y + " guests have confirmed attendance.");
		System.out.println(n + " guests are unable to attend.");
		System.out.println(dnr + " guests have not yet responded.");
	}
	
}
