package arrayAndStrings;

public class Compression{


	public String compress1(String str){
		// get the count array for each new char
		// here we sacrafice some space assuming the str is not too long		
		int[] count = new int[str.length()];
		int j=0;
		count[j] = 1;
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) == str.charAt(i-1)){
				count[j]++;
			}else{
				j++;
				count[j] = 1;
			}
		}
		// get the size of the new chars, the scan array
		int size;
		for( size=0; size<count.length; size++){
			if(count[size] == 0){
				break;
			}
		}
		// construct the scan array
		int[] scan = new int[size];
		scan[0] = 0;
		for(int i=1; i<scan.length; i++){
			scan[i] = scan[i-1] + count[i-1];
		}
		// construct the string
		// StringBuilder is a faster way of doing this, 
		// but you can do without it. You can get the length of the 
		// final string first and then construct a char[] to store the string, 
		// then place each char(find the char via scan[i]) and its count(count[i]) 
		// in the appropriate place(increase pointer when you set each element in 
		// the char[] array in the char[]
		StringBuilder sb = new StringBuilder();;
		for(int i=0; i< scan.length; i++){
			sb.append(str.charAt(scan[i]));
			sb.append(Integer.toString(count[i])); 	// @better: can use: sb.append(count[i]);
		};
		if(sb.length() < str.length()){
			return sb.toString();
		}else{
			return str;
		}

	}

	/**
	* this solution is wrong:
	* 1. it changes the order of the characters
	* 2. if two characters are not adjacent, they shouldn't be put together
	* 3. use char[] to construct the string is tedious, might consider using
	* 	StringBuilder
	**/
	public String compress(String str){
		// count in each bucket
		int[] buckets = new int[128];
		for(int i=0; i<str.length(); i++){
			buckets[str.charAt(i)]++;
		}
		// get total count
		int newLength = 0;
		for(int i=0; i<128; i++){
			if(buckets[i]!=0){
				int size = Integer.toString(buckets[i]).length();
				newLength += size+1;
			}
		}
		if(newLength > str.length()){
			return str;
		}else{
			// convert each not null bucket to char in the array
			int j=0;
			char[] contents = new char[newLength];
			for(int i=0; i<128; i++){
				if(buckets[i]!=0){
					char[] count = Integer.toString(buckets[i]).toCharArray();
					contents[j] = (char) i;
					for(int m=0; m<count.length; m++){
						contents[j+m+1] = count[m];
					}
					j += count.length+1;
				}
			}
			return new String(contents);
		}
	}
}