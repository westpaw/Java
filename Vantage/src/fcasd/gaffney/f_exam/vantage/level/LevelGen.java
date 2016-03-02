package fcasd.gaffney.f_exam.vantage.level;

import java.util.ArrayList;
import java.util.Random;

public class LevelGen extends Level
{
	
	private static final Random r = new Random();
	private int goal;

	public LevelGen(int w, int h) 
	{
		super(w, h);
	}
	
	/**
	 * Creates a random layout for the level
	 */
	public void buildLevel()
	{ 	
		for(int y = 0; y < this.getHeight(); y++)
			for(int x = 0; x < this.getWidth(); x++)
			{
				if(x < this.getDISTANCE() //defaults tile to a wall if too close to the border of the level
						|| x > this.getWidth() - this.getDISTANCE() 
						|| y < this.getDISTANCE()
						|| y > this.getHeight() - this.getDISTANCE())
					this.getTiles()[x][y] = this.getWALL();
				if(this.getTiles()[x][y] != this.getBLANK()) //will not change a tile that has already been assigned
					continue;
				int code = r.nextInt(20); // 5% chance to spawn new room if far enough from other rooms
				if(code == 19 && isFarAway(x, y))
				{
					int rad = r.nextInt(3) + 2; //radius of room between 2 and 4
					for(int a = x - rad; a <= x + rad; a++)
						for(int b = y - rad; b <= y + rad; b++)
							this.getTiles()[a][b] = r.nextInt(this.getFLOOR() - 2) + 2; //builds room around center tile
					this.getCenters().add(new Center(x, y)); // saves coordinates of center
				}
				else
					this.getTiles()[x][y] = this.getWALL();
			}
	this.connectCenters(this.getCenters());
	}
	
	/**
	 * Connects first two Centers with a path of FloorTiles, won't
	 * make changes if only one Center
	 * @param centers list of Centers spawned in level
	 */
	public void connectCenters(ArrayList<Center> centers)
	{
		if(centers.size() <= 1)
			return;
		Center cen1 = centers.get(0);
		Center cen2 = centers.get(1);
		this.buildPath(cen1, cen2);
		centers.get(0).connects();
		centers.get(1).connects();
		this.connectCenters(centers, 2);
	}
	
	/**
	 * Connects remaining Centers after first two, executes for
	 * all Centers
	 * @param centers list of Centers
	 * @param spot centers index to be checked
	 */
	public void connectCenters(ArrayList<Center> centers, int spot)
	{
		if(spot == centers.size())
			return;
		Center cen2 = centers.get(spot);
		Center cen1 = this.findClosest(centers, cen2.getX(), cen2.getY(), spot);
		this.buildPath(cen1, cen2);
		centers.get(spot).connects();
		this.connectCenters(centers, spot + 1);
	}
	
	/**
	 * Finds closest Center to a specified Center
	 * @param centers list of Centers
	 * @param x coordinate of specified Center
	 * @param y coordinate of specified Center
	 * @param origin index of specified Center
	 * @return closest Center already connected to layout
	 */
	public Center findClosest(ArrayList<Center> centers, int x, int y, int origin)
	{
		int min = this.getWidth() + this.getHeight();
		int spot = -1;
		for(int z = 0; z < origin; z++)
		{
			int dis = Math.abs(centers.get(z).getX() - x) + Math.abs(centers.get(z).getY() - y);
			if(dis < min)
			{
				min = dis;
				spot = z;
			}
		}
		return this.getCenters().get(spot);
	}
	
	/**
	 * Determines how to build a path between two Centers
	 * @param cen1 first Center
	 * @param cen2 second Center, must have greater y coordinate or equal y and greater x coordinate
	 */
	public void buildPath(Center cen1, Center cen2)
	{
		if(cen2.getX() < cen1.getX())
			this.buildDiagPos(cen2, cen1); //positive slope
		else if(cen2.getX() == cen1.getX())
			this.buildVert(cen2, cen1);
		else if(cen2.getY() == cen1.getY())
			this.buildHori(cen1, cen2);
		else
			this.buildDiagNeg(cen1, cen2); //negative slope
	}
	
	/**
	 * Builds path straight up from higher Center to lower Center
	 * @param start higher Center
	 * @param goal lower Center
	 */
	public void buildVert(Center start, Center goal)
	{
		for(int y = start.getY(); y < goal.getY(); y++)
		{
			if(this.getTiles()[start.getX()][y] < 8) //won't draw over FloorTiles
				continue;
			this.getTiles()[start.getX()][y] = 1;
			this.getTiles()[start.getX() + 1][y] = 1;
		}
	}
	
