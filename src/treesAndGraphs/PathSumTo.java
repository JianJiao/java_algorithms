package treesAndGraphs;

public class PathSumTo{

	/**
	*	@better: could use an array to hold the path from root to any element, or to 
	* each leaf. Then you can just deal with the array. It would be a lot easier to 
	* iterate through an array than iteratte through the tree: you can start anywhere, 
	* go in any direction, even skip elements.
	* With array, there are still two ways to do it:
	*		+ get arrays from root to each leaf, then do things on the whole array
	* 	+ keep an array from root to each node as you go, and iterate immediately 
	*			in that node.
	*	These two are essentially the same. I prefer the first one.
	*/
	public void pathSumTo1(int k, BinaryTreeNode<Integer> node){
		if(node == null){
			return;
		}
		// get depth
		int depth = depth(node, 0);
		int[] arr = new int[depth+1];
		traverse(k, node, arr, 0);
	}

	/**
	*	@param: level starts from 0
	*/
	protected void traverse(int k, BinaryTreeNode<Integer> node, int[] arr, int level){
		//check arg
		if(node == null){
			// @note: exception should be newed!
			throw new IllegalArgumentException("tree node cannot be null");
		}
		// stop and visit
		arr[level] = node.item;
		// @note:@change: should be &&, not ||
		if(node.leftChild == null && node.rightChild == null){
			// manipulate array index from 0 to level inclusive
			visit(arr, level, k);
		}
		// rec left
		if(node.leftChild != null){
			traverse(k, node.leftChild, arr, level + 1);
		}
		if(node.rightChild != null){
			traverse(k, node.rightChild, arr, level + 1);
		}
	}


	protected void visit(int[] arr, int level, int k){
		int sum = 0;
		for(int i=0; i<= level; i++){
			for(int j=i; j<=level; j++){
				sum += arr[j];
				if(sum == k){
					printPath(arr, i, j);
				}
			}
		}

	}

	protected void printPath(int[] arr, int i, int j){
		System.out.println("path:");
		for(int k=i; k<=j; k++){
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}



	/**
	* depth of a tree, starting from 0
	*/
	protected int depth(BinaryTreeNode node, int depth){
		// stop
		if(node == null){
			return depth-1;
		}
		int left = depth(node.leftChild, depth+1);
		int right = depth(node.rightChild, depth+1);
		return Math.max(left, right);
	}


	/**
	*	@assume: k >= 0;
	*						+ when you cannot have an array to hold elements, this one works
	*						+ but it will print elements in reverse order
	*						+ need modification if k is integer, not positive integer
	* @note: if k >=0, and all numbers stored in nodes >=0, then 
	* 				a bottom-up approach would be better, it consumes much less time
	*					+ but if k is just integer, positive or negative. Then you could use
	* 					both top-down and bottom-up, because you have to iterate through 
	*						every possible paths
	*/
	public void pathSumTo(int k, BinaryTreeNode<Integer> node){
		// stop
		if(node == null){
			return;
		}
		// visit self
		if(visit(k, node)){
			System.out.println();
		}
		// rec left
		pathSumTo(k, node.leftChild);
		// rec right
		pathSumTo(k, node.rightChild);
	}


	public boolean visit(int k, BinaryTreeNode<Integer> node){
		// stop and check self
		// should check null
		if(node == null){
			return false;
		}
		if(node.item > k){
			return false;
		}
		if(node.item == k){
			System.out.println(k);
			return true;
		}
		// @note: only three possibilities here, no need to add another if
		// plus, it is not valid syntax
		// check left
		if(visit(k - node.item, node.leftChild)){
			System.out.println(node.item);
			return true;
		}
		// check right
		if(visit(k - node.item, node.rightChild)){
			System.out.println(node.item);
			return true;
		}
		return false;
	}




}