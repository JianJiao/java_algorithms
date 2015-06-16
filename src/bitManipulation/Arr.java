package bitManipulation;


public class Arr{


	protected int[] arr;

	public int length(){
		return arr.length;
	}

	public Arr(int[] arr){
		this.arr = arr;
	}

	public int getFrom(int bitIdx, int intIdx){
		// System.out.println(bitIdx + " " + intIdx);
		// System.out.println(arr[intIdx]);
		if(bitIdx > 31 || bitIdx < 0){
			throw new IllegalArgumentException("bitIdx out of bound");
		}
		if(intIdx> arr.length || intIdx< 0){
			throw new IllegalArgumentException("no such integer");
		}
		int result = (arr[intIdx] >> bitIdx) & 1;
		return result;
	}
}