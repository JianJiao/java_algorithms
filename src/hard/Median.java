package hard;
import java.util.PriorityQueue;
import java.util.Collections;


/**
* @todo:
* @note: the definition of meidan: if even, it's the mean of middle two numbers
*/


public class Median{
	// @note: don't confuse the two, the defualt is minQueue, not maxQueue
	protected PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(50, Collections.reverseOrder());
	protected PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();

	// @note: no need to have a seperate field to hold median

	public void insert(int k){
		int maxSize = maxQueue.size();
		int minSize = minQueue.size();
		// System.out.println("got " + k);
		// @note: not directly goes to either side, should compare with the median
		if(maxSize == minSize && maxSize == 0){
			// System.out.println("inserting " + k);
			maxQueue.add(k);
			// @note: short-circuit: should return!
			return;
		}
		// System.out.println("inserting " + k);
		if(maxSize == minSize){
			if(k <= minQueue.peek()){
				maxQueue.add(k);
			}else{
				minQueue.add(k);
				int tmp = minQueue.remove();
				maxQueue.add(tmp);
			}
		}else{
			if(k < maxQueue.peek()){
				maxQueue.add(k);
				int tmp = maxQueue.remove();
				minQueue.add(tmp);
			}else{
				// System.out.println(k);
				// System.out.println("ya;");
				minQueue.add(k);
			}
		}
	}

	public int median(){
		// System.out.println(maxQueue.peek());
		// System.out.println(minQueue.peek());
		// System.out.println(maxQueue.size());
		// System.out.println(minQueue.size());

		int maxSize = maxQueue.size();
		int minSize = minQueue.size();
		if(maxSize == minSize && maxSize == 0){
			throw new EmptyHeapException();
		}
		if(maxSize == minSize){
			return (maxQueue.peek() + minQueue.peek()) / 2;
		}else{
			return maxQueue.peek();
		}
	}

}