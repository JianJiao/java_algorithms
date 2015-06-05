package linkedLists;

public class RemoveNode{


	/**
	* remove the node from the linked list
	* @assume: node is in the middle of the list
	* I would note recommend this method, since 
	* it is not well encapsulated and is a lazy operation. 
	* It might break the the code using the linked list 
	**/
	public void remove(ListNode n){
		// @note: the order of the two statements 
		// is very important
		// @note: should still check first if it is in the 
		// middle of the list
		n.item = n.next.item;
		n.next = n.next.next;
	}
}