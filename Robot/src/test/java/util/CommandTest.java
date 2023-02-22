/**
 * Test class for testing the functionality of the ArraySheet class.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package util;

import junit.framework.TestCase;
import org.junit.Test;


public class CommandTest extends TestCase{
	/**
     * Testing the “isCommand” functionality with the valid command.
     * @param input The command value. It can be U, D, R, L, M, P, C, Q, I, i. 
     * @return True or false. In this case, return is true.
     */	
	@Test
	public void testIsCommand_validCommand_returnsTrue() {
		assertTrue(Command.isCommand("U"));
		assertTrue(Command.isCommand("D"));
		assertTrue(Command.isCommand("R"));
		assertTrue(Command.isCommand("L"));
		assertTrue(Command.isCommand("M"));
		assertTrue(Command.isCommand("P"));
		assertTrue(Command.isCommand("C"));
		assertTrue(Command.isCommand("Q"));
		assertTrue(Command.isCommand("I"));
		assertTrue(Command.isCommand("i"));
	}
	
	/**
     * Testing the “isCommand” functionality with the invalid command.
     * @param input The command value. It can be Z, Foo, Bar. 
     * @return True or false. In this case, return is False.
     */	
	@Test
	public void testIsCommand_invalidCommand_returnsFalse() {
		assertFalse(Command.isCommand("Z"));
		assertFalse(Command.isCommand("Foo"));
		assertFalse(Command.isCommand("Bar"));
	}
	
	/**
     * Testing the “GetValue” functionality with the valid command.
     * @return value The command value. It can be U, D, R, L, M, P, C, Q, I. 
     */	
	@Test
	public void testGetValue_validCommand_returnsCorrectValue() {
		assertEquals("U", Command.U.getValue());
		assertEquals("D", Command.D.getValue());
		assertEquals("M", Command.M.getValue());
		assertEquals("P", Command.P.getValue());
		assertEquals("C", Command.C.getValue());
		assertEquals("Q", Command.Q.getValue());
		assertEquals("I", Command.I.getValue());
		assertEquals("L", Command.L.getValue());
		assertEquals("R", Command.R.getValue());
	}
}