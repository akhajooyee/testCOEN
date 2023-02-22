/**
 * Test class for testing the functionality of the Robot class.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package generator;

import errortracker.BugReporter;
import junit.framework.TestCase;
import util.Mode;
import util.Heading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import java.util.ArrayList;



public class RobotTest extends TestCase {
	
	private Robot robot;
	private ArraySheet arraysheet;

	@BeforeEach
	public void setUp() {
		robot = new Robot();
		arraysheet = new ArraySheet(5, 5);
	}
	
	/**
     * Testing the PlaceRobot functionality when ArraySheet is null.
     * @param location The location of the robot. in this case, location is (0, 0, Heading.NORTH, Mode.UP, arraysheet).
     * @param table The 2D array that the robot can walk through it. in this case, table is null.
     * @throws IllegalArgumentException If the table is null. In this case, we expected to have a "Table not found" as an exception.
     */
	@Test
	public void testPlaceRobotInNullTable() {
		try {
			robot.placeRobot(new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet), null);
		} catch (BugReporter ex) {
			assertEquals("Table not found", ex.getMessage());
		}
	}
	
	/**
     * Testing the PlaceRobot functionality when Location is null.
     * @param location The location of the robot. in this case, location is null.
     * @param table The 2D array that the robot can walk through it.
     * @throws IllegalArgumentException If the location is null. In this case, we expected to have a "Location not found" as an exception.
     */
	@Test
	public void testPlaceRobotInNullLocation() {
		try {
			robot.placeRobot(null, arraysheet);
		} catch (BugReporter ex) {
			assertEquals("Location not found", ex.getMessage());
		}
	}
	
	/**
     * Test the PlaceRobot functionality when the robot is in an out-of-boundary location.
     * @param location The location of the robot. in this case, location is (4, 6, Heading.NORTH, Mode.UP, arraysheet), arraysheet).
     * @param table The 2D array that the robot can walk through it.
     * @throw IllegalArgumentException If the robot is in an out-of-boundary location. In this case, we expected to have a "Invalid location" as an exception.
     */
	@Test
	public void testPlaceRobotInLocationOutOfBoundary() {
		try {
			robot.placeRobot(new Location(4, 6, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		} catch (BugReporter ex) {
			assertEquals("Invalid location", ex.getMessage());
		}
	}
	
	/**
     * Test the PlaceRobot functionality when the robot location is valid.
     * @param location The location of the robot. in this case, location is (2, 3, Heading.NORTH, Mode.UP, arraysheet), arraysheet).
     * @param table The 2D array that the robot can walk through it.
     * @throw IllegalArgumentException ignore. 
     */
	@Test
	public void testPlaceRobotInValidLocation() {
		try {
			robot.placeRobot(new Location(2, 3, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		} catch (BugReporter ex) {
			// Ignore
		}
	}
	
	/**
     * Test the “move” functionality when the robot heading direction is north.
     * @param step The number of the steps that the robot should move. In this case, we set it 1.
     */
	@Test
	public void testMoveCommandInNorthHeading() {
		robot.placeRobot(new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(0, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}
	/**
     * Test the “move” functionality when the robot heading direction is south.
     * @param step The number of the steps that the robot should move. In this case, we set it 1.
     */
	@Test
	public void testMoveCommandInSouthHeading() {
		robot.placeRobot(new Location(0, 1, Heading.SOUTH, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.SOUTH, robot.getLocation().getHeading());
		assertEquals(0, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY());
	}
	/**
     * Test the “move” functionality when the robot heading direction is east.
     * @param step The number of the steps that the robot should move. In this case, we set it 1.
     */
	@Test
	public void testMoveCommandInEastHeading() {
		robot.placeRobot(new Location(0, 0, Heading.EAST, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.EAST, robot.getLocation().getHeading());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY());
	}
	/**
     * Test the “move” functionality when the robot heading direction is west.
     * @param step The number of the steps that the robot should move. In this case, we set it 1.
     */
	@Test
	public void testMoveCommandInWestHeading() {
		robot.placeRobot(new Location(1, 0, Heading.WEST, Mode.UP, arraysheet), arraysheet);
		robot.move(1);
		assertEquals(Heading.WEST, robot.getLocation().getHeading());
		assertEquals(0, robot.getLocation().getX());
		assertEquals(0, robot.getLocation().getY());
	}
	/**
     * Test the “move” functionality when the robot heading direction is north but after this movement, the robot is in an out-of-boundary location. 
     * @param step The number of the steps that the robot should move. In this case, we set it 6.
     */
	@Test
	public void testRobotMoveToOutsideofBoundary() {
		robot.placeRobot(new Location(5, 5, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		robot.move(6);
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(5, robot.getLocation().getX());
		assertEquals(5, robot.getLocation().getY());
		
		
	}
	/**
     * Test the “left” functionality. Robot changes direction to its left side.
     */
	
	@Test
	public void testRobotToLeft() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.UP, arraysheet));
		robot.left();
		assertEquals(Heading.SOUTH, robot.getLocation().getHeading());
		assertEquals(2, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}
	/**
     * Test the “right” functionality. Robot changes direction to its right side.
     */
	@Test
	public void testRobotToRight() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.UP, arraysheet));
		robot.right();
		assertEquals(Heading.NORTH, robot.getLocation().getHeading());
		assertEquals(2, robot.getLocation().getX());
		assertEquals(1, robot.getLocation().getY());
	}
	/**
     * Test the “up” functionality. Robot alters the pen situation to up and stop writing accordingly.
     */
	@Test
	public void testRobotToUp() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.DOWN, arraysheet));
		robot.up();
		assertEquals(Mode.UP, robot.getLocation().getMode());	
	}
	/**
     * Test the “down” functionality. Robot alters the pen situation to down and start writing accordingly.
     */
	@Test
	public void testRobotToDowm() {
		robot.setLocation(new Location(2, 1, Heading.WEST,  Mode.UP, arraysheet));
		robot.down();
		assertEquals(Mode.DOWN, robot.getLocation().getMode());	
	}
	/**
     * Test the “report” functionality. this method prints the current situation of the robot.
     * @return userdata The location of the robot. in this case, location is "2,1,WEST,UP".
     */
	@Test
	public void testRobotReport() {
		robot.setLocation(new Location(2, 1, Heading.WEST, Mode.UP, arraysheet));
		ArrayList<String> expected = new ArrayList<>();
		expected.add("2,1,WEST,UP");
		assertEquals(expected, robot.report());
	}
	/**
     * Test the “print” functionality.This method prints the whole floor situation.
     * @return userdata The whole floor situation. in this case, floor situation is " ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , *, *,  ,  ,  ".
     */
	 @Test
	   public void testPrint() {
		
		robot.placeRobot(new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet), arraysheet);
		robot.down();
		robot.right();
		robot.move(1);
		robot.report();
		ArrayList<String> expected = new ArrayList<>();
	    expected.add(" ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , *, *,  ,  ,  ");
	    assertEquals(expected.toString(), robot.print().toString());
	   }
	
}
