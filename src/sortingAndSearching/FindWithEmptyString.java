package sortingAndSearching;

public class FindWithEmptyString{

	public int find(String str, String[] strs){
		if(str == null || strs == null){
			return -1;
		}
		return findHelper(str, strs, 0, strs.length);
	}


	protected int findHelper(String str, String[] strs, int start, int end){
		if(str == null){
			return -1;
		}
		if(start == end){
			return -1;
		}

		int middle = (start + end) / 2;

		if(strs[middle] != ""){
			if(str.compareTo(strs[middle]) == 0){
				return middle;
			}else if(str.compareTo(strs[middle]) < 0){
				return findHelper(str, strs, start, middle);
			}else{
				return findHelper(str, strs, middle + 1, end);
			}
		}else{
			int leftResult = findHelper(str, strs, start, middle);
			if(leftResult >=0){
				return leftResult;
			}
			return findHelper(str, strs, middle + 1, end);
		}
	}
}