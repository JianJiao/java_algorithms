package recursion;
import java.util.List;
import java.util.ArrayList;


public class Permutation{

	/**
	* @assume: string chars are all unique
	*/
	public List<String> permutation(String str){
		if(str == null){
			return null;
		}
		StringBuilder sb = new StringBuilder(str);
		List<StringBuilder> l = permutationHelper(sb);
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < l.size(); i++){
			String iter = l.get(i).toString();
			result.add(iter);
		}
		return result;
	}

	protected List<StringBuilder> permutationHelper(StringBuilder sb){
		// check args should put null into this
		if(sb == null){
			return null;
		}
		List<StringBuilder> l = new ArrayList<StringBuilder>();
		if(sb.length() == 0){
			StringBuilder newSb = new StringBuilder();
			l.add(newSb);
			return l;
		}
		// detach each one
		int len = sb.length();
		for(int i = 0; i < len; i++){
			// get a char as the last char and then delete it
			char last = sb.charAt(i);
			sb.deleteCharAt(i);
			// get permu from the remaining
			List<StringBuilder> subPermu = permutationHelper(sb);
			// prepend the char back
			for(int j = 0; j < subPermu.size(); j++){
				subPermu.get(j).insert(0, last);
			}
			// add the subpermu list to the whole list
			l.addAll(subPermu);
			sb.insert(i, last);
		}
		return l;
	}
}