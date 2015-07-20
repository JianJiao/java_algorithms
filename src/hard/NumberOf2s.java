package hard;

public class NumberOf2s{

	/**
	* how to approach: which 2: 2 at which digit, and have you counted all of 
	* them?
	*/
	public int number(int n){
		if(n == 0){
			return 0;
		}else if(n < 0){
			n = -n;
		}
		int original = n;
		int result = 0;
		int base = 1;
		while(n > 0){
			int basic = n % 10;
			int basicCount = 0;
			if(basic > 2){
				basicCount += base;
			}else if(basic == 2){
				basicCount += 1 + original % base;
			}
			n /= 10;
			result += n * base + basicCount;
			base *= 10;
		}
		return result;
	}
}