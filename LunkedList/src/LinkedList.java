import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Conor
 *
 */
public class LinkedList 
{
	private ListNode list;
	
	public LinkedList()
	{
		list = null;
	}
	
	//adds value to list in proper numerical order if it doesn't already exist
	public void addValue(int value)
	{
		ListNode add = new ListNode(value);
		if(list == null)
			list = add;
		else if(list.getValue() == value)
			System.out.println("Already on list");
		else if(list.getValue() > value)
		{
			add.setNext(list);
			list = add;
		}
		else if(list.getNext() == null)
			list.setNext(add);
		else
		{
			ListNode last = list;
			ListNode next = list.getNext();
			do
			{
				if(next.getValue() == value)
				{
					System.out.println("Already on list");
					return;
				}
				else if(next.getValue() > value)
				{
					add.setNext(next);
					last.setNext(add);
					return;
				}
				else
				{
					last = next;
					if(next.getNext() != null)
						next = next.getNext();
					else
						next = null;
				}
			}while(next != null);
			last.setNext(add);
		}
	}

	//removes value from beginning of list
	public void deleteValue(int value)
	{
		if(list.getValue() == value)
			list = list.getNext();
		else
			this.deleteValue(value, list);
	}
	
	//removes value from any other part in list if it exists
	public void deleteValue(int value, ListNode spot)
	{
		if(spot.getNext() == null)
			System.out.println("Not on list");
		else if(spot.getNext().getValue() == value)
			spot.setNext(spot.getNext().getNext());
		else
			this.deleteValue(value, spot.getNext());
	}
	
	//empties list
	public void deleteAll()
	{
		list = null;
	}
	
	//prints all values in list
	public void printList(ListNode l)
	{
		if(!isEmpty())
		{
			System.out.print(l.getValue() + " ");
			if(l.getNext() != null)
				this.printList(l.getNext());
			else
				System.out.println('\n');
		}
		else
			System.out.println("List is empty");
	}
	
	//returns true if list is empty
	public boolean isEmpty()
	{
		return list == null;
	}
	
	//gives instructions for user input
	public void instructions()
	{
		System.out.println("Enter \"add\" to add a value to the list," + '\n' + 
				"\"delete\" to remove a value," + '\n' +  
				"\"delete all\" to remove all values," + '\n' + 
				"\"print\" to print all values in the list, " + '\n' + 
				"or \"end\" to quit the program");
	}
	
	//handles user input to list modification
	public void interact() throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		this.instructions();
		
		String ans = input.readLine();
		
		while(ans != "end")
		{
			if(ans.equals("add"))
					this.addValue(this.askValue(true));
			else if(ans.equals("delete"))
			{
				if(this.isEmpty())
					System.out.println("List is Empty");
				else
					this.deleteValue(this.askValue(false));
			}
			else if(ans.equals("delete all"))
					this.deleteAll();
			else if(ans.equals("print"))
					this.printList(list);
			else if(ans.equals("end"))
				break;
			else
			{
				System.out.println("Invalid input");
				this.instructions();
			}
			System.out.println("Enter another command: ");
			ans = input.readLine();
		}
	}
	
	//receives value from user input
	public int askValue(boolean plus) throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.print("Enter the desired value ");
		if(plus)
			System.out.println("to be added: ");
		else
			System.out.println("to be deleted: ");
		return Integer.parseInt(input.readLine());
	}
	
	public static void main(String[] args) throws IOException
	{
		LinkedList links = new LinkedList();
		links.interact();
	}
/* Trial 1
 * Enter "add" to add a value to the list,
"delete" to remove a value,
"delete all" to remove all values,
"print" to print all values in the list, 
or "end" to quit the program
add
Enter the desired value to be added: 
15
Enter another command: 
add
Enter the desired value to be added: 
10
Enter another command: 
add
Enter the desired value to be added: 
25
Enter another command: 
deleete
Invalid input
Enter "add" to add a value to the list,
"delete" to remove a value,
"delete all" to remove all values,
"print" to print all values in the list, 
or "end" to quit the program
Enter another command: 
delete
Enter the desired value to be deleted: 
12
Not on list
Enter another command: 
add
Enter the desired value to be added: 
5
Enter another command: 
add
Enter the desired value to be added: 
20
Enter another command: 
add
Enter the desired value to be added: 
15
Already on list
Enter another command: 
delete
Enter the desired value to be deleted: 
30
Not on list
Enter another command: 
add
Enter the desired value to be added: 
17
Enter another command: 
add
Enter the desired value to be added: 
16
Enter another command: 
add
Enter the desired value to be added: 
10
Already on list
Enter another command: 
delete
Enter the desired value to be deleted: 
15
Enter another command: 
delete
Enter the desired value to be deleted: 
10
Enter another command: 
print
5 16 17 20 25 

Enter another command: 
add
Enter the desired value to be added: 
4
Enter another command: 
add
Enter the desired value to be added: 
0
Enter another command: 
delete
Enter the desired value to be deleted: 
25
Enter another command: 
delete
Enter the desired value to be deleted: 
20
Enter another command: 
delete
Enter the desired value to be deleted: 
-4
Not on list
Enter another command: 
add
Enter the desired value to be added: 
18
Enter another command: 
add
Enter the desired value to be added: 
5
Already on list
Enter another command: 
add
Enter the desired value to be added: 
19
Enter another command: 
delete
Enter the desired value to be deleted: 
0
Enter another command: 
delete
Enter the desired value to be deleted: 
4
Enter another command: 
print
5 16 17 18 19 

Enter another command: 
delete all
Enter another command: 
print
List is empty
Enter another command: 
delete
List is Empty
Enter another command: 
add
Enter the desired value to be added: 
5
Enter another command: 
add
Enter the desired value to be added:
10
Enter another command:
add
Enter the desired value to be added: 
7
Enter another command: 
print
5 10 7 

Enter another command: 
end
 * 
 */
	
/* Trial 2
 * Enter "add" to add a value to the list,
"delete" to remove a value,
"delete all" to remove all values,
"print" to print all values in the list, 
or "end" to quit the program
add
Enter the desired value to be added: 
5
Enter another command: 
delete
Enter the desired value to be deleted: 
5
Enter another command: 
print
List is empty
Enter another command: 
end
 * 
 */
}
