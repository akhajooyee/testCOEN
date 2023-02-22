/**
 * Test class for testing the functionality of the Mode class.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package util;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class ModeTest extends TestCase{
	
	private Mode mode;
	@BeforeEach
	public void setUp() {
		mode = Mode.UP;
	}
	
	/**
     * Testing the ‘from” functionality with the constant mode. 
     * @param writingmode The situation of the robot's pen. It can be UP, DOWN.
     * @return mode The situation of the robot's pen. It can be UP, DOWN.
     */
	@Test
	public void testModeConstant() {
		assertEquals(Mode.UP, Mode.from("UP"));
		assertEquals(Mode.DOWN, Mode.from("DOWN"));

	}
	/**
     * Testing the ‘from” functionality with invalid constant mode. 
     * @param writingmode The situation of the robot's pen. In this test case, we choose "UPPP".
     * @return mode The situation of the robot's pen. In this test case, return is null.
     */
	@Test
	public void testInvalidModeConstant() {
		assertNull(Mode.from("UPPP"));
	}
	
	/**
     * Testing the “changeMode” functionality. Change from UP to DOWN. 
     * @param rotatepoint Specifies the value next situation of the robot's pen. it can be 0, 1. in this case, rotatepoint is 0.
     * @return value() Specifies the next situation of the robot's head. It can be UP, DOWN. in this case, value() is UP.
     */
	@Test
	public void testChangeModeFromUpToDown() {
		Mode newMode = mode.changeMode(0);
		assertEquals(Mode.UP, newMode);
		
	}
	
	/**
     * Testing the “changeMode” functionality. Change from DOWN to UP. 
     * @param rotatepoint Specifies the value next situation of the robot's pen. it can be 0, 1. in this case, rotatepoint is 1.
     * @return value() Specifies the next situation of the robot's head. It can be UP, DOWN. in this case, value() is DOWN.
     */
	@Test
	public void testChangeModeFromDownToUp() {
		Mode newMode = mode.changeMode(1);
		assertEquals(Mode.DOWN, newMode);

	}
	/**
     * Testing the “getWritingMode” functionality. 
     * @return writingmodeThe situation of the robot's pen. It can be UP, DOWN.
     */
	@Test
	public void testGetWritingMode_validMode_returnsCorrectValue() {
		assertEquals("UP", Mode.UP.getWritingMode());
		assertEquals("UP", Mode.UP.getWritingMode());	
	}
	
	
	
	

}
