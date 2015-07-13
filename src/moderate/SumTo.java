package moderate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class SumTo{

	// key: number, value: list of indices
	public List<int[]> find(int[] arr, int k){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException("array cannot be null and must contain at least 2 element");
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(arr[i])){
				map.get(arr[i]).add(i);
			}else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(arr[i], list);
			}
		}
		ArrayList<int[]> results = new ArrayList<int[]>();
		// @note: no need for the <>?
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()){
			int key = iter.next();
			int target = k - key;
			if(target == key){
				List<Integer> ll = map.get(key);
				for(int i = 0; i < ll.size(); i++){
					for(int j = i + 1; j < ll.size(); j++){
						int[] result = {ll.get(i), ll.get(j)};
						results.add(result);
					}
				}
				// @note: containsKey, not contains
			}else if(map.containsKey(target)){
				List<Integer> ll1 = map.get(key);
				List<Integer> ll2 = map.get(target);
				for(Integer i : ll1){
					for(Integer j : ll2){
						int[] result = {i, j};
						results.add(result);
					}
				}
			}
			//@note: should remove this after done to avoid duplicats
			// iterator.remove();
			iter.remove();
		}
		return results;
	}
}