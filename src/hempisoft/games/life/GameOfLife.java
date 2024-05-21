package hempisoft.games.life;

import java.util.Scanner;

public class GameOfLife {
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[36m";
    public static final String ANSI_CYAN = "\u001B[96m";
    public static final String ANSI_VISIBLE = "\033[96;42m";
    
	public static void main(String[] args) {
		
		// Epic Intro
		System.out.println(ANSI_CYAN + "   ______                           ____   ____   __     _  ____       __\r\n"
				+ "  / ____/____ _ ____ ___   ___     / __ \\ / __/  / /    (_)/ __/___   / /\r\n"
				+ " / / __ / __ `// __ `__ \\ / _ \\   / / / // /_   / /    / // /_ / _ \\ / / \r\n"
				+ "/ /_/ // /_/ // / / / / //  __/  / /_/ // __/  / /___ / // __//  __//_/  \r\n"
				+ "\\____/ \\__,_//_/ /_/ /_/ \\___/   \\____//_/    /_____//_//_/   \\___/(_)   \r\n"
				+ "                                                                         " + ANSI_RESET);

		// Scanner is used for Game-loop-Timing in the console implementation
		Scanner s = new Scanner(System.in);
		System.out.println("Press " + ANSI_GREEN + "'Enter'" + ANSI_RESET + " to start!");
		s.nextLine();

		// Accept user input as width and height
		// Remove if width and height are set
		int[] size = { 1, 1 };
		System.out.println("Please enter the Board width:" + ANSI_CYAN);
		while (size[0] == 1 || size[1] == 1) {
			try {
				if (size[0] == 1)
					size[0] = Integer.parseInt(s.nextLine());
				else
					size[1] = Integer.parseInt(s.nextLine());
				if(size[0] < 1) {
					size[0] = 1;
					throw new RuntimeException();
				}else if(size[1] < 1) {
					size[1] = 1;
					throw new RuntimeException();
				}
			} catch (Exception e) {
				System.out.println( ANSI_RESET  + ANSI_RED + "Please enter only a single, non-negative integer." + ANSI_CYAN);
			}
			if (size[0] != 1 && size[1] == 1)
				System.out.println(ANSI_RESET + "Please enter the Board height:" + ANSI_CYAN);
		}
		System.out.print(ANSI_RESET);

		// Initialize Grid
		Grid grid = new Grid(size[0], size[1], null);

		// Change for different starting position
		for (int i = 0; i < grid.getWidth(); i++) {
			grid.getGrid()[i][size[1] / 2].setLife(true);
		}

		// Main Game-Loop
		while (s != null) {
			// Print Game state
			grid.printGrid();
			System.out.println("Press Enter to proceed!");
			s.nextLine();

			// Game-logic implementation
			Grid newGrid = new Grid(size[0], size[1], null);
			for (int j = 0; j < grid.getHeight(); j++) {
				for (int i = 0; i < grid.getWidth(); i++) {
					// Count alive cells
					int count = 0;
					for (int t = -1; t < 2; t++) {
						for (int f = -1; f < 2; f++) {
							if ((t != 0 || f != 0) && i + t >= 0 && i + t < grid.getWidth() && j + f >= 0
									&& j + f < grid.getHeight() && grid.getGrid()[i + t][j + f].isAlive()) {
								count++;
							}
						}
					}

					// Update cell-alive-state
					if (!grid.getGrid()[i][j].isAlive()) {
						if (count == 3)
							newGrid.getGrid()[i][j].setLife(true);
					} else if (count >= 2 && count <= 3) {
						newGrid.getGrid()[i][j].setLife(true);
					}
				}
			}
			// Update game state
			grid = newGrid;

			// repaint();
		}
	}

}
