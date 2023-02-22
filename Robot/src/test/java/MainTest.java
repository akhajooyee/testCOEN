import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;
import junit.framework.TestCase; 
import static org.junit.Assert.*; 
 
import java.io.ByteArrayInputStream; 
import java.io.ByteArrayOutputStream; 
import java.io.PrintStream; 
import java.io.InputStream; 
import java.util.ArrayList; 
 
import org.junit.Test;   
import static org.junit.Assert.*; 
 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;

import input.InputReader;
public class MainTest extends TestCase {
	private final InputStream systemIn = System.in; 
    private final PrintStream systemOut = System.out; 
 
//    private ByteArrayInputStream testIn; 
    private InputStream testIn; 
    private ByteArrayOutputStream testOut; 
  
  
   
 
    @Before 
    public void setUpOutput() { 
        testOut = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(testOut)); 
    } 
 
    private void provideInput(String data) { 
        testIn = new ByteArrayInputStream(data.getBytes()); 
        System.setIn(testIn); 
    } 
 
    private String getOutput() { 
        return testOut.toString(); 
    } 
 
    @After 
    public void restoreSystemInputOutput() { 
        System.setIn(systemIn); 
        System.setOut(systemOut); 
    }
	@Test 
    public void testCaseMoveExtra() { 
        final String testString = "Invalid movement"; 
        provideInput("I 10\nR \nM 11\nQ\n"); 
        testOut = new ByteArrayOutputStream(); 
        PrintStream ps = new PrintStream(testOut); 
        PrintStream old = System.out; 
        System.setOut(ps); 
        Main.main(new String[0]); 
        System.out.flush(); 
        System.setOut(old); 
        String temp = testOut.toString().split("\n")[3]; 
        System.out.print(temp); 
        assertEquals(testString.toString(), testOut.toString().split("\n")[3].substring(0,16)); 
 
    }

}
