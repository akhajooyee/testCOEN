/*
 * This class create the surface in which the robot move.
 */
package generator;

public class ArraySheet {
	private int rows;
	private int columns;
	public static int [][] floor;

	public ArraySheet(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.floor=new int [this.rows][this.columns];
	}
	
	public int [][] initializeLocation() {
		for (int i=0; i<this.getRows(); i++)
			for (int j=0; j<this.getColumns(); j++)
				this.floor[i][j]=0;
			return floor;
	}

	public boolean validateLocation(Location location) {
		int xValue = location.getX();
		int yValue = location.getY();
		if (xValue > rows || xValue < 0 ||
				yValue > columns || yValue < 0) {
			return false;
		}
		return true;
	}
	

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	
}
