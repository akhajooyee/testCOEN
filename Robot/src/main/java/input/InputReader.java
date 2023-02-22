/*
 * This is the main class that  get the input from user
 */
package input;

import generator.ArraySheet;
import generator.Robot;
import generator.Simulator;
import util.Command;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
	static Simulator simulator;
	 protected static Simulator createRobotSimulator(int row,int column) {
			ArraySheet table = new ArraySheet(row, column);
			Robot robot = new Robot();
			simulator = new Simulator();
			simulator.initSimulator(robot, table);
			return simulator;
		}
		public static  void readInput() {
			
		    while (true) {
				ArrayList<String> result = new ArrayList<>();
		    	System.out.println("Enter Command: ");
	    	    Scanner input = new Scanner(System.in);
			    String line = input.nextLine();
			    
			    if (!validateCommand(line)) 
			    {
			    	showHelperMessage();
			    	continue;
			    }
		    
	    	    String[] commandArgs = line.split(" ");
	    	 
		        if (commandArgs[0].compareToIgnoreCase("Q")==0) {
		        	break;
		        	}
		        
		        else if (commandArgs[0].compareToIgnoreCase("I")==0) {
		        	int xyValue=Integer.parseInt(commandArgs[1]);
		            simulator = createRobotSimulator(xyValue,xyValue);
		            simulator.placeCommand();
		            }
		        
		        else if ((commandArgs[0].compareToIgnoreCase("M")==0)) {
		        	simulator.moveCommand(Integer.parseInt(commandArgs[1]));
		        	}
		        else {
		        	Command command = Command.valueOf(commandArgs[0].toUpperCase());
		        	result=simulator.otherCommand(command);
		        	}
		        }
		    }
		
		  public static boolean validateCommand(String line)
		  {
		
			  String[] commandArgs = line.split(" ");

			  
			  if (commandArgs.length>2 || commandArgs.length<1 )
	  	      {
		    	return false;
	  	      }
			  else if ( commandArgs[0].compareToIgnoreCase("Q")==0 )
			 {
	 	    	  return true;

			  }
			  else if (simulator==null &&  !(commandArgs[0].compareToIgnoreCase("I")==0) )
			  {
	  	    	  return false;

			  }
			  
			 
			  
	  	       if (!Command.isCommand(commandArgs[0]))
	  	      {
	  	    	  return false;
	  	      }
	  	       
	  	    
	  	       if (commandArgs[0].compareToIgnoreCase("I")==0 ) {
	  	    	  if (commandArgs.length<2)
	  	    	  {
	  	    		return false;
	  	    	  }
	 
	  	    	   if (Integer.parseInt(commandArgs[1])>100||Integer.parseInt(commandArgs[1])<2)
	  	    	 {
		    	   return false;
	  	    	 }
	  	      }
	  	      if (commandArgs[0].compareToIgnoreCase("M")==0)
	  	      {
	  	    	  if (commandArgs.length<2)
	  	    	  {
	  	    		return false;
	  	    	  }
	  	    
	  	    	  if (Integer.parseInt(commandArgs[1]) <1 )
	  	    		
	 	    	 {
		    	   return false;
	 	    	 }
	  	      }
			  return true;
		  }
		  
		  public static boolean  showHelperMessage() {
			   	 
			  			 
			  System.out.println("\033[1;35m Command	 Meaning\033[0m");
			  System.out.println("\033[1;35m [U|u]		Pen up\033[0m");
			  System.out.println("\033[1;35m [D|d]		Pen down\033[0m");
			  System.out.println("\033[1;35m [R|r]		Turn right\033[0m");
			  System.out.println("\033[1;35m [L|l]		Turn left\033[0m");
			  System.out.println("\033[1;35m [M s|m s]	Move forward s spaces (s is a non-negative integer)\033[0m");
			  System.out.println("\033[1;35m [P|p] 		Print the N by N array and display the indices\033[0m");
			  System.out.println("\033[1;35m [C|c]		Print current position of the pen and whether it is up or down and its facing direction\033[0m");
			  System.out.println("\033[1;35m [I n|i n]	Initialize the system: The values of the array floor are zeros and the robot is back to [0, 0], pen up and facing north. n size of the array, an integer greater than zero\033[0m");
			  System.out.println("\033[1;35m [Q|q]		Stop the program\033[0m");
			  System.out.println("\033[1;35m Yoh have to initialize the array by [I n|i n] in First Command\033[0m");
			  
			  return true;
		        
		   
		    }

}




