package treesAndGraphs;

public class ArrayToBinary{

	public BinaryTreeNode<Integer> getTree(int[] arr){
		// @note: array of length 0
		if(arr == null || arr.length == 0){
			return null;
		}
		BinaryTreeNode root = getSubTree(arr, 0, arr.length-1);
		return root;
	}


	public BinaryTreeNode<Integer> getSubTree(int[] arr, int startid, int endid){
		int length = endid - startid + 1;
		int rootid = (startid + endid + 1)/2;
		BinaryTreeNode node = new BinaryTreeNode(arr[rootid]);
		if(length == 2){
			int leftid = rootid -1;
			BinaryTreeNode left = new BinaryTreeNode(arr[leftid]);
			left.parent = node;
			node.leftChild = left;
			return node;
		}else if(length == 1){
			return node;
		}
		BinaryTreeNode left = getSubTree(arr, startid, rootid-1);
		BinaryTreeNode right = getSubTree(arr, rootid+1, endid);
		node.leftChild = left;
		left.parent = node;
		node.rightChild = right;
		right.parent = node;
		return node;
	}
}