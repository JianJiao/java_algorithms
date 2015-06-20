package recursion;

public class StairPattern{


	public int dynaPatterns(int n){
		// we want the index to represent the staris number, starting from 1
		int[] patterns = new int[n + 1];
		// todo
		return patterns(n, patterns);
	}


	public int patterns(int n, int[] patterns){
		// check args
		if(n <= 0){
			throw new IllegalArgumentException("stairs number must be greater than 0");
		}
		// @note: you shall use it, or why do you store them in an array?
		// add array --> change signature and code --> add the if test
		if(patterns[n] > 0){
			return patterns[n];
		}else{
			// stop:
			if(n == 1){
				patterns[1] = 1;
				return 1;
			}else if(n == 2){
				patterns[2] = 2;
				return 2;
			}else if(n == 3){
				patterns[3] = 4;
				return 4;
			}

			// last step 1
			int count1 = patterns(n-1, patterns);
			// last step 2
			int count2 = patterns(n-2, patterns);
			// last step 3
			int count3 = patterns(n-3, patterns);

			int result = count1 + count2 + count3;
			patterns[n] = result;
			return result;
		}
	}
}