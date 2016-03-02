package fcasd.gaffney.f_exam.vantage.entity;

import fcasd.gaffney.f_exam.vantage.graphics.Sprite;

public abstract class Mob extends Entity
{
	
	protected Sprite sprite;
	
	protected int dir = 2; //0 = up, 1 = left, 2 = down, 3 = right
	protected boolean moving = false;
	protected int top; //  pixel offsets for hitbox relative to mob sprite
	protected int bottom;
	protected int left;
	protected int right;
	
	/**
	 * Sets direction of mob.  Moves mob if shift would
	 * not result in a collision
	 * @param dx input x movement in pixels
	 * @param dy input y movement in pixels
	 * @return true if it does move
	 * @return false if it does not move
	 */
	public boolean move(int dx, int dy)
	{
		boolean moved = false;
		if(dy > 0)
			dir = 2;
		else if(dy < 0)
			dir = 0;
		else if(dx > 0)
			dir = 1;
		else if(dx < 0)
			dir = 3;
		
		if(dx != 0 && !collision(dx, 0))
		{
			xPix += dx;
			moved = true;
		}
		if(dy != 0 && !collision(0, dy))
		{
			yPix += dy;
			moved = true;
		}		
		return moved;
	}
	
	public boolean isMoving()
	{
		return moving;
	}
	
	public void moves()
	{
		moving = true;
	}
	
	public void stops()
	{
		moving = false;
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
	
	/**
	 * Determines if movement player is about to make will cause a collision
	 * with the walls
	 * @param dx input x movement in pixels
	 * @param dy input y movement in pixels
	 * @return true if tile of intended location is solid
	 * @return false if movement can be made
	 */
	public boolean collision(int dx, int dy) 
	{
		if(level.getTile((xPix + left + dx) / Sprite.getPPT(), (yPix + top + dy) / Sprite.getPPT()).isSolid()
				|| level.getTile((xPix + left + dx) / Sprite.getPPT(), (yPix + bottom + dy) / Sprite.getPPT()).isSolid()
				|| level.getTile((xPix + right + dx) / Sprite.getPPT(), (yPix + top + dy) / Sprite.getPPT()).isSolid()
				|| level.getTile((xPix + right + dx) / Sprite.getPPT(), (yPix + bottom + dy) / Sprite.getPPT()).isSolid())
			return true;
		return false;
	}
	
}
