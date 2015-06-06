package linkedLists;

public class Test{


	public static void main(String[] args){
		Test test = new Test();
		test.testKthToLast();
		test.testRemove();
		test.testPartition();
		test.testAddition();
	}

	public void testAddition(){
		print("* testing addition");
		Addition add = new Addition();
		ListNode n1 = constructLinkedList(9);
		printList(n1);
		ListNode n2 = constructLinkedList(9);
		printList(n2);
		ListNode node = add.add(n1, n2);
		ListNode node1 = add.add1(n1, n2);
		printList(node);
		printList(node1);
		ListNode nn = add.addForward(n1, n2);
		printList(nn);

		print();

		ListNode less = randomListLess();
		printList(less);
		printList(node);
		ListNode result = add.add(less, node);
		ListNode result1 = add.add1(less, node);
		printList(result);
		printList(result1);
		print();
		printList(less);
		printList(node);
		nn = add.addForward(less, node);
		printList(nn);

		print();
	}

	public void testRemove(){
		print("*testing remove");
		ListNode head = constructLinkedList(5);
		printList(head);
		RemoveNode rn = new RemoveNode();
		rn.remove(head.next.next);
		printList(head);

	}

	public void testPartition(){
		print("*testing partition");
		ListNode head = constructLinkedList(9);
		printList(head);
		Partition p = new Partition();
		ListNode newHead = p.partition(5, head);
		printList(newHead);
		print();

		head = randomList();
		printList(head);
		newHead = p.partition(30, head);
		printList(newHead);
		print();

		printList(head);
		newHead = p.partition1(30, head);
		printList(newHead);
		print();

		printList(head);
		newHead = p.partition(3, head);
		printList(newHead);
		print();

		printList(head);
		newHead = p.partition1(3, head);
		printList(newHead);
		print();


	}


	public ListNode randomList(){
		ListNode node = new ListNode(3, null);
		node = new ListNode(5, node);
		node = new ListNode(1, node);
		node = new ListNode(90, node);
		node = new ListNode(44, node);
		node = new ListNode(23, node);
		return node;
	}

	public ListNode randomListLess(){
		ListNode node = new ListNode(3, null);
		node = new ListNode(5, node);
		node = new ListNode(1, node);
		node = new ListNode(9, node);
		node = new ListNode(4, node);
		node = new ListNode(2, node);
		return node;
	}


	public void print(String str){
		System.out.println(str);
	}

	public void print(){
		System.out.println();
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