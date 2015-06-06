package linkedLists;

public class Addition{

	/**
	* @assume: number stored in forward order
	**/
	public ListNode addForward(ListNode n1, ListNode n2){
		n1 = reverseList(n1);
		n2 = reverseList(n2);
		ListNode result = add(n1, n2);
		result = reverseList(result);

		// restore the input objects
		n1 = reverseList(n1);
		n2 = reverseList(n2);

		return result;
	}

	public ListNode reverseList(ListNode n){
		if(n == null){
			return null;
		}
		ListNode prev = null
						,cur = n
						,next = null;

		while(cur!=null){
			// change next pointer
			next = cur.next;
			cur.next = prev;

			// update iterator
			prev = cur;
			cur = next;
		}

		return prev;
	}


	/**
	* @better: 1. tertiary operation
	* 2. use recursion to solve the problem
	**/
	public ListNode add1(ListNode n1, ListNode n2){
		return add1(n1, n2, 0);
	}

	/**
	* overload the method for a better external interface
	**/
	public ListNode add1(ListNode n1, ListNode n2, int offset){

		if(n1 == null && n2 == null){
			// @note: when offset is not 0, you still return a new node
			if(offset == 0){
				return null;
			}else{
				return new ListNode(1, null);
			}
		}
		ListNode node = new ListNode(0, null);
		int value = (n1 == null ? 0 : n1.item) + (n2 == null ? 0 : n2.item) + offset;
		// @note the sequence of the following two statements
		offset = (value < 10 ? 0 : 1);
		value = value % 10;
		node.item = value;
		node.next = add1((n1 == null ? null : n1.next), (n2 == null ? null : n2.next), offset);
		return node;
	}


	/**
	* @assume: radix is 10
	* every node.item is in [0, 9]
	* number stored in reverse order
	* @note: you can do it recursively,
	* and that would be much easier to do
	* @note: linked list can often be solved 
	* using recursion
	**/
	public ListNode add(ListNode n1, ListNode n2){
		if(n1 == null){
			return n2;
		}
		if(n2 == null){
			return n1;
		}

		ListNode sumNode = new ListNode(0, null);
		ListNode prev = null,
							head = sumNode;
		int value = 0, offset = 0;

		while(!(n1 == null && n2 == null)){
			// if one of the node is null
			if(n1 == null){
				n1 = sumNode;
			}
			if(n2 == null){
				n2 = sumNode;
			}

			value = n1.item + n2.item + offset;
			if(value >= 10){
				sumNode.item = value -10;
				offset = 1;
			}else{
				sumNode.item = value;
				offset = 0;
			}
			n1 = n1.next;
			n2 = n2.next;
			sumNode.next = new ListNode(0, null);
			prev = sumNode;
			sumNode = sumNode.next;
		}
		if(offset == 1){
			sumNode.item = 1;
		}else{
			prev.next = null;
		}
		return head;
	}
}