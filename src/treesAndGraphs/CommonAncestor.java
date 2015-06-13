package treesAndGraphs;

public class CommonAncestor{


	/**
	*	@better: a yet simpler version: 
	* 	+ use ? : more
	* 	+ check for null instead of deciding p or q one by one
	*/
	public BinaryTreeNode commonAnce1(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q){
		if(root == null || p == null || q == null){
			return null;
		}
		boolean resultL = hasNode(p, root);
		boolean resultR = hasNode(q, root);
		if(!resultL|| !resultR){
			return null;
		}
		return common1(root, p, q);

	}

	public BinaryTreeNode common1(BinaryTreeNode node, BinaryTreeNode p, BinaryTreeNode q){
		if(p == null || q == null){
			throw new IllegalArgumentException("p and q cannot be null");
		}
		// stop creteria
		if(node == null){
			return null;
		}
		// check left
		BinaryTreeNode left = common1(node.leftChild, p, q);
		// short circuit to save time, this is not logically necessary
		if( left!= null && left != p && left != q){
			return left;
		}
		// check right 
		BinaryTreeNode right = common1(node.rightChild, p, q);
		if(right != null && right != p && right != q){
			return right;
		}
		// check self, found p, q on diff br
		if(left != null && right != null){
			return node;
		}
		// not on diff br,  then found p or q on this
		if(node == p || node == q){
			return node;
		}
		// not found on this, then if nothing found on left, right
		if(left == null && right == null){
			return null;
		}
		// at least one br found sth
		// then return that
		return left == null ? right : left;
	}



	// @todo: needs to be tested
	// @note: one other case: p == q
	public BinaryTreeNode commonAnce(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q){
		if(root == null || p == null || q == null){
			return null;
		}
		// first check if p and q are both in the tree
		// @note: the sequnce of params conform the the signature of the method
		if(!hasNode(p, root) || !hasNode(q , root)){
			System.out.println("not");
			return null;
		}
		return common(root, p, q);
	}

	protected boolean hasNode(BinaryTreeNode node, BinaryTreeNode root){
		if(node == null || root == null){
			return false;
		}
		// visit left recursively
		boolean leftR = hasNode(node, root.leftChild);
		if(leftR == true){
			return true;
		}
		// visit right recursively
		boolean rightR = hasNode(node, root.rightChild);
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

