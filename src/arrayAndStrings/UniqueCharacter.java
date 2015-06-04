package arrayAndStrings;

// hashtable, bucket sort, counting sort
// ASCII and unicode character int range   -- may extend to 256 for extended ascii

public class UniqueCharacter{

	/**
	* this is not very useful since it assumes:
	* 1. only a -- z: 26 character
	* 2. use int to store boolean to save up space: really need that space
	**/
	public boolean allUnique2(String str){
		if(str.length()>26){
			return false;
		}
		int buckets = 0;
		for(int i=0; i<str.length(); i++){
			int idx= str.charAt(i) - 'a';
			if((buckets & (1<<idx)) >0){
				return false;
			}
			buckets |= 1<<idx;
		}
		return true;
	}




	public boolean allUnique1(String str){
		boolean result = true; 
		if(str.length()>128){
			result = false;
		}else{
			boolean buckets[] = new boolean[128];
			for(int i=0; i<str.length(); i++){
				if(buckets[str.charAt(i)] == true){ 
					// @change: if(buckets[str.charAt(i)]){...} much simpler
					result = false;
					return result;
				}else{
					buckets[str.charAt(i)] = true;
				}
			}
		}
		return result;
	}


	public boolean allUnique(String str){
		boolean result = true;
		for(int i=0; i<str.length(); i++){
			for(int j=i+1; j<str.length(); j++){
				if(str.charAt(i) == str.charAt(j)){
					result = false;
					return result;
				}
			}
		}
		return result;
	}

	public static void main(String args[]){
		UniqueCharacter uniq = new UniqueCharacter();
		boolean result;
		result = uniq.allUnique("lahlala");
		System.out.println(result);

	}
}