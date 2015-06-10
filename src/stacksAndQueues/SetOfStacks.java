package stacksAndQueues;

/**
* @note: if we were allowed to use arraylist, it would be easier to find the 
* correct stack in popAt. 
**/

public class SetOfStacks{

	// you don't need this pointer, the bottom node has prev set to null
	//protected ListNode bottomNode;
	protected ListNode current;
	protected int top;
	// assign 10 for easier testing
	protected static int LIMIT = 10;

	public SetOfStacks(){
		Object[] stack = new Object[LIMIT];
		ListNode node = new ListNode(stack, null);
		current = node;
		// -1 means empty
		top = -1;
	}

	public Object push(Object item){
		top++;
		if(top< LIMIT){
			this.current.stack[top] = item;
		}else{
			Object[] stack = new Object[LIMIT];
			ListNode node = new ListNode(stack, this.current);
			this.current = node;
			top = 0;
			this.current.stack[top] = item;
		}
		return item;
	}

	public Object pop(){
		// @note: remember to check if stack is empty
		if(this.current.prev == null && top == -1){
			throw new StackEmptyException();
		}
		Object item = this.current.stack[top];
		top--;
		if(top < 0){
			top = 9;
			this.current = this.current.prev;
		}
		return item;
	}

	/**
	* @param: index specifies the substack, starting from 0
	**/
	public Object popAt(int index){
		ListNode node = findStackNode(index);
		if(node == this.current){
			return this.pop();
		}else{
			Object item = node.stack[9];
			//System.out.println(this.current);
			shift(this.current, node, this.current.stack[0]);
			top--;
			if(top == -1){
				top = 9;
				this.current = this.current.prev;
			}
			return item;
		}
	}

	protected void shift(ListNode start, ListNode end, Object item){
		if(start == end){
			start.stack[9] = item;
			// @note: remember the return statement in the recursion
			return;
		}
		//System.out.println(start);
		Object myItem = start.stack[0];
		shift(start.stack);
		start.stack[9] = item;
		shift(start.prev, end, myItem);
	}

	protected void shift(Object[] s){
		for(int i=0; i<s.length-1; i++){
			s[i] = s[i+1];
		}
	}

	/**
	* find stack node at index index
	**/
	protected ListNode findStackNode(int index){
		ListNode slow= this.current;
		ListNode fast = this.current;
		for(int i=0; i< index; i++){
			if(fast.prev == null){
				throw new IllegalArgumentException("there is no stack at index " + index);
			}else{
				fast = fast.prev;
			}
		}
		while(fast.prev != null){
			fast = fast.prev;
			slow = slow.prev;
		}
		return slow;
	}

	protected class ListNode{
		protected Object[] stack;
		protected ListNode prev;

		public ListNode(){

		}

		public ListNode(Object[] stack, ListNode prev){
			this.stack = stack;
			this.prev = prev;
		}
	}

}