package mathematics;
// @note: remember to import
import java.util.LinkedList;

public class NumberWithPrime{


	public int find1(int k){
		if(k <= 0){
			throw new IllegalArgumentException();
		}
		int iter = 1;
		int count = 1;
		LinkedList<Integer> q3 = new LinkedList<Integer>(),
												q5 = new LinkedList<Integer>(),
												q7 = new LinkedList<Integer>();
		q3.add(1*3);
		q5.add(1*5);
		q7.add(1*7);
		while(count != k){
			// @note: remember to add @todo here: remember to add args
			iter = findNext(q3, q5, q7);
			count++;
		}
		return iter;
	}

	protected int findNext(LinkedList<Integer> q3, LinkedList<Integer> q5, LinkedList<Integer> q7){
		int cand3 = q3.get(0);
		int cand5 = q5.get(0);
		int cand7 = q7.get(0);
		int cand;
		if( cand3 < cand5 && cand3 < cand7){
			cand = q3.remove();
			q3.add(cand * 3);
			q5.add(cand * 5);
			q7.add(cand * 7);
		}else if(cand5 < cand3 && cand5 < cand7){
			cand = q5.remove();
			q5.add(cand * 5);
			q5.add(cand * 7);
		}else{
			cand = q7.remove();
			q7.add(cand * 7);
		}
		return cand;
	}

	/**
	* @wrong: 
	*   1. the order is not like what you originally thought it would be
	*   2. there are overlaps
	*   3. as per your original thought, it should be a tertiary tree, and what you want to 
	*      do is a breadth first search, that's why you find it hard to implement purely using
	*      loops: it's just not practical. 
	*	find the kth number with factors consisting of only 3, 5, 7
	*/
	// public int find(int k){
	// 	if(k <= 0){
	// 		throw new IllegalArgumentException("k should be an positive integer");
	// 	}
	// 	int[] factors = {3, 5, 7};
	// 	int iter = 3 * 5 * 7;
	// 	int count = 1;
	// 	while(true){
	// 		for(int i = 0; i < 3; i++){
	// 			for(int j = 0; j < 3; j++){
	// 				if(count != k){
	// 					count++;
	// 				}else{
	// 					return (iterInner * factors[j]);
	// 				}
	// 			}
	// 			iterOuter = 
	// 		}
	// 	}
	// 	// the compiler can detect that the loop is a infinite loop
	// 	// you don't need to return here
	// }

	/**
	*  @note: forget about this: exponential...
	*  @note: I think we don't need the flags: we know which is the next one, it has
	*  a pattern, not like prime where you have to cross out all that is not prime to
	*  find the prime. Here we can predict what the next one is.
	*	 find the kth number with factors consisting of only 3, 5, 7
	*  + we think from the oppsite when we can't get there directly. But here we can think directly
	*/
	public int find(int k){
		int upper = upperBound(k);
		boolean[] flags = new boolean[upper];
		// generate numbers meeting the req
		int[] factors = {3, 5, 7};
		int iter = 3 * 5 * 7;
		flags[iter] = true;
		boolean end = false;
		while(true){
			for(int i = 0; i < 3; i++){
				int iterIn = iter * factors[i];
				if(iterIn < upper){
					flags[iterIn] = true;
				}else{
					end = true;
					break;
				}
			}
			if(end){
				break;
			}
			iter = getNext(iter, flags);
		}
		int result = getKth(k, flags);
		return result;
	}


	protected int getKth(int k, boolean[] flags){
		int count = 0;
		// @note: if you want to use i outside the loop, you must declare it outside
		int i;
		for(i = 0; i < flags.length && count < k; i++){
			if(flags[i]){
				count++;
			}
		}
		i--;
		return i;
	}

	protected int upperBound(int k){
		// the first one
		// @since we use index to represent number, we start from 1, not 0
		int init = 3 * 5 * 7;
		int result = (int) Math.pow(3, k-1);
		result *= init;
		result += 1;
		return result;
	}

	protected int getNext(int iter, boolean[] flags){
		iter++;
		while(iter < flags.length){
			if(flags[iter]){
				return iter;
			}
			// @note: don't forget the else half and updating iterator
			iter++;
		}
		return -1;
	}
}