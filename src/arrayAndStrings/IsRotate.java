package arrayAndStrings;

public class IsRotate{

	/**
	* this approach is smart. It is kind of mathematical.
	* Refer to the book for explanation if you forget it. 
	**/
	public boolean isRotate1(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		String s1s1 = s1 + s1;
		boolean result = isSubstring(s2, s1s1);
		return result;
	}


	public boolean isSubstring(String str, String word){
		return true;
	}

	/**
	* this one is not smart. It is kind of ugly
	**/
	public boolean isRotate(String s1,String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		char start = s1.charAt(0);
		for(int i=0; i<s2.length(); i++){
			if(s2.charAt(i) == start){
				if(isSubstring(s2.substring(i), s1)){
					String part1 = s2.substring(i);
					String part2 = s2.substring(0, i);
					StringBuilder s2n = sb.append(part1).append(part2);
					if(s2n.toString().equals(s1));
					return true;
				}else{
					return false;
				}
			}
		}
	}
}