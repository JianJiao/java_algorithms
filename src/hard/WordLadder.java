package hard;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;

public class WordLadder{


	public ArrayList<String> getPath(String start, String end, HashSet<String> set){
		// change start and end here or write a wrapper class
		if(set == null || set.size() == 0 || !set.contains(start) || !set.contains(end)){
			throw new IllegalArgumentException();
		}
		HashMap<String, String> map = new HashMap<String, String>();
		LinkedList<String> queue = new LinkedList<String>();
		boolean findit = find(start, end, set, map, queue);
		if(findit){
			ArrayList<String> list = new ArrayList<String>();
			list.add(end);
			String tmp = map.get(end);
			list.add(tmp);
			while(!tmp.equals(start)){
				tmp = map.get(tmp);
				// @note: should update inside the loop also!
				list.add(tmp);
			}
			return list;
		}else{
			return null;
		}
	}

	protected boolean find(String start, String end, HashSet<String> set, HashMap<String, String> map, 
		LinkedList<String> queue){
		map.put(start, null);
		queue.add(start);
		// @note: the method is isEmpty()
		while(!queue.isEmpty()){
			String first = queue.remove();
			// @note: iterating through the set is not the best way. Just focus on the word
			// itself and you can get all one-edit-away words
			for(String second : set){
				if(!map.containsKey(second)){
					if(canConnect(first, second)){
						map.put(second, first);
						if(second.equals(end)){
							return true;
						}
						queue.add(second);
					}
				}
			}
		}
			return false;
	}

	protected boolean canConnect(String a, String b){
		// @note: a.length()! are you fucking kidding me?
		if(a == null || b == null || a.length() != b.length()){
			throw new IllegalArgumentException();
		}
		int count = 0;
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i) != b.charAt(i)){
				count++;
			}
		}
		if(count == 1){
			return true;
		}else{
			return false;
		}
	}
}