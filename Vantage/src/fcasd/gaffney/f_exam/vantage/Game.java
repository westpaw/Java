/* Conor Gaffney
 * makes window and runs game
 */

package fcasd.gaffney.f_exam.vantage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import fcasd.gaffney.f_exam.vantage.entity.Hero;
import fcasd.gaffney.f_exam.vantage.graphics.Render;
import fcasd.gaffney.f_exam.vantage.graphics.Sprite;
import fcasd.gaffney.f_exam.vantage.input.KeyInput;
import fcasd.gaffney.f_exam.vantage.level.Level;
import fcasd.gaffney.f_exam.vantage.level.LevelGen;

public class Game extends Canvas implements Runnable
{

	private static final long serialVersionUID = 1L; // default code, Canvas
											// makes Game
											// serializable?

	private static int width = 640; // dimentions of window in pixels: scaled
								// down to reduce size of graphics, 16:9
								// ratio

	private static int height = width * 9 / 16; // 360

	private static int scale = 2; // set to 3 once fullscreen running

	private int time;

	private int floor;

	private static String title = "Game";

	private static Random r = new Random();

	private JFrame jframe;

	private Thread gameThread;

	private KeyInput key;

	private Render render;

	private Level level;

	private Hero p1;

	private boolean running;

	private BufferedImage image = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB); // image to fill window

	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); // puts int values of color for each pixel into an array

	/**
	 * initializes window, level, and player
	 */
	public Game()
	{
		running = false;
		Dimension dimension = new Dimension(width * scale , height * scale);
		setPreferredSize(dimension); // sets window to dimentions specified in
								// data
		render = new Render(width , height);
		jframe = new JFrame();
		key = new KeyInput();
		time = 60; // time limit
		floor = 0; // floor count
		this.makeNewLevel();
		addKeyListener(key); // receives key events
	}

	/**
	 * Starts the game thread
	 */
	public synchronized void start()
	{
		gameThread = new Thread(this , "Display");
		gameThread.start();
		running = true;
	}

	/**
	 * Stops the game thread
	 */
	public synchronized void stop()
	{
		try
		{
			gameThread.join();
		} catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Perpetuates game. Tracks updates made and frames displayed per second
	 */
	public void run()
	{
		long before = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; // converts from nanoseconds to
										// 1/60 seconds (= 60 fps)
		double updateTimer = 0;
		int frames = 0;
		int updates = 0;
		requestFocus(); // puts window in focus
		while(running)
		{
			long now = System.nanoTime();
			updateTimer += (now - before) / ns;
			before = now;
			while(updateTimer >= 1) // limits rate that game updates, runs at
								// constant 60 ups independent of fps
			{
				update();
				updates++;
				updateTimer--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				jframe.setTitle(title + "    -    " + updates + " ups, " + frames + " fps"); // displays title, ups and fps in header
				time -= 1;
				updates = 0;
				frames = 0;
			}
			if(time <= 0)
				level.closeGoal(level.getCenters());
			if(time <= -5)
				running = false;
		}
		this.stop(); // ends game once running == false
	}

	/**
	 * Takes input. Applies changes to entities in the gamew
	 */
	public void update()
	{
		key.update();
		p1.update();
		if(level.isDone())
		{
			int gain = 2 * (level.getCenters().size() - floor);
			if(gain > 0)
				time += gain;
			level = null;
			this.makeNewLevel();
		}
	}

	private void makeNewLevel()
	{
		level = new LevelGen(128 , 128);
		floor++;
		int spawn = r.nextInt(level.getCenters().size());
		level.setGoal(level.getCenters() , spawn);
		p1 = new Hero(level.getCenters().get(spawn).getX() * Sprite.getPPT() , level.getCenters().get(spawn).getY() * Sprite.getPPT() ,
				key);
		p1.enterLevel(level);
	}

	/**
	 * Renders a new frame with the player always in center of the window
	 */
	public void render()
	{
		BufferStrategy bs = getBufferStrategy(); // returns null if bs hasn't been created yet
		if(bs == null)
		{
			createBufferStrategy(3); // creates a 3-image cycle
			return;
		}

		render.clear();
		int xPos = p1.getXPix() - render.getWidth() / 2; // pixel coordinate of upper left corner of window
		int yPos = p1.getYPix() - render.getHeight() / 2;
		level.render(xPos , yPos , render);
		p1.render(render);

		for(int x = 0; x < pixels.length; x++)
			// puts rendered pixels into array to be drawn
			pixels[x] = render.getPixels()[x];

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image , 0 , 0 , getWidth() , getHeight() , null); // draws image rendered in Render
		if(time > 10)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		g.setFont(new Font("Verdana" , 0 , 50));
		if(time > 0)
			g.drawString(Integer.toString(time) , 1150 , 80);
		else
		{
			g.drawString("Game Over" , 500 , 500);
			g.drawString(Integer.toString(floor - 1) + " Floors Cleared" , 400 , 600);
		}
		g.dispose(); // removes graphics from system resources
		bs.show();

	}

	public static void main(String[] args)
	{
		Game game = new Game();

		game.jframe.setResizable(false); // creates a window: can't be resized, dimensions match data, is centered, and is visible
		game.jframe.setTitle(Game.title);
		game.jframe.add(game); // puts game in window
		game.jframe.pack(); // sizes window
		game.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.jframe.setLocationRelativeTo(null); // centers window
		game.jframe.setVisible(true);

		game.start();
	}

}