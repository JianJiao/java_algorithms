package hard;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Longest{
	public String longest(String[] strs){
		if(strs == null || strs.length < 3){
			return null;
		}
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		Arrays.sort(strs, new StringComparator());
		HashSet<String> set = new HashSet<String>(Arrays.asList(strs));
		// @note: reversed order
		// @note: might have some minor problem is the array only contains word of length 1
		for(int i = strs.length - 1; i >= 0; i--){
			if(valid(set, strs[i], map)){
				return strs[i];
			}
		}
		return null;
	}

	/**
	* @note: need to include <>
	*/
	public class StringComparator implements Comparator<String>{
		public int compare(String a, String b){
			// @note: string.length() is a method!
			int la = a.length();
			int lb = b.length();
			return la - lb;
		}
	}

	protected boolean valid(HashSet<String> set, String str, HashMap<String, Boolean> map){
		//
		if(map.containsKey(str)){
			return map.get(str);
		}
		if(set.contains(str)){
			map.put(str, true);
			return true;
		}
		for(int i = 0; i < str.length() - 1; i++){
			String left = str.substring(0, i + 1);
			String right = str.substring(i + 1, str.length());
			if(set.contains(left) && valid(set, right, map)){
				map.put(str, true);
				return true;
			}
		}
		map.put(str, false);
		return false;
	}
}