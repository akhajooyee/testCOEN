/**
 * Test class for testing the functionality of the Location method.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package generator;

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import util.Heading;
import util.Mode;

public class LocationTest extends TestCase {
	private Location location;

	@BeforeEach
	public void setUp() {
		ArraySheet arraysheet=new ArraySheet(3, 3);
		location = new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet);
	}
	
	/**
     * Test case for verifying the Location functionality.
     * @param X The row in which the robot is located. In this test case, we set it 1.
     * @param Y The row in which the robot is located. In this test case, we set it 2.
     * @param head The situation of the robot's head. head is equal to EAST.
     * @param mode The situation of the robot's pen. mode is equal to UP.
     * @param ArraySheet The Floor that robot walk on it. ArraySheet is equal to (3, 3).
     * 
     */ 
	
	@Test
	public void testDerivedLocation() {
		location.setX(1);
		location.setY(2);
		location.setHeading(Heading.EAST);
		assertEquals(Heading.EAST, location.getHeading());
		assertEquals(1, location.getX());
		assertEquals(2, location.getY());
	}
	

	/**
     * Testing the UpdateLocation functionality when X is out of range.
     * @param Xpoint Specifies the direction of the row for the movement of the robot. In this test case, we set it 1 and in the second step we set it -1.
     * @param Ypoint Specifies the direction of the column for the movement of the robot. In this test case, we set it 0.
     * @param Step The number of the steps that the robot should move. In this test case, we set it 1.
     * 
     */ 	
	@Test
	public void testUpdateLocationXOutOfRange() {
		
		location.setMaxX(5);
		location.setMaxY(5);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		
		
		location.setX(5);
		location.setY(5);
		location.updateLocation(1, 0, 1);
		assertEquals(5, location.getX());
		assertEquals(5, location.getY());
		assertEquals("Invalid movement\r\n", outContent.toString());

		ByteArrayOutputStream secondoutContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(secondoutContent));
		location.setMaxX(5);
		location.setMaxY(5);
		location.setX(0);
		location.setY(0);
		location.updateLocation(-1, 0, 1);
		assertEquals(0, location.getX());
		assertEquals(0, location.getY());
		assertEquals("Invalid movement\r\n", secondoutContent.toString());
	}
	
	/**
     * Testing the UpdateLocation functionality when Y is out of range.
     * @param Xpoint Specifies the direction of the row for the movement of the robot. In this test case, we set it 0.
     * @param Ypoint Specifies the direction of the column for the movement of the robot. In this test case, we set it 1 and then we set it -1.
     * @param Step The number of the steps that the robot should move. In this test case, we set it 1.
     * 
     */
	@Test
	public void testUpdateLocationYOutOfRange() {
		location.setMaxX(5);
		location.setMaxY(5);
		location.setX(5);
		location.setY(5);
		location.updateLocation(0, 1, 1);
		assertEquals(5, location.getX());
		assertEquals(5, location.getY());

		location.setMaxX(5);
		location.setMaxY(5);
		location.setX(0);
		location.setY(0);
		location.updateLocation(0, -1, 1);
		assertEquals(0, location.getX());
		assertEquals(0, location.getY());
	}
	
	/**
     * Testing the UpdateLocation functionality when X and Y is in the range.
     * @param Xpoint Specifies the direction of the row for the movement of the robot. In this test case, we set it 1.
     * @param Ypoint Specifies the direction of the column for the movement of the robot. In this test case, we set it 0.
     * @param Step The number of the steps that the robot should move. In this test case, we set it 1.
     * 
     */
	@Test
	public void testUpdateLocationXYWithinRange() {
		location.setX(3);
		location.setY(2);
		location.setMaxX(5);
		location.setMaxY(5);
		location.updateLocation(1, 0, 1);
		assertEquals(4, location.getX());
		assertEquals(2, location.getY());
	}
	
	/**
     * Testing the “toString” functionality. Before this method, you should build ArraySheet(5,5), Location(0, 0, Heading.NORTH, Mode.UP, arraysheet).
     * @return "x,y,head,mode". In this test case, method returns 0, 0, NORTH, UP
     */
	
	@Test
	public void testPrintToString() {
		String result = location.toString();
		assertEquals("0,0,NORTH,UP", result);
	}
	
	/**
     * Testing the “getHeading” functionality.
     * @return heading The situation of the robot's head. In this case, It returns NORTH. 
     */
	@Test
	public void testGetHeading() {
		assertEquals(Heading.NORTH, location.getHeading());
	
	}
	
	/**
     * Testing the “setHeading” functionality.
     * @param heading The situation of the robot's head. In this case, we set it EAST. 
     */
	
	@Test
	public void testSetHeading() {
	    location.setHeading(Heading.EAST);
	    assertEquals(Heading.EAST, location.getHeading());
	}
	
	/**
     * Testing the “getMode” functionality.
     * @return mode The situation of the robot's pen. In this case, It returns UP. 
     */
	 @Test
	 public void testGetMode() {
			assertEquals(Mode.UP, location.getMode());
		
   	 }
		
	/**
     * Testing the “setMode” functionality.
     * @param mode The situation of the robot's pen. In this case, we set it DOWN. 
     */
	 @Test
	 public void testSetMode() {
	     location.setMode(Mode.DOWN);
	     assertEquals(Mode.DOWN, location.getMode());
	    }
	 
	 /**
      * Testing the “getX” functionality.
      * @return X The row in which the robot is located. In this case, It returns 0. 
      */
   	  @Test
   	  public void testGetX() {
     		assertEquals(0, location.getX());
			
   	   }
   	  
 	 /**
       * Testing the “SetX” functionality.
       * @param X The row in which the robot is located. In this case, we set it 5. 
       */
						
			 @Test
			   public void testSetX() {
			     location.setX(5);
			     assertEquals(5, location.getX());
			    }
				/**
			     * Testing the “getY” functionality.
			     * @return Y The column in which the robot is located. In this case, It returns 0. 
			     */
			 @Test
				public void testGetY() {
					assertEquals(0, location.getY());
				
				}
				/**
			     * Testing the “setY” functionality.
			     * @param Y The column in which the robot is located. In this case, we set it 5. 
			     */
							
				 @Test
				   public void testSetY() {
				     location.setY(5);
				     assertEquals(5, location.getY());
				    }
				 
					/**
				     * Testing the “getMaxX” functionality.
				     * @return maxX The maximum row in which the robot can be located. In this case, It returns 0. 
				     */
				 
				 @Test
					public void testGetMaxX() {
						assertEquals(0, location.getMaxX());
					
					}
				 
					/**
				     * Testing the “setMaxX” functionality.
				     * @param maxX The maximum row in which the robot can be located. In this case, we set it 3. 
				     */
				 @Test
					public void testSetMaxX() {
					 ArraySheet mockarraysheet = EasyMock.createNiceMock(ArraySheet.class);
						EasyMock.expect(mockarraysheet.getRows()).andReturn(3);
						EasyMock.expect(mockarraysheet.getColumns()).andReturn(3);
						EasyMock.replay(mockarraysheet);
						location.setMaxX(mockarraysheet.getRows());
						assertEquals(3, location.getMaxX());
					
					}		
				 
					/**
				     * Testing the “getMaxY” functionality.
				     * @return maxY The maximum column in which the robot can be located. In this case, It returns 0. 
				     */
				 @Test
					public void testGetMaxY() {
					 
						assertEquals(0, location.getMaxY());
					
					}
					/**
				     * Testing the “setMaxY” functionality.
				     * @return maxY The maximum column in which the robot can be located. In this case, we set it 3. 
				     */
				 @Test
					public void testSetMaxY() {
					 ArraySheet mockarraysheet = EasyMock.createNiceMock(ArraySheet.class);
						EasyMock.expect(mockarraysheet.getRows()).andReturn(3);
						EasyMock.expect(mockarraysheet.getColumns()).andReturn(3);
						EasyMock.replay(mockarraysheet);
						location.setMaxY(mockarraysheet.getColumns());
						assertEquals(3, location.getMaxY());
					
					}	
				 
	 
}







