package treesAndGraphs;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ListOfNodesEachDepth{

	/**
	* @todo: implement a DFS version of this problem
	**/



	/**
	* @better: since we already have a queue(the LinkedList) for each level, 
	* we don't have to maintain another queue for the whole
	**/
	public List<LinkedList<BinaryTreeNode>> getNodeLists1(BinaryTreeNode root){
		List<LinkedList<BinaryTreeNode>> l = new ArrayList<LinkedList<BinaryTreeNode>>();
		LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
		if(root == null){
			return null;
		}
		ll.add(root);
		l.add(ll);
		while(!ll.isEmpty()){
			LinkedList<BinaryTreeNode> children = new LinkedList<BinaryTreeNode>();
			for(int i=0; i<ll.size(); i++){
				BinaryTreeNode parent = ll.get(i);
				if(parent.leftChild!=null){
					children.add(parent.leftChild);
				}
				if(parent.rightChild!=null){
					children.add(parent.rightChild);
				}
			}

			if(!children.isEmpty()){
				l.add(children);
			}
			ll = children;
		}
		return l;
	}


	/**
	* traditional BFS: not necessary
	*/
	// we could usually skip the Integer parameter part of the generic type
	public List<LinkedList<BinaryTreeNode>> getNodeLists(BinaryTreeNode root){
		if(root == null){
			return null;
		}
		List<LinkedList<BinaryTreeNode>> l = new ArrayList<LinkedList<BinaryTreeNode>>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		// construct level list, add elems to it
		LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
		ll.add(root);
		queue.add(root);
		// level list end
		queue.add(null);
		l.add(ll);
		ll = new LinkedList<BinaryTreeNode>();

		while(!queue.isEmpty()){

			BinaryTreeNode node = queue.remove();
			if(node == null){
				if(!queue.isEmpty()){
					queue.add(null);
					l.add(ll);
					ll = new LinkedList<BinaryTreeNode>();
				}
				continue;
			}

			BinaryTreeNode left = node.leftChild, right = node.rightChild;
			if(left!=null){
				ll.add(left);
				queue.add(left);
			}
			if(right != null){
				ll.add(right);
				queue.add(right);
			}
		}
		return l;
	}
}