package treesAndQueues;

public class CommonAncestor{



	// @todo: needs to be tested
	// @note: one other case: p == q
	public BinaryTreeNode commonAnce(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q){
		if(root == null || p == null || q == null){
			return null;
		}
		// first check if p and q are both in the tree
		if(!hasNode(root, p) || !hasNode(root, q)){
			return null;
		}
		return BinaryTreeNode result = common(root, p, q);
	}

	protected boolean hasNode(BinaryTreeNode node, BinaryTreeNode root){
		if(node == null || root == null){
			return false;
		}
		// visit left recursively
		boolean leftR = hasNode(node, node.leftChild);
		if(leftR == true){
			return true;
		}
		// visit right recursively
		boolean rightR = hasNode(node, node.rightChild);
		if(rightR == true){
			return true;
		}
		// visit self: the first actual execution of visit here
		if(node == root){
			return true;
		}
		return false;
	}

	/**
	*	@return: common if found, p or q if only one inside, null if none of them found
	*/
	public BinaryTreeNode common(BinaryTreeNode node, BinaryTreeNode p, BinaryTreeNode q){
		if(node == null){
			return null;
		}

		BinaryTreeNode leftResult = common(node.leftChild, p, q);
		// if found on right
		if(leftResult != p && leftResult !=q && leftResult != null){
			return leftResult;
		}
		// if found on right
		BinaryTreeNode rightResult = common(node.rightChild, p, q);
		if(rightResult !=p && rightResult != q && rightResult != null){
			return rightResult;
		}
		// common not found on both, then p, q not in same branch
		// then if found both p, q amoung left, right, or this, this node is common
		if((leftResult == p && (node == q || rightResult == q)) 
			|| (node == p && (leftResult == q || rightResult == q))
			|| (rightResult == p && (leftResult == q || rightResult == q))){
			return node;
		}

		// common not found on left, right, this
		// then if p or q found, return it
		if(leftResult == p || rightResult == p || node == p){
			return p;
		}
		if(leftResult == q || leftResult == q  || node == q){
			return q;
		}

		// both p, q not found on left, right, this
		return null;

	}
}

