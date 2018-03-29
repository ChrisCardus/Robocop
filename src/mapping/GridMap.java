package mapping;

import lejos.geom.Line;
import lejos.geom.Point;
import lejos.robotics.navigation.Pose;
import rp.robotics.mapping.IGridMap;
import rp.robotics.mapping.RPLineMap;

public class GridMap implements IGridMap {

	private RPLineMap lm;
	private int sizeX;
	private int sizeY;
	private float XStart;
	private float YStart;
	private float cellSize;
	
	public GridMap(RPLineMap lm, float offX, float offY, int sizeX, int sizeY, float cellSize) {
		this.lm = lm;
		this.XStart = offX;
		this.YStart = offY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.cellSize = cellSize;
	}

	@Override
	public int getXSize() {
		return sizeX;
	}

	@Override
	public int getYSize() {
		return sizeY;
	}

	@Override
	public boolean isValidGridPosition(int _x, int _y) {
		return _x < sizeX && _y < sizeY && _x >= 0 && _y >= 0;
	}

	@Override
	public boolean isObstructed(int _x, int _y) {
		Point p = getCoordinatesOfGridPosition(_x, _y);
		return !lm.inside(p);
	}

	@Override
	public Point getCoordinatesOfGridPosition(int _x, int _y) {
		return new Point(getXCoord(_x), getYCoord(_y));
	}
	
	private float getXCoord(int _x){
		return (((float)_x*cellSize) + XStart);
	}
	
	private float getYCoord(int _y){
		return (((float)_y*cellSize) + YStart);
	}

	@Override
	public boolean isValidTransition(int _x1, int _y1, int _x2, int _y2) {
		//check points are within grid
		if(!(isValidGridPosition(_x1, _y1) && isValidGridPosition(_x2, _y2))) return false;
		
		//check if point is in obstacle
		if(isObstructed(_x1, _y1) || isObstructed(_x2, _y2)) return false;
		
		Line l = new Line(getXCoord(_x1), getYCoord(_y1), getXCoord(_x2), getYCoord(_y2));
		Line[] lines = lm.getLines();
		for(int i = 0; i < lines.length; i++){
			if(lm.intersectsAt(l, lines[i]) != null){
				return false;
			}
		}
		return true;
	}

	@Override
	public float rangeToObstacleFromGridPosition(int _x, int _y, float _heading) {
		return lm.range(new Pose(getXCoord(_x), getYCoord(_y), _heading));
	}
}
