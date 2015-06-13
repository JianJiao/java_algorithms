package treesAndGraphs;

public class Next{

	/**
	*	@return the next node, null if there is no next node
	*/
	public BinaryTreeNode next(BinaryTreeNode node){
		// null
		if( node == null){
			return null;
		}
		// has right child
		if(node.rightChild != null){
			BinaryTreeNode iterator = node.rightChild;
			while(iterator.leftChild != null){
				iterator = iterator.leftChild;
			}
			return iterator;
		}
		// no right child
		BinaryTreeNode iterator = node;
		while(iterator.parent != null){
			if(iterator.parent.leftChild == iterator){
				return iterator.parent;
			}
			iterator = iterator.parent;
		}
		// no ancestor is leftChild, no left
		return null;
	}
}