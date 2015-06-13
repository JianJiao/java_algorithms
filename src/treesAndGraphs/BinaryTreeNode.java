package treesAndGraphs;

public class BinaryTreeNode<T>{
	protected BinaryTreeNode parent, leftChild, rightChild;
	protected T item;

	public BinaryTreeNode(T item){
		this(item, null, null, null);
	}

	public BinaryTreeNode(T item, BinaryTreeNode parent, BinaryTreeNode leftChild
		, BinaryTreeNode rightChild){
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.item = item;
	}

	public BinaryTreeNode<T> insertLeft(T item){
		BinaryTreeNode<T> node = new BinaryTreeNode<T>(item, this, null, null);
		this.leftChild = node;
		return node;
	}

	public BinaryTreeNode<T> insertRight(T item){
		BinaryTreeNode<T> node = new BinaryTreeNode<T>(item, this, null, null);
		this.rightChild = node;
		return node;
	}
}