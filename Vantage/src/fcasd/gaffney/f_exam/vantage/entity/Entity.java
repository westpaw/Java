package fcasd.gaffney.f_exam.vantage.entity;

import fcasd.gaffney.f_exam.vantage.graphics.Render;
import fcasd.gaffney.f_exam.vantage.level.Level;

public abstract class Entity 
{
	
	protected int xPix; //pixel coordinates of upper left of sprite of entity (usually transparent)
	protected int yPix;
	protected Level level; // level in which Entity spawns
	
	public void update()
	{
		
	}
	
	public void render(Render render)
	{
		
	}
	
	public void enterLevel(Level l)
	{
		level = l;
	}
	
	public int getXPix()
	{
		return xPix;
	}
	
	public int getYPix()
	{
		return yPix;
	}
}
