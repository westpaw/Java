package fcasd.gaffney.f_exam.vantage.graphics;

public class Sprite
{
	
	protected final int SIZE; //length in pixels of Sprite
	protected int[] pixels; //pixels of sprite
	private SpriteSheet sheet;
	private static final int PPT = 32; //size of a floor tile, used unless object is scaled

	public static Sprite[] floor = 
		{
			new Sprite(PPT, 1, 0, SpriteSheet.temple),
			new Sprite(PPT, 2, 0, SpriteSheet.temple),
			new Sprite(PPT, 3, 0, SpriteSheet.temple),
			new Sprite(PPT, 4, 0, SpriteSheet.temple),
			new Sprite(PPT, 5, 0, SpriteSheet.temple),
			new Sprite(PPT, 6, 0, SpriteSheet.temple),
			new Sprite(PPT, 7, 0, SpriteSheet.temple)
		};
	
	public static Sprite stairs = new Sprite(PPT, 0, 5, SpriteSheet.temple);
	
	
	public static Sprite[] cornerNE = //wall face differentiation not implemented at this time
		{
			new Sprite(PPT, 0, 1, SpriteSheet.temple),
			new Sprite(PPT, 1, 1, SpriteSheet.temple)
		};
	public static Sprite[] cornerSE = 
		{
			new Sprite(PPT, 0, 2, SpriteSheet.temple),
			new Sprite(PPT, 1, 2, SpriteSheet.temple)
		};
	public static Sprite[] cornerNW =
		{
			new Sprite(PPT, 0, 3, SpriteSheet.temple),
			new Sprite(PPT, 1, 3, SpriteSheet.temple)
		};
	public static Sprite[] cornerSW = 
		{
			new Sprite(PPT, 0, 4, SpriteSheet.temple),
			new Sprite(PPT, 1, 4, SpriteSheet.temple)
		};
	
	public static Sprite[][] corners = 
		{
			cornerNE,
			cornerSE,
			cornerNW,
			cornerSW
		};
	
	
	public static Sprite[] wallN = 
		{
			new Sprite(PPT, 2, 1, SpriteSheet.temple),
			new Sprite(PPT, 3, 1, SpriteSheet.temple),
			new Sprite(PPT, 4, 1, SpriteSheet.temple),
			new Sprite(PPT, 5, 1, SpriteSheet.temple),
			new Sprite(PPT, 6, 1, SpriteSheet.temple),
			new Sprite(PPT, 7, 1, SpriteSheet.temple)
		};
	public static Sprite[] wallE = 
		{
			new Sprite(PPT, 2, 2, SpriteSheet.temple),
			new Sprite(PPT, 3, 2, SpriteSheet.temple),
			new Sprite(PPT, 4, 2, SpriteSheet.temple),
			new Sprite(PPT, 5, 2, SpriteSheet.temple),
			new Sprite(PPT, 6, 2, SpriteSheet.temple),
			new Sprite(PPT, 7, 2, SpriteSheet.temple)
		};
	public static Sprite[] wallS = 
		{
			new Sprite(PPT, 2, 3, SpriteSheet.temple),
			new Sprite(PPT, 3, 3, SpriteSheet.temple),
			new Sprite(PPT, 4, 3, SpriteSheet.temple),
			new Sprite(PPT, 5, 3, SpriteSheet.temple),
			new Sprite(PPT, 6, 3, SpriteSheet.temple),
			new Sprite(PPT, 7, 3, SpriteSheet.temple)
		};
	public static Sprite[] wallW = 
		{
			new Sprite(PPT, 2, 4, SpriteSheet.temple),
			new Sprite(PPT, 3, 4, SpriteSheet.temple),
			new Sprite(PPT, 4, 4, SpriteSheet.temple),
			new Sprite(PPT, 5, 4, SpriteSheet.temple),
			new Sprite(PPT, 6, 4, SpriteSheet.temple),
			new Sprite(PPT, 7, 4, SpriteSheet.temple)
		};
	
	public static Sprite[][] walls = 
		{
		wallN,
		wallE,
		wallS,
		wallW
		};
	
	public static Sprite testWall = new Sprite(PPT, 0, 0, SpriteSheet.temple); //temporary universal use wall
	
	public static Sprite[] heroUp = 
		{
		new Sprite(PPT * 3 / 2, 0, 0, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 0, 1, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 0, 2, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 0, 3, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 0, 4, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 0, 5, SpriteSheet.hero)
		};
	public static Sprite[] heroRight = 
		{
		new Sprite(PPT * 3 / 2, 1, 0, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 1, 1, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 1, 2, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 1, 3, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 1, 4, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 1, 5, SpriteSheet.hero)
		};
	public static Sprite[] heroDown = 
		{
		new Sprite(PPT * 3 / 2, 2, 0, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 2, 1, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 2, 2, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 2, 3, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 2, 4, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 2, 5, SpriteSheet.hero)
		};
	public static Sprite[] heroLeft = 
		{
		new Sprite(PPT * 3 / 2, 3, 0, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 3, 1, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 3, 2, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 3, 3, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 3, 4, SpriteSheet.hero),
		new Sprite(PPT * 3 / 2, 3, 5, SpriteSheet.hero)
		};
	
	public static Sprite[][] hero = 
		{
		heroUp,
		heroRight,
		heroDown,
		heroLeft
		};
	
	public static Sprite hitbox = new Sprite(PPT, 0, 0, SpriteSheet.heroHitbox); //hitbox of player, won't be visible, for debugging
	
	public static Sprite blank = new Sprite(PPT, 0x304340); //blank sprite, for outside of map
	
	/**
	 * Creates a sprite
	 * @param s dimention of Sprite
	 * @param x SpriteSheet x coordinate of Sprite
	 * @param y SpriteSheet y coordinate of Sprite
	 * @param sh SpriteSheet to retrieve Sprite from
	 */
	public Sprite(int s, int x, int y, SpriteSheet sh) 
	{
		SIZE = s;
		pixels = new int[SIZE * SIZE];
		sheet = sh;
		load(x * SIZE, y * SIZE);
	}
	
	/**
	 * Creates a monocolored Sprite
	 * @param s dimention of Sprite
	 * @param c color code for Sprite
	 */
	public Sprite(int s, int c) //makes solid colored sprite
	{
		SIZE = s;
		pixels = new int[SIZE*SIZE];
		this.setColor(c);
	}
	
	/**
	 * sets all pixels of a Sprite to one color
	 * @param c code for color
	 */
	public void setColor(int c)
	{
		for(int x = 0; x < SIZE * SIZE; x++)
			pixels[x] = c;
	}
	
	/**
	 * Retrieves Sprite pixel data from a SpriteSheet
	 * @param xPos
	 * @param yPos
	 */
	public void load(int xPos, int yPos)
	{
		for(int y = 0; y < SIZE; y++)
			for(int x = 0; x < SIZE; x++)
				pixels[x + y * SIZE] = sheet.pixels[(x + xPos) + (y + yPos) * sheet.WIDTH];
	}

	public static int getPPT()
	{
		return PPT;
	}
}
