/**
 * Test class for testing the functionality of the BugReporter method.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package generator;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.easymock.EasyMock;
import util.Command;
import util.Heading;
import util.Mode;
import java.util.ArrayList;

public class SimulatorTest extends TestCase {
	
	private Simulator simulator;
	private Robot robot;
	private ArraySheet arraysheet;
	Location initialPosition;
	@BeforeEach
	public void setUp() {
		simulator = new Simulator();
		robot = new Robot();
		arraysheet = new ArraySheet(5, 5);
		simulator.initSimulator(robot, arraysheet);
		initialPosition = new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet);
		robot.placeRobot(initialPosition, arraysheet);
	}
	/**
	 * Test the “placeCommand” inner functionality. It is imperative to establish the location of the robot when constructing a new floor.
     * 
     */ 
	 @Test
	    public void testPlaceCommandInnerFunctionality() {
	        ArraySheet.floor= arraysheet.initializeLocation();
	        Location location = new Location(0, 0, Heading.NORTH, Mode.UP, arraysheet);
	        robot.placeRobot(location, arraysheet);
	        assertEquals(location, robot.getLocation());
	        
	    }
	 
		/**
		 * Test the “placeCommand” functionality. It is imperative to establish the location of the robot when constructing a new floor.
	     * 
	     */ 
	 @Test
	 public void testPlaceCommand() {

		 
		 simulator.placeCommand();
			
		 assertEquals(Heading.NORTH, robot.location.getHeading());
		 assertEquals(Mode.UP, robot.location.getMode());
		 assertEquals("0,0,NORTH,UP", robot.getLocation().toString());
		
		
	 }

		/**
		 * Test the “moveCommand” functionality. Upon receipt of the move command, the robot must proceed to the designated location.
	     * @param step The steps that the robot should move. In this case, It is 4.
	     * 
	     */ 
	 	@Test
	    public void testMoveCommand() {

	        simulator.moveCommand(4);
	        Location finalPosition = robot.getLocation();
	        assertEquals(finalPosition.getX(), 0);
	        assertEquals(finalPosition.getY(), 4);
	        assertEquals(finalPosition.getHeading(), Heading.NORTH);
	 }
	 	
		/**
		 * Test the “otherCommand” functionality with the command left direction.
	     * @param currentcommand The command that the robot should do it. In this case, It is L.
	     * @return output. The command result.
	     * 
	     */ 
	 
	 @Test
	 public void testOtherCommandCHangeDirectionToLeft() {
		 
		 simulator.otherCommand(Command.L);
	     assertEquals("WEST", robot.getLocation().getHeading().toString());
	   
	 }
	 
		/**
		 * Test the “otherCommand” functionality with the command right direction.
	     * @param currentcommand The command that the robot should do it. In this case, It is R.
	     * @return output. The command result.
	     * 
	     */ 
	 
	 @Test
	 public void testOtherCommandCHangeDirectionToRight() {
		 
		 simulator.otherCommand(Command.R);
	     assertEquals("EAST", robot.getLocation().getHeading().toString());
	   
	 }
		/**
		 * Test the “otherCommand” functionality with the command UP.
	     * @param currentcommand The command that the robot should do it. In this case, It is U.
	     * @return output. The command result.
	     * 
	     */ 
	 
	 @Test
	 public void testOtherCommandCHangeWritingModeToUp() {
			initialPosition = new Location(0, 0, Heading.NORTH, Mode.DOWN, arraysheet);
			robot.placeRobot(initialPosition, arraysheet);
			simulator.otherCommand(Command.U);
			assertEquals("UP", robot.getLocation().getMode().toString());
	   
	 }
		/**
		 * Test the “otherCommand” functionality with the command Down.
	     * @param currentcommand The command that the robot should do it. In this case, It is D.
	     * @return output. The command result.
	     * 
	     */ 
	 @Test
	 public void testOtherCommandCHangeWritingModeToDown() {
			
			simulator.otherCommand(Command.D);
			assertEquals("DOWN", robot.getLocation().getMode().toString());
	   
	 }
		/**
		 * Test the “otherCommand” functionality with the command C to report the last condition of the robot.
	     * @param currentcommand The command that the robot should do it. In this case, It is C.
	     * @return output.The command result.
	     * 
	     */
	 @Test
		public void testOtherCommandReport() {
			ArrayList<String> expected = new ArrayList<>();
			expected.add("0,0,NORTH,UP");
			assertEquals(expected, simulator.otherCommand(Command.C));
			
		}
		/**
		 * Testing the “otherCommand” functionality with the command P to report the whole floor.
	     * @param currentcommand The command that the robot should do it. In this case, It is P.
	     * @return output. The command result.
	     * 
	     */
	 @Test
	   public void testOtherCommandPrint() {
		
		ArrayList<String> expected = new ArrayList<>();
	    expected.add(" ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ");
	    assertEquals(expected.toString(), simulator.otherCommand(Command.P).toString());
	   }
		/**
		 * Test the “getRobot” functionality.
	     * @return bot An object from Robot class. 
	     * 
	     */
	 @Test
	 public void testGetRobot() {
	
	     assertEquals(robot, simulator.getRobot());
	 }







	

	
}
