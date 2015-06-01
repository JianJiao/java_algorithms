package arrayAndStrings;

// hashtable, bucket sort, counting sort
// ASCII and unicode character int range

public class UniqueCharacter{

	public boolean allUnique1(String str){
		boolean result = true; 
		if(str.length()>128){
			result = false;
		}else{
			boolean buckets[] = new boolean[128];
			for(int i=0; i<str.length(); i++){
				if(buckets[str.charAt(i)] == true){
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