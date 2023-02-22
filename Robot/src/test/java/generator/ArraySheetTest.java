/**
 * Test class for testing the functionality of the ArraySheet class.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package generator;
import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;



public class ArraySheetTest extends TestCase{
	
	private ArraySheet arraysheet;
	
	@BeforeEach
	public void setUp() {
		arraysheet = new ArraySheet(5, 5);
	}
	/**
     * Testing the validateLocation method functionality with a location in the range. When the robot is in the valid location (3,4) this function should return True.
     * @param location The location of the robot. in this case, location is (3,4)
     * @return True or false. In this case, return is true.
     */
	
	@Test
	public void testValidateLocationWithinRange() {
		Location mockLocation = EasyMock.createNiceMock(Location.class);
		EasyMock.expect(mockLocation.getX()).andReturn(3);
		EasyMock.expect(mockLocation.getY()).andReturn(4);
		EasyMock.replay(mockLocation);

		assertTrue(arraysheet.validateLocation(mockLocation));
	}
	
	/**
     * Testing the validateLocation method functionality with a location out of the range. When the robot is in the invalid location (3,6) this function should return False.
     * @param location The location of the robot. in this case, location is (3,6)
     * @return True or false. In this case, return is False.
     */
	
	@Test
	public void testValidateLocationOutOfRange() {
		Location mockLocation = EasyMock.createNiceMock(Location.class);
		EasyMock.expect(mockLocation.getX()).andReturn(3);
		EasyMock.expect(mockLocation.getY()).andReturn(6);
		EasyMock.replay(mockLocation);

		assertFalse(arraysheet.validateLocation(mockLocation));
	}
	
	/**
     * Testing the initializationLocation functionality. Before of this method you should build ArraySheet(5,5).
     * @return floor. floor is a 2D array that the robot can walk through it. In this case, return is {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}.
     */
	@Test
	    public void testInitializeLocation() {
	       
	        int[][] result = arraysheet.initializeLocation();
	        assertArrayEquals(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}, result);
	    }
	/**
     * Testing the getRow method functionality. Before of this method you should build ArraySheet(5,5).
     * @return rows. Row is the number of rows in a 2D array that the robot can walk through it. In this case, return is 5.
     */
	@Test
		public void testGetRows() {
			assertEquals(5, arraysheet.getRows());
		
		}
	/**
     * Testing the getColumns method functionality. Before of this method you should build ArraySheet(5,5).
     * @return rows. Row is the number of rows in a 2D array that the robot can walk through it. In this case, return is 5.
     */
	@Test
		public void testGetColumns() {
			assertEquals(5, arraysheet.getColumns());
		
		}

}
