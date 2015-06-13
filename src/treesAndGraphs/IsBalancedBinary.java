package treesAndGraphs;

public class IsBalancedBinary{
	
	public static boolean isBalanced(BinaryTreeNode root){
		int height = getHeight(root);
		if(height == -2){
			return false;
		}else if(height == -1){
			throw new IllegalArgumentException("root is null");
		}else{
			return true;
		}
	}

	/**
	* @return the height of the subtree from the node, or -2 if
	* it is not balanced. Return -1 if the tree is null. 
	*/
	protected static int getHeight(BinaryTreeNode node){
		// if null, return -1
		if(node == null){
			return -1;
		}
		// if not null, get height of its children
		int left = getHeight(node.leftChild);
		int right = getHeight(node.rightChild);
		// if any of them is unbalanced, this tree itself is unbalanced
		// return -2 for unbalanced
		// @note: the `==` and `=`!
		// @better: it is better to separate them and place left above,
		// thus you don't need to go through all the right children of it
		if(left == -2 || right == -2){
			return -2;
		}

		// if children are balanced, compare them
		// unbalanced, return -2
		if(Math.abs(left - right)>1){
			return -2;
		}
		// balanced, return height
		return (Math.max(left, right) + 1);
	}
	
}