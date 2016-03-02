

public class ListNode
{
	private int x; //value of list, any object
	private ListNode next; //next value in list
	
	public ListNode(int x)
	{
		this.x = x;
		next = null;
	}
	
	public int getValue()
	{
		return x;
	}
	
	public void setValue(int x)
	{
		this.x = x;
	}
	
	public ListNode getNext()
	{
		return next;
	}
	
	public void setNext(ListNode l)
	{
		next = l;
	}
}
