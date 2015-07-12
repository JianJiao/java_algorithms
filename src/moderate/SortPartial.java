package moderate;

public class SortPartial{
	public Result find(int[] array){
		if(array == null){
			throw new IllegalArgumentException("cannot be null");
		}
		if(array.length == 0){
			return new Result(0, 0);
		}
		// @todo: completely sorted
		int m = findReverse(array, 0);
		if(m == -1){
			return new Result(0, 0);
		}
		int n = findReverse(array, 1);
		// System.out.println("m is: " + m);
		// System.out.println("n is: " + n);
		MaxMin maxmin = findMaxMin(m, n, array);
		// System.out.println("maxmin max is: " + maxmin.max);
		// System.out.println("min is: " + maxmin.min);
		if(maxmin.min < array[m]){
			m = find(array, 0, m - 1, maxmin.min, 0);
		}
		if(maxmin.max > array[n]){
			// System.out.println("yes");
			n = find(array, n + 1, array.length - 1, maxmin.max, 1);
			// System.out.println("n is: " + n);
		}
		Result result = new Result(m, n);
		return result;
	}

	/**
	* side: 0 is left, 1 is right
	*/
	protected int find(int[] array, int start, int end, int k, int side){
		if(array == null || array.length == 0){
			throw new IllegalArgumentException();
		}
		if(start > end){
			if(side == 0){
				return start;
			}else{
				return end;
			}
		}
		int middle = (start + end) / 2;
		if(array[middle] == k){
			// make sure before this the whole array is not completely sorted
			if(side == 0){
				while(array[middle + 1] == array[middle]){
					middle++;
				}
				return middle + 1;
			}else{
				while(array[middle - 1] == array[middle]){
					middle--;
				}
				return middle - 1;
			}
			// @note: the order of array[middle] and k, don't confuse them
		}else if(k < array[middle]){
			return find(array, start, middle - 1, k, side);
		}else{
			// if(k == 4){
			// 	System.out.println("aha");
			// }
			return find(array, middle + 1, end, k, side);
		}
	}

	protected MaxMin findMaxMin(int start, int end, int[] array){
		if(start > end || start < 0 || end >= array.length || array == null || array.length == 0){
			return null;
		}
		// @note: actual value or index, and all should be consistent. Dont' change once you
		// decided, because all needs to be consistent and it's hard
		// if max and min are indices, they should start from start, not 0
		int max = start, min = start;
		for(int i = start + 1; i <= end; i++){
			if(array[i] > array[max]){
				max = i;
			}
			if(array[i] < array[min]){
				min = i;
			}
		}
		MaxMin maxmin = new MaxMin(array[max], array[min]);
		return maxmin;
	}

	/**
	* find the first reversed one, direction: 0, forward, 1, backward
	* return the index
	*/
	protected int findReverse(int[] array, int dir){
		if(array == null){
			throw new IllegalArgumentException("null");
		}
		if(array.length < 2){
			return -1;
		}
		if(dir == 0){
			int i;
			for(i = 0; i + 1 < array.length; i++){
				if(array[i] > array[i + 1]){
					break;
				}
			}
			// check if sorted
			if(i == array.length){
				return -1;
			}else{
				return i;
			}
		}else{
			int i;
			for(i = array.length - 1; i - 1 >= 0; i--){
				if(array[i] < array[i - 1]){
					break;
				}
			}
			// if sorted, -1 included
			return i;
		}
	}



	public class MaxMin{
		int max;
		int min;
		public MaxMin(int max, int min){
			this.max = max;
			this.min = min;
		}
	}

	public class Result{
		public int m;
		public int n;
		public Result(int m, int n){
			this.m = m;
			this.n = n;
		}
	}
}