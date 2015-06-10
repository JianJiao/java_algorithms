package stacksAndQueues;

/**
* @note: stop fixing this implementation. It is still faulty. 
* 	The needShift() method is faulty since it fails to consider when you keep pushing into one 
* 		stack while all others are empty, in which case you still need to shift the starting place
* 		of the second stack, which would be too complex: too many edge cases;
* @note: 
*	1. inconsitency is evil. It might look easy to implement, but not, at all. 
*  		+ specifically here(most important two): 
*				1. the third stack grows in an alternating way on both sides, one source of inconsistency;
*				2. when you set tops[i] = -1, you cause another inconsistency with the normal behavior. See
*						the note bellow for why that is so bad.
*
*	2. problem like this needs to be carefully thought about first. It needs to be carefully 
*			designed. The methods and interface should be designed before you actually start to 
*			implement them. 
*			Thus this is not suitable at all for an interview question: you might solve it by luck in 
*			a shor period of time, but in most cases it will introduce bugs that are hard to find and 
*			fix. 
*	3. how would you make it better:
*			+ don't use this strange third stack that grows in both direction
*			+ leave a cell for each stack for indicating empty, storing nothing, but keeping the 
*					consistency. It wastes three cells, but greatly improves the maintainity and reduces the
*					complexity. When a tops[i] points to that cell, it means this stack is empty. What that
*					cell actually holds doesn't matter.
*			+	the middle cell should have a clear range, if you were to use the alternating growing 
*					stack: you should store the boudaries of both sides.
*
*
*
*
* 1. This implementation is a mess
* 2. Space efficient, but not all space has been used. Several cells are
* not been used.  
* @note: 
* 1. Inconsistency is evil! Here, settig tops[] = {-1,-1, -1} is evil! 
* 	+ when pushing, you have to check if it is null, then you start from -1 and jump to 
* 			other values
* 	+ @not fixing: also pushing, when you keep pushing one stack when others are empty, you don't 
* 			know if others need shifting
* 	+ when poping, you have to check if you reached 0, or end, or middle, then you jump to
* 			-1
* 	+ when checking for collision, you have to check if you reached out of the bound of the 
* 			array, but you cannot use -1, because it is used here, but naturally when it goes out
*				of bound if shuold reach -1 or end+1, you have to deal with this special case
* 	+ when finding remaining space, you have to first check for -1, which you didn't, which might
* 			still be wrong, this implementation!!!
**/
public class ArrayStack{
	protected Object[] stacks;
	protected int[] tops = {-1, -1, -1};
	protected int middle, end;
	protected int side = 1;  // 0 -- left; 1 -- right
	protected int prev;

	public ArrayStack(){
		this(10);
	}

	public ArrayStack(int estimateSize){
		if(estimateSize == 0){
			estimateSize= 10;
		}
		stacks = new Object[estimateSize];
		end = estimateSize -1;
		middle = end / 2;
	}

	public Object push(int which, Object obj){
		int next = computeNextIndex(which);
		System.out.println(next);
		boolean needShift= needShift(which, next);
		System.out.println(tops[0] + " " + tops[1] + " " + tops[2] );
		System.out.println(needShift);
		System.out.println();
		if(needShift){
			int remain = remainSpace();
			if(remain <2 ){
				throw new StackFullException();
			}
			int start = remain/2 + 1 + tops[0];
			int end = tops[2] - remain/2 - 1;
			System.out.println(start + " " + end);
			shift(start, end);
			// next and tops[2] also need to be shifted, how do you do that?
			next = computeNextIndex(which);
		}
		tops[which] = next;
		stacks[next] = obj;
		if(which == 2){
			side = side == 0 ? 1 : 0;
		}
		return obj;
	}

	protected void shift(int start, int end){
		int mStart;
		int mEnd;
		if(tops[2] > middle){
			mStart = prev;
			mEnd = tops[2];
		}else{
			// equal also put to this
			mStart = tops[2];
			mEnd = prev;
		}
		// must know shifting left or right to avoid overlapping
		if(mStart < start){
			// shift right
			for(int i=mEnd, j=end; i>=mStart; i--, j--){
				stacks[j] = stacks[i];
			}
		}else{
			// shift left
			for(int i=mStart, j=start; i<=mEnd; i++, j++){
				stacks[j] = stacks[i];
			}
		}
		// also shift tops[2]
		tops[2] = tops[2] > middle ? end : start;
	}

	protected boolean needShift(int which, int next){
		// first should check if the queue is empty
		if(tops[which] == -1){
			return false;
		}
		// prev stores the prev value for tops[2]
		if(tops[2] > middle){
			prev = 2*middle - tops[2] + 1;
		}else{
			prev = 2*middle - tops[2];
		}

		// if no space, no need to shift, throw exception.
		if(which == 0 && tops[0] == end){
			throw new StackFullException();
		}
		if(which == 1 && tops[1] == 0){
			throw new StackFullException();
		}
		// waste one cell for simplicity
		if(which == 2 && (tops[2] == 0 || tops[2] == end)){
			throw new StackFullException();
		}

		// might still have space, check if needing shift
		if(next == prev || next == tops[0] || next == tops[1] || next == tops[2]){
			return true;
		}else{
			return false;
		}
	}

	protected int remainSpace(){
		int remain, used;
		int[] mocktops = new int[3];
		for(int i=0; i<3; i++){
			mocktops[i] = tops[i];
		}
		if(mocktops[1] == -1){
			mocktops[1] = end+1;
		}
		if(mocktops[2] == -1){
			used = tops[0] + end - tops[1] + 2;
		}else{
			if(side == 0){
				used = tops[0] + end + middle - tops[1] - tops[2] +3;
			}else{
				used = tops[0] + end - tops[1] + tops[2] - middle +3;
			}
		}
		remain = end + 1 -used;
		return remain;
	}

	protected int computeNextIndex(int which){
		if(which == 0){
			if(tops[0] == -1){
				return 0;
			}else{
				return tops[0]+1;
			}
		}else if(which == 1){
			if(tops[1] == -1){
				return end;
			}else{
				return tops[1] -1;
			}
		}else if(which == 2){
			if(tops[2] == -1){
				return middle;
			}else{
				int next;
				if(side == 0){	 // go to the right side
					// @todo: should update side=0 after inserting sth in the middle position
					next = 2*middle - tops[2] + 1;
				}else{
					next = 2*middle - tops[2];
				}
				return next;
			}
		}else{
			throw new IllegalArgumentException("which should be 0, 1, 2");
		}
	}

	public Object pop(int which){
		if(which <0 || which > 2){
			throw new IllegalArgumentException("only three stacks, choose from 0, 1, 2");
		}
		if(tops[which] == -1){
			throw new StackEmptyException();
		}
		int previous = getPrev(which);
		Object obj = stacks[tops[which]];
		tops[which] = previous;
		if(which == 2){
			side = side == 0 ? 1 : 0;
		}
		return obj;
	}


	protected int getPrev(int which){
		int result;
		if(which == 0){
			if(tops[0] == 0){
				result = -1;
			}else{
				result = tops[0] -1;
			}
		}else if(which == 1){
			if(tops[1] == end){
				result = -1;
			}else{
				result = tops[1] + 1;
			}
		}else{
			if(tops[2] == middle){
				result = -1;
			}else{
				result = side == 0 ? (2*middle - tops[2]) : (2*middle - tops[2] + 1);
			}
		}
		return result;
	}
}