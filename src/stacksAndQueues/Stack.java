package stacksAndQueues;

public class Stack<T>{
	// we call it head here, but it is not a head in the 
	// linked list perspective, it is actually the tail
	protected SListNode<T> head;

	public T push(T item){
		SListNode<T> node = new SListNode<T>(item, head);
		head = node;
		return item;
	}

	public T peek(){
		if(this.isEmpty()){
			throw new StackEmptyException();
		}else{
			return head.item;
		}
	}

	public T pop(){
		if(head != null){
			SListNode<T> oldHead = head;
			head = head.next;
			return oldHead.item;
		}else{
			throw new StackEmptyException();
		}
	}

	public boolean isEmpty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}

	protected class SListNode<T>{
		protected T item;
		protected SListNode<T> next;

		protected SListNode(T item, SListNode<T> next){
			this.item = item;
			this.next = next;
		}
	}
}