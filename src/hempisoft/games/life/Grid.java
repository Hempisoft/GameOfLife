package hempisoft.games.life;

public class Grid {
	private int width;
	private int height;
	private Cell[][] grid;

	public Grid(int width, int height, int[][] startingCells) {
		grid = new Cell[width][height];
		this.width = width;
		this.height = height;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = new Cell();
			}
		}
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Cell[][] getGrid() {
		return this.grid;
	}

	public void printGrid() {
		String line = "-";
		for (int i = 0; i < width; i++)
			line += "--";
		System.out.println(line);
		for (int j = 0; j < height; j++) {
			line = "-";
			System.out.print("|");
			for (int i = 0; i < width; i++) {
				System.out.print((grid[i][j].isAlive() ? "O" : "#") + "|");
			}
			System.out.println("");
			for (int i = 0; i < width; i++)
				line += "--";
			System.out.println(line);
		}
	}
}
