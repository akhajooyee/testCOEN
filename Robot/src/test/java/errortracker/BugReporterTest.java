/**
 * Test class for testing the functionality of the BugReporter method.
 * @author Maryam Asgari
 * @since 2023-02-04
 */
package errortracker;

import junit.framework.TestCase;

import org.junit.Test;

public class BugReporterTest extends TestCase{
	
	/**
     * Test case for verifying the BugReporter functionality.
     * 
     * @param an instance error message. in this case, "This is a bug" is the error message. 
     * @throws Exception if any error occurs during the program. In this case, we expected to have a " This is a bug" as an exception.
     */
	@Test
    public void testBugReporter() {
        String expectedMessage = "This is a bug";
        BugReporter bugReporter = new BugReporter(expectedMessage);
        String actualMessage = bugReporter.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
