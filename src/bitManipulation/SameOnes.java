package bitManipulation;

public class SameOnes{


	/**
	* @note: don't use this method. It is better but very error prone
	*	a even better way to implement this: use math
	* but this is very hard to think about: you have different situations when 
	* doing next and prev, and you have to think about both situations in each, 
	* though they kind of follow the same pattern when you know them all very well:
	*		+ trailing bits are ones
	*		+ trailing bits are zeros
	*		next should consider trailing is zero
	*		prev should consider trailing is one
	* 
	*/
	public void nextMath(int num){
		int lower = firstOneIndex(num);
		int higher = nextZeroIndex(num, lower);
		if(lower > 31 || higher > 31){
			System.out.println("no such number");
		}else{
			int numOnes = higher - lower - 1;
			int setNextOne = num + (1 << lower );
			int addOnes = setNextOne + (1 << numOnes) -1;
			System.out.println("the next one would be: " + Integer.toBinaryString(addOnes));
		}
	}



	/**
	*	many places you make mistakes
	* If you don't like this method and want to finish it quickly, you are likely to make
	* mistakes, because you don't think thoughouly at each step.
	* !!! how do you change the state you are in?
	* @note: 1. check if not found: 32
	* 				2. the precedence with bit shifting: << , >>  !!! important, always include 
	* 					parathenses when you use bit shifting
	*/
	public void prevMath(int num){
		int lower = firstZeroIndex(num);
		int higher = nextOneIndex(num, lower);
		if(lower > 32 || higher > 32){
			System.out.println("no such number");
		}else{
			int numZero = higher - lower - 1;
			int setOne = num - (1 << lower);
			int addZeros = setOne - ((1 << numZero) - 1);
			System.out.println("the previous one is: " + Integer.toBinaryString(addZeros));
		}
	}

	/**
	*	return 35 if not found
	*/
	protected int firstZeroIndex(int num){
		int shifted = 0;
		for(int i = 0; i < 32; i++){
			shifted = num >> i;
			if((shifted & 1) == 0){
					return i;
			}
		}
		return 35;
	}

	protected int nextOneIndex(int num, int lower){
		int shifted = 0;
		for(int i = lower + 1; i < 32; i++){
			shifted = (num >> i);
			if((shifted & 1) == 1){
				return i;
			}
		}
		return 35;
	}


	/**
	* @update: now it is right and better
	*	problematic
	* why? + Not the *smallest* one that is larger than the original one
	*				+ when you get some hint, don't just do it without thinking thouroughly, 
	*					it might have other pitfalls
	*/
	public void next(int num){
		int lower = firstOneIndex(num);
		int higher = nextZeroIndex(num, lower);
		if(lower > 31 || higher > 31){
			System.out.println("no such number");
		}else{
			// @note: even drawing diagram should be careful and clean, cause it will 
			// influnce how clearly you can see things and it can introduce bugs
			int numOfOnes = higher - lower - 1;
			int setHigher = (1 << higher) | num;
			int clear = (-1 << higher) & setHigher;
			int addZero = ((1 << numOfOnes) - 1) | clear;
			System.out.println("the next number is: " + Integer.toBinaryString(addZero));
		}

	}

	/**
	*	return 35 if not found
	*/
	public int firstOneIndex(int num){
		int a = 0;
		for(int i = 0; i < 32; i++){
			a = num >> i;
			if((a & 1) == 1){
				return i;
			}
		}
		return 35;
	}
	/**
	*	return 35 if not found
	*/
	protected int nextZeroIndex(int num, int lower){
		int a = 0;
		for(int i = lower + 1; i < 32; i++){
			a = num >> i;
			if((a & 1) == 0){
				return i;
			}
		}
		return 35;
	}


	public void nextSmallestAndLargest(int num){
		int onesNum = numberOfOnes(num);
		System.out.println(onesNum + " ones num");
		// next smallest
		int smallest = num + 1;
		int onesSmallest = numberOfOnes(smallest);
		while(onesSmallest != onesNum){
			smallest++;
			onesSmallest = numberOfOnes(smallest);
		}
		// System.out.println("smallest " + smallest);
		// System.out.println("ones smallest " + onesSmallest);
		// @change: here you should use smallest, not onesSmallest;
		// @note: bad name make it hard for you to distinguish between
		// @note: also has an upper limit
		System.out.println("the next smallest one is: " + Integer.toBinaryString(smallest));

		// next largest, also includes the negative number
		int largest = num - 1;
		int onesLargest = numberOfOnes(largest);
		while(onesLargest != onesNum){
			largest--;
			if(largest < 0){
				break;
			}
			onesLargest = numberOfOnes(largest);
		}
		if(largest < 0){
			System.out.println("no next largest");
		}else{
			System.out.println("the next largest one is: " + Integer.toBinaryString(largest));
		}

	}


	/**
	*	get number of 1s in the input num
	* of their binary representation
	*/
	protected int numberOfOnes(int num){
		int count = 0;
		for(int i = 0; i < 32; i++){
			// @note: @change: you should not change the original number here! 
			int a = num >> i;
			// @note: @change: precedence!!!
			if((a & 1) == 1){
				count++;
			}
		}
		return count;
	}
}