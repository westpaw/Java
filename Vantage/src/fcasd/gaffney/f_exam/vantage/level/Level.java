package fcasd.gaffney.f_exam.vantage.level;

import java.util.ArrayList;

import fcasd.gaffney.f_exam.vantage.graphics.Render;
import fcasd.gaffney.f_exam.vantage.graphics.Sprite;
import fcasd.gaffney.f_exam.vantage.level.tile.Tile;

public abstract class Level
{
	
	private static final int DISTANCE = 11; //minimum distance between two centers
	private static final int BLANK = 0; //highest index for each type of tile
	private static final int FLOOR = 7; 
	private static final int WALL = 8;
	private static final int STAIRS = 9;
	
	private int width; // in tiles
	private int height;
	private int[][] tiles;
	private ArrayList<Center> centers = new ArrayList<Center>(); // tracks centers of rooms
	private int spawn;
	private boolean done;
	
	public Level(String path) //spawns level from file ///////////////////////////////////
	{
		loadLevel(path);
	}
	
	/**
	 * Creates a level layout of specified dimentions
	 * @param w width of the level
	 * @param h height of the level
	 */
	public Level(int w, int h) //generates random level
	{
		width = w;
		height = h;
		tiles = new int[width][height];
		for(int x = 0; x < width; x++) //sets all tiles to BlankTiles by default
			for(int y = 0; y < height; y++)
				tiles[x][y] = 0;
		this.buildLevel();
	}
	
	public void buildLevel()
	{
		
	}
	
	public void loadLevel(String path)
	{
		
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int[][] getTiles()
	{
		return tiles;
	}
	
	public ArrayList<Center> getCenters()
	{
		return centers;
	}
	
	public int getDISTANCE()
	{
		return DISTANCE;
	}
	
	public int getBLANK()
	{
		return BLANK;
	}
	
	public int getFLOOR()
	{
		return FLOOR;
	}
	
	public int getSTAIRS()
	{
		return STAIRS;
	}
	
	public int getWALL()
	{
		return WALL;
	}
	
	public void setSpawn(int a)
	{
		spawn = a;
	}
	
	public int getSpawn()
	{
		return spawn;
	}
	
	public void setGoal(ArrayList<Center> centers, int spawn)
	{
		
	}
	
	public void closeGoal(ArrayList<Center> centers)
	{
		
	}
	
	/**
	 * Tells whether a level has been completed
	 * @return true if player has touched end tile
	 * @return false if player has not touched end tile
	 */
	public boolean isDone()
	{
		return done;
	}
	
	/**
	 * Marks the level as completed once player touches goal tile
	 */
	public void finished()
	{
		done = true;
	}
	
	/**
	 * Renders the level centered on the player one tile beyond
	 * what would fit in the window for partial rendering at edges
	 * @param xPos upper left pixel x coordinate of window
	 * @param yPos upper left pixel y coordinate of window
	 * @param render render object for graphics handling
	 */
	public void render(int xPos, int yPos, Render render)
	{
		render.setOffset(xPos, yPos);
		int xLeft = xPos >> 5; //finds start of closest tiles which start outside window
		int yTop = yPos >> 5;
		int xRight = (xPos + render.getWidth() + Sprite.getPPT()) >> 5; //finds start of closest tiles which end outside window
		int yBottom = (yPos + render.getHeight() + Sprite.getPPT()) >> 5;
		
		for(int y = yTop; y < yBottom; y++) 
			for(int x = xLeft; x < xRight; x++)
				getTile(x, y).render(x, y, render); //renders all tiles which could appear in window
	}
	
	/**
	 * Determines tile type for a location in the tile array
	 * @param x x coordinate in tiles 
	 * @param y y coordinate in tiles
	 * @return
	 */
	public Tile getTile(int x, int y)
	{
		if(x < 0 || x >= width || y < 0 || y >= height)
			return Tile.blank;
		if(tiles[x][y] > BLANK && tiles[x][y] <= FLOOR)
			return Tile.floorTiles[tiles[x][y] - 1];
		if(tiles[x][y] == WALL)
			return Tile.testWall; //determine wall type ///
		if(tiles[x][y] == STAIRS)
			return Tile.stairs;
		return Tile.blank;
	}
}
