package recursion;

public class PaintFill{


	/**
	* @assume: row is row index, col is col index
	*/
	public void paintFill(int[][] screen, int row, int col, int color){
		if(screen == null){
			return;
		}
		int rowDim = screen.length;
		int colDim = screen[0].length;
		if(row >= rowDim || col >= colDim || row < 0 ||  col < 0){
			return;
		}
		boolean[][] visited = new boolean[rowDim][colDim];
		if(screen[row][col] == color){
			return;
		}
		int original = screen[row][col];
		paintFillHelper(screen, row, col, color, original, visited, rowDim, colDim);
	}


	protected void paintFillHelper(int[][] screen, int row, int col, int color, int original, boolean[][] visited
		, int rowDim, int colDim){
		// stop:
		if(row >= rowDim || col >= colDim || row < 0 || col < 0){
			return;
		}
		if(screen[row][col] != original){
			return;
		}
		if(visited[row][col]){
			return;
		}
		// paint self
		screen[row][col] = color;
		visited[row][col] = true;
		// paint neighbors
		paintFillHelper(screen, row - 1, col, color, original, visited, rowDim, colDim);
		paintFillHelper(screen, row, col - 1, color, original, visited, rowDim, colDim);
		paintFillHelper(screen, row, col + 1, color, original, visited, rowDim, colDim);
		paintFillHelper(screen, row + 1, col, color, original, visited, rowDim, colDim);
	}
}