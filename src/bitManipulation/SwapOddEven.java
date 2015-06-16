package bitManipulation;

public class SwapOddEven{

	/**
	*	@note: java is "pass by value"
	*  				If the variable is a primitive rather than a reference, 
	*					Thenre is no way you could change the original one;
	*/
	public int swap(int num){
		int even = num >> 1;
		int odd = num << 1;
		int tmp = 0;
		for(int i = 0; i < 16; i += 2){
			tmp += 1 << i;
		}
		// & tmp will keep even bits, & ~tmp will keep odd bits
		int setEven = (even & tmp) | (num & ~tmp);
		int setOdd = (odd & ~tmp) | (setEven & tmp);
		return setOdd;
	}


	/**
	*	@better: +get odd, get even, and combine them. Don't need the internal
	*						+ and we could just provide the plain number in 0x, no need to calculate it in code
	*	
	*/
	public int swap1(int num){
		int leaveOdd = 0x55555555;
		int leaveEven = 0xAAAAAAAA;
		int newOdd = leaveOdd & (num >> 1);
		int newEven = leaveEven & (num << 1);
		int newNum = newOdd | newEven;
		return newNum;
	}
}