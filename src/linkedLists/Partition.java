package linkedLists;

public class Partition{

	/**
	*	@alternative: not stable
	* if we don't need it to be stalbe, 
	* there is a better alternative.
	**/
	public ListNode partition1(int x, ListNode head){
		if(head == null){
			return head;
		}

		ListNode nhead = null,
							node = null,
							next = null,    // @note: you will need the next poiter to update iterator
							ntail = null;

		nhead = head;
		ntail = head;
		node = head.next;
		while(node != null){
			next = node.next; 	// @note: since you will change node.next in the following code
													// you should preserve it in a variable
													// or you go to an infinite loop
			if(node.item < x){
				node.next = nhead;
				nhead = node;
			}else{
				ntail.next = node;
				ntail = node;
				// @note: you can't set it to null here
				// 1. you will need it to increase the iterator
				// 2. if the code dosen't go to the else, then you fail to 
				// set the tail
				// ntail.next = null;   // wrong!
			}
			// @note: don't forget to increase the iterator at the end of the loop
			node = next;
		}
		ntail.next = null;
		return nhead;
	}


	/**
	* partition a list around x
	* @assume: 1. item is int
	* 				 2. head to represent list
	* @return:  head of new list
	* @note: remember to initialize
	**/
	public ListNode partition(int x, ListNode head){
		if(head == null){
			return head;
		}
		ListNode head1 = null, head2 = null, 
							tail1 = null, tail2 = null, node;
		node = head;
		while(node != null){
			if(node.item < x){
				if(head1 == null){
					head1 = node;
				}else{
					tail1.next = node;
				}
				tail1 = node;
			}else{
				if(head2 == null){
					head2 = node;
				}else{
					tail2.next = node;
					tail2 = node;
				}
				tail2 = node;
			}
			node = node.next;
		}
		if(head1 == null){
			return head2;
		}else{
			tail1.next = head2;
			if(head2 != null){
				tail2.next = null;
			}
			return head1;
		}
	}
}