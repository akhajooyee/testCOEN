/*Command Meaning
[U|u] Pen up
[D|d] Pen down
[R|r] Turn right
[L|l] Turn left
[M s|m s] Move forward s spaces (s is a non-negative integer)
[P|p] Print the N by N array and display the indices
[C|c] Print current position of the pen and whether it is up or down and its facing direction
[Q|q] Stop the program
[I n|i n] Initialize the system: The values of the array floor are zeros and the robot
is back to [0, 0], pen up and facing north. n size of the array, an integer greater than zero
*/
package util;

public enum Command {
	U("U"),
	D("D"),
	M("M"),
	P("P"),
	C("C"),
	Q("Q"),
	I("I"),
	L("L"),
	R("R");
	

	
	private final String value;

    Command(String value) {
        this.value = value;
    }
    
    public static boolean isCommand(String input) {
        for (Command command : Command.values()) {
            if (command.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

	public String getValue() {
		return value;
	}
}

