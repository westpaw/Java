package fcasd.gaffney.f_exam.vantage.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener
{

	private boolean[] keys = new boolean[140]; // array of "pressed" or "not pressed" for each key
	private boolean up; //booleans for any action used by player, can have more than one key
	private boolean down;
	private boolean left;
	private boolean right;
	private boolean run; // toggles when run key is released

	/**
	 * updates which commands are being input
	 */
	public void update()
	{
		up = keys[KeyEvent.VK_UP] 
				|| keys[KeyEvent.VK_W]; // checks if up or w key is pressed
		down = keys[KeyEvent.VK_DOWN] 
				|| keys[KeyEvent.VK_S]; //checks down or s
		left = keys[KeyEvent.VK_LEFT] 
				|| keys[KeyEvent.VK_A]; // checks left or a
		right = keys[KeyEvent.VK_RIGHT] 
				|| keys[KeyEvent.VK_D]; // checks right or d
		run = keys[KeyEvent.VK_SHIFT]; //checks shift
	}
	
	public boolean up()
	{
		return up;
	}
	
	public boolean down()
	{
		return down;
	}
	
	public boolean left()
	{
		return left;
	}
	
	public boolean right()
	{
		return right;
	}
	
	public boolean run()
	{
		return run;
	}
	
	public void keyPressed(KeyEvent a)
	{
		if(a.getKeyCode() != KeyEvent.VK_SHIFT)
			keys[a.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent a) 
	{
		if(a.getKeyCode() == KeyEvent.VK_SHIFT)
			keys[a.getKeyCode()] = !keys[a.getKeyCode()];
		else
			keys[a.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent a) 
	{

	}

	/**
	 * Stops the player from running, for if it collides
	 */
	public void resetRun()
	{
		keys[KeyEvent.VK_SHIFT] = false;
	}
	
}
