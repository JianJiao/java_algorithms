package arrayAndStrings;

public class Test{
	
	public static void main(String args[]){
		UniqueCharacter uniq = new UniqueCharacter();
		String strs[] = new String[4];
		strs[0]= "not aaa";
		strs[1] = "lalalak";
		strs[2] = "klab";
		strs[3] = " what  ";
		for(int i=0; i<4; i++){
			boolean result = uniq.allUnique1(strs[i]);
			System.out.println(result);
		}
	}
}