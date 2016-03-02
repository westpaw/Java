//renders image for each frame

package fcasd.gaffney.f_exam.vantage.graphics;

import fcasd.gaffney.f_exam.vantage.level.tile.Tile;

public class Render
{

	private int[] pixels; 
	private int width; 
	private int height;
	private int xOffset; //upper left corner of render, used to change from level position to render position
	private int yOffset;
	
	public Render(int w, int h)
	{
		width = w;
		height = h;
		pixels = new int[width * height]; 
	}
	
	/**
	 * resets values of all pixels
	 */
	public void clear()
	{
		for(int x  = 0; x < pixels.length; x++)
			pixels[x] = 0;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int[] getPixels()
	{
		return pixels;
	}
	
	/**
	 * Renders one tile
	 * @param xPos pixel position of tile in level
	 * @param yPos pixel positioin of tile in level
	 * @param tile type of tile to be rendered
	 */
	public void renderTile(int xPos, int yPos, Tile tile)
	{
		xPos -= xOffset; //sets Pos relative to render pixels
		yPos -= yOffset;
		
		for(int y = 0; y < tile.sprite.SIZE; y++)
		{
			int yRender = y + yPos;
			for(int x = 0; x < tile.sprite.SIZE; x++)
			{
				int xRender = x + xPos;
				if(xRender < -tile.sprite.SIZE || xRender >= width || yRender < -tile.sprite.SIZE || yRender >= height) //won't render pixels of tiles not in render at all
					break;
				if(xRender < 0)
					xRender = 0;
				if(yRender < 0)
					yRender = 0;
				pixels[xRender + yRender * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	/**
	 * Render player onto level
	 * @param xPos pixel position of player in level
	 * @param yPos pixel position of player in level
	 * @param sprite Sprite of player
	 */
	public void renderPlayer(int xPos, int yPos, Sprite sprite)
	{
		xPos -= xOffset; //changes Pos relative to the render pixels
		yPos -= yOffset;
		
		for(int y = 0; y < sprite.SIZE; y++)
		{
			int yRender = y + yPos;
			for(int x = 0; x < sprite.SIZE; x++)
			{
				int xRender = x + xPos;
				int color = sprite.pixels[x + y * sprite.SIZE];
				if(color != 0xff24ff00)
					pixels[xRender + yRender * width] = color;
			}
		}
	}
	
	/**
	 * Renders player onto level with visible hitbox ** debugging purposes only
	 * @param xPos pixel position of player in level
	 * @param yPos pixel position of player in level
	 * @param sprite Sprite of player
	 * @param hb sprite of hitbox
	 */
	public void renderPlayer(int xPos, int yPos, Sprite sprite, Sprite hb) ////////////////////////////////////
	{
		xPos -= xOffset;
		yPos -= yOffset;
		
		for(int y = 0; y < sprite.SIZE; y++)
		{
			int yRender = y + yPos;
			for(int x = 0; x < sprite.SIZE; x++)
			{
				int xRender = x + xPos;
				int color = sprite.pixels[x + y * sprite.SIZE];
				if(color != 0xff24ff00)
					pixels[xRender + yRender * width] = color;
			}
		}
		for(int y = 0; y < hb.SIZE; y++)
		{   
			int yAbs = y + 15 + yPos;
			for(int x = 0; x < hb.SIZE; x++)
			{
				int xAbs = x + 8  + xPos;
				if(xAbs < -sprite.SIZE || xAbs >= width || yAbs < -sprite.SIZE || yAbs >= height)
					break;
				if(xAbs < 0)
					xAbs = 0;
				if(yAbs < 0)
					yAbs = 0;
				int color = hb.pixels[x + y * hb.SIZE];
				if(color != 0xff24ff00)
					pixels[xAbs + yAbs * width] = color;			
				}
		}
	}
	
	/**
	 * Defines coordinates for upper left corner of window
	 * @param xPos pixel x coordinate, changes based on player movement
	 * @param yPos pixel y coordinate, changes based on player movement
	 */
	public void setOffset(int xPos, int yPos)
	{
		xOffset = xPos;
		yOffset = yPos;
	}

}
