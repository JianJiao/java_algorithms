package hard;

/**
* @note: consider all possible solutins, think twice before you go into details
*/

public class MaxSquare{

	public boolean[][] maxSquare(boolean[][] square){
		if(square == null || square.length == 0 || square[0].length == 0){
			return null;
		}
		int loop = (square.length + 1) / 2;
		for(int i = 0; i < loop; i++){
			boolean result = check(i, square);
			if(result){
				boolean[][] maxSquare = new boolean[square.length - i * 2][square.length - i * 2];
				int start = i;
				int end = square.length - i - 1;
				for(int j = 0; j < maxSquare.length; j++){
					for(int k = 0; k < maxSquare.length; k++){
						maxSquare[j][k] = square[j + i][k + i];
					}
				}
				return maxSquare;
			}
		}
		return null;
	}

	protected boolean check(int k, boolean[][] square){
		int start = k;
		// @note: str or array?
		int end = square.length - k - 1;
		for(int i = start; i <= end; i++){
			if(square[start][i] == true || square[end][i] == true
				|| square[i][start] == true || square[i][end] == true){
				return false;
			}
		}
		return true;
	}
}