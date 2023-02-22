/*
 * This class determine the various type of task done by robot.
 */
package generator;

import java.util.ArrayList;

import errortracker.BugReporter;
import util.Heading;
import util.Mode;

public class Robot {
    Location location;
    ArraySheet arraysheet;
    
    public void move(int step) {
        if (location.getHeading().equals(Heading.NORTH)) {
        	location.updateLocation(0, 1, step);
            
        } else if (location.getHeading().equals(Heading.SOUTH)) {
        	location.updateLocation(0, -1, step);
            
        } else if (location.getHeading().equals(Heading.EAST)) {
        	location.updateLocation(1, 0, step);
            
        } else if (location.getHeading().equals(Heading.WEST)) {
        	location.updateLocation(-1, 0, step);
       
        }
    }

    public void left() {
        Heading newHeading = getLocation().getHeading().changeHeading(-1);
        getLocation().setHeading(newHeading);
    }

    public void right() {
        Heading newHeading = getLocation().getHeading().changeHeading(1);
        getLocation().setHeading(newHeading);
    }
    public void up() {
        Mode mode = getLocation().getMode().changeMode(0);
        getLocation().setMode(mode);
    }
    public void down() {
        Mode mode = getLocation().getMode().changeMode(1);
        getLocation().setMode(mode);
    }

    public ArrayList<String> report() {
    	ArrayList<String> userData = new ArrayList<>();
    	System.out.println(location.toString());
    	userData.add(location.toString());
    	return userData;
    }
    public ArrayList<String> print() {
    	 ArrayList<String> userData = new ArrayList<>();
    	int i=0;
    	int k=0;
    	int j=arraysheet.floor.length-1;
    	while (i<arraysheet.floor.length)
    		{
    		System.out.print("|");
    		while (j>=0 && k<arraysheet.floor.length)
    			{ 
    			if (arraysheet.floor[k][j]==1)
    			{
    			System.out.print("*");
    			userData.add("*");
    			}
    			else 
    				{System.out.print(" ");
    				userData.add(" ");
    				}
    			 System.out.print("|");
    			 k++;
    			}
    		i++;
    		k=0;
    		System.out.println();
    		j--;
    		
    		}
    	return userData;
     
    }
    public void placeRobot(Location location, ArraySheet arraysheet) {
        if (arraysheet == null) {
            throw new BugReporter(("ArraySheet not found"));
        }

        if (location == null) {
            throw new BugReporter("Location not found");
        }

        if (!arraysheet.validateLocation(location)) {
            throw new BugReporter("Invalid location");
        }
        location.setMaxX(arraysheet.getRows());
        location.setMaxY(arraysheet.getColumns());
        setLocation(location);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public ArraySheet getArraySheer() {
        return arraysheet;
    }

    public void setArraySheet(ArraySheet arraysheet) {
        this.arraysheet = arraysheet;
    }
}