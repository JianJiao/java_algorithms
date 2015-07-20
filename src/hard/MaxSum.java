package hard;

public class MaxSum{

	public int[][] maxSum(int[][] mat){
		if(mat == null){
			return null;
		}
		if(mat.length == 0 || mat[0].length == 0){
			return new int[0][0];
		}
		int len = mat.length;


		Result max = null;
		// which rows you want to process together
		for(int i = 0; i < len; i++){
			int[] arr = new int[len];
			for(int j = i; j < len; j++){
				for(int k = 0; k < len; k++){
					arr[k] += mat[j][k];
				}
				// @note: @todo: args
				Result result = getMaxSum(arr, i, j);
				// detect the first iteration
				if(max == null){
					max = result;
				}else{
					if(result.sum > max.sum){
						max = result;
					}
				}
			}
		}

		int ht = max.endRow - max.startRow + 1;
		int wd = max.endCol - max.startCol + 1;
		int[][] maxMat = new int[ht][wd];
		for(int i = 0; i < ht; i++){
			for(int j = 0; j < wd; j++){
				maxMat[i][j] = mat[i + max.startRow][j + max.startCol];
			}
		}
		return maxMat;
	}

	/**
	* one dimensional version of this problem,
	* @return: the row, col, sum
	*/
	protected Result getMaxSum(int[] arr, int startRow, int endRow){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException();
		}
		// if(startRow == 0 && endRow == 0){
		// 	System.out.println("ys");
		// 	for(int i = 0; i < arr.length; i++){
		// 		System.out.println(arr[i]);
		// 	}
		// 	System.out.println("ys");
		// }
		int sum = 0;
		int max = arr[0];
		int maxStart = 0;
		int maxEnd = 0;
		int curStart = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			if(sum > max){
				max = sum;
				maxStart = curStart;
				maxEnd = i;
			}else{
				if(sum < 0){
					sum = 0;
					curStart = i + 1;
				}
			}
		}
		Result result = new Result(startRow, endRow, maxStart, maxEnd, max);
		return result;
	}


	protected class Result{
		int startRow;
		int endRow;
		int startCol;
		int endCol;
		int sum;
		public Result(int startRow, int endRow, int startCol, int endCol, int sum){
			this.startRow = startRow;
			this.endRow = endRow;
			this.startCol = startCol;
			this.endCol = endCol;
			this.sum = sum;
		}
	}



}