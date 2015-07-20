package hard;
import java.util.ArrayList;

public class SuffixTree{

	protected TreeNode root = new TreeNode('\0');


	public SuffixTree(String str){
		if(str == null){
			throw new IllegalArgumentException();
		}
		// @note: str.length() is method! str is obj!
		if(str.length() == 0){
			return;
		}
		// @note: should have a loop and insert all substrings!
		for(int i = 0; i < str.length(); i++){
			this.root.insertAfter(str, i);
		}
	}

	public ArrayList<Integer> search(String str){
		if(str == null || str.length() == 0){
			throw new IllegalArgumentException();
		}
		return this.root.search(str, 0);
		//@note: @todo: return

	}


}