package treesAndGraphs;
import java.util.List;

public class IsBinarySearchTree{

	/**
	* @better: in-order traversal
	* @assume: no duplicate items(or, allow to store duplicates on both left or right)
	* @note: deal with the first time initialization
	*/
	public boolean isBST1(BinaryTreeNode<Comparable> root){
		Wrapper lastItem = new Wrapper();
		lastItem.value = Integer.MIN_VALUE;
		boolean result = isBST1(root, lastItem);
		return result;
	}

	/**
	*	@note: if you wnat to pass around  a pointer to an object, the pointer cannot be null
	* Although objects are passed by reference values, null will not have a reference 
	* to it and it will simply be passed as null value.
	* @note: if you want to pass the reference to an object around while still being able to
	* use the null value, you either create a field in the class or create a wrapper class to 
	* wrap that object up
	* 	+ Integer can be passed around using pointer while int cannot, but you're gonna change 
	* 		its value in a very different way
	* 	+ If you want to use null, you can use a wrapper class to wrap Integer up;
	* @note: Integer.MIN_VALUE is an int, not Integer
	* @note: if you want to pass something aroud and see the change everywhere, create a wrapper
	* and, don't change the pointer to the wrapper, change the field of the wrapper. That way 
	* you can always points to the same wrapper and still being able to change it
	*/
	public boolean isBST1(BinaryTreeNode<Comparable> node, Wrapper lastItem){
		// if null, skip this by returning true
		if(node == null){
			// this matters, we will be catching it later
			return true;
		}
		// check left
		if(!isBST1(node.leftChild, lastItem)){
			return false;
		}
		// visit self
		// first time got here, initialize lastItem
		// since we use Integer.MIN_VALUE, we cannot use >, but >=, for the first time it might
		// equal to Integer.MIN_VALUE
		if(lastItem.value.compareTo(node.item) >= 0){
			return false;
		}
		// @note: should remember to update the iterator you pass to the call
		lastItem.value = node.item;
		// if(node.item == 6){
		// 	System.out.println("got you");
		// 	System.out.println(lastItem);
		// }
		// check right
		if(!isBST1(node.rightChild, lastItem)){
			return false;
		}
		// all goood
		return true;
	}


	protected class Wrapper{
		Comparable value;
	}

	/**
	* @better:  in-order traversal, array
	* + instead of share one value among all, you create an array to store them
	* you pass this array around and you don't change it, only pushing new items into it.
	* + Another good thing about it is that you separate the logic from the search.
	* @assuem: no duplicates or allowed to store duplicates in both directions
	*/
	public boolean isBST2(BinaryTreeNode<Comparable> root){
		List<Comparable> l = new java.util.ArrayList<Comparable>();
		isBST2(root, l);
		for(int i=1; i<l.size(); i++){
			if(l.get(i).compareTo(l.get(i-1))<=0){
				return false;
			}
		}
		return true;
	}


	/**
	*	@l: list to be changed. The method will change the list content
	*/
	public void isBST2(BinaryTreeNode<Comparable> node, List<Comparable> l){
		// when to stop: null
		if(node == null){
			return;
		}
		// check left
		isBST2(node.leftChild, l);
		// self
		l.add(node.item);
		// check right
		isBST2(node.rightChild, l);
	}

	/**
	*	@better: top-down DFS, not bottom-up. So you don't need to create extra classes 
	* for returning because you can pass more than one params
	*/
	public boolean isBST3(BinaryTreeNode<Comparable> root){
		return isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBST3(BinaryTreeNode<Comparable> node, Comparable min, Comparable max){
		// check args
		if(min == null || max == null){
			throw new IllegalArgumentException("min and max cannot be null");
		}
		// stop condition
		if(node == null){
			return true;
		}
		// check self
		if(!((min.compareTo(node.item)<=0) && (node.item.compareTo(max)<=0))){
			return false;
		}
		// check children
		if(!isBST3(node.leftChild, min, node.item) || !isBST3(node.rightChild, node.item, max)){
			return false;
		}
		// all good
		return true;
	}


	/**
	* @assume: the tree node is BinaryTreeNode<Comparable>
	* if it is not declared Comparable, you can still use the
	* method, but it is not instantiated Comparable, you will 
	* get a ClassCastException
	**/
	public boolean isBST(BinaryTreeNode<Comparable> root){
		SubTreeInfo info = getInfo(root);
		if(info == null){
			return false;
		}else{
			return true;
		}
	}


	public SubTreeInfo getInfo(BinaryTreeNode<Comparable> node){
		if(node == null){
			throw new IllegalArgumentException("node cannot be null");
		}
		SubTreeInfo info = new SubTreeInfo();
		BinaryTreeNode<Comparable> left = node.leftChild;
		BinaryTreeNode<Comparable> right = node.rightChild;
		if(left == null && right == null){
			info.min = info.max = node.item;
		}else if(left == null && right != null){
			SubTreeInfo rightInfo = getInfo(right);
			if(rightInfo == null){
				// right tree unbalanced
				return null;
			}else{
				// balanced
				if( node.item.compareTo(rightInfo.min)<=0 ){
					info.min = node.item;
					info.max = rightInfo.max;
				}else{
					return null;
				}
			}
		}else if(left !=null && right == null){
			SubTreeInfo leftInfo = getInfo(left);
			if(leftInfo == null){
				return null;
			}else{
				if(leftInfo.max.compareTo(node.item) <=0){
					info.min = leftInfo.min;
					info.max = node.item;
				}else{
					return null;
				}
			}
		}else{
			SubTreeInfo leftInfo = getInfo(left)
									,rightInfo = getInfo(right);
			if(leftInfo == null || rightInfo == null){
				return null;
			}else{
				if(leftInfo.max.compareTo(node.item) <=0 && node.item.compareTo(rightInfo.min)<=0 ){
					info.min = leftInfo.min;
					info.max = rightInfo.max;
				}else{
					return null;
				}
			}
		}
			return info;
	}




	/**
	* we could have much cleaner code if we add another field balanced
	**/
	protected class SubTreeInfo{
		protected Comparable max;
		protected Comparable min; 
	}
}