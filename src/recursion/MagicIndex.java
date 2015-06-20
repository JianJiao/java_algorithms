package recursion;

public class MagicIndex{


	/**
	*	return the index if found,
	* -1 if not found
	*/
	public int find(int[] arr){
		return findHelper(arr, 0, arr.length - 1);
	}

	/**
	* return the index 0-... if found
	* -1 if not found
	*/
	protected int findHelper(int[] arr, int start, int end){
		if(start > end){
			return -1;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == mid){
			// found
			return mid;
		}
		int result;
		if(arr[mid] > mid){
			// go find on left
			result = findHelper(arr, start, mid - 1);
			// @note: no no no!!! no need to test, just return directly!
			// you don't need them all, you just need one side!
			return result;
		}else{
			// go find on right
			result = findHelper(arr, mid + 1, end);
			return result;
		}
	}

	public int findWithDup(int[] arr){
		return findWithDupHelper(arr, 0);
	}

	/**
	* return -1 if not found, the index if found
	* surely can be solved using while loop
	* should ensure start < arr.length
	*/
	protected int findWithDupHelper(int[] arr, int start){
		if(start < 0 || start >= arr.length){
			return -1;
		}
		int next;
		if(arr[start] == start){
			return start;
		}else if(arr[start] > start){
			// remember to return!
			next = arr[start];
		}else{
			next = start + 1;
		}
		if(next < arr.length){
			// @note: mind the param you pass, should be start + 1, not arr[start + 1]
			// don't pass the actual element when you intend to pass the index
			return findWithDupHelper(arr, start + 1);
		}else{
			return -1;
		}
	}







}