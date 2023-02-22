/*
 * This class determine the robot location.
 */
package generator;

import util.Heading;
import util.Mode;

public class Location {
	private int x;
	private int y;
	private int maxX;
	private int maxY;
	private Heading head;
	private Mode mode;
	private ArraySheet arraysheet;

	public Location(int x, int y, Heading head, Mode mode, ArraySheet arraysheet) {
		this.x = x;
		this.y = y;
		this.head = head;
		this.mode=mode;
		this.arraysheet=arraysheet;
	}

	public Heading getHeading() {
		return head;
	}

	public void setHeading(Heading head) {
		this.head = head;
	}
	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return x + "," + y + "," + head.getHeading() + "," + mode.getWritingMode();
	}

	public void updateLocation(int xPoint, int yPoint, int step) {
		if (mode.getWritingMode().contentEquals("DOWN"))
			arraysheet.floor[getX()][getY()]=1;
		int newX = getX() + xPoint*step;
		int newY = getY() + yPoint*step;
		if (newX >= maxX) {
			System.out.println("Invalid movement");
			return;
		} else if (newX < 0) {
			System.out.println("Invalid movement");
			return;
			
		}
		if (newY >= maxY) {
			System.out.println("Invalid movement");
			return;
		} else if (newY < 0) {
			System.out.println("Invalid movement");
			return;
		}
		for (int i=0; i<step; i++)
		{
			newX = getX() + xPoint;
			newY = getY() + yPoint;
		this.x = newX;
		this.y = newY;
		if (mode.getWritingMode().contentEquals("DOWN"))
			arraysheet.floor[x][y]=1;}
	}
	
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxX() {
		return maxX;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	public int getMaxY() {
		return maxY;
	}
}
