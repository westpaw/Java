
public class TreeNode 
{
	
	private int value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int v)
	{
		value = v;
		left = null;
		right = null;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int v)
	{
		value = v;
	}
	
	public TreeNode getLeft()
	{
		return left;
	}
	
	public void setLeft(TreeNode t)
	{
		left = t;
	}
	
	public TreeNode getRight()
	{
		return right;
	}
	
	public void setRight(TreeNode t)
	{
		right = t;
	}

}
