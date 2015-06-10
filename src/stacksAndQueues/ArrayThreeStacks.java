package stacksAndQueues;

/**
*	1. this implementation didn't check if the stack is full
* You could dynamically allocate new space for the stack, just like you 
* do with the implementation of the hashtable
* 2. if space is fixed and you need to most efficiently utilize that space,
* you must dynamically shift stacks or use something like linked lists, which, 
* I think would lose the point of using the array.
* 3. this implementation returns null if the stack is empty. Not very good, because you
* should not allow null to be put in the stack if you do it, but it didn't check for null.
* Either way, you'll need to throw exceptions. It might be better if you just throw exception
* when the stack if empty. 
*
**/
public class ArrayThreeStacks{
	Object[] stacks;
	// the indices in the array of the three stack tops
	// @better: the below: why not use an array to store it?
	// int top0, top1, top2;
	int[] tops = new int[3];

	/**
	* construct an array to represent three stacks
	* @param: EstimateSize: the estimated size of each 
	* stack
	**/
	public ArrayThreeStacks(int estimateSize){
	// call to `this` must be the first statement in the constructor
		if(estimateSize != 0){
			estimateSize = 1024;
		}
		// @note: you shouldn't set them to 0, 1, 2 at first, which would be
		// the case when you have only one element in the stack
		// @note: actually this implementation is still valid, because you always 
		// return null when there is no elements in the stack. 
		// so in each array for a stack, you store a null at the bottom of the stack to 
		// indicate you hit the bottom of the stack
		// Each stack start storing elements from index 1, not 0. 
		// index 0 always stores null and represent it is empty
		stacks = new Object[3*estimateSize];
		for(int i=0; i<3; i++){
			tops[i] = i;
		}
	}

	public ArrayThreeStacks(){
		this(1024);
	}

	public Object pop(int which){
		if(which != 0 && which != 1 && which != 2){
			return null;
		}else{
			if(tops[which] == which){
				Object result = stacks[tops[which]];
				stacks[tops[which]] = null;
				return result;
			}else{
				Object result = stacks[tops[which]];
				stacks[tops[which]] = null;
				tops[which] -= 3;
				return result;
			}
		}
	}

	public Object push(int which, Object item){
		if(which != 0 && which != 1 && which != 2){
			return null;
		}else{
			tops[which] += 3;
			stacks[tops[which]] = item;
			return item;
		}
	}
}