package linkedLists;

public class Circular{

	/**
	* if we were not allowed to use the hashset
	* @better: the runner technique
	* 1. faster will run a distance longer than the slower by one loop
	* 2. they will meet at a spot with S0 distance to the beginning of the loop
	**/
	public ListNode loopBeginning1(ListNode head){
		if(head == null){
			return null;
		}else{
			ListNode faster = head;
			ListNode slower = head;
			// @better: better to also check if there is actually a loop
			while(faster != slower || faster == null || faster.next == null){
				faster = faster.next.next;
				slower = slower.next;
			}
			// and if no loop, return null
			if(faster == null || faster.next == null){
				return null;
			}
			faster = head;
			while(faster != slower){
				faster = faster.next;
				slower = slower.next;
			}
			return faster;
		}
	}

	public ListNode loopBeginning(ListNode head){
		if(head == null){
			return null;
		}
		java.util.HashSet<ListNode> set = new java.util.HashSet<ListNode>();
		ListNode node = head;
		while(node != null){
			if(set.contains(node)){
				return node;
			}else{
				set.add(node);
				node = node.next;
			}
		}
		return null;
	}
}