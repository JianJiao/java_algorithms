package stacksAndQueues;

public class SortStack{
	protected Stack<Integer> target = new Stack<Integer>();
	protected Stack<Integer> helper = new Stack<Integer>();


	public void sort(){
		if(target.isEmpty()){
			return;
		}
		Integer item = target.pop();
		helper.push(item);

		// move one by one to the helper in sorted order
		while(!target.isEmpty()){
			item = target.pop();
			int count = 0;
			while((!helper.isEmpty())&&item > helper.peek()){
				int helperItem = helper.pop();
				target.push(helperItem);
				count++;
			}
			helper.push(item);
			for(int i=0; i<count; i++){
				int helperItem = target.pop();
				helper.push(helperItem);
			}
		}
		// move them back again to the original stack
		while(!helper.isEmpty()){
			item = helper.pop();
			target.push(item);
		}
	}



}