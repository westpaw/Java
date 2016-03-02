package fcasd.gaffney.f_exam.vantage.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpriteSheet
{
	
	private String path;
	protected final int WIDTH;
	protected final int HEIGHT;
	protected int[] pixels;
	
	public static SpriteSheet temple = new SpriteSheet("/textures/temple.png", 482, 256);
	public static SpriteSheet hero = new SpriteSheet("/textures/heroSprite48px.png", 288, 192);
	public static SpriteSheet heroHitbox = new SpriteSheet("/textures/hitbox.png", 32, 32); //for debugging on contact
	
	/**
	 * Creates a SpriteSheet from a file
	 * @param p path to find resource
	 * @param h height of sheet
	 * @param w width of sheet
	 */
	public SpriteSheet(String p, int h, int w)
	{
		path = p;
		WIDTH = w;
		HEIGHT = h;
		pixels = new int[WIDTH * HEIGHT];
		load();
	}
	
	/**
	 * Retrieves pixel data from called resource, stores
	 * in pixels
	 */
	public void load()
	{
		try //throws won't work when making static instances above
		{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w); // starting at (0,0); image of width w and height h; pixels put int int[]pixels; 0 offset; scans horizontally (width)
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
