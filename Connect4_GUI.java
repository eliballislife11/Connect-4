/**
 *
 * @author eliballislife11
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Connect4_GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1062534865334032725L;
	private Connect4_Grid my_grid;
	private Connect4_Game_Logic logic;
	private boolean has_winner;
	private boolean has_draw;
	private boolean quit_game;
	private boolean new_game;
	private int rows;
	private int columns;
	private int current_player;
	private JFrame frame;
	private JLabel[][] slots;
	private JButton[] buttons;

	public Connect4_GUI(Connect4_Grid grid, int size, int win_by) {
		this.my_grid = grid;
		logic = new Connect4_Game_Logic(grid, size, win_by);
		rows = grid.get_rows_size();
		columns = grid.get_columns_size();
		has_winner = false;
		has_draw = false;
		quit_game = false;
		new_game = false;
		current_player = 1;

		frame = new JFrame("Connect 4");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new GridLayout(rows + 1/* rows */, columns + 1));

		slots = new JLabel[rows][columns]; // Labels to represent the grid
		buttons = new JButton[rows]; // buttons for the players to choose which
										// columns to click each turn

		for (int i = 0; i < rows; i++) {
			buttons[i] = new JButton("" + (i + 1)); // Making buttons with an index
			buttons[i].setActionCommand("" + i);
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int x = Integer.parseInt(e.getActionCommand()); // return the column number of the button
					int y = grid.find_column(x); // return the next slot that is not occupied
					if (y != -1) {
						if (logic.set_and_check(x, y, current_player)) // check
																		// if
																		// there
																		// is a
																		// winner
						{
							has_winner = true;
						} else if (logic.draw_game()) // check if the game ends
														// in a draw
						{
							has_draw = true;
						} else // switch player
						{
							current_player = grid.change_player(current_player);
							frame.setTitle("Connect 4 - Player " + current_player + "'s turn");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Choose another column", "Column is full",
								JOptionPane.INFORMATION_MESSAGE);
					}
					{

					}

				}
			});
			panel.add(buttons[i]);
		}

		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) // making the grid for the game
			{
				slots[row][column] = new JLabel(/*"Slot " + row + " " + column*/);
				slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				slots[row][column].setVerticalAlignment(SwingConstants.CENTER);
				slots[row][column].setBorder(new LineBorder(Color.BLACK));
				panel.add(slots[row][column]);
			}
		}

		frame.setContentPane(panel);
		frame.setSize(800, 100);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void update_grid() {
		for (int i = 0; i < my_grid.get_rows_size(); i++)
			for (int j = 0; j < my_grid.get_columns_size(); j++) {
				if (my_grid.slot_equals(i, j, 1)) {
					slots[i][j].setOpaque(true);
					slots[i][j].setBackground(Color.BLUE);
				}
				if (my_grid.slot_equals(i, j, 2)) {
					slots[i][j].setOpaque(true);
					slots[i][j].setBackground(Color.RED);
				}
			}
	}

	public void show_winner_window() {
		String winner = "Player " + current_player + " wins the game!";
		int option = JOptionPane.showConfirmDialog(frame, "New Game?", winner, JOptionPane.YES_NO_OPTION);

		if (option < 1) {
			frame.dispose();
			new_game = true;
		} else {
			frame.dispose();
			quit_game = true;
		}
	}

	public void show_draw_window() {
		String draw = "It's a draw!";
		int option = JOptionPane.showConfirmDialog(frame, "New Game?", draw, JOptionPane.YES_NO_OPTION);

		if (option < 1) {
			frame.dispose();
			new_game = true;
		} else {
			frame.dispose();
			quit_game = true;
		}
	}

	public boolean get_has_winner() {
		return has_winner;
	}

	public boolean get_has_draw() {
		return has_draw;
	}

	public boolean get_quit_game() {
		return quit_game;
	}

	public boolean get_new_game() {
		return new_game;
	}

	public Connect4_Grid get_grid() {
		return my_grid;
	}

}

