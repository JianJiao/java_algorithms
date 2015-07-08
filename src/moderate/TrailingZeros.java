package moderate;

public class TrailingZeros{

	public int trailingZeros(int n){
		int count = 0;
		int iter = n;
		while(iter >= 5){
			iter = iter / 5;
			count += iter;
		}
		return count;
	}
}