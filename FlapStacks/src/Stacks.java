import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Conor
 *
 */
public class Stacks 
{
	
	private ListNode stak;
	
	public Stacks()
	{
		stak = null;
	}
	
	public void push(int x)
	{
		ListNode add = new ListNode(x);
		add.setNext(stak);
		stak = add;
	}
	
	public int pop()
	{
		int x = stak.getValue();
		stak = stak.getNext();
		return x;
	}
	
	public boolean isEmpty()
	{
		return stak == null;
	}
	
	public int peekTop()
	{
		return stak.getValue();
	}
	
	public void add()
	{
		this.push(this.pop() + this.pop());
	}
	
	public void sub()
	{
		this.push(-this.pop() + this.pop());
	}
	
	public void mult()
	{
		this.push(this.pop() * this.pop());
	}
	
	public void div()
	{
		this.push((int)(1.0/this.pop() * this.pop()));
	}
	
	public int solve(String eq)
	{
		for(int x = 0; x < eq.length(); x++)
		{
			char c = eq.charAt(x);
			if(c >= 48
					&& c <= 57)
				this.push(c-48);
			else if(c == 42)
				this.mult();
			else if(c == 43)
				this.add();
			else if(c == 45)
				this.sub();
			else
				this.div();
		}
		return stak.getValue();
	}
	
	public void interact() throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter your postfix equation in need of solving: ");
		String eq = input.readLine();
		
		System.out.println("Your equation is " + eq);
		System.out.println("and the solution is " + this.solve(eq));
	}
	
	public static void main(String [] args) throws IOException
	{
		Stacks stoocks = new Stacks();
		stoocks.interact();
	}
/* Trial 1
 * Enter your postfix equation in need of solving: 
985-*
Your equation is 985-*
and the solution is 27

 * Trial 2
 * Enter your postfix equation in need of solving: 
98-5*
Your equation is 98-5*
and the solution is 5

 * Trial 3
 * Enter your postfix equation in need of solving: 
34521+-*/
//Your equation is 34521+-*/
//and the solution is 0
	
/*
 * Trial 4
 * Enter your postfix equation in need of solving: 
93/3/
Your equation is 93/3/
and the solution is 1

 * Trial 5
 * Enter your postfix equation in need of solving: 
933//
Your equation is 933//
and the solution is 9

 * Trial 6
 * Enter your postfix equation in need of solving: 
234+-1-43*+7/
Your equation is 234+-1-43*+7/
and the solution is 0

 * Trial 7
 * Enter your postfix equation in need of solving: */
//54321*/+-
//Your equation is 54321*/+-
//and the solution is 0
/*
 * Trial 8
 * Enter your postfix equation in need of solving: 
8842-*+356-+*
Your equation is 8842-*+356-+*
and the solution is 48

 * Trial 9
 * Enter your postfix equation in need of solving: 
54321+-*/
//Your equation is 54321+-*/
//and the solution is 2147483647
/**divide by 0*/
 }
