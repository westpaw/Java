package fcasd.gaffney.f_exam.vantage.entity;

import fcasd.gaffney.f_exam.vantage.graphics.Render;
import fcasd.gaffney.f_exam.vantage.graphics.Sprite;
import fcasd.gaffney.f_exam.vantage.input.KeyInput;

public class Hero extends Mob 
{
	private KeyInput input;
	private int cycle = 0; //controls animation cycle
	private static Sprite hb = Sprite.hitbox; //will be invisible in final
	
	/**
	 * Creates a Hero object to represent the player's character.  
	 * @param x the x-coordinate of the upper left pixel of the Hero
	 * @param y the y-coordinate of the upper left pixel of the Hero
	 * @param i the KeyInput object for the player to control the Hero
	 */
	public Hero(int x, int y, KeyInput i)
	{
		xPix = x;
		yPix = y;
		input = i;
		top = 16; 
		bottom = 45;
		left = 9;
		right = 38;
	}
	
	/**
	 * Makes changes to location of Hero.  Uses KeyEvents to 
	 * determine necessary offset.  Animation control is incremented
	 * for walking animation.  Determines Hero as either moving or
	 * stopped.  Movement is doubled if player is running
	 */
	public void update()
	{
		int dx = 0; // pixels
		int dy = 0;
		cycle = (cycle + 1) % 60;
		
		if(input.up())
			dy -= 2;
		if(input.down())
			dy += 2;
		if(input.right())
			dx += 2;
		if(input.left())
			dx -= 2;
		
		if(input.run())
		{
			dx *= 2;
			dy *= 2;
		}
		
		if(dx != 0 || dy != 0) //if player needs to move
		{
			if(this.move(dx, dy))
			{
				this.moves();
				if(this.reachGoal())
					this.level.finished();
			}
			else
			{
				this.stops();
				input.resetRun(); // ends player run if collision
			}
		}
		else
			this.stops();
	}
	
	public boolean reachGoal()
	{
		if(level.getTile((xPix + left) / Sprite.getPPT(), (yPix + top) / Sprite.getPPT()).isLevelEnd()
				|| level.getTile((xPix + left) / Sprite.getPPT(), (yPix + bottom) / Sprite.getPPT()).isLevelEnd()
				|| level.getTile((xPix + right) / Sprite.getPPT(), (yPix + top) / Sprite.getPPT()).isLevelEnd()
				|| level.getTile((xPix + right) / Sprite.getPPT(), (yPix + bottom) / Sprite.getPPT()).isLevelEnd())
			return true;
		return false;
	}
	
	/**
	 * renders the Hero sprite in the window at the proper location
	 * after Hero is updated.  
	 */
	public void render(Render render)
	{
		int anim = 0; // index for walk cycle
		if(this.isMoving())
		{
			if(cycle / 15 == 1)
				anim = 1;
			else if(cycle / 15 == 3)
				anim = 2;
		}
		render.renderPlayer(xPix, yPix, Sprite.hero[dir][anim]); // renders player
		//render.renderPlayer(xPix, yPix, Sprite.hero[dir][anim], hb); //puts hitbox over player
	}

}
