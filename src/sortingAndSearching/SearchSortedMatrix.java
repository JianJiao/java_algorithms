package sortingAndSearching;

public class SearchSortedMatrix{

	public Result find(int k, int[][] mat){
		if(mat == null || mat.length == 0 || mat[0].length == 0){
			return null;
		}
		int row = mat.length - 1;
		int col = 0;
		// @note: < length no ==
		while(row >= 0 && col < mat[0].length){
			if(mat[row][col] == k){
				return new Result(row, col);
				// @note: mat[row][col] and k, don't confuse them
			}else if(k > mat[row][col]){
				col++;
			}else{
				row--;
			}
		}
		return null;
	}




	public class Result{
		int row;
		int col;
		public Result(int row, int col){
			this.row = row;
			this.col = col;
		}
	}



	// public Result find(int[][] mat, int k){
	// 	if(mat == null || mat.length == 0){
	// 		return null;
	// 	}
	// 	int rowDim = mat.length;
	// 	int colDim = mat[0].length;
	// 	// stop:
	// 	if(rowDim == 1 )


	// }





	// public class Result{
	// 	int row;
	// 	int col;
	// }
}