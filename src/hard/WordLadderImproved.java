package hard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderImproved{

	public ArrayList<String> getPath(String start, String end, HashSet<String> set){
		String middle = start;
		start = end;
		end = middle;
		if(set == null || set.size() < 3 || !set.contains(start) || !set.contains(end)){
			return null;
		}
		HashMap<String, String> map = new HashMap<String, String>();
		boolean find = find(start, end, set, map);
		if(find){
			ArrayList<String> list = new ArrayList<String>();
			String tmp = end;
			list.add(end);
			while(!tmp.equals(start)){
				tmp = map.get(tmp);
				list.add(tmp);
			}
			return list;
		}else{
			System.out.println("here");
			return null;
		}

	}

	protected boolean find(String start, String end, HashSet<String> set, HashMap<String, String> map){
		System.out.println(start + " " + end);
		LinkedList<String> queue = new LinkedList<String>();
		map.put(start, null);
		queue.add(start);
		while(!queue.isEmpty()){
			String first = queue.remove();
			ArrayList<String> children = getOneEditWords(first);
			for(String second : children){
				if(set.contains(second)){
					map.put(second, first);
					if(second.equals(end)){
						return true;
					}
					queue.add(second);
				}
			}
		}
		return false;
	}

	ArrayList<String> getOneEditWords(String word){
		if(word == null || word.length() == 0){
			return null;
		}
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < word.length(); i++){
			for(int j = 'a'; j <= 'z'; j++){
				// System.out.println((char)j);
				if(word.charAt(i) != j){
					// @fucking kidding me! str.length()
					// @note: should clear the sb every time if you reuse it
					// @note: cannot just replace, for it should be reused 
					StringBuilder sb = new StringBuilder(word);
					sb.setCharAt(i, (char) j);
					list.add(sb.toString());
				}
			}
		}
		// System.out.println(list);
		return list;
	}

}