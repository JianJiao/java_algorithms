package treesAndGraphs;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Tests{
	public static void main(String[] args){
		Tests test = new Tests();
		test.testIsBalancedBinaray();
		// test.testHashRoute();
		test.testArrayToBianry();
		test.testListOfNodesEachDepth();
		test.testIsBST();
		test.testIsBST1();
		test.testIsBST2();
		test.testIsBST3();
		test.testNext();
	}

	public void testNext(){
		end();
		start("next");
		Next next = new Next();
		ArrayToBinary atb = new ArrayToBinary();
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		BinaryTreeNode root = atb.getTree(arr);
		System.out.println(next.next(root).item);
			// System.out.println(root.item);
			// System.out.println(root.leftChild.item);
		System.out.println(next.next(root.leftChild).item);
		System.out.println(next.next(root.rightChild).item);
		System.out.println(next.next(root.rightChild.leftChild).item);
		System.out.println(next.next(root.rightChild.leftChild.leftChild).item);
		// System.out.println(next.next(root.rightChild.rightChild).item);
		System.out.println(next.next(root.leftChild.rightChild).item);

		end();
	}

	public void testIsBST(){
		end();
		start("is BST");
		IsBinarySearchTree iBST = new IsBinarySearchTree();
		// construct BST
		ArrayToBinary atb = new ArrayToBinary();
		int[] arr = {0,1,2,6,4,5,6,7,8,9};
		BinaryTreeNode root = atb.getTree(arr);
		end();
		System.out.println(root.item);
		end();
		printTree(root);
		end();

		System.out.println(iBST.isBST(root));
		end();
	}

	public void testIsBST1(){
		end();
		start("is BST1");
		IsBinarySearchTree iBST = new IsBinarySearchTree();
		// construct BST
		ArrayToBinary atb = new ArrayToBinary();
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		BinaryTreeNode root = atb.getTree(arr);
		end();
		System.out.println(root.item);
		end();
		printTree(root);
		end();

		System.out.println(iBST.isBST1(root));
		end();
	}


	public void testIsBST2(){
		end();
		start("is BST2");
		IsBinarySearchTree iBST = new IsBinarySearchTree();
		// construct BST
		ArrayToBinary atb = new ArrayToBinary();
		int[] arr = {0,1,2,3,10,5,6,7,8,9};
		BinaryTreeNode root = atb.getTree(arr);
		end();
		System.out.println(root.item);
		end();
		printTree(root);
		end();

		System.out.println(iBST.isBST2(root));
		end();
	}

	public void testIsBST3(){
		end();
		start("is BST3");
		IsBinarySearchTree iBST = new IsBinarySearchTree();
		// construct BST
		ArrayToBinary atb = new ArrayToBinary();
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		BinaryTreeNode root = atb.getTree(arr);
		end();
		System.out.println(root.item);
		end();
		printTree(root);
		end();

		System.out.println(iBST.isBST3(root));
		end();
	}

	public void testListOfNodesEachDepth(){
		end();
		start("list of node each depth");
		ListOfNodesEachDepth lon = new ListOfNodesEachDepth();
		ArrayToBinary atb = new ArrayToBinary();
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		BinaryTreeNode root = atb.getTree(arr);
		printTree(root);
		end();
		List<LinkedList<BinaryTreeNode>> l = lon.getNodeLists(root);
		for(int i=0; i<l.size(); i++){
			LinkedList<BinaryTreeNode> ll = l.get(i);
			for(int j=0; j<ll.size(); j++){
				System.out.print(ll.get(j).item + ", ");
			}
			end();
		}
		end();


		int[] arr1 = {0,1,2,3,4,5,6,7,8,9};
		root = atb.getTree(arr1);
		printTree(root);
		end();
		List<LinkedList<BinaryTreeNode>> l1 = lon.getNodeLists1(root);
		for(int i=0; i<l1.size(); i++){
			LinkedList<BinaryTreeNode> ll1 = l1.get(i);
			for(int j=0; j<ll1.size(); j++){
				System.out.print(ll1.get(j).item + ", ");
			}
			end();
		}
		end();

	}


	public void testArrayToBianry(){
		end();
		start("array to binary");
		ArrayToBinary atb = new ArrayToBinary();
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		BinaryTreeNode root = atb.getTree(arr);
		System.out.println(root.item);
		end();
		printTree(root);
		end();



		int[] arr1 = {0,1,2,3,4,5,6,7,8,9,10};
		BinaryTreeNode root1 = atb.getTree(arr1);
		System.out.println(root1.item);
		end();
		printTree(root1);
		end();

	}

	public void printTree(BinaryTreeNode root){
		if(root == null){
			return;
		}
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		System.out.println(root.item);
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.remove();
			BinaryTreeNode left = node.leftChild;
			BinaryTreeNode right = node.rightChild;
			if(left != null){
				System.out.println(left.item);
				queue.add(left);
			}
			if(right != null){
				System.out.println(right.item);
				queue.add(right);
			}
		}
	}

	// public void testHashRoute(){
	// 	end();
	// 	start("has route");
	// 	// construct graph
	// 	List<GraphNode> l = new ArrayList<GraphNode>();
	// 	for(int i=0; i<9; i++){
	// 		l.add(new GraphNode<Integer>(i));
	// 	}
	// 	// @better: lots of repeated code here, should use
	// 	// a loop
	// 	// @note: you get the index wrong, they should start from 0(the below code)
	// 	List<GraphNode> l1 = new ArrayList<GraphNode>();
	// 	l1.add(l.get(5));
	// 	l1.add(l.get(6));
	// 	l1.add(l.get(2));
	// 	l.get(1).adjacent = l1;
	// 	List<GraphNode> l2 = new ArrayList<GraphNode>();
	// 	l2.add(l.get(3));
	// 	l.get(2).adjacent= l2;
	// 	List<GraphNode> l3 = new ArrayList<GraphNode>();
	// 	l3.add(l.get(4));
	// 	l.get(3).adjacent = l3;
	// 	List<GraphNode> l6 = new ArrayList<GraphNode>();
	// 	l6.add(l.get(7));
	// 	l.get(7).adjacent = l6;
	// 	List<GraphNode> l7 = new ArrayList<GraphNode>();
	// 	l7.add(l.get(8));
	// 	l.get(7).adjacent = l7;
	// 	List<GraphNode> l8 = new ArrayList<GraphNode>();
	// 	l8.add(l.get(3));
	// 	l.get(8).adjacent = l8;

	// 	Graph g = new Graph(l);

	// 	System.out.println(HasRoute.hasRoute(g, l.get(1), l.get(4)));
	// 	System.out.println(HasRoute.hasRoute(g, l.get(1), l.get(8)));
	// 	System.out.println(HasRoute.hasRoute(g, l.get(0), l.get(8)));



	// 	end();
	// }

	public void testIsBalancedBinaray(){
		end();
		start("is balanced binary tree");
		IsBalancedBinary ib = new IsBalancedBinary();
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> root = node;
		node = node.insertLeft(3);
		node = node.insertLeft(4);
		boolean result = IsBalancedBinary.isBalanced(root);
		System.out.println(result);

		node = new BinaryTreeNode<Integer>(4);
		root = node;
		BinaryTreeNode<Integer> left = node.insertLeft(4);
		BinaryTreeNode<Integer> right = node.insertRight(4);
		left.insertLeft(4);
		left.insertRight(4);
		right.insertRight(2);
		result = IsBalancedBinary.isBalanced(root);
		System.out.println(result);

		end();
	}







	public static void println(Object obj){
		System.out.println(obj);
	}

	public static void start(String str){
		System.out.println("***testing " + str);
	}

	public static void end(){
		System.out.println();
	}
}