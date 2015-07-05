package sortingAndSearching;
import java.util.Comparator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;


/**
* @note: both hashtable and hashMap don't allow duplicates
*/

public class GroupAnagram{


	public void sort(String[] strs){
		Arrays.sort(strs, new StringComparator());
	}


	protected class StringComparator implements Comparator<String>{
		public int compare(String str1, String str2){
			String key1 = getKey(str1);
			String key2 = getKey(str2);
			return key1.compareTo(key2);
		}
	}


	public void group(String[] strs){
		if(strs == null){
			return;
		}

		// get key, put into map
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for(int i = 0; i < strs.length; i++){
			String key = getKey(strs[i]);
			LinkedList<String> list = map.get(key);
			if(list == null){
				list = new LinkedList<String>();
				map.put(key, list);
			}
			list.add(strs[i]);
		}

		// get outof map, put into the array
		int i = 0;
		for(String key : map.keySet()){
			LinkedList<String> list = map.get(key);
			if(list != null){
				for(int j = 0; j < list.size(); j++){
					strs[i] = list.get(j);
					i++;
				}
			}
		}
	}


	protected String getKey(String str){
		if(str == null){
			return null;
		}
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}
}