package bitManipulation;

public class BitsToFlip{

	/**
	*	@return: the number of bits to flip to convert src to dest
	*/
	public int bitsToFlip(int src, int dest){
		int diff = src ^ dest;
		return numOfOnes(diff);
	}


	protected int numOfOnes(int num){
		int count = 0;
		int shifted = 0;
		for(int i = 0; i < 32; i++){
			shifted = num >> i;
			if((shifted & 1) == 1){
				count++;
			}
		}
		return count;
	}


	public static void main(String[] args){
		BitsToFlip btf = new BitsToFlip();
		System.out.println(Integer.toBinaryString(3));
		System.out.println(btf.numOfOnes(3));
	}
}