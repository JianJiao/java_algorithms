package stacksAndQueues;

public class Hanoi{
	// use integer to represent disks
	// java doesn't support generic arrays, this is a hack. 
	protected Stack<Integer>[] stacks = new Stack[3];
	protected int N; // the disk number

	public Hanoi(int N){
		this.N = N;
		// array of objs must be initialized manually
		for(int i=0; i<3; i++){
			stacks[i] = new Stack<Integer>();
		}
		for(int i=N; i>0; i--){
			stacks[0].push(i);
		}
	}

	public void moveAllToThird(){
		shift(N, 0 , 2);
	}

	/**
	* @param: number, the number of disks to shift;
	* 				dest, the destination stack
	* The first is not always the src
	*/
	public void shift(int number, int src, int dest){
		if(number < 0){
			throw new IllegalArgumentException();
		}
		if(number == 0){
			return;
		}
		// first shift all others to another dest
		// the three stacks index are 0, 1, 2, so the other 
		// dest would be 3 - src - dest
		shift(number - 1, src, 3-src-dest);
		// shift the last one to the dest
		// System.out.println();
		// System.out.println(stacks[src].pop());
		// stacks[0].pop();
		// stacks[0].pop();
		// System.out.println(src);
		int last = stacks[src].pop();
		stacks[dest].push(last);
		// then shift all others to the dest
		shift(number -1, 3-src-dest, dest);
	}
}