package sortingAndSearching;

public class SearchRoatedSorted{

	/**
	* @note: @wrong: still problematic: duplicates! The separater has duplicates! --> search both sides
	* find the index of k in arr
	*/
	public int find(int[] arr, int k){
		if(arr == null || arr.length == 0){
			return -1;
		}
		int middleElement = arr[arr.length - 1];
		if(k == middleElement){
			return arr.length - 1;
		}
		if(k > middleElement){
			return searchLarger(arr, 0, arr.length - 1, middleElement, k);
		}else{
			return searchSmaller(arr, 0, arr.length - 1, middleElement, k);
		}

	}

	protected int searchLarger(int[] arr, int start, int end, int middleElement, int k){
		if(arr == null){
			return -1;
		}
		if(start == end){
			return -1;
		}

		int middle = (start + end) / 2;
		if(arr[middle] < middleElement){
			return searchLarger(arr, start, middle, middleElement, k);
		}else{
			if(arr[middle] == k){
				return middle;
			}else if(k < arr[middle]){
				return searchLarger(arr, start, middle, middleElement, k);
			}else{
				return searchLarger(arr, middle + 1, end, middleElement, k);
			}
		}
	}

	protected int searchSmaller(int[] arr, int start, int end, int middleElement, int k){
		if(arr == null){
			return -1;
		}
		if(start == end){
			return -1;
		}

		int middle = (start + end) / 2;
		if(arr[middle] > middleElement){
			return searchSmaller(arr, middle + 1, end, middleElement, k);
		}else{
			if(k == arr[middle]){
				return middle;
			}else if(k < arr[middle]){
				return searchSmaller(arr, start, middle, middleElement, k);
			}else{
				return searchSmaller(arr, middle + 1, end, middleElement, k);
			}

		}
	}

	protected int binarySearch(int[] arr, int start, int end, int k){
		// check args 
		if(arr == null){
			return -1;
		}
		// @todo: stop: 
		if(start == end){
			return -1;
		}

		// should compare with middle and decide which side to go next, diff from traditional 
		// recursion
		int middle = (start + end) / 2;
		if(arr[middle] == k){
			return middle;
		}else if(arr[middle] > k){
			return binarySearch(arr, start, middle, k);
		}else{
			return binarySearch(arr, middle + 1, end, k);
		}
	}
}