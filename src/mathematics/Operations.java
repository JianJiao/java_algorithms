package mathematics;

public class Operations{

	public int multiply(int x, int y){
		int result = 0;
		boolean flag = false;
		if(y < 0){
			y = negative(y);
			flag = true;
		}
		for(int i = 0; i < y; i++){
			result += x;
		}
		if(flag){
			result = negative(result);
		}
		return result;
	}

	public int subtract(int x, int y){
		int result = 0;
		y = negative(y);
		result = x + y;
		return result;
	}

	/**
	*	first of all, think clearly into detail about what a 
	* division is. Set the rules, and you have a higher chance to get the answer from
	* the rule
	*/
	public int divide(int x, int y){
		if(y == 0){
			throw new IllegalArgumentException();
		}
		boolean flag = false;
		if( x < 0 && y > 0 || x > 0 && y < 0){
			flag = true;
		}
		x = x >= 0 ? x : negative(x);
		y = y >= 0 ? y : negative(y);
		int i;
		for(i = 0; multiply(i, y) <= x; i++){}
		i--;
		// @note: remember to check the flag
		if(flag){
			i = negative(i);
		}
		return i;
	}

	/**
	*	@note: if we were not allowed to use bit manipulation
	* then, we will have to use -1, and add until we hit the negative value: see the negate
	*
	*/
	public int negative(int x){
		return (~x + 1);
	}

	public int negate(int x){
		int d = x > 0 ? -1 : 1;
		int neg = 0;
		while( (neg + x) != 0){
			neg += d;
		}
		return neg;
	}



}