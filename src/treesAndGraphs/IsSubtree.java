package treesAndGraphs;

public class IsSubtree{

	public boolean isSubtree(BinaryTreeNode root, BinaryTreeNode sub){
		// check args
		if(root == null || sub == null){
			throw new IllegalArgumentException("input cannot be null");
		}
		//  do a post-order traversal
		return traverse(root, sub);

	}

	protected boolean traverse(BinaryTreeNode node, BinaryTreeNode sub){
		// stop criteria
		if(node == null){
			return false;
		}
		// check l
		boolean resultL = traverse(node.leftChild, sub);
		if(resultL){
			return resultL;
		}
		// l, not found the subtree
		// check r
		boolean resultR = traverse(node.rightChild, sub);
		if(resultR){
			return resultR;
		}
		// r, l, not found the subtree
		// check self, is the subtree
		return checkTree(node, sub);
	}

	/**
	*	check if two trees are the same
	* + using post-order traversal
	*/
	protected boolean checkTree(BinaryTreeNode root1, BinaryTreeNode root2){
		// stop
		if(root1 == null || root2 == null){
			if(root1 == null && root2 == null){
				return true;
			}else{
				return false;
			}
		}
		if(!root1.item.equals(root2.item)){
			return false;
		}
		// root1 == root2 != null
		// check left
		boolean resultL = checkTree(root1.leftChild, root2.leftChild);
		if(!resultL){
			return false;
		}
		// check right
		boolean resultR = checkTree(root1.rightChild, root2.rightChild);
		if(!resultR){
			return false;
		}
		// left, right are equal, and self equal
		// all good
		return true;
	}

}