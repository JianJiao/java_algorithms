package hard;

/**
* @note: int better than boolean
* 0 as white, 1 as black
*/
public class Max{
	// @note: @todo: need to be initialized somewhere
	protected int[][] right, below;

	public int[][] max(int[][] square){
		if(square == null || square.length == 0 
			|| square[0].length == 0){
			return null;
		}
		int len = square.length;
		// right = new int[len][len];
		// below = new int[len][len];
		preProcess(square);
		for(int size = len; size > 0; size--){
			for(int i = 0; i + size -1 < len; i++){
				for(int j = 0; j + size - 1 < len; j++){
					boolean result = check(i, j, size);
					// System.out.println(result);
					if(result){
						int[][] max = new int[size][size];
						for(int o = 0; o < size; o++){
							for(int p = 0; p < size; p++){
								max[o][p] = square[o + i][p + j];
							}
						}
						return max;
					}

				}
			}
		}
		return null;
	}

	/**
	* given the starting corner and size of each subsquare, check if it is valid
	*/
	protected boolean check(int i, int j, int size){
		// System.out.println(i + " " + j);
		if(right[i][j] >= size && below[i][j] >= size 
			&& right[i + size - 1][j] >= size && below[i][j + size - 1] >= size){
			return true;
		}else{
			return false;
		}
	}

	protected void preProcess(int[][] square){
		int len = square.length;
		right = new int[len][len];
		below = new int[len][len];
		// process right
		for(int i = 0; i < len; i++){
			if(square[i][len - 1] == 1){
				right[i][len - 1] = 1;
			}
			for(int j = len -2; j >=0; j--){
				if(square[i][j] == 1){
					right[i][j] = right[i][j + 1] + 1;
				}
			}
		}

		// process below
		for(int i = 0; i < len; i++){
			if(square[len - 1][i] == 1){
				below[len - 1][i] = 1;
			}
			for(int j = len - 2; j >= 0; j--){
				if(square[j][i] == 1){
					below[j][i] = below[j + 1][i] + 1;
				}
			}
		}
	}

}