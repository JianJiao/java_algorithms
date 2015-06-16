package bitManipulation;

public class MtoN{

	public int insertTo(int M, int N, int lower, int higher){
		System.out.println(Integer.toBinaryString(M));
		System.out.println(Integer.toBinaryString(N));
		// 111111111000000000
		int a = -1 << (higher + 1);
		System.out.println(Integer.toBinaryString(a));
		// 000000000000000111
		int b = (1 << lower ) -1;
		System.out.println(Integer.toBinaryString(b));
		// 111111111000000111
		int c = a ^ b;
		System.out.println(Integer.toBinaryString(c));
		// store M in the 0s
		N = (N & c) ^ (M << lower);
		System.out.println(Integer.toBinaryString(N));
		return N;
	}
}