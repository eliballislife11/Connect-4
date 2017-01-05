/**
 *
 * @author eliballislife11
 */

public class Connect4_Start 
{
	private Connect4_GUI my_gui;
	private int size;
	private int win_by;
	public Connect4_Start(Connect4_GUI gui, int size, int win_by)
	{
		this.my_gui = gui;
		this.size = size;
		this.win_by = win_by;
		play_my_gui(my_gui);
	}
	
	void play_my_gui(Connect4_GUI my_gui)
	{
		int state = 0;		
		while(state != -1)
		{
			if (state == 0)
			{
				my_gui.update_grid();
				if (my_gui.get_has_winner())
				{
					state = 1;
				}
				else if (my_gui.get_has_draw())
				{
					state = 2;
				}
				else if (my_gui.get_new_game())
				{
					my_gui = new Connect4_GUI(new Connect4_Grid(size, win_by), size, win_by);
					state = 0;
				}
			}
			else if (state == 1)
			{
				my_gui.show_winner_window();
				if (my_gui.get_quit_game())
				{
					state = -1;
				}
				else if (my_gui.get_new_game())
				{
					my_gui = new Connect4_GUI(new Connect4_Grid(size, win_by), size, win_by);
					state = 0;
				}
			}
			else if (state == 2)
			{
				my_gui.show_draw_window();
				if (my_gui.get_quit_game())
				{
					state = -1;
				}
				else if(my_gui.get_new_game())
				{
					my_gui = new Connect4_GUI(new Connect4_Grid(size, win_by), size, win_by);
					state = 0;
				}
			}
		}
	}
	
	
}

