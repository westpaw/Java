package fcasd.gaffney.f_exam.vantage.level;

public class Center
{
	
	private int xTile;
	private int yTile;
	private boolean connected;
	
	/**
	 * Creates a Center to aid in level creation
	 * @param x coordinate of Center in tile array of level
	 * @param y coordinate of Center in tile array of level
	 */
	public Center(int x, int y)
	{
		xTile = x;
		yTile = y;
		connected = false;
	}
	
	public int getX()
	{
		return xTile;
	}
	
	public int getY()
	{
		return yTile;
	}
	
	/**
	 * Returns if the Center is connected to the path network of a level
	 * @return true if Center is connected to other Centers
	 * @return false if Center has not been connected
	 */
	public boolean isConnected()
	{
		return connected;
	}
	
	/**
	 * Marks a center as connected to the level layout
	 */
	public void connects()
	{
		connected = true;
	}

}
