package stacksAndQueues;

public class MyQueue<T>{
	Stack<T> inStack = new Stack<T>();
	Stack<T> outStack = new Stack<T>();

	public T enqueue(T item){
		inStack.push(item);
		// @note: when you have a return type, you shuold have a place holder here to 
		// remind yourself
		return item;
	}

	// @note: @mistake: no param, it is easy to add a param without thinking here
	public T dequeue(){
		if(outStack.isEmpty()){
			moveItems();
			if(outStack.isEmpty()){
				throw new QueueEmptyException();
			}
		}
		return outStack.pop();
	}


	protected void moveItems(){
		while(!inStack.isEmpty()){
			T item = inStack.pop();
			outStack.push(item);
		}
	}
}