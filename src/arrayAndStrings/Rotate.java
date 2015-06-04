package arrayAndStrings;

public class Rotate{

	// @assume: N*N
	public void rotate(int[][] img){
		int N = img.length;
		int tmp;
		for(int i=0; i<N-1; i++){
			for(int j=i; j<N-i-1; j++){
				tmp = img[i][j];
				img[i][j] = img[N-1-j][i];
				img[N-1-j][i] = img[N-1-i][N-1-j];
				img[N-1-i][N-1-j] = img[j][N-1-i];
				img[j][N-1-i] = tmp;
			}
		}
	}
}