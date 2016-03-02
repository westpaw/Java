package fcasd.gaffney.f_exam.vantage.level.tile;

import fcasd.gaffney.f_exam.vantage.graphics.Sprite;

public class StairsTile extends Tile
{
	
	public StairsTile(Sprite s)
	{
		super(s);
	}
	
	/**
	 * @return true, touching tile will result in respawn in new level
	 */
	public boolean isLevelEnd()
	{
		return true;
	}

}
