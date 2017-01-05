/**
 *
 * @author eliballislife11
 */

import java.util.Scanner;

public class Connect4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try{
			System.out.print("Please enter the size of the grid you want: ");
			int size = in.nextInt();
			System.out.print("Now enter the number to win by: ");
			int win_by = in.nextInt();
			Connect4_Grid grid = new Connect4_Grid(size, win_by);
			Connect4_GUI gui = new Connect4_GUI(grid, size, win_by);
			new Connect4_Start(gui, size, win_by);
		}catch (Exception e){
			System.out.println("Command format should follow this model: java -jar <filename.jar> <int for dimensions of grid> <int for winning sequence");
		}
		/*try{
			int size = Integer.parseInt(args[0]);
			int win_by = Integer.parseInt(args[1]);
			Connect4_Grid grid = new Connect4_Grid(size, win_by);
			Connect4_GUI gui = new Connect4_GUI(grid, size, win_by);
			new Connect4_Start(gui, size, win_by);
		}catch (Exception e){
			System.out.println("Command format should follow this model: java -jar <filename.jar> <int for dimensions of grid> <int for winning sequence");
		}*/
		
		
		in.close();
	}
}
