package arrayAndStrings;

public class Permutation{
	// assuming all strings are ascii encoded   better if you use 256-- extended ascii
	// should you test null pointer?
	public boolean isPermutation(String str1, String str2){
		if(str1!=null&&str2!=null){
			if(str1.length() != str2.length()){
				return false;
			}
			int buckets1[] = new int[128];
			int buckets2[] = new int[128];
			counting(str1, buckets1);
			counting(str2, buckets2);
			for(int i=0; i<128; i++){
				if(buckets1[i] != buckets2[i]){
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
	}

	public boolean isPermutation1(String str1, String str2){
		// assuming they are not null
		if(str1.length()!=str2.length()){
			return false;
		}
		str1 = sort(str1);
		str2 = sort(str2);
		if(str1.equals(str2)){
			return true;
		}else{
			return false;
		}
	}

	public String sort(String str){
		char[] chars = str.toCharArray();
		java.util.Arrays.sort(chars);
		return new String(chars);
	}

	public void counting(String str, int buckets[]){
		for(int i=0; i<str.length(); i++){
			buckets[str.charAt(i)]++;
		}
	}
}