	/**
	 * Builds path straight across from left Center to right Center
	 * @param start left Center
	 * @param goal right Center
	 */
	public void buildHori(Center start, Center goal)
	{
		for(int x = start.getX(); x < goal.getX(); x++)
		{
			if(this.getTiles()[x][start.getY()] < 8)
				continue;
			this.getTiles()[x][start.getY()] = 1;
			this.getTiles()[x][start.getY() + 1] = 1;
		}
	}
	
	/**
	 * Builds diagonal path from lower left Center to upper right Center
	 * @param start lower left Center
	 * @param goal upper right Center
	 */
	public void buildDiagPos(Center start, Center goal)
	{
		int slopeX = goal.getX() - start.getX();
		int slopeY = start.getY() - goal.getY();
		int divisor = this.gcf(slopeX, slopeY);
		slopeX = slopeX / divisor; //simplifies change in y and x to form as close to a direct path as possible
		slopeY = slopeY / divisor;
		for(int x = start.getX(), y = start.getY(); x <= goal.getX() || y >= goal.getY();)
		{
			for(int yy = y; y >= yy - slopeY; y--) //moves up
			{
				if(this.getTiles()[x][y] >= 8)
					this.getTiles()[x][y] = 1;
				if(this.getTiles()[x + 1][y] >= 8)
					this.getTiles()[x + 1][y] = 1;
			}
			
			for(int xx = x; x <= xx + slopeX; x++) //moves left
			{
				if(this.getTiles()[x][y] >= 8)
					this.getTiles()[x][y] = 1;
				if(this.getTiles()[x][y - 1] >= 8)
					this.getTiles()[x][y - 1] = 1;
			}
		}
	}
	
	/**
	 * Builds diagonal path from upper left Center to lower right Center
	 * @param start upper left Center
	 * @param goal lower right Center
	 */
	public void buildDiagNeg(Center start, Center goal)
	{
		int slopeX = goal.getX() - start.getX();
		int slopeY = goal.getY() - start.getY();
		int divisor = this.gcf(slopeX, slopeY);
		slopeX = slopeX / divisor;
		slopeY = slopeY / divisor;
		for(int x = start.getX(), y = start.getY(); x <= goal.getX() || y <= goal.getY();)
		{
			for(int yy = y; y <= yy + slopeY; y++) //moves down
			{
				if(this.getTiles()[x][y] >= 8)
					this.getTiles()[x][y] = 1;
				if(this.getTiles()[x + 1][y] >= 8)
					this.getTiles()[x + 1][y] = 1;
			}
			
			for(int xx = x; x <= xx + slopeX; x++) //moves left
			{
				if(this.getTiles()[x][y] >= 8)
					this.getTiles()[x][y] = 1;
				if(this.getTiles()[x][y + 1] >= 8)
					this.getTiles()[x][y + 1] = 1;
			}
		}
	}
	
	/**
	 * Finds the greatest common factor between two numbers
	 * @param a first number
	 * @param b second number
	 * @return greatest factor shared by a and b
	 */
	public int gcf(int a, int b)
	{
		int ans = 1;
		for(int x = 2; x <= a && x <= b; x++)
			if(a % x == 0 && b % x == 0)
				ans = x;
		return ans;
	}
	
	/**
	 * Sets one of the Centers to be the goal to 
	 * advance to the next level
	 * @param centers the list of Centers in the level
	 * @param spawn the index of the Center the player spawns at, will not be chosen for the goal
	 */
	public void setGoal(ArrayList<Center> centers, int spawn)
	{
		goal = r.nextInt(centers.size());
		while(goal == spawn)
			goal = r.nextInt(centers.size());
		this.getTiles()[centers.get(goal).getX()][centers.get(goal).getY()] = this.getSTAIRS();
	}
	
	/**
	 * Prevents player from activating goal tile if time runs out
	 * @param centers list of Centers, goal contained at index of goal
	 */
	public void closeGoal(ArrayList<Center> centers)
	{
		this.getTiles()[centers.get(goal).getX()][centers.get(goal).getY()] = this.getFLOOR();
	}
	
	/**
	 * Makes sure rooms won't be generated too close together.
	 * Minimum distance held as static in Level as DISTANCE
	 * @param x coordinate of potential Center
	 * @param y coordinate of potential Center
	 * @return true if room can be created
	 * @return false if coordinates are too close to preexisting Center
	 */
	public boolean isFarAway(int x, int y)
	{
		for(int z = 0; z < this.getCenters().size(); z++)
		{
			if(Math.abs(this.getCenters().get(z).getX() - x) < this.getDISTANCE()
					|| Math.abs(this.getCenters().get(z).getY() - y) < this.getDISTANCE())
				return false;
		}
		return true;
	}

}
