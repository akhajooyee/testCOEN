/**
 * Test class for testing the functionality of the Heading class.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package util;



import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class HeadingTest extends TestCase  {

	private Heading heading;
	@BeforeEach
	public void setUp() {
		heading = Heading.NORTH;
	}
	
	/**
     * Testing the ‘from” functionality with the constant heading. 
     * @param value The situation of the robot's head. It can be EAST, WEST, NORTH, SOUTH.
     * @return head The situation of the robot's head. It can be EAST, WEST, NORTH, SOUTH.
     */


	@Test
	public void testHeadingConstant() {
		assertEquals(Heading.EAST, Heading.from("EAST"));
		assertEquals(Heading.WEST, Heading.from("WEST"));
		assertEquals(Heading.NORTH, Heading.from("NORTH"));
		assertEquals(Heading.WEST, Heading.from("WEST"));
	}
	
	/**
     * Testing the ‘from” functionality with the invalid constant heading. 
     * @param value The situation of the robot's head. It can be every thing except EAST, WEST, NORTH, SOUTH.
     * @return head The situation of the robot's head. It can be every thing except EAST, WEST, NORTH, SOUTH.
     */
	@Test
	public void testInvalidHeadingConstant() {
		assertNull(Heading.from("EASTWEST"));
	}
	/**
     * Testing the “changeHeading” functionality. Change from North to west. 
     * @param rotatepoint Specifies the value next direction of the robot's head. it can be -1, 1. in this case, rotatepoint is -1.
     * @return value Specifies the next direction of the robot's head. It can be EAST, WEST, NORTH, SOUTH. in this case, value() is WEST.
     */
	@Test
	public void testChangeHeadingFromNorthToWest() {
		Heading newHeading = heading.changeHeading(-1);
		assertEquals(Heading.WEST, newHeading);
		
	}
	/**
     * Testing the “changeHeading” functionality. Change from North to EAST. 
     * @param rotatepoint Specifies the value next direction of the robot's head. it can be -1, 1. in this case, rotatepoint is 1.
     * @return value Specifies the next direction of the robot's head. It can be EAST, WEST, NORTH, SOUTH. in this case, value() is EAST.
     */
	@Test
	public void testChangeHeadingFromNorthToEast() {
		Heading newHeading = heading.changeHeading(1);
		assertEquals(Heading.EAST, newHeading);
	}
	/**
     * Testing the “changeHeading” functionality. Change from WEST to SOUTH. 
     * @param rotatepoint Specifies the value next direction of the robot's head. it can be -1, 1. in this case, rotatepoint is -1.
     * @return value Specifies the next direction of the robot's head. It can be EAST, WEST, NORTH, SOUTH. in this case, value() is SOUTH.
     */
	@Test
	public void testChangeHeadingFromWestToSouth() {
		Heading newHeading = heading.changeHeading(-1);
		newHeading = newHeading.changeHeading(-1);
		assertEquals(Heading.SOUTH, newHeading);
		
	}
	/**
     * Testing the “changeHeading” functionality. Change from EAST to SOUTH. 
     * @param rotatepoint Specifies the value next direction of the robot's head. it can be -1, 1. in this case, rotatepoint is 1.
     * @return value Specifies the next direction of the robot's head. It can be EAST, WEST, NORTH, SOUTH. in this case, value() is SOUTH.
     */
	@Test
	public void testChangeHeadingFromEastToSouth() {
		Heading newHeading = heading.changeHeading(1);
		newHeading = newHeading.changeHeading(1);
		assertEquals(Heading.SOUTH, newHeading);
	}
	/**
     * Testing the “getHeading” functionality with the valid command. 
     * @return value Specifies the direction of the robot's head. It can be EAST, WEST, NORTH, SOUTH.
     */
	
	@Test
	public void testGetHeading_validHeading_returnsCorrectValue() {
		assertEquals("WEST", Heading.WEST.getHeading());
		assertEquals("EAST", Heading.EAST.getHeading());
		assertEquals("NORTH", Heading.NORTH.getHeading());
		assertEquals("SOUTH", Heading.SOUTH.getHeading());	
	}
	
	
}