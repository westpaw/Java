package fcasd.gaffney.f_exam.vantage.level.tile;

import fcasd.gaffney.f_exam.vantage.graphics.Sprite;

public class WallTile extends Tile
{
	
	public WallTile(Sprite s)
	{
		super(s);
	}
	
	/**
	 * @return true, WallTile cannot be walked on
	 */
	public boolean isSolid()
	{
		return true;
	}

}
