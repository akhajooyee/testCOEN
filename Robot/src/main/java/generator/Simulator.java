/*
 * This class instantiate a robot and place the robot in a predefined location and based on the command trigger the robot movement.
 */
package generator;

import java.util.ArrayList;

import net.bytebuddy.asm.Advice.Exit;
import util.Command;
import util.Heading;
import util.Mode;

public class Simulator {
    private Robot bot;
    private ArraySheet sheet;

    public void initSimulator(Robot robot, ArraySheet sheet) {
        this.bot = robot;
        this.sheet = sheet;
    }

    public void placeCommand() {
        
        Heading direction = Heading.from("NORTH");
        Mode mode = Mode.from("up");
        ArraySheet.floor= sheet.initializeLocation();
        Location location = new Location(0, 0, direction, mode, sheet);
        bot.placeRobot(location, sheet);
      
    }
    public void moveCommand(int step){
        	bot.move(step);
        	}
    public ArrayList<String> otherCommand(Command currentCommand) {
 
        ArrayList<String> output = new ArrayList<>();

        
        
        switch (currentCommand) {
     
            case L:
            	bot.left();
                break;
            case R:
            	bot.right();
                break;
            case U:
            	bot.up();
                break;
            case D:
            	bot.down();
                break;
            case P:
              output=bot.print();
                break;
            case C:
                output =bot.report();
                break;
      
            	
        }
        return output;
    }

   

    public Robot getRobot() {
        return bot;
    }
}