import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Conor Gaffney
public class StudentList
{
	
	private ArrayList<Student>students;
	
	public StudentList()
	{
		students = new ArrayList<Student>();
	}
	
	public ArrayList<Student> getList()
	{
		return students;
	}
	
	public void readStudents(ArrayList<Student>a) throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the name of the file to be read: ");
		
		FileReader readFile = new FileReader(input.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine();
		
		while(inputString != null)
		{
			StringTokenizer in = new StringTokenizer(inputString);
				String fn = in.nextToken();
				String ln = in.nextToken();
				int spot = findSpot(students, fn, ln);
				switch(Integer.parseInt(in.nextToken()))
						{
					case 9:
					{
						a.add(spot, new Freshman(fn, ln, 9, Double.parseDouble(in.nextToken()), Integer.parseInt(in.nextToken())));
						break;
					}
					case 10:
					{
						a.add(spot, new Sophomore(fn, ln, 10, Double.parseDouble(in.nextToken()), Integer.parseInt(in.nextToken())));
						break;
					}
					case 11:
					{
						a.add(spot, new Junior(fn, ln, 11, Double.parseDouble(in.nextToken()), in.nextToken()));
						break;
					}
					default:
						a.add(spot, new Señor(fn, ln, 12, Double.parseDouble(in.nextToken()), Boolean.parseBoolean(in.nextToken()), Double.parseDouble(in.nextToken())));
						}
				inputString = inFile.readLine();
		}
		
		inFile.close();
	}
	
	public int findSpot(ArrayList<Student> a, String fn, String ln)
	{
		if(a.isEmpty())
			return 0;
		int l = 0;
		int r = a.size() - 1;
		while(l <= r)
		{
			int mid = (l + r) / 2;
			int spot = ln.compareTo(a.get(mid).getLName());
			if(spot == 0)
				spot = fn.compareTo(a.get(mid).getFName());
			if(spot > 0)
			{
				if(mid == r)
					return mid + 1;
				else
					l = mid + 1;
			}
			else if(spot < 0)
			{
				if(mid == l)
					return mid;
				else
					r = mid - 1;
			}
		}
		return -1; //would only return if name is duplicate
	}
	
	public void listAllStudents()
	{
		for(Student s : students)
			s.display();
	}
	
	public static void main(String [] args) throws IOException
	{
		StudentList list = new StudentList();
		list.readStudents(list.getList());
		list.listAllStudents();
	}
	
	/* part 1:
	 * Enter the name of the file to be read: 
InheritanceScript.txt
Lawrence Andortre is in 10 grade, and has a QPA of 2.77
Moe Enster is in 9 grade, and has a QPA of 3.17
Moe Fiat is in 12 grade, and has a QPA of 2.89
Tony Fich is in 11 grade, and has a QPA of 3.12
Matt Gitrik is in 11 grade, and has a QPA of 2.8
Paul Oercabl is in 11 grade, and has a QPA of 3.4
Gordan Punkin is in 12 grade, and has a QPA of 2.85
Dom Spupidhead is in 10 grade, and has a QPA of 0.0
Sam Taclus is in 10 grade, and has a QPA of 3.86
Amanda Truns is in 9 grade, and has a QPA of 3.9

	 * part 2:
	 * Enter the name of the file to be read: 
InheritanceScript.txt
Lawrence Andortre is in 10 grade, and has a QPA of 2.77.  This student scored a(n) 1630 on the PSATs.  
Moe Enster is in 9 grade, and has a QPA of 3.17.  This student received 2 discipline referrals in middle school.  
Moe Fiat is in 12 grade, and has a QPA of 2.89.  This student has completed his/her community service requirements.  He/she owes $25.5 to the school.  
Tony Fich is in 11 grade, and has a QPA of 3.12.  This student scored a(n) basic on the algebra Keystone test.  
Matt Gitrik is in 11 grade, and has a QPA of 2.8.  This student scored a(n) advanced on the algebra Keystone test.  
Paul Oercabl is in 11 grade, and has a QPA of 3.4.  This student scored a(n) proficient on the algebra Keystone test.  
Gordan Punkin is in 12 grade, and has a QPA of 2.85.  This student has not completed his/her community service requirements.  He/she owes $12.04 to the school.  
Dom Spupidhead is in 10 grade, and has a QPA of 0.0.  This student scored a(n) 300 on the PSATs.  
Sam Taclus is in 10 grade, and has a QPA of 3.86.  This student scored a(n) 2150 on the PSATs.  
Amanda Truns is in 9 grade, and has a QPA of 3.9.  This student received 0 discipline referrals in middle school.  

	 * 
	 */
}
