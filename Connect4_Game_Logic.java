/**
 *
 * @author eliballislife11
 */

public class Connect4_Game_Logic {
	private int max;
	private Connect4_Grid grid;
	private int cells_left;
	private int size;
	private int win_by;

	public Connect4_Game_Logic(Connect4_Grid Grid, int grid_size, int win_num) {
		this.grid = Grid;
		this.setSize(grid_size);
		this.setWin_by(win_num);
		max = grid.get_win_num();
		cells_left = grid.get_cells_left();
	}

	private boolean valid(int x, int y) {
		return x >= 0 && x < grid.get_rows_size() && y >= 0 && y < grid.get_columns_size();
	}

	public boolean set_and_check(int x, int y, int player) {
		grid.set_slot(x, y, player);
		cells_left--;
		return check_one(x, y, 0, 1, player) || check_one(x, y, -1, 1, player) || check_one(x, y, -1, 0, player)
				|| check_one(x, y, 1, 1, player) || check_one(x, y, 1, 0, player) || check_one(x, y, 0, -1, player)
				|| check_one(x, y, -1, -1, player);
	}

	public boolean check_one(int x, int y, int dx, int dy, int player) {
		int count = 0;
		int tempx = x;
		int tempy = y;

		while (count < max && valid(tempx, tempy)) {
			if (!grid.slot_equals(tempx, tempy, player)) {
				break;
			}

			tempx += dx;
			tempy += dy;
			count++;
		}

		tempx = x - dx;
		tempy = y - dy;
		while (count < max && valid(tempx, tempy)) {
			if (!grid.slot_equals(tempx, tempy, player)) {
				break;
			}

			tempx -= dx;
			tempy -= dy;
			count++;

		}
		return count == max;
	}

	public boolean draw_game() {
		return cells_left == 0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWin_by() {
		return win_by;
	}

	public void setWin_by(int win_by) {
		this.win_by = win_by;
	}

}
