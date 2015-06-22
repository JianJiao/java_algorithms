package recursion;
import java.util.HashSet;
import java.util.ArrayList;

public class Cents{

	protected int count;

	/**
	* @return the number of ways of representing n cents
	*/
	public int cents(int n){
		count = 0;
		centsHelper(n, 25);
		return count;
	}

	protected void centsHelper(int n, int which){
		// stop:
		if(n < 0){
			return;
		}
		if(n == 0){
			count++;
		}
		if(which == 25){
			centsHelper(n - 25, 25);
		}
		if(which >= 10){
			centsHelper(n - 10, 10);
		}
		if(which >= 5){
			centsHelper(n - 5, 5);
		}
		centsHelper(n - 1, 1);
	}
}