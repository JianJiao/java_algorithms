package hard;
import java.util.HashMap;
import java.util.ArrayList;


public class TreeNode{
	protected char data;
	// @note: should be Character, not string
	protected HashMap<Character, TreeNode> map;
	protected ArrayList<Integer> indices;

	public TreeNode(char data){
		this.data = data;
		this.map = new HashMap<Character, TreeNode>();
		this.indices = new ArrayList<Integer>();
	}

	/**
	* @note: a good name makes things clearer: help you understand what this function does
	* add another node as the next node of this node. This should be called insertAfter, not
	* insert. Insert is from the SuffixTree's viewpoint.
	*/
	public void insertAfter(String str, int start){
		if(start == str.length()){
			return;
		}

		TreeNode next;
		if(this.map.containsKey(str.charAt(start))){
			next = this.map.get(str.charAt(start));
		}else{
			next = new TreeNode(str.charAt(start));
			this.map.put(str.charAt(start), next);
		}
		// insert to next
		next.indices.add(start);
		// go on with the substring
		next.insertAfter(str, start + 1);
	}

	/**
	* @return indices list of the last character, or null if not found
	*/
	public ArrayList<Integer> search(String str, int start){
		// stop, str end
		if(start == str.length()){
			return this.indices;
		}

		if(this.map.containsKey(str.charAt(start))){
			return this.map.get(str.charAt(start)).search(str, start + 1);
		}else{
			return null;
		}
	}





}