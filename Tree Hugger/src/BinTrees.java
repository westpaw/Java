import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BinTrees 
{
	private TreeNode root;
	
	public BinTrees()
	{
		root = null;
	}

	/**
	 * Determines whether there is an element in the tree
	 * @return true if there is no element
	 * @return false if there is an element
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
	 * Determines if a given TreeNode has no nodes branching from it
	 * @param t the TreeNode to be checked
	 * @return true if t references no other TreeNode
	 * @return false if t references at least one other TreeNode
	 */
	public boolean isLeaf(TreeNode t)
	{
		return t.getLeft() == null && t.getRight() == null;
	}
	
	/**
	 * Determines if a TreeNode references 2 TreeNodes
	 * @param t the TreeNode to be checked
	 * @return true if t references 2 other TreeNodes
	 * @return false if t references less than 2 TreeNodes
	 */
	public boolean hasTwoKid(TreeNode t)
	{
		return t.getLeft() != null && t.getRight() != null;
	}
	
	/**
	 * Adds a TreeNode to the tree.  Assigns new node to root
	 * if there are no values.  Uses recursive call otherwise to
	 * find location
	 * @param x value to be included as a new TreeNode
	 */
	public void add(int x)
	{
		if(this.isEmpty())
			root = new TreeNode(x);
		else
			this.add(x, root);
	}
	
	/**
	 * Compares value to be added with values in tree to find
	 * location for new TreeNode
	 * @see add(int x)
	 * @param x value to be included as a new TreeNode
	 * @param t TreeNode in tree that x is being compared to
	 * @return new TreeNode with value x if t must reference the new TreeNode
	 * @return original TreeNode value if location is already set
	 */
	public TreeNode add(int x, TreeNode t)
	{
		if(t != null)
		{
			if(x < t.getValue())
				t.setLeft(this.add(x, t.getLeft()));
			else if(x > t.getValue())
				t.setRight(this.add(x, t.getRight()));
			else
				System.out.println("Already in list ");
		}
		else
			return new TreeNode(x);
		return t;
	}
	
	/**
	 * Removes a Node containing the value x if it exists
	 * @param x the value being searched for
	 * @param t the TreeNode being checked to contain x
	 * @return null if Node containing x has no references
	 * @return removeDouble(t) if t holds x and references two nodes
	 * @return removeSingle(t) if t holds x and references one node
	 */
	public TreeNode delete(int x, TreeNode t)
	{
		if(t == null)
			System.out.println("Not on list ");
		else if(x < t.getValue())
			t.setLeft(this.delete(x, t.getLeft()));
		else if(x > t.getValue())
				t.setRight(this.delete(x, t.getRight()));
		else
		{
			if(this.isLeaf(t))
				return null;
			else if(this.hasTwoKid(t))
			{
				return this.removeDouble(t);
			}
			else
			{
				return this.removeSingle(t);
			}
		}
		return t;
	}
	
	/**
	 * finds sole TreeNode that a prior node references and refers it
	 * @param t TreeNode to be replaced with its child
	 * @return the child of t
	 */
	public TreeNode removeSingle(TreeNode t)
	{
		if(t.getLeft() == null)
			return t.getRight();
		else
			return t.getLeft();
	}
	
	/**
	 * Replaces a TreeNode with the largest TreeNode smaller than 
	 * itself, then deletes smaller TreeNode
	 * @param t TreeNode to be replaced
	 * @return t with a modified value
	 */
	public TreeNode removeDouble(TreeNode t)
	{
		t.setValue(this.getLargest(t.getLeft()));
		this.delete(t.getValue(), t.getLeft());
		return t;
	}
	
	/**
	 * finds the largest value in the tree from a specific TreeNode
	 * @param t the TreeNode being checked
	 * @return largest value in tree starting from initial TreeNode call
	 */
	public int getLargest(TreeNode t)
	{
		if(t.getRight() == null)
			return t.getValue();
		else
			return this.getLargest(t.getRight());
	}
		
	/**
	 * prints values of tree in numerical order
	 * @param t TreeNode being checked
	 */
	public void inOrder(TreeNode t)
	{
		if(t.getLeft() != null)
			this.inOrder(t.getLeft());
		System.out.println(t.getValue() + " ");
		if(t.getRight() != null)
			this.inOrder(t.getRight());
	}
	
	/**
	 * prints values of tree in preorder
	 * @param t TreeNode being checked
	 */
	public void preOrder(TreeNode t)
	{
		System.out.println(t.getValue() + " ");
		if(t.getLeft() != null)
			this.preOrder(t.getLeft());
		if(t.getRight() != null)
			this.preOrder(t.getRight());
	}
	
	/**
	 * prints values of tree in postorder
	 * @param t TreeNode being checked
	 */
	public void postOrder(TreeNode t)
	{
		if(t.getLeft() != null)
			this.postOrder(t.getLeft());
		if(t.getRight() != null)
			this.postOrder(t.getRight());
		System.out.println(t.getValue() + " ");
	}
	
	/**
	 * gives user instructions to operate program
	 */
	public void prompt()
	{
		System.out.println("Enter \"add\" to add a value to the tree, \n"
				+ "\"delete\" to remove a value, \n"
				+ "\"order\" to print all values in order, \n"
				+ "\"pre\" to print all values in prefix, \n"
				+ "\"post\" to print all values in postfix, \n"
				+ "or \"end\" to end the program.");
	}
	
	/**
	 * retrieves values user wishes to input
	 * @param input input object used to let user type
	 * @return value input by user
	 * @throws IOException
	 */
	public int getValue(BufferedReader input) throws IOException
	{
		System.out.println("Enter the desired value: ");
		return Integer.parseInt(input.readLine());
	}
	
	/**
	 * handles all commands input by user
	 * @throws IOException
	 */
	public void interact() throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		this.prompt();
		
		String ans = input.readLine();
		while(!ans.equals("end"))
		{
			if(ans.equals("add"))
				this.add(this.getValue(input));
			else if(this.isEmpty())
				System.out.println("Tree is empty");
			else if(ans.equals("delete"))
				this.delete(this.getValue(input), root);
			else if(ans.equals("order"))
				this.inOrder(root);
			else if(ans.equals("pre"))
				this.preOrder(root);
			else if(ans.equals("post"))
				this.postOrder(root);
			else
			{
				System.out.println("Invalid input: ");
				this.prompt();
			}
			ans = input.readLine();
		}
	}
	
	public static void main(String [] args) throws IOException
	{
		BinTrees oak = new BinTrees();
		oak.interact();
	}
	/*
	 * main run
	 * 
	 * Enter "add" to add a value to the tree, 
"delete" to remove a value, 
"order" to print all values in order, 
"pre" to print all values in prefix, 
"post" to print all values in postfix, 
or "end" to end the program.
pre
Tree is empty
add
Enter the desired value: 
13
add
Enter the desired value: 
10
add
Enter the desired value: 
20
add
Enter the desired value: 
12
add
Enter the desired value: 
15
add
Enter the desired value: 
5
preorder
Invalid input: 
Enter "add" to add a value to the tree, 
"delete" to remove a value, 
"order" to print all values in order, 
"pre" to print all values in prefix, 
"post" to print all values in postfix, 
or "end" to end the program.
pre
13 
10 
5 
12 
20 
15 
order
5 
10 
12 
13 
15 
20 
post
5 
12 
10 
15 
20 
13 
delete
Enter the desired value: 
5
add
Enter the desired value: 
30
add
Enter the desired value: 
40
add
Enter the desired value: 
11
add
Enter the desired value: 
35
add
Enter the desired value: 
50
order
10 
11 
12 
13 
15 
20 
30 
35 
40 
50 
delete
Enter the desired value: 
50
add
Enter the desired value: 
2
delete
Enter the desired value: 
100
Not on list 
delete
Enter the desired value: 
2
order
10 
11 
12 
13 
15 
20 
30 
35 
40 
delete
Enter the desired value: 
15
post
11 
12 
10 
35 
40 
30 
20 
13 
add
Enter the desired value: 
10
Already in list 
add
Enter the desired value: 
15
add
Enter the desired value: 
20
Already in list 
add
Enter the desired value: 
5
pre
13 
10 
5 
12 
11 
20 
15 
30 
40 
35 
order
5 
10 
11 
12 
13 
15 
20 
30 
35 
40 
post
5 
11 
12 
10 
15 
35 
40 
30 
20 
13 
end

 * 
 * extra
 * 
 * Enter "add" to add a value to the tree, 
"delete" to remove a value, 
"order" to print all values in order, 
"pre" to print all values in prefix, 
"post" to print all values in postfix, 
or "end" to end the program.
pre
Tree is empty
add
Enter the desired value: 
13
add
Enter the desired value: 
10
add
Enter the desired value: 
20
add
Enter the desired value: 
12
add
Enter the desired value: 
15
add
Enter the desired value: 
5
pre
13 
10 
5 
12 
20 
15 
order
5 
10 
12 
13 
15 
20 
post
5 
12 
10 
15 
20 
13 
delete
Enter the desired value: 
5
add
Enter the desired value: 
30
add
Enter the desired value: 
40
add
Enter the desired value: 
112
delete
Enter the desired value: 
112
add
Enter the desired value: 
11
delete
Enter the desired value: 
18
Not on list 
add
Enter the desired value: 
35
add
Enter the desired value: 
50
delete
Enter the desired value: 
0
Not on list 
delete
Enter the desired value: 
20
order
10 
11 
12 
13 
15 
15 
30 
35 
40 
50 
delete
Enter the desired value: 
50
add
Enter the desired value: 
2
delete
Enter the desired value: 
13
delete
Enter the desired value: 
100
Not on list 
delete
Enter the desired value: 
10
delete
Enter the desired value: 
2
order
2 
2 
11 
12 
15 
15 
30 
35 
40 
delete
Enter the desired value: 
15
delete
Enter the desired value: 
12
delete
Enter the desired value: 
30
delete
Enter the desired value: 
35
delete
Enter the desired value: 
40
post
2 
2 
15 
15 
11 
add
Enter the desired value: 
10
add
Enter the desired value: 
15
Already in list 
add
Enter the desired value: 
20
add
Enter the desired value: 
5
pre
11 
2 
2 
10 
5 
15 
15 
20 
order
2 
2 
5 
10 
11 
15 
15 
20 
post
2 
5 
10 
2 
15 
20 
15 
11 
end
 * 
	 */
}
