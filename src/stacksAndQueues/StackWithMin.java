package stacksAndQueues;

public class StackWithMin{

	protected StackNode top;

	public Object push(Object item){
		// empty
		if(this.top == null){
			StackNode node = new StackNode(item, null, null);
			node.min = node;
			this.top = node;
		}else{
			// not empty
			StackNode node = new StackNode(item, null, this.top);

			Comparable newItem = (Comparable) item;
			Comparable existing = (Comparable) this.top.min.item;
			if(newItem.compareTo(existing)<0){
				node.min = node;
			}else{
				node.min = this.top.min;
			}

			this.top = node;
		}
		return item;
	}

	public Object pop(){
		if(this.top == null){
			throw new StackEmptyException();
		}
		Object item = this.top.item;
		this.top = this.top.prev;
		return item;
	}

	public Object min(){
		if(this.top == null){
			return null;
		}
		return this.top.min.item;
	}


	/**
	*	 An inner class
	* @better: the min could be the actual item, no need to be the 
	* StackNode, because we don't expose it to the outside world
	**/
	protected class StackNode{
		protected Object item;
		protected StackNode min;
		protected StackNode prev;

		public StackNode(){

		}

		public StackNode(Object item, StackNode min, StackNode prev){
			this.item = item;
			this.min = min;
			this.prev= prev;
		}
	}
}