import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MapIllustrator
{
	/** the 2D array containing the elevations */
	private int[][] grid;

	/** constructor, parses input from the file into grid */
	public MapIllustrator(String fileName)
	{
		Scanner input = null;
		File file = new File(fileName);
		try {
			 input = new Scanner(file);
		}
		catch(FileNotFoundException f) {
			System.out.println("File not Found!");;
		}
		int row = input.nextInt();
		int col = input.nextInt();
		grid = new int[row][col];
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				grid[r][c] = input.nextInt();
			}
		}
	}


	/** @return the min value in the entire grid */
	public int findMin() {
		int min = grid[0][0];
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid.length; c++) {
				if (grid[r][c] < min) min = grid[r][c];
			}
		}
		return min;
	}

	/** @return the max value in the entire grid */
	public int findMax() {
		int max = grid[0][0];
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid.length; c++) {
				if (grid[r][c] > max) max = grid[r][c];
			}
		}
		return max;
	}

	/**
	 * Draws the grid using the given Graphics object.
	 * Colors should be grayscale values 0-255, scaled based on min/max values in grid
	 */
	public void drawMap(Graphics g) {
		int min = findMin();
		double scalingFactor = 255.0/(findMax() - findMin());
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				int color = (int)(scalingFactor * (grid[r][c] - min) + 0.5);
				g.setColor(new Color(color, color, color));
				g.fillRect(c, r, 1, 1);
			}
		}
	}

	/**
	 * Find a path from West-to-East starting at given row.
	 * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
	 * @return the total change in elevation traveled from West-to-East
	 */
	public int drawPath(Graphics g, int row) {
		int sum = 0;
		g.fillRect(0, row, 1, 1);
		for (int c = 1; c < grid[0].length; c++) {
			int diffTop = Integer.MAX_VALUE;
			if (row > 0) {
				 diffTop = Math.abs(grid[row - 1][c] - grid[row][c - 1]);
			}
			int diffBot = Integer.MAX_VALUE;
			if (row < grid.length - 1) {
				diffBot = Math.abs(grid[row + 1][c] - grid[row][c - 1]);
			}
			int diffMid = Math.abs(grid[row][c] - grid[row][c - 1]);
			if (Math.min(diffTop, Math.min(diffBot, diffMid)) == diffMid) {
				g.fillRect(c, row, 1, 1);
				sum += diffMid;
			}
			else if (diffTop == diffBot) {
				if (((int) (Math.random() * 2)) == 1){
					g.fillRect(c, row - 1, 1, 1);
					row--;
					sum += diffTop;
				}
				else if (((int) (Math.random() * 2)) == 0) {
					g.fillRect(c, row + 1, 1, 1);
					row++;
					sum += diffBot;
				}

			}
			else if (Math.min(diffTop, Math.min(diffBot, diffMid)) == diffBot) {
				g.fillRect(c, row + 1, 1, 1);
				row++;
				sum += diffBot;
			}
			else if (Math.min(diffTop, Math.min(diffBot, diffMid)) == diffTop) {
				g.fillRect(c, row - 1, 1, 1);
				row--;
				sum += diffTop;
			}

		}
		return sum;
	}

	/** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
	public int getIndexOfLowestPath(Graphics g) {
		int lowestLength = Integer.MAX_VALUE;
		int indexOfLowestLength = -1;
		for (int r = 0; r < grid.length; r++) {
			if (drawPath(g, r) <= lowestLength) {
				lowestLength = drawPath(g, r);
				indexOfLowestLength = r;
			}
		}
		return indexOfLowestLength;
	}

	/** return the number of rows in grid */
	public int getRows() {
		return grid.length;
	}

	/** return the number of columns in grid (assumed rectangular) */
	public int getCols() {
		return grid[0].length;
	}
}
