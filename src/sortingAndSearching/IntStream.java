package sortingAndSearching;

import java.util.LinkedList;
import java.util.HashMap;

public class IntStream{
	LinkedList<Integer> list = new LinkedList<Integer>();
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	// @note: has to have a return type
	public void track(int x){
		int i;
		for(i = 0; i < this.list.size(); i++){
			if(list.get(i) > x){
				break;
			}
		}
		int rank;
		// @note: because we access i - 1, we must check the boundary
		if(i == 0){
			rank = 0;
		}else{
			rank = map.get(list.get(i - 1)) + 1;
		}
		list.add(i, x);
		map.put(x, rank);
		// @note: update all numbers later in the linkedlist
		// @note: in this case, it's better to start backwards, so you save some time: you 
		// don't change the whole list each time
		for(int j = i + 1; j < list.size(); j++){
			map.put(list.get(j), map.get(list.get(j)) + 1);
		}
	}

	public int getRankOfNumber(int x){
		if(map.containsKey(x)){
			return map.get(x);
		}else{
			return 0;
		}
	}

}