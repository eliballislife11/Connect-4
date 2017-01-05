/**
 *
 * @author eliballislife11
 */

public class Connect4_Grid {

	private int rows_size;
	private int columns_size;
	private int win_num;
	private int[][] grid;
	private int cells_left;

	public Connect4_Grid(int size, int win_by) {
		cells_left = 0;
		rows_size = size; // size;
		columns_size = size; // size - 1
		win_num = win_by;
		grid = new int[rows_size][columns_size];

		for (int i = 0; i < rows_size; i++)
			for (int j = 0; j < columns_size; j++) {
				grid[i][j] = 0;
				cells_left++;
			}
	}

	public int get_win_num() {
		return win_num;
	}

	public int get_rows_size() {
		return rows_size;
	}

	public int get_columns_size() {
		return columns_size;
	}

	public int[][] get_grid() {
		return grid;
	}

	public int get_cells_left() {
		return cells_left;
	}

	public void set_slot(int i, int j, int player) {
		grid[i][j] = player;
	}

	public boolean slot_equals(int i, int j, int player) {
		return grid[i][j] == player;
	}

	public int find_column(int row) {
		int column = -1;
		for (int i = 0; i < columns_size; i++) {
			if (grid[row][i] == 0) {
				column = i;
			}
		}
		return column;
	}

	public void subtract_cell() {
		cells_left--;
	}

	public int change_player(int player) {
		if (player == 1)
			return 2;
		else {
			return 1;
		}
	}

}
