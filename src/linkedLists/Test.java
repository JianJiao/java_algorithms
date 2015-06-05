package linkedLists;

public class Test{


	public static void main(String[] args){
		Test test = new Test();
		test.testKthToLast();
		test.testRemove();
	}

	public void testRemove(){
		print("*testing remove");
		ListNode head = constructLinkedList(5);
		printList(head);
		RemoveNode rn = new RemoveNode();
		rn.remove(head.next.next);
		printList(head);

	}


	public void print(String str){
		System.out.println(str);
	}

	public void testKthToLast(){
		System.out.println("*testing kthToLast");
		ListNode head = constructLinkedList(4);
		printList(head);
		KthToLast ktl = new KthToLast();
		ListNode newHead = ktl.kthToLast(3, head);
		System.out.println(newHead.item);
		newHead = ktl.kthToLast1(3, head);
		System.out.println(newHead.item);

		head = constructLinkedList(9);
		printList(head);
		newHead = ktl.kthToLast(5, head);
		System.out.println(newHead.item);
		newHead = ktl.kthToLast(5, head);
		System.out.println(newHead.item);

		newHead = ktl.kthToLast(11, head);
		if(newHead == null){
			System.out.println("null");
		}

		System.out.println();
	}

	/**
	* construct a linked list of size n
	* @return the head node
	**/
	public ListNode constructLinkedList(int n){
		ListNode next = null;
		ListNode node = null;
		for(int i=n; i>0; i--){
			node = new ListNode(i, next);
			next = node;
		}
		return node;
	}

	/**
	* print the items of a linked list
	* @param head, head of the linked list
	**/
	public void printList(ListNode head){
		ListNode node = head;
		while(node!= null){
			System.out.print(node.item + ", ");
			node = node.next;
		}
		System.out.println();
	}


}