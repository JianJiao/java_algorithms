package linkedLists;

public class Palindrome{

	/**
	* use stack and runner to solve the problem
	* @better: 1. stack
	* 				2. runner that can find the middle of the list
	**/
	public boolean isPalindrome1(ListNode node){
		// return true if it's null
		if(node == null){
			return true;
		}

		ListNode slower = node;
		ListNode faster = node;
		ListNode second = null;
		// pop into stack and find middle
		Stack stack = new Stack();
		while(faster.next != null && faster.next.next != null){
			stack.push(slower);

			slower = slower.next;
			faster = faster.next.next;
		}

		// head of the second half
		second = slower.next;

		// deal with even
		if(faster.next != null){
			stack.push(slower);
		}

		// construct the reversed first half list
		ListNode head = (ListNode) stack.pop();
		ListNode n= head;
		int count = 0;
		if(n == null){
			return true;
		}
		// @note: here n could be null, n.next would cost nullpointerexcetion
		// combine with the above code
		do{
			n.next = (ListNode) stack.pop();
			n = n.next;
			count++;
		}while(n != null);



		// compare the first half and the second half
		for(int i=0; i<count; i++){
			if(head.item != second.item){
				return false;
			}
		}
		return true;
	}

	/**
	* simple way: reverse and compare and reverse back
	**/
	public boolean isPalindrome(ListNode node){
		ListNode reversed = reverse(node);
		ListNode reversedHead = reversed;
		// @better: actually you only need to compare the first half 
		// of the list!
		while(node != null){
			if(node.item != reversed.item){
				reverse(reversedHead);
				return false;
			}
			node = node.next;
			reversed = reversed.next;
		}
		reverse(reversedHead);
		return true;
	}

	/**
	* construct a new linked list, keep the original one intact
	* @return: new linked list
	**/
	public ListNode reverse(ListNode head){
		if(head == null){
			return null;
		}
		ListNode node = new ListNode(head.item, null);
		head = head.next;
		while(head != null){
			node = new ListNode(head.item, node);
			head = head.next;
		}
		return node;
	}

	/**
	* @note:
	* the reverse method should not change the original one,
	* or you have nothing to compare with
	* so this one is not right in this scenario, which changed the original list
	**/
	public ListNode reverseWrong(ListNode node){
		if(node == null){
			return node;
		}
		ListNode prev = null
						,next = null;
		while(node != null){
			next = node.next;
			node.next = prev;

			// @note: !!! the sequence of the two lines
			// when you update a variable, make sure you don't use it 
			// later!!!
			prev = node;
			node = next;
		}
		return prev;
	}


}