package fcasd.gaffney.f_exam.vantage.level.tile;

import fcasd.gaffney.f_exam.vantage.graphics.Render;
import fcasd.gaffney.f_exam.vantage.graphics.Sprite;

public abstract class Tile 
{
	
	public int x, y; //coordinates in tile array
	public Sprite sprite; 
	
	public static Tile[] floorTiles =
		{
			new FloorTile(Sprite.floor[0]),
			new FloorTile(Sprite.floor[1]),
			new FloorTile(Sprite.floor[2]),
			new FloorTile(Sprite.floor[3]),
			new FloorTile(Sprite.floor[4]),
			new FloorTile(Sprite.floor[5]),
			new FloorTile(Sprite.floor[6])
		};
	
	public static Tile[] wallN = 
		{
			new WallTile(Sprite.walls[0][0]),
			new WallTile(Sprite.walls[0][1]),
			new WallTile(Sprite.walls[0][2]),
			new WallTile(Sprite.walls[0][3]),
			new WallTile(Sprite.walls[0][4]),
			new WallTile(Sprite.walls[0][5])
		};
	public static Tile[] wallE = 
		{
			new WallTile(Sprite.walls[1][0]),
			new WallTile(Sprite.walls[1][1]),
			new WallTile(Sprite.walls[1][2]),
			new WallTile(Sprite.walls[1][3]),
			new WallTile(Sprite.walls[1][4]),
			new WallTile(Sprite.walls[1][5])
		};
	public static Tile[] wallS = 
		{
			new WallTile(Sprite.walls[2][0]),
			new WallTile(Sprite.walls[2][1]),
			new WallTile(Sprite.walls[2][2]),
			new WallTile(Sprite.walls[2][3]),
			new WallTile(Sprite.walls[2][4]),
			new WallTile(Sprite.walls[2][5])
		};
	public static Tile[] wallW = 
		{
			new WallTile(Sprite.walls[3][0]),
			new WallTile(Sprite.walls[3][1]),
			new WallTile(Sprite.walls[3][2]),
			new WallTile(Sprite.walls[3][3]),
			new WallTile(Sprite.walls[3][4]),
			new WallTile(Sprite.walls[3][5])
		};
	
	public static Tile[][] walls = 
		{
			wallN,
			wallE,
			wallS,
			wallW
		};
	
	public static Tile stairs = new StairsTile(Sprite.stairs);
	
	public static Tile testWall = new WallTile(Sprite.testWall);
	
	public static Tile blank = new BlankTile(Sprite.blank);

	public Tile(Sprite s){
		sprite = s;
	}
	
	/**
	 * Sends tile data to the Render
	 * @param x
	 * @param y
	 * @param render
	 */
	public void render(int x, int y, Render render)
	{
		render.renderTile(x * Sprite.getPPT(), y * Sprite.getPPT(), this);
	}
	
	/**
	 * Tells whether a tile can be walked on or not
	 * @return false, tile can be walked on
	 */
	public boolean isSolid()
	{
		return false;
	}
	
	/**
	 * Tells whether a tile will result in spawning a new level
	 * @return false, tile will not respawn player in new level;
	 */
	public boolean isLevelEnd()
	{
		return false;
	}

}
