package arrayAndStrings;

public class SetZero{


	//@assume: the input array is a matrix
	// and not null
	public void setZero(int[][] mat){
		int M = mat.length;
		int N = mat[0].length;
		// @better: we could use the first row and first column as the 
		// row and column array, because will set it to zero anyway when 
		// there is a zero in that row or column
		boolean[] row = new boolean[M];
		boolean[] col = new boolean[N];
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				if(mat[i][j]==0){
					row[i] = true;
					col[j] = true;
					// @note: you cannot break here! You not only
					// need to set i, you still need to set j!
				}
			}
		}

		for(int i=0; i<M; i++){
			if(row[i]){
				for(int j=0; j<N; j++){
					mat[i][j] = 0;
				}
			}
		}

		for(int j=0; j<N; j++){
			if(col[j]){
				for(int i=0; i<M; i++){
					mat[i][j] = 0;
				}
			}
		}


	}
}