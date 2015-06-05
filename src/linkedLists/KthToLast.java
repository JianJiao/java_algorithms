package linkedLists;

public class KthToLast{

	/**
	* @better: a single loop instead of two loops
	*  + use a runner
	**/
	public ListNode kthToLast1(int k, ListNode head){
		if(head == null){
			return null;
		}
		ListNode faster = head,
						 slower = head;
		// return null if length < k
		for(int i=0; i<2; i++){
			faster = faster.next;
			if(faster == null){
				return null;
			}
		}

		// run until faster hit the last node
		while(faster.next != null){
			faster = faster.next;
			slower = slower.next;
		}
		return slower;
	}



	/**
	* return the kth element to the last of the list
	* k = 1, the tail
	**/
	public ListNode kthToLast(int k, ListNode head){
		int l = 0;
		ListNode node = head;
		while(node != null){
			l++;
			node = node.next;
		}
		//  get the tth from first
		int t = l - k + 1;
		if(t < 0){
			return null;
		}
		node = kthFromFirst(t, head);
		return node;
	}


	/**
	* return the kth element from the head of the list
	* k=1, the head
	**/
	public ListNode kthFromFirst(int k, ListNode head){
		if(head == null){
			return null;
		}
		ListNode n = head;
		int i;
		for(i=0; i<(k-1) && n.next!=null; i++){
			n = n.next;
		}
		if(i < k-1){
			return null;
		}else{
			return n;
		}
	}
}