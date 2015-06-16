package bitManipulation;
import java.util.List;
import java.util.ArrayList;

public class FindMissing{

	/**
	*		@better: an implementation that would be easier to understand was
	*		not to create the Arr class, the array A is still an array;
	*		but to create a BitInteger class that we can only fetch a bit from at one time
	*		then each time we just pass the ArrayList of BitInteger
	*		@todo: implement the above
	*		@note: though we know the upper bound of the array, we don't know the exact size
	*		of the array, then we don't know when we should stop: how many cells of the array are
	*		not been used
	*		//@better: we actually know the *upper bound* size of each array, we don't actually 
	*							need an ArrayList
	*/

	public int findMissing(Arr arr){
		int[] bits = new int[32];
		int n = arr.length();
		ArrayList<Integer> bitsList = new ArrayList<Integer>();
		ArrayList<Integer> remainList = new ArrayList<Integer>();
		for(int i = 0; i < arr.length(); i++){
			remainList.add(i);
		}
		find(arr, remainList, bitsList, 0);
		int result = 0;
		for(int i = 0; i < bitsList.size(); i++){
			result += (bitsList.get(i) << i);
		}
		return result;
	}

	/**
	*	find the bit at digit round, place that in a list
	* @param: remainList: the list to iterate though
	*	@param: bitsList: the bits we find up till now
	* @param: round starts from 0
	*/
	protected void find(Arr arr, List<Integer> remainList, List<Integer> bitsList, int round){
		if(remainList.size() == 0){
			return;
		}
		int shouldSize = remainList.size() + 1;
		ArrayList<Integer> evenList = new ArrayList<Integer>()
												,oddList = new ArrayList<Integer>();
		for(int i = 0; i < remainList.size(); i++){
			int iterator = remainList.get(i);
			if((arr.getFrom(round, iterator) & 1) == 0){
				// even
				evenList.add(iterator);
			}else{
				// odd
				oddList.add(iterator);
			}
		}
		if((shouldSize & 1) == 0){
			// size even, should equal
			if(evenList.size() > oddList.size()){
				// miss odd, drop even
				bitsList.add(1);
				find(arr, oddList, bitsList, round + 1);
			}else{
				// miss even, drop odd
				bitsList.add(0);
				find(arr, evenList, bitsList, round + 1);
			}
		}else{
			// size odd, even should be greater than odd by one
			if(evenList.size() == oddList.size()){
				// miss even, drop odd
				bitsList.add(0);
				find(arr, evenList, bitsList, round + 1);
			}else{
				// miss odd, drop even
				bitsList.add(1);
				find(arr, oddList, bitsList, round + 1);
			}
		}
	}

	/**
	* @wrong: they didn't say the integers are placed in sorted order. 
	* 				so you don't know which index holds an even integer and which index holds an odd
	*					integer
	*	find the bit of this round, and store in ArrayList
	* round start from 0
	*/
	// protected void find(Arr arr, int n, int start, int round, ArrayList<Integer>){
	// 	int count = 0,
	// 			countEven = 0,
	// 			countOdd = 0,
	// 			countShould = 0;
	// 	for(int i = start; i < n; i += (1 << round)){
	// 		count++;
	// 		if(getFrom(round, i) == 0){
	// 			countEven++;
	// 		}else{
	// 			countOdd++;
	// 		}
	// 	}
	// 	boolean stop = if(count == 1);
	// 	countShould = count + 1;
	// 	if((countShould & 1) == 0){
	// 		// even, should equal
	// 		if(countEven > countOdd){
	// 			// missing odd, drop even
	// 			list.add(1);
	// 			if(!stop){
	// 				find(arr, n, start + (1 << round), round + 1, list);
	// 			}
	// 		}else{
	// 			// missing even, drop odd
	// 			list.add(0);
	// 			if(!stop){
	// 				find(arr, n, start, 
	// 			}
	// 		}
	// 	}
	// }
}