/*
 * This Class created for handling special error during runtime (Invalid Parameter,Input,...)
 */
package errortracker;

public class BugReporter extends RuntimeException {
	
	private String message;
	public BugReporter(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}