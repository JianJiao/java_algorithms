package moderate;

public class Convert{

	public BiNode convert(BiNode root){
		if(root == null){
			return null;
		}
		// System.out.println(root.data);
		Result result = convertHelper(root);
		// System.out.println(result.min.node2);
		return result.min;
	}

	/**
	*/
	protected Result convertHelper(BiNode node){
		if(node == null){
			return new Result(null, null);
		}
		Result leftReturn = convertHelper(node.node1);
		Result rightReturn = convertHelper(node.node2);
		// @note: doubly linked list, should modify both pointers
		node.node1 = leftReturn.max;
		if(node.node1 != null){
			node.node1.node2 = node;
		}
		node.node2 = rightReturn.min;
		if(node.node2 != null){
			node.node2.node1 = node;
		}
		BiNode max = rightReturn.max != null ? rightReturn.max : node;
		BiNode min = leftReturn.min != null ? leftReturn.min : node;
		return new Result(max, min);
	}

	protected class Result{
		BiNode max;
		BiNode min;
		public Result(BiNode max, BiNode min){
			this.max = max;
			this.min = min;
		}
	}
}