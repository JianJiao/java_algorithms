package linkedLists;

public class Stack{
	protected SListNode head;

	public Object push(Object item){
		SListNode node = new SListNode(item, head);
		head = node;
		return item;
	}

	public Object pop(){
		if(head != null){
			SListNode oldHead = head;
			head = head.next;
			return oldHead.item;
		}else{
			return null;
		}
	}

	protected class SListNode{
		protected Object item;
		protected SListNode next;

		protected SListNode(Object item, SListNode next){
			this.item = item;
			this.next = next;
		}
	}
}