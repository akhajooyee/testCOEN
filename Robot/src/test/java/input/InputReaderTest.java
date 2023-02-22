package input;

import junit.framework.TestCase;
/**
 * Test class for testing the functionality of the BugReporter method.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.http.impl.execchain.MainClientExec;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import junit.framework.TestCase; 
import static org.junit.Assert.*; 
 


import generator.Simulator;

public class InputReaderTest extends TestCase{
	/**
	 * Before adjusting the location, it is imperative to ensure that the new position does not exceed the boundaries of the floor space.
     * @param row The row in which the robot is located. In this test case, we set it 5.
     * @param column The row in which the robot is located. In this test case, we set it 5.
     * @return simulator Simulator object.
     * 
     */ 

 	  @Test
	  public void testCreateRobotSimulator() {
	    InputReader inputReader = new InputReader();
	    Simulator simulator = inputReader.createRobotSimulator(5, 5);
	    assertNotNull(simulator);
	  }
	  
 		/**
 		 * Test the “validateCommand” functionality with invalid command.
 	     * @param line The command that user enters.In this case, It is "II 23"
 	     * @return true or false. In this case, it returns false.
 	     * 
 	     */ 
	  
	  @Test
	  public void testValidateCommand_InvalidCommand() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("II 23");
	 
	    assertFalse(result);
		
	  }
	  
		/**
		 * Test the “validateCommand” functionality with valid command.
	     * @param line The command that user enters.In this case, It is "I 23"
	     * @return true or false. In this case, it returns True.
	     * 
	     */ 

	  @Test
	  public void testValidateCommand_ValidCommand() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I 5");
	    assertTrue(result);
	  }
		/**
		 * Test the “validateCommand” functionality with the command I but a part of the command was missed.
	     * @param line The command that user enters.In this case, It is "I"
	     * @return true or false. In this case, it returns Flase.
	     * 
	     */ 
	  @Test
	  public void testValidateCommand_MissingArgumentsForCommandI() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I");
	    assertFalse(result);
	    result = inputReader.validateCommand("I 1");
	    assertFalse(result);
	    result = inputReader.validateCommand("I 101");
	    assertFalse(result);
	  }
		/**
		 * Test the “validateCommand” functionality with the command I but a part of the command was extra.
	     * @param line The command that user enters.In this case, It is "I 10 20"
	     * @return true or false. In this case, it returns Flase.
	     * 
	     */ 
	
	  @Test
	  public void testValidateCommand_TooManyArguments() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I 10 20");
	    assertFalse(result);
	  }
		/**
		 * Test the “validateCommand” functionality with the command “ ”.
	     * @param line The command that user enters.In this case, It is ""
	     * @return true or false. In this case, it returns Flase.
	     * 
	     */ 
	
	  @Test
	  public void testValidateCommand_NoArguments() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("");
	    assertFalse(result);
	  }
		/**
		 * Test the “validateCommand” functionality with the command I but a part of the command is invalid.
	     * @param line The command that user enters.In this case, It is "I 0"
	     * @return true or false. In this case, it returns Flase.
	     * 
	     */ 
	  @Test
	  public void testValidateCommand_InvalidArgument() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("I 0");
	    assertFalse(result);
	  }
		/**
		 * Test the “validateCommand” functionality with the command Q.
	     * @param line The command that user enters.In this case, It is "Q"
	     * @return true or false. In this case, it returns True.
	     * 
	     */ 
	  @Test
	  public void testValidateCommandQ() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("Q");
	    assertTrue(result);
	  }
		/**
		 * Test the “validateCommand” functionality with null simulator and the command M.
	     * @param line The command that user enters.In this case, It is "M 2"
	     * @return true or false. In this case, it returns False.
	     * 
	     */ 
	  @Test
	  public void testCommandWithSimulatorNullAndCommandNotI() {
		  InputReader inputReader = EasyMock.createMock(InputReader.class);
		     inputReader = new InputReader();
		     inputReader.simulator=null;
	    
	    boolean result = inputReader.validateCommand("M 2");
	    assertFalse(result);
	  }
		/**
		 * Test the “validateCommand” functionality with the command M but a part of the command was missed.
	     * @param line The command that user enters.In this case, It is "M"
	     * @return true or false. In this case, it returns False.
	     * 
	     */ 
	  @Test
	  public void testValidateCommand_MissingArgumentsForCommandM() {
	    InputReader inputReader = new InputReader();
	    boolean result = inputReader.validateCommand("M");
	    assertFalse(result);
	    result = inputReader.validateCommand("M 0");
	    assertFalse(result);
	  }
	
	  
	  
	  
}
